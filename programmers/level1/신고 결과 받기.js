/**
    전제 조건
    중복 신고 X 1회 처리
    신고 제한 X 여러 명을 신고할 수 있음
    내가 신고한 사람이 정지된다면 메일을 발송받음
    K번 이상 신고당하면 정지
    id_list에는 같은 아이디 중복X
    이용자id와 신고한id는 공백(스페이스)하나로 구분되어 있습니다.
    자기 자신 신고 X
    id_list 배열에 존재하는 유저 순으로 메일 발송받는 횟수를 리턴
*/

function solution(id_list, report, k) {
    const answer = [];
    const reportList = {};
    const reportedList = {};
    const kOver = [];
    
    for (const val of report) {
        // 신고한 유저와 신고당한 유저 구별
        const result =  val.split(' ');
        
        const reporter = result[0];
        const reported = result[1];
        
        if(!reportList[reporter]) {
            reportList[reporter] = [];
        }
        // 신고한 유저와 신고당한 유저 중복 체크
        if(reportList[reporter].includes(reported)) continue;
        reportList[reporter].push(reported);
        reportedList[reported] = (reportedList[reported] || 0) + 1;
    }
    // K번 이상 신고당했는지 체크
    for (const reported in reportedList) {
        if (reportedList[reported] < k) continue;
        kOver.push(reported);
    }
    // 내가 신고한 유저 중 K번 이상 신고 당한 유저가 몇명 있는지 체크
    for (const id of id_list) {
        let result = 0;
        for (const reported of kOver) {
          if(reportList[id] && reportList[id].includes(reported)) result++;
        }
        answer.push(result);
    }
    // return Array<number> 배열 형식    
    return answer;
}

const id_list = ["muzi", "frodo", "apeach", "neo"];
const report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"];
const k = 2;
const result = solution(id_list, report, k);
console.log(result);








