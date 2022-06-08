function solution(citations) {    
    citations.sort(function(a, b) {
      return b - a;
    });
    
    const len = citations.length;
    let answer = 0;
    
    citations.forEach((val, idx) => {
        if(val >= idx + 1) {
            answer = idx + 1;
        }
    })
    return answer;
}