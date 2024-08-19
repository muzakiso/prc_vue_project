document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');
    const errorMessage = document.getElementById('error-message');

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        const username = document.getElementById('uname').value;
        const password = document.getElementById('pwd').value;

        if (username === 'admin' && password === '1234') {
            form.submit();
        } else {
            errorMessage.textContent = '登录名或密码错误！';
            errorMessage.classList.remove('hidden');
            setTimeout(function () {
                errorMessage.classList.add('hidden');
            }, 3000);
        }
    });
});