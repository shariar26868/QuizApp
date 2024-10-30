import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class userCreate {
    public static void main(String[] args) throws IOException {
        JSONObject admin= new JSONObject();
        admin.put("username", "admin");
        admin.put("password", "1234");
        admin.put("role", "admin");

        JSONObject student1 = new JSONObject();
        student1.put("username", "shaikat");
        student1.put("password", "1234");
        student1.put("role", "student");

        JSONObject student2 = new JSONObject();
        student2.put("username", "salman");
        student2.put("password", "1245");
        student2.put("role", "student");

        JSONObject student3=new JSONObject();
        student3.put("username", "akib");
        student3.put("password", "2345");
        student3.put("role", "student");

        JSONArray userArray=new JSONArray();
        userArray.add(student1);
        userArray.add(student2);
        userArray.add(student3);
        FileWriter file=new FileWriter("./src/main/resources/user.json");

        file.write(userArray.toJSONString());
        file.flush();
        System.out.println("USer create successful");
        file.close();



    }

}
