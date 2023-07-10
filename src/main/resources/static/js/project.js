// agree
let agree1 = document.querySelector("#agree1");
let agree2 = document.querySelector("#agree2");
let okagree = document.querySelector("#okagree");
let noagree = document.querySelector("#noagree");

okagree?.addEventListener('click', () => {
    if (!agree1.checked) alert('이용약관에 동의에 체크 하세요!🙄');
    else if (!agree2.checked) alert('개인정보 이용 동의에 체크하세요!');
    else location.href = '/join/checkme';
});
noagree?.addEventListener('click', () => {
    location.href="/";
});
//checkme
let frm = document.forms.agreefrm2;
let checkbtn2 = document.querySelector("#checkbtn2");
let cancelbtn2 = document.querySelector("#cencelbtn2");
checkbtn2?.addEventListener('click',()=>{
    if (frm.name.value === '') alert('이름을 입력하세요!!');
    else if (frm.jumin1.value === '') alert('주민번호를 입력하세요!!');
    else if (frm.jumin2.value === '') alert('나머지 주민번호를 입력하세요!!');
    else if (!frm.infoagree.checked) alert('주민번호 처리에 동의하세요!!');
    else {
      frm.method = 'post';
      frm.submit();
    }
});
cancelbtn2?.addEventListener('click',()=>{
    location.href = '/';
});
//joinme
let zipbtn = document.querySelector("#findzipbtn");
let dong = document.querySelector("#dong");
let addrlist = document.querySelector("#addrlist");
let sendzip = document.querySelector("#sendzip");
const showzipaddr = (jsons) => {
    jsons = JSON.parse(jsons); // 문자열을 json 객체로 변환
    let addr = '';
    jsons.forEach(function (data, idx) { //json 반복처리
        addr += `<option>${data['zipcode']} ${data['sido']} ${data['gugun']} 
                ${data['dong']} ${data['bunji']}</option>`;
    });
    addrlist.innerHTML = addr;
};
zipbtn?.addEventListener('click', () => {
    if (dong.value === ''){
        alert('동이름을 입력하세요');
        return;

    }
    const url = '/join/zipcode?dong=' + dong.value;
    fetch(url).then(response => response.text())
        .then(text => showzipaddr(text));
});

sendzip?.addEventListener('click', ()=> {
    let frm = document.forms.joinfrm;
    let addr = addrlist.value; // 선택한 주소 항목
    if (addr !== '') {
        // 123-456 서울 관악구 신림동
        let zip = addr.split(' ')[0];
        let addrs = addr.split(' ');// 우편번호 추출
        let vaddr = `${addrs[1]} ${addrs[2]} ${addrs[3]}`; //주소 추출 - 배열에 담긴다. 인덱스 값, 위치 값 이용해서 가져오는 것.

        frm.zip1.value = zip.split('-')[0];
        frm.zip2.value = zip.split('-')[1];
        frm.addr1.value = vaddr;

    }else {
        alert('주소를 선택하세요!!');
    }
});