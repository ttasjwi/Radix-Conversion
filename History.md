
# History

- 이 프로젝트의 역사를 기록했습니다.

---

# [Work 1] Logicgate 추가작업

### (v 1.01) Initial commit

프로젝트 관리에 필요한 몇 가지 파일들을 추가했다.

- `README.md` 파일 추가 : 프로젝트 소개용 마크다운 문서
- `.gitignore` 파일 추가 : git의 tracking에서 예외시킬 파일들 목록
- `History.md` 파일 추가 : 프로젝트의 변경사항 기록

### (v 1.02) LogicGate 클래스 생성, and 메서드 추가

LogicGate 클래스 : 논리게이트의 역할을 하는 메서드 모음.  
논리회로의 and 역할을 수행하는 and 메서드를 추가했다.

- and 메서드 : boolean 인자 두개가 모두 true일 때만 true를 반환한다.

### (v 1.03) or 메서드 추가  

논리회로의 or 역할을 수행하는 or 메서드를 추가했다.  

- or 메서드 : boolean 인자 둘 중 적어도 하나가 true이면 true를 반환한다.

### (v 1.04) not 메서드 추가

논리회로의 not 역할을 수행하는 not 메서드를 추가했다.

- not 메서드 : 입력된 `boolean` 인자에 대하여 반대되는 `boolean` 값을 반환한다.

### (v 1.05) nand 메서드 추가

논리회로의 nand 역할을 수행하는 nand 메서드를 추가했다.  

- nand 메서드
    - 입력된 `boolean` 두개의 인자에 대하여 and 메서드의 결과값에 반대되는 `boolean` 값을 반환한다.
    - 두개의 boolean 인자가 모두 true일때 false가 반환됨.
    - 둘 중 적어도 하나의 인자가 false이면 true가 반환됨.

### (v 1.06) nor 메서드 추가  

논리회로의 nor 역할을 수행하는 nor 메서드를 추가했다.  

- nor 메서드
  - 입력된 `boolean` 두개의 인자에 대하여 or 메서드의 결과값에 반대되는 `boolean` 값을 반환한다.
  - 두개의 boolean 인자 중 적어도 하나가 true일때 false가 반환됨.
  - 두개의 boolean 인자 모두 false 일 때 true가 반환됨.

### (v 1.07) xor 메서드 추가

논리회로의 xor 역할을 수행하는 xor 메서드를 추가했다.  

- xor 메서드
  - 입력된 `boolean` 인자가 서로 다르면 true를 반환한다.

### (v 1.08) xnor 메서드 추가

논리회로의 xnor 역할을 수행하는 xnor 메서드를 추가했다.

- xnor 메서드
  - 입력된 `boolean` 인자가 서로 같으면 true를 반환한다.
    - xor 메서드의 반대값

## (v 1.09) buffer 메서드 추가  

논리회로의 buffer 역할을 수행하는 buffer 메서드를 추가했다.  

- buffer 메서드
  - 입력된 `boolean` 인자와 동일한 boolean 값을 반환한다.

---

# [Work 2] Adder 추가 작업

### (v 2.01) Adder 클래스 생성, halfAdd 메서드 추가

가산기 Adder 클래스를 생성 및, Adder에 halfAdd 메서드를 추가했다.

- halfAdd 메서드
  - 입력된 두 boolean 값에 대하여, 가산작업을 수행하여 `boolean` 배열로 다음의 결과를 저장해 반환한다.
    - 결과의 0번째 인덱스에는 자리바꿈 (and 연산)
    - 결과의 1번째 인덱스에는 합 결과 (xor 연산)

### (v 2.02) fullAdd 메서드 추가

Adder 클래스에 fullAdd 메서드를 추가했다.
비트 단위의 덧셈을 온전히 수행할 수 있다.

- fullAdd 메서드
  - 비트 두 개의 합과, 자리올림수 입력이 주어졌을 때 다음 결과를 배열에 저장해 반환한다.
    - carryOut(0번 인덱스) : 자리올림수
    - Sum(1번 인덱스) : 합(자리에 남는 수)

### (v 2.03) byteAdd 메서드 추가

Adder 클래스에 byteAdd 메서드를 추가했다.
바이트 단위의 덧셈을 온전히 수행할 수 있다.

- byteAdd 메서드
  - boolean 배열에 대하여 Add 덧셈을 수행한다.
    - 배열의 크기가 다를 경우 큰 배열에 맞게 배열의 크기를 통일하여 연산을 수행한다.
    - 맨 마지막 자리수에서 carry값이 true가 반환되면, 배열의 길이를 1 증가시켜, 맨 마지막 자리에 true를 입력하여 반환한다.

---

# [Work 3] Converter

### (v. 3.01) Converter 클래스 생성, dec2bin 메서드 추가

진법을 변환하는 메서드들을 모아둔 Converter 클래스를 생성.

- dec2bin 메서드 : 십진수(int 타입)가 입력됐을 때, 다음 반복을 통해 이를 이진수로 변환한 boolean 배열을 반환한다.
  - current에 인자를 저장하고, 다음 반복을 통해 이진배열을 반환한다. (current가 0보다 클 때만 반복을 수행한다.)
    - 배열의 길이를 한 단계 더 늘린다. (배열을 복제하여 한 단계 큰 배열로 참조를 변경한다.)
    - 2로 나눈 나머지를 판단하여 배열의 다음 인덱스에 추가
    - 2로 나눈 몫을 current에 저장한다.


### (v 3.02) intExponentiation 메서드 추가

정수의 거듭제곱꼴을 계산하는 메서드. Converter 클래스 내부적으로 사용하기 위하여 정의

- `int intExponentiation(int base, int exponent)` : base의 exponent 제곱을 반환함.

### (v 3.03) bin2dec 메서드 추가

이진수(boolean 배열)를 십진수로 변환하는 bin2dec 메서드를 추가

- bin2dex 메서드 : 이진수가 입력됐을 때 이를 십진수로 변환하여 반환함.
  - 배열의 첫번째 인덱스부터 배열의 끝까지, 각 인덱스에 대응하는 2의 거듭제곱값을 누적함 (intExponentation 메서드 참조)
  
---

### [semiWork] History.md 수정

History.md의 기록별로 순서대로 숫자를 부여했다.

---

# [Work 4] Adder 수정

### (v 4.01) getBitSum 메서드 분리

- 두 bit 값이 입력됐을 때 `bitSum`을 반환하도록 한다.
  - 두 비트에 대한 `xor 게이트`의 return 값이 반환된다.
  - 이 메서드는 자리 올림을 고려하지 않는다.
  - 이후 사용할 메서드들에서 내부적으로 사용될 메서드이므로, private 메서드로 선언했다.

### (v 4.02) getBitCarryOut 메서드 분리

- 두 bit 값이 입력됐을 때 두 비트값의 합에 대한 자리올림 비트를 반환하도록 한다.
  - 두 비트에 대한 `and 게이트`의 return 값이 반환된다.
  - 이 메서드는 부가적인 자리 올림이 입력된 상황은 고려하지 않는다.
  - 이후 사용할 메서드들에서 내부적으로 사용될 메서드이므로, private 메서드로 선언했다.

### (v 4.03) halfAdd 메서드 수정

- halfAdd 메서드를 수정했다.
  - bitSum, bitCarryOut 값을, getBitSum, getBitCarryOut 메서드를 참조하도록 하였다.
  - 다른 메서드를 참조하도록 하였더니 코드가 간결해졌다.

### (v 4.04) fullAdd 메서드 수정

- fullAdd 메서드를 수정했다.
  - 두번에 거친 halfAdd 결과물 각각에 대해 변수명을 붙여서 코드를 정리했다.


### (v 4.05) byteAdd 메서드 수정, extendArray 추가

- byteAdd 메서드를 수정했다.
  - 배열의 길이를 늘리는 작업을 별도로 메서드를 분리했다.
  - 배열의 길이를 처음부터 주어진 bit 배열의 최대길이보다 1개 더 길게 생성하도록 했다.
  - 마지막 인덱스에 carry 추가
    - 기존 메서드에서 마지막 인덱스 번호 지정이 잘못 되어있던 것을 발견해서 수정했다

- exetendArray 메서드 추가
  - byteAdd 메서드에서 처음에 배열의 길이를 늘리는 작업을 하던 것을 메서드를 분리하여 처리하도록 했다.
    - 배열의 길이가 최대인 것은 배열을 복사하지 않고 그대로 반환하도록 했다.

---
