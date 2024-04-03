## TODO

- InputView
  - inputBallNumber
  - inputGameOverOption
- Random
  - create
  - createDifferentNumbers(count)
- Balls
  - play(Balls)
- OutputView
  - showError
  - showResult

### 왜 balls가 아닌 ball이 자리에 대한 정보를 가지는가?

전문가 패턴은 해당 정보를 잘 알고있는 객체에게 책임을 할당한다.

balls와 ball 둘 중 위치에 대한 정보를 알아야하는 객체는 어떤 객체인가?

- balls는 여러개의 ball에 대한 정보를 가진다. 
- ball은 공 하나에 대한 정보를 가진다.
