-- 1.查询 "001" 课程比 "002" 课程成绩高的所有学生的学号；(子查询/连表) --
select a.student_id
from t_score a, t_score b
where a.student_id = b.student_id && a.course_id = '001' && b.course_id = '002' && a.score > b.score;
/*
+------------+
| student_id |
+------------+
| 002        |
| 003        |
| 004        |
+------------+
*/


-- 2.查询平均成绩大于60分的同学的学号和平均成绩：--
select student_id, avg(score) as avg
from t_score
group by student_id having avg > 60;
/*
+------------+---------+
| student_id | avg     |
+------------+---------+
| 001        | 67.4000 |
| 002        | 70.0000 |
| 003        | 64.8000 |
| 004        | 69.0000 |
| 005        | 70.8000 |
+------------+---------+
*/


-- 3.查询所有同学的学号、姓名、选课数、总成绩(比较有难度 group by 和 函数) --
select a.student_id, a.student_name, count_of_course, sum_of_score
from
t_student a
join
(select student_id, count(*) as count_of_course, sum(score) as sum_of_score from t_score group by student_id) b
on
a.student_id = b.student_id;
/*
+------------+--------------+-----------------+--------------+
| student_id | student_name | count_of_course | sum_of_score |
+------------+--------------+-----------------+--------------+
| 001        | 黄国仲       |               5 |          337 |
| 002        | 张三         |               5 |          350 |
| 003        | 李四         |               5 |          324 |
| 004        | 王花花       |               4 |          276 |
| 005        | 李大美       |               5 |          354 |
+------------+--------------+-----------------+--------------+
*/


-- 4.查询 姓 李 同学的个数(考察like和count) --
select "李%" as s_name, count(*) from t_student where student_name like "李%";
/*
+--------+----------+
| s_name | count(*) |
+--------+----------+
| 李%    |        4 |
+--------+----------+
*/


-- 5.查询没有 003课程成绩的学生 --
select student_id, student_name, "没有003课程成绩" as " " from t_student
where student_id not in (select student_id from t_score where course_id = "003");
/*
+------------+--------------+-----------------------+
| student_id | student_name |                       |
+------------+--------------+-----------------------+
| 004        | 王花花       | 没有003课程成绩       |
| 006        | 孙花         | 没有003课程成绩       |
| 007        | 李四         | 没有003课程成绩       |
| 008        | 李大美       | 没有003课程成绩       |
+------------+--------------+-----------------------+
*/


-- 6.查询学过"001"并且也学过编号"002"课程的同学的学号、姓名；--
select student_id, student_name from t_student
where
student_id in
(select student_id from t_score where course_id = "001"
union
select student_id from t_score where course_id = "002");
/*
+------------+--------------+
| student_id | student_name |
+------------+--------------+
| 001        | 黄国仲       |
| 002        | 张三         |
| 003        | 李四         |
| 004        | 王花花       |
| 005        | 李大美       |
+------------+--------------+
*/


-- 7.查询所有课程平均成绩小于70分的同学的学号、姓名； --
select student_id, student_name from t_student
where student_id in (select student_id from t_score group by student_id having avg(score) < 70);
/*
+------------+--------------+
| student_id | student_name |
+------------+--------------+
| 001        | 黄国仲       |
| 003        | 李四         |
| 004        | 王花花       |
+------------+--------------+
*/


-- 8.查询没有学全所有课的同学的学号、姓名； --
select student_id, student_name from t_student
where student_id not in
(select student_id from t_score
group by student_id
having count(*) = 5);
/*
+------------+--------------+
| student_id | student_name |
+------------+--------------+
| 004        | 王花花       |
| 006        | 孙花         |
| 007        | 李四         |
| 008        | 李大美       |
+------------+--------------+
*/


-- 9.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分 --
select course_id, max(score), min(score) from t_score group by course_id;
/*
+-----------+------------+------------+
| course_id | max(score) | min(score) |
+-----------+------------+------------+
| 001       |        100 |         39 |
| 002       |         80 |         44 |
| 003       |         99 |         53 |
| 004       |         80 |         34 |
| 005       |         99 |         50 |
+-----------+------------+------------+
*/


-- 10.查询每门课程有成绩的学生数 --
select course_id, count(*) from t_score group by course_id;
/*
+-----------+----------+
| course_id | count(*) |
+-----------+----------+
| 001       |        5 |
| 002       |        5 |
| 003       |        4 |
| 004       |        5 |
| 005       |        5 |
+-----------+----------+
*/


-- 11.查询男生、女生人数 --
select gender, count(*) from t_student group by gender;
/*
+--------+----------+
| gender | count(*) |
+--------+----------+
| m      |        4 |
| w      |        4 |
+--------+----------+
*/


-- 12.统计同名同姓人数 --
select student_name, count(*) from t_student group by student_name;
/*
+--------------+----------+
| student_name | count(*) |
+--------------+----------+
| 黄国仲       |        1 |
| 张三         |        1 |
| 李四         |        2 |
| 王花花       |        1 |
| 李大美       |        2 |
| 孙花         |        1 |
+--------------+----------+
*/