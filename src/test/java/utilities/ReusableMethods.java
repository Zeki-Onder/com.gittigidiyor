package utilities;


import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReusableMethods {


    public static void writeToTxt(String fileName, WebElement element) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(element.getText());
            writer.append("\n");
            writer.close();
        } catch (Exception e) {
        }
    }

    public static List readTxt(String filePath) {
        List list = new ArrayList();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

}

