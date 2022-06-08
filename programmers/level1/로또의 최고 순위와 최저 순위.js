/**
 * 1~45 숫자 중 6개 맞추는 복권
 * 6 - 5 - 4 - 3 - 2 개수 순으로 순위가 정해짐
 * 알아볼 수 없는 번호를 0으로 표기
 * 순서와 상관없이 구매한 로또에 당첨 번호와 일치하면 인정
 * 당첨 가능한 최고 순위와 최저 순위를 배열에 담아서 리턴
 * 
 * win_nums: 당첨 번호
 * lottos : 구매한 로또 번호
 */

function solution(lottos, win_nums) {
  // win: win_nums 값 정보 
  const win = {}
  for (n of win_nums) {
    win[n] = true;
  }
  
  let zeroCount = 0;
  let check = 0;
  for(const n of lottos) {
    //0의 개수
    if(n === 0) {
      zeroCount++;
      continue;
    }
    // 이미 당첨된 번호 개수
    if(win[n]) check++;

  }
  return [getRank(check + zeroCount), getRank(check)];
}

function getRank(n) {
  const result = 7 - n;
  if(result > 5) return 6;
  return result;
}

const lottos = [[44, 1, 0, 0, 31, 25],[0, 0, 0, 0, 0, 0],[45, 4, 35, 20, 3, 9]];
const win_nums = [[31, 10, 45, 1, 6, 19],[38, 19, 20, 40, 15, 25],[20, 9, 3, 45, 4, 35]];
const result = [[3, 5],[1, 6],[1, 1]];

for (let i = 0; i < lottos.length; i++) {
    const answer = solution(lottos[i], win_nums[i]);
    console.log('answer', answer);
    console.log('result', result[i]);
}