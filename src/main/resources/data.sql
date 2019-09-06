-- 插入User数据 --
insert into user(id, username, sex, age, password, likes, signature, role)
values(1, 'Java', '男', 20, '123123', '撩妹, 写代码', 'No.1', 'consumer'),
(2, 'Python', '女', 21, '123123', '写代码', 'No.2', 'consumer'),
(3, '小萌新', '女', 22, '123123', '篮球, 足球', 'No.3', 'consumer'),
(4, 'root', '女', 21, 'password', '写代码', '个性签名', 'admin');

-- 插入Role数据 --
insert into role(id, name, description)
values(1, 'consumer', '普通用户'),
(2, 'admin', '管理员');

-- 插入Permission数据 --
insert into permission(id, name, description, url, icon)
values(1, 'profile_priv', '个人信息', 'profile', 'ti-user'),
(2, 'message_priv', '留言板', 'messages', 'ti-clipboard'),
(3, 'edituser_priv', '所有用户', 'users', 'ti-agenda'),
(4, 'role_priv', '角色管理', 'roles', 'ti-server'),
(5, 'permission_priv', '权限管理', 'permissions', 'ti-server');

-- 插入初始化数据 --
insert into role_permission(id, role, permission)
values(1, 'consumer', 'profile_priv'),
(2, 'consumer', 'message_priv'),
(3, 'admin', 'profile_priv'),
(4, 'admin', 'message_priv'),
(5, 'admin', 'edituser_priv'),
(6, 'admin', 'role_priv'),
(7, 'admin', 'permission_priv');