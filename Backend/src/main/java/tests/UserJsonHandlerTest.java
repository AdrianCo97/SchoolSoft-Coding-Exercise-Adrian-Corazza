package tests;

import entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.UserJsonHandler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserJsonHandlerTest {

    private static String userJsonString;

    @BeforeAll
    public static void setup(){
        userJsonString = UserJsonHandler.getUsers();
    }

    @Test
    void reverseUserFirstnamesShouldReverseEveryName(){
        //Obtain all the reversed firstnames from the json values;
        String reversedUserFirstnames = UserJsonHandler.reverseUserFirstnames(userJsonString);

        List<User> usersWithOriginalFirstnames = UserJsonHandler.extractValuesFromJsonString(userJsonString);
        List<User> usersWithReversedNames = UserJsonHandler.extractValuesFromJsonString(reversedUserFirstnames);

        for(int i = 0; i < usersWithReversedNames.size(); i++){
            String reversedOriginalFirstname = UserJsonHandler.reverseString(usersWithOriginalFirstnames.get(i).getFirstname());
            String reversedNameWithoutPalindromeFlag = usersWithReversedNames.get(i).getFirstname().split(",")[0];
            assertEquals(reversedNameWithoutPalindromeFlag, reversedOriginalFirstname);
        }
    }

    @Test
    void reverseStringShouldReverseString(){
        String stringToReverse = "Adrian";
        assertEquals("nairdA", UserJsonHandler.reverseString(stringToReverse));
    }

    @Test
    void extractValuesFromJsonStringShouldReturnValues(){
        List<User> users = UserJsonHandler.extractValuesFromJsonString(userJsonString);
        assertEquals(1, users.get(0).getId());
        assertEquals("Anna", users.get(0).getFirstname());
        assertEquals("Graham", users.get(0).getLastname());
        assertEquals("angr", users.get(0).getUsername());
        assertEquals(30, users.get(0).getAge());
    }

    @Test
    void isStringPalindromeTest(){
        Boolean isPalindrome = UserJsonHandler.isStringPalindrome("Anna");
        assertEquals(true, isPalindrome);

        Boolean isNotPalindrome = UserJsonHandler.isStringPalindrome("Adrian");
        assertFalse(isNotPalindrome);
    }

    @Test
    void convertUserListToJsonTest(){
        List<User> testList = new ArrayList<>();

        User user = new User(1, "Adrian", "Corazza", "adri", 25);
        testList.add(user);

        String json = UserJsonHandler.convertUserListToJson(testList);
        String jsonString = json.replaceAll("\r\n", "");
        String expectedJson = "[ {  \"id\" : 1,  \"firstname\" : \"Adrian\",  \"lastname\" : \"Corazza\",  \"username\" : \"adri\",  \"age\" : 25} ]";
        assertEquals(expectedJson, jsonString);
    }
}