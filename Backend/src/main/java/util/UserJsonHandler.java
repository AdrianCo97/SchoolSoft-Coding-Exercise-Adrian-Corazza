package util;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserJsonHandler {

    private final ClassLoader classLoader = this.getClass().getClassLoader();

    public static String getUsers() {
        try{
            final File file = new File("src/main/res/users.json");
            final StringBuilder stringBuilder = new StringBuilder();
            final BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static String reverseUserFirstnames(String json){
        List<User> userList = extractValuesFromJsonString(json);
        List<User> usersWithReversedNames = new ArrayList<>();
        for(User user : userList){
            boolean isPalindrome = isStringPalindrome(user.getFirstname());

            if(isPalindrome){
                user.setFirstname(reverseString(user.getFirstname()) + ", is a palindrome");
            }
            else{
                user.setFirstname(reverseString(user.getFirstname()));
            }
            usersWithReversedNames.add(user);
        }
        return convertUserListToJson(usersWithReversedNames);
    }

    public static String reverseString(String string){
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = chars.length - 1; i >= 0; i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static List<User> extractValuesFromJsonString(String json){
        try{
            ObjectMapper mapper = new ObjectMapper();
            User[] users = mapper.readValue(json, User[].class);

            List<User> usersList = new ArrayList<>(Arrays.asList(users));
            return usersList;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean isStringPalindrome(String string){
        String stringInLowerCase = string.toLowerCase();
        String reversedString = reverseString(stringInLowerCase);

        if(stringInLowerCase.equals(reversedString)){
            return true;
        }
        return false;
    }

    public static String convertUserListToJson(List<User> userList){
        ObjectMapper mapper = new ObjectMapper();
        try{
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);
            return json;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
