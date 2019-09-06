/* ajax GET方式获取页面 */
function getData(url){
    var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest();
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("demo").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
/* ajax POST方式获取页面 */
function postData(url, data){
    var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest();
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("demo").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("POST", url);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send(data);
}

/* jquery POST数据 */
function ajaxPostData(url, form_id){
    $.ajax({
        type: "POST",
        url: url,
        data: $(form_id).serializeArray(),
        success: function(result) {
            console.log(result);//打印服务端返回的数据(调试用)
            alert("修改成功!");
            $(location).attr('href', 'main')
        },
        error : function() {
            alert("异常!");
        }
    });
}

/* 用户 */
/* 注册用户 */
function userAdd() {
    ajaxPostData('register', '#register_form')
}
/* 修改用户 */
function toUserChange(id) {
    getData("user_change?id=" + id);
}
function userChange() {
    ajaxPostData("user_change", "#change_form");
}
/* 删除用户 */
function userDelete(id) {
    postData("user_delete", "id=" + id);
}

/* 留言板 */
/* 添加留言 */
function messageAdd() {
    var data = document.getElementById("message_data").value;
    postData("message_add", "data=" + data);
}

/* 权限 */
/* 添加权限 */
function toPermissionAdd() {
    getData("permission_add");
}
function permissionAdd() {
    ajaxPostData("permission_add", "#permission_form");
}
/* 修改权限 */
function toPermissionChange(id) {
    getData("permission_change?id=" + id)
}
function permissionChange() {
    ajaxPostData("permission_change", "#change_form")
}
/* 删除权限 */
function permissionDelete(id) {
    postData("permission_delete", "id=" + id);
}

/* 角色 */
/* 添加角色 */
function toRoleAdd() {
    getData("role_add");
}
function roleAdd() {
    ajaxPostData("role_add", "#role_form");
}
/* 修改角色 */
function toRoleChange(id) {
    getData("role_change?id=" + id);
}
function roleChange() {
    ajaxPostData("role_change", "#change_form");
}
/* 删除角色 */
function roleDelete(id) {
    postData("role_delete", "id=" + id);
}