package study.baseball;

import java.util.Random;

public class Computer {

    /// Fields
    int size = 3; // default 3

    /// Constructor
    public Computer(int size) {
        this.size = size;
    }

    /// Method
    public String generateNumber() {
        // 필요한 객체 선언
        StringBuilder numbers = new StringBuilder();
        Random random = new Random();
        // 랜덤 값 만들기
        for (int i = 0 ; i < size ; i ++) {
            numbers.append(random.nextInt(9));
        }
        // 반환
        return numbers.toString();
    }
}
