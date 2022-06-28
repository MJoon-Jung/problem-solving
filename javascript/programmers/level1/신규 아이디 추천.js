function checkStr(str) {
    if(str >= 'a' && str <= 'z') {
        return true;   
    } 
    if(str >= '0' && str <= '9') {
        return true;
    }
    if(str === '-' || str === '_' || str === '.') {
        return true;
    }
    return false;
}
function solution(new_id) {
//1. 모든 대문자를 대응되는 소문자로 치환합니다.
    new_id = new_id.toLowerCase();
//2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
    let str = ''
    for(let i = 0; i < new_id.length; i++) {
        if(!checkStr(new_id.charAt(i))) continue;
        str += new_id.charAt(i);
    }
    
//3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
    str = str.replace(/[.]{2,}/g, '.');
//4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
    if(str.charAt(0) === '.') {
        str = str.substring(1, str.length);
    }
    if(str.charAt(str.length-1) === '.') {
        str = str.substring(0, str.length - 1);
    }
//5. 빈 문자열이라면, new_id에 "a"를 대입합니다.
    if (!str) {
        str += 'a';
    }
//6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    if(str.length >= 16) {
        str = str.substring(0, 15);
    }
//   #만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다
    if(str.charAt(str.length-1) === '.') {
        str = str.substring(0, str.length - 1);
    }
//7. 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복
    if(str.length <= 2) {
        const addStr = str.charAt(str.length - 1);
        while(str.length < 3) {
            str += addStr;
        }
    }
    return str;
}