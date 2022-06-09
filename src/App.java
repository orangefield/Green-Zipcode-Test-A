public class App {

    public static void main(String[] args) throws Exception {
        int result = TextToCsvFile.process("zipcode.txt", "zipcode.csv");

        if (result == 1) {
            System.out.println("csv 파일 생성에 성공했습니다");
        } else {
            System.out.println("csv 파일 생성을 실패했습니다");
        }
    }
}