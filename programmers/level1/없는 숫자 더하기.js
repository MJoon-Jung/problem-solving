function solution(numbers) {
    return [...new Set(numbers)].reduce((pre, cur) => pre - cur, 45);
}