package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility_FetchProperty {
    public static String fetchProperty_Value(String key) throws IOException {
        FileInputStream i=new FileInputStream("./src/test/resources/config/config.properties");
        Properties p=new Properties();
        p.load(i);
        return p.get(key).toString();
    }
}
