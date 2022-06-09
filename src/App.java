import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;

public class App {

    // 파일 경로를 변수화
    private static final String WORKSPACE = "C:\\green_workspace\\orangefield01\\zipcode-test-practice\\";
    private static final String RESOURCE = WORKSPACE + "resource\\";

    public static void main(String[] args) throws Exception {

        // 파일 읽기 과정
        FileReader reader = new FileReader(RESOURCE + "zipcode.txt", Charset.forName("utf-8"));
        BufferedReader br = new BufferedReader(reader);

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {

            // 구분자를 콤마로 변환
            String csvline = line.replaceAll("\\^", ", ");
            sb.append(csvline + "\n");
        }
        String resultLine = sb.toString();

        // 버퍼를 열었으면 닫아야 한다
        reader.close();
        br.close();

        // 파일 쓰기 과정
        FileWriter writer = new FileWriter(RESOURCE + "zipcode.csv", Charset.forName("utf-8"));
        BufferedWriter bw = new BufferedWriter(writer);

        bw.write(resultLine);
        bw.flush();

        // 버퍼를 열었으면 닫아야 한다
        writer.close();
        bw.close();

    }
}