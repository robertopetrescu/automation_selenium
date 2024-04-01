package utils;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
    public static By getSelectorFromFile(String selector) {
        By value = null;
        //new Scanner(Paths.get("D:/test.txt"), StandardCharsets.UTF_8)
        try {
            File myObj = new File(System.getProperty("user.dir")+"\\src\\test\\java\\utils\\selectors.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                var row = data.split(",");
                if(row[0].startsWith(selector)) {
                    data = data.replace(selector + ',', "");
                    if (row[1].equals("xpath")) {
                        data = data.replace(row[1] + ',', "");
                        value = By.xpath(data);
                        break;
                    }
                    else {
                        data = data.replace(row[1] + ',', "");
                        value = By.cssSelector(data);
                        break;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return value;
    }
}
