import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File file = new File("./input.xml");
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Accounts accounts = xmlMapper.readValue(file,Accounts.class);
            System.out.println(accounts.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
