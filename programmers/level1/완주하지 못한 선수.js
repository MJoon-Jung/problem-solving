function solution(participant, completion) {
    const pList = {};
    participant.forEach((p) => pList[p] = (pList[p] + 1) || 1);
    completion.forEach((c) => pList[c] -= 1);
    for(const p in pList) {
        if(pList[p]) return p;
    }
}