function solution(n, lost, reserve) {
    const l = getMap(lost);
    const r = getMap(reserve);
    
    // reserve에 lost의 학생이 포함되어 있는 경우 제거
    r.forEach((val, key) => {
        if(l.get(key)) {
            r.delete(key);
            l.delete(key);
        }
    });
    
    // lost에서 학생의 +-1인 학생이 reserve의 포함되는 학생이면 lost, reserve Map에서 삭제
    l.forEach((_, key) => {
        if (r.get(key-1)) {
            l.delete(key);
            r.delete(key-1);
        } else if (r.get(key+1)) {
            l.delete(key);
            r.delete(key+1);
        }
    })
    
    // 학생 수 - lost 인원 수
    return n - l.size;
}
function getMap(arr) {
    const map = new Map();
    arr.forEach((val) => map.set(val, true));
    return new Map([...map.entries()].sort());
}