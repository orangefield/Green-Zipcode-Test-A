public class App2 extends TextToCsvFile {

    /**
     * <메서드 재정의>
     *
     * TextToCsvFile을 상속받아 protected 메서드에 접근해
     * readFile 메서드를 재정의했다.
     *
     */

    public int process(String readFilePath, String writeFilePath) {
        String data = readFile(readFilePath, "UTF-8");
        String csvData = convertCsv(data, "-");
        return writeFile(writeFilePath, "UTF-8", csvData);
    }

    public static void main(String[] args) {
        App2 app2 = new App2();

        // TextToCsvFile을 상속받아 protected 메서드에 접근 가능
        String result1 = app2.readFile("zipcode.txt", "euc-kr");
        // System.out.println(result1);

        app2.process("test.txt", "test.csv");

    }
}