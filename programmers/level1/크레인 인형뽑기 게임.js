// input board [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
// input moves [1,5,3,5,1,2,1,4]	
// output 4
// 빈 공간에서 꺼내면 아무것도 없다
// 스택에 넣어두고 같으면 터트리면 됨
class Stack {
    _arr;
    _count;
    constructor() {
        this._arr = [];
        this._count = 0;
    }
    push(item) {
        if(this.length() && this.peek() === item) {
            this.boom();
            this.pop();
        } else {
            this._arr.push(item);
        } 
    }
    pop() {
        return this._arr.pop();
    }
    peek() {
        return this._arr[this._arr.length - 1];
    }
    length() {
        return this._arr.length;
    }
    boom() {
        return this._count++;
    }
    get count() {
        return this._count;
    }
}
function solution(board, moves) {
    const len = board.length;
    const stack = new Stack();
    
    for (const n of moves) {
        for (let x = 0; x < len; x++) {
            if(board[x][n-1]) {
                stack.push(board[x][n-1]);
                board[x][n-1] = 0;
                break;
            }
        }
    }
    
    // return 총 터진 갯수
    return stack.count * 2;
}


const board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]];
const moves = [1,5,3,5,1,2,1,4];

console.log(solution(board, moves));