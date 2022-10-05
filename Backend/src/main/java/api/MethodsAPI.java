package api;
import util.Huvuduppgift2;
import util.UserJsonHandler;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("methods")
public class MethodsAPI {

    private static String usersJson = UserJsonHandler.getUsers();


    @GET
    @Path("userswithreversednames")
    public static Response usersWithReversedNames() {
        return Response.ok(
                UserJsonHandler.reverseUserFirstnames(usersJson)
        ).build();
    }

    @POST
    @Path("reversestring")
    public static Response reverseString(@FormParam("string") String string) {
        return Response.ok(
                UserJsonHandler.reverseString(string)
        ).build();
    }

    @POST
    @Path("ispalindrome")
    public static Response isPalindrome(@FormParam("string") String string) {
        return Response.ok(
                UserJsonHandler.isStringPalindrome(string)
        ).build();
    }

    @POST
    @Path("padnumberwithzeroes")
    public static Response padNumberWithZeroes(@FormParam("number") int number) {
        return Response.ok(
                Huvuduppgift2.addZerosToInt(number)
        ).build();
    }

    @POST
    @Path("findnthlargestnumber")
    public static Response findNthLargestNumber(@FormParam("numbers") List<Integer> numbers,
                                                @FormParam("nthlargestnumber") int nthLargestNumber) {
        return Response.ok(
                Huvuduppgift2.findNthLargestNumber(nthLargestNumber, numbers)
        ).build();
    }

}
