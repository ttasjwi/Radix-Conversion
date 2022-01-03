
# History

- 이 프로젝트의 역사를 기록했습니다.

---

# Logicgate

### Initial commit

프로젝트 관리에 필요한 몇 가지 파일들을 추가했다.

- `README.md` 파일 추가 : 프로젝트 소개용 마크다운 문서
- `.gitignore` 파일 추가 : git의 tracking에서 예외시킬 파일들 목록
- `History.md` 파일 추가 : 프로젝트의 변경사항 기록

### LogicGate 클래스 생성, and 메서드 추가

LogicGate 클래스 : 논리게이트의 역할을 하는 메서드 모음.  
논리회로의 and 역할을 수행하는 and 메서드를 추가했다.

- and 메서드 : boolean 인자 두개가 모두 true일 때만 true를 반환한다.

### or 메서드 추가  

논리회로의 or 역할을 수행하는 or 메서드를 추가했다.  

- or 메서드 : boolean 인자 둘 중 적어도 하나가 true이면 true를 반환한다.

### not 메서드 추가

논리회로의 not 역할을 수행하는 not 메서드를 추가했다.

- not 메서드 : 입력된 `boolean` 인자에 대하여 반대되는 `boolean` 값을 반환한다.

### nand 메서드 추가

논리회로의 nand 역할을 수행하는 nand 메서드를 추가했다.  

- nand 메서드
    - 입력된 `boolean` 두개의 인자에 대하여 and 메서드의 결과값에 반대되는 `boolean` 값을 반환한다.
    - 두개의 boolean 인자가 모두 true일때 false가 반환됨.
    - 둘 중 적어도 하나의 인자가 false이면 true가 반환됨.

### nor 메서드 추가  

논리회로의 nor 역할을 수행하는 nor 메서드를 추가했다.  

- nor 메서드
  - 입력된 `boolean` 두개의 인자에 대하여 or 메서드의 결과값에 반대되는 `boolean` 값을 반환한다.
  - 두개의 boolean 인자 중 적어도 하나가 true일때 false가 반환됨.
  - 두개의 boolean 인자 모두 false 일 때 true가 반환됨.

### xor 메서드 추가

논리회로의 xor 역할을 수행하는 xor 메서드를 추가했다.  

- xor 메서드
  - 입력된 `boolean` 인자가 서로 다르면 true를 반환한다.

### xnor 메서드 추가

논리회로의 xnor 역할을 수행하는 xnor 메서드를 추가했다.

- xnor 메서드
  - 입력된 `boolean` 인자가 서로 같으면 true를 반환한다.
    - xor 메서드의 반대값

## buffer 메서드 추가  

논리회로의 buffer 역할을 수행하는 buffer 메서드를 추가했다.  

- buffer 메서드
  - 입력된 `boolean` 인자와 동일한 boolean 값을 반환한다.

---

# Adder

### Adder 클래스 생성, halfAdd 메서드 추가

가산기 Adder 클래스를 생성 및, Adder에 halfAdd 메서드를 추가했다.

- halfAdd 메서드
  - 입력된 두 boolean 값에 대하여, 가산작업을 수행하여 `boolean` 배열로 다음의 결과를 저장해 반환한다.
    - 결과의 0번째 인덱스에는 자리바꿈 (and 연산)
    - 결과의 1번째 인덱스에는 합 결과 (xor 연산)

### fullAdd 메서드 추가

Adder 클래스에 fullAdd 메서드를 추가했다.
비트 단위의 덧셈을 온전히 수행할 수 있다.

- fullAdd 메서드
  - 비트 두 개의 합과, 자리올림수 입력이 주어졌을 때 다음 결과를 배열에 저장해 반환한다.
    - carryOut(0번 인덱스) : 자리올림수
    - Sum(1번 인덱스) : 합(자리에 남는 수)

---