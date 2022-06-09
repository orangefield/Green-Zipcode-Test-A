import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;

public class TextToCsvFile {

    private static final String WORKSPACE = "C:\\green_workspace\\orangefield01\\zipcode-test-practice\\";
    private static final String RESOURCE = WORKSPACE + "resource\\";

    // path = 내 프로젝트 경로와 내부 resource 폴더가 내장되어 있습니다
    // encType = UTF-8, EUC-KR 등을 입력합니다
    protected String readFile(String path, String encType) {
        try {

            FileReader reader = new FileReader(RESOURCE + path, Charset.forName(encType));
            BufferedReader br = new BufferedReader(reader);

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }

            reader.close();
            br.close();

            return sb.toString();

        } catch (Exception e) {
            System.out.println("파일의 경로가 잘못 되었습니다");
        }
        return null;
    }

    // CSV 형태로 변환합니다
    protected String convertCsv(String data, String seperator) {
        return data.replaceAll("\\" + seperator, ", ");
    }

    protected int writeFile(String path, String encType, String csvStr) {
        try {

            FileWriter writer = new FileWriter(RESOURCE + path, Charset.forName(encType));
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write(csvStr);
            bw.flush();

            writer.close();
            bw.close();
            return 1;

        } catch (Exception e) {
            System.out.println("파일 쓰기를 실패했습니다. 이유 : " + e.getMessage());
        }
        return -1;
    }

    // public int process(String readFilePath, String writeFilePath) {
    // String data = readFile(readFilePath, "UTF-8");
    // String csvData = convertCsv(data, "^");

    // return writeFile(writeFilePath, "UTF-8", csvData);
    // }

}