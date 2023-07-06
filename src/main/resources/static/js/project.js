// agree
let agree1 = document.querySelector("#agree1");
let agree2 = document.querySelector("#agree2");
let okagree = document.querySelector("#okagree");
let noagree = document.querySelector("#noagree");

okagree?.addEventListener('click', () => {
    if (!agree1.checked) alert('이용약관에 동의에 체크 하세요!🙄');
    else if (!agree2.checked) alert('개인정보 이용 동의에 체크하세요!');
    else location.href = 'join/checkme';
});
noagree?.addEventListener('click', () => {
    location.href="/";
});

