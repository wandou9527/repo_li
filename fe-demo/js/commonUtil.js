/**
 * 跳转到添加步数页
 */
function toAddStepPage() {
    window.location.href = feHost + '/xiaomubiao/add.html'
}

function getToken() {
    let token = window.localStorage.getItem('token');
    if (!token) {
        // window.location.href = login.html
        alert('请登录')
        // window.location.href = feHost + '/login/index.html'
        return
    }
    return token
}




