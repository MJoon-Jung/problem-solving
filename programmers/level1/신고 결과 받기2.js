function solution(id_list, report, k) {
  const reports = [...new Set(report)].map(v => v.split(' '));

  const counts = new Map();
  reports.forEach((bad) => {
    counts.set(bad[1], (counts.get(bad[1]) || 0) + 1);
  })

  const good = new Map();
  reports.forEach((bad) => {
    if(counts.get(bad[1]) >= k) {
      good.set(bad[0], (good.get(bad[0]) || 0) + 1);
    }
  })

  const answer = id_list.map((id) => good.get(id) || 0);

  return answer;
}

const id_list = ["muzi", "frodo", "apeach", "neo"];
const report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"];
const k = 2;
const result = solution(id_list, report, k);
console.log(result);