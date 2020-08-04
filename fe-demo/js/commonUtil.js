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
        // alert('请登录')
        // window.location.href = feHost + '/login/index.html'
        return
    }
    return token
}

function getCurrentYear() {
    return 2020;
}

function getNick(userId) {
    switch (userId) {
        case 1:
            return '李明';
        case 2:
            return '艳杰';
        case 23:
            return '知足是福';
        case 25:
            return '阿冷';
        default:
            return '无名';
    }
}




