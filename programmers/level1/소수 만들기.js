function solution(nums) {
    const board = prime(nums.length * 1000);
    let count = 0;
    for(let i = 0; i < nums.length - 2; i++) {
        for(let j = i+1; j < nums.length - 1; j++) {
            for(let k = j + 1; k < nums.length; k++) {
                if(board[nums[i]+nums[j]+nums[k]]) {
                    count++;
                }
            }
        } 
    }
    return count;
}
function prime(n) {
    const arr = new Array(n).fill(true).fill(false, 0, 2);
    for (let i = 2; i * i <= n; i++) {
        if (!arr[i]) continue;
        for (let j = i + i; j <= n; j += i) {
            arr[j] = false;
        }
    }
    return arr;
}