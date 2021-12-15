import ServicesProof.WeatherAPI.ReqResAPI;
import model.REQRES.POST.PostUserRequest;
import model.REQRES.POST.PostUserResponse;
import model.ResponseData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WeatherTestCases {

    private ReqResAPI reqResAPI;
    private PostUserRequest postUserRequest;
    private PostUserResponse postUserResponse;
    private  ResponseData response;
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void getUserTestCase() {
        reqResAPI = new ReqResAPI();
        response = reqResAPI.getSingleUser();
        softAssert.assertTrue(response.getData().first_name.equals("Janet"));
        softAssert.assertEquals(response.getSupport().getUrl(), "https://reqres.in/#support-heading");
        softAssert.assertAll();
    }


    @DataProvider(name="post-data")
    public Object[][] postValues(){
        return new Object[][]{
                {"marcos","QA engineer"},
                {"noemi","Seller"}
        };
    }

    @Test(dataProvider = "post-data")
    public void postUserTestCase(String name, String job){
        postUserRequest = new PostUserRequest();
        postUserRequest.setName(name);
        postUserRequest.setJob(job);
        reqResAPI = new ReqResAPI();
        postUserResponse = reqResAPI.postUserRequest(postUserRequest);
        softAssert.assertEquals(postUserResponse.getName(),name);
        softAssert.assertEquals(postUserResponse.getJob(),job);
        softAssert.assertAll();
    }

}
