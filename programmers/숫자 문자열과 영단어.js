function solution(str) {
    const words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
    
    for (const idx in words) {
        const regExp = new RegExp(words[idx], 'g');
        str = str.replace(regExp, idx);
    }
    return parseInt(str, 10);
} 