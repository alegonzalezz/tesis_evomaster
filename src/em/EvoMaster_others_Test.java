import  org.junit.AfterClass;
import  org.junit.BeforeClass;
import  org.junit.Before;
import  org.junit.Test;
import static org.junit.Assert.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import  io.restassured.config.JsonConfig;
import  io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import  org.evomaster.client.java.controller.expect.ExpectationHandler;
import  io.restassured.path.json.JsonPath;
import  java.util.Arrays;




/**
 * This file was automatically generated by EvoMaster on 2024-03-10T21:40:45.013Z[Etc/UTC]
 * <br>
 * The generated test suite contains 5 tests
 * <br>
 * Covered targets: 10
 * <br>
 * Used time: 0h 1m 11s
 * <br>
 * Needed budget for current results: 100%
 * <br>
 * This file contains test cases that represent failed calls, but not indicative of faults.
 */
public class EvoMaster_others_Test {

    
    private static String baseUrlOfSut = "https://api.apis.guru";
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    
    
    @BeforeClass
    public static void initClass() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;
        RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
    }
    
    
    
    
    
    
    
    
    @Test(timeout = 60000)
    public void test_0() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/v2/specs/OhS_I8a2ki/G5ArxLNDorbA/JB.json")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/v2/NP/services.json")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/v2/specs/_EM_2_XYZ_/_EM_3_XYZ_.json")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/v2/YOgsW.json")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/:-1/v2/openapi.yaml")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
    }


}
