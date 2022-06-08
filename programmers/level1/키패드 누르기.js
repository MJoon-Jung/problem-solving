function solution(numbers, hand) {
    // 왼손은 1,4,7
    // 오른손은 3,6,9
    // 공통 2,5,8,0 - 키패드 위치에서 더 가까운 엄지손가락
    // 거리가 같다면 오른손 잡이는 오른손 엄지
    let answer = '';
    const leftNum = [1, 4, 7];
    const rightNum = [3, 6, 9];
    const keyPad = { 
                    1: [0, 0],
                    2: [0, 1],
                    3: [0, 2],
                    4: [1, 0],
                    5: [1, 1],
                    6: [1, 2],
                    7: [2, 0],
                    8: [2, 1],
                    9: [2, 2],
                    '*': [3, 0],
                    0: [3, 1],
                    '#': [3, 2]
                };
    let lHand = keyPad['*'];
    let rHand = keyPad['#'];
    
    for (const n of numbers) {
        // 숫자가 왼손 오른손 공통인지 판단
        let isLeft = false;
        if (leftNum.includes(n)) {
            isLeft = true;
        } else if (rightNum.includes(n)) {
        } else {
            // 공통 - 거리 판단
            const lDistance = getDistance(keyPad[n], lHand);
            const rDistance = getDistance(keyPad[n], rHand);
            if(lDistance === rDistance) {
                if(hand === 'left') {
                    isLeft = true;
                }
            } else if(lDistance < rDistance) {
                isLeft = true;
            }
        }
        // 공통 - 거리 같다면 주 손 판단
        if(isLeft) {
            lHand = keyPad[n];
            answer += 'L';
        }else {
            rHand = keyPad[n];
            answer += 'R';
        }
    }
    return answer;
}
function getDistance(keyPad, hand) {
    return Math.abs(keyPad[0] - hand[0]) + Math.abs(keyPad[1] - hand[1]);
}