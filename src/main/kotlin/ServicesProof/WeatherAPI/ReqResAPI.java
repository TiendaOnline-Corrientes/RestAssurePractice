package ServicesProof.WeatherAPI;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.REQRES.POST.PostUserRequest;
import model.REQRES.POST.PostUserResponse;
import model.ResponseData;

import static io.restassured.RestAssured.given;

public class ReqResAPI extends BaseMain{


    //RequestSpecification: to club common request specification, this is an interface this allows us
    // how the request will look like it has methods like BaseURL,BasePath,headers, etc.
    //Remember is an interface we cannot create an object of it
    protected RequestSpecification baseRequestSpecification(){
        return  given().
                        contentType(ContentType.JSON).
                        baseUri(getProperty("reqresBaseURL"));
    }

    public ResponseData getSingleUser(){
        return  baseRequestSpecification().
                when().
                       get(getProperty("reqresPathUser")).
                then().
                        extract().
                        body().
                        as(ResponseData.class);
    }

    public PostUserResponse postUserRequest(PostUserRequest postUserRequest){
        return baseRequestSpecification().
                       body(postUserRequest).
                when().
                       post(getProperty("reqresPathPost")).
                then().
                       extract().
                       as(PostUserResponse.class);
    }


}
