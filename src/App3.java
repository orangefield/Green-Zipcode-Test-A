public class App3 {

    public static void CSV파일만들기(TextToCsvFileAble ttc) {
        ttc.process("zipcode.txt", "zipcode.csv");
    }

    public static void main(String[] args) {
        CSV파일만들기(new TextToCsvFile()); // 인터페이스 구현
    }
}
