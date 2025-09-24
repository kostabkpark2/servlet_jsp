package ch04;

public class Calculator {
  // 멤버변수
  private int n1;
  private int n2;
  private String op;
  // Getter, Setter
  public int getN1() {
    return n1;
  }

  public void setN1(int n1) {
    this.n1 = n1;
  }

  public int getN2() {
    return n2;
  }

  public void setN2(int n2) {
    this.n2 = n2;
  }

  public String getOp() {
    return op;
  }

  public void setOp(String op) {
    this.op = op;
  }
  // 비즈니스 로직 처리 해주는 메서드
  public long calc() {
    long result = 0L;
    switch (op) {
      case "+" : result = n1 + n2; break;
      case "-" : result = n1 - n2; break;
      case "*" : result = n1 * n2; break;
      case "/" : result = n1 / n2; break;
    }
    return result;
  }
}
