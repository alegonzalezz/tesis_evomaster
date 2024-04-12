import  org.junit.jupiter.api.AfterAll;
import  org.junit.jupiter.api.BeforeAll;
import  org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.evomaster.client.java.controller.db.dsl.SqlDsl.sql;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionResultsDto;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionDto;
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
 * This file was automatically generated by EvoMaster on 2024-04-12T20:37:02.655Z[Etc/UTC]
 * <br>
 * The generated test suite contains 4 tests
 * <br>
 * Covered targets: 10
 * <br>
 * Used time: 0h 1m 0s
 * <br>
 * Needed budget for current results: 100%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class EvoMaster_successes_Test {

    
    private static final SutHandler controller = new org.evomaster.EMDriver();
    private static String baseUrlOfSut;
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    /**
    * rso - response structure oracle - checking that the response objects match the responses defined in the schema
    */
    private static boolean rso = false;
    
    
    @BeforeAll
    public static void initClass() {
        controller.setupForGeneratedTest();
        baseUrlOfSut = controller.startSut();
        controller.registerOrExecuteInitSqlCommandsIfNeeded();
        assertNotNull(baseUrlOfSut);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;
        RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
    }
    
    
    @AfterAll
    public static void tearDown() {
        controller.stopSut();
    }
    
    
    @BeforeEach
    public void initTest() {
        controller.resetDatabase(Arrays.asList("ITEM"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    @Test @Timeout(60)
    public void test_0() throws Exception {
        List<InsertionDto> insertions0 = sql().insertInto("ITEM", 8L)
                .d("ID", "319")
                .d("COST", "995")
                .d("DESCRIPTION", "NULL")
                .d("NAME", "NULL")
            .dtos();
        InsertionResultsDto insertions0result = controller.execInsertionsIntoDatabase(insertions0);
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/items/319")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", nullValue())
                .body("'description'", nullValue())
                .body("'cost'", numberMatches(995.0));
        
    }
    
    
    @Test @Timeout(60)
    public void test_1() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("ITEM", 2L)
                .d("ID", "737")
                .d("COST", "NULL")
                .d("DESCRIPTION", "\"aNwA26XsZ8oN6V0I\"")
                .d("NAME", "\"xXYOC\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/items")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("[0].'name'", containsString("xXYOC"))
                .body("[0].'description'", containsString("aNwA26XsZ8oN6V0I"))
                .body("[0].'cost'", nullValue());
        
        expectationHandler.expect(ems);
    }
    
    
    @Test @Timeout(60)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/v3/api-docs")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'openapi'", containsString("3.0.3"))
                .body("'info'.'title'", containsString("Api Documentation"))
                .body("'info'.'description'", containsString("Api Documentation"))
                .body("'info'.'termsOfService'", containsString("urn:tos"))
                .body("'info'.'contact'.isEmpty()", is(true))
                .body("'info'.'license'.'name'", containsString("Apache 2.0"))
                .body("'info'.'license'.'url'", containsString("http://www.apache.org/licenses/LICENSE-2.0"))
                .body("'info'.'version'", containsString("1.0"))
                .body("'servers'.size()", equalTo(1))
                .body("'servers'[0].'description'", containsString("Inferred Url"))
                .body("'tags'.size()", equalTo(1))
                .body("'tags'[0].'name'", containsString("rest-api"))
                .body("'tags'[0].'description'", containsString("Rest Api"))
                .body("'paths'.'/api/items'.'get'.'tags'.size()", equalTo(1))
                .body("'paths'.'/api/items'.'get'.'tags'", hasItems("rest-api"))
                .body("'paths'.'/api/items'.'get'.'summary'", containsString("getAll"))
                .body("'paths'.'/api/items'.'get'.'operationId'", containsString("getAllUsingGET"))
                .body("'paths'.'/api/items'.'get'.'responses'.'200'.'description'", containsString("OK"))
                .body("'paths'.'/api/items'.'get'.'responses'.'200'.'content'.'*/*'.'schema'.'$ref'", containsString("#/components/schemas/Iterable«Item»"))
                .body("'paths'.'/api/items'.'get'.'responses'.'401'.'description'", containsString("Unauthorized"))
                .body("'paths'.'/api/items'.'get'.'responses'.'403'.'description'", containsString("Forbidden"))
                .body("'paths'.'/api/items'.'get'.'responses'.'404'.'description'", containsString("Not Found"))
                .body("'paths'.'/api/items'.'post'.'tags'.size()", equalTo(1))
                .body("'paths'.'/api/items'.'post'.'tags'", hasItems("rest-api"))
                .body("'paths'.'/api/items'.'post'.'summary'", containsString("create"))
                .body("'paths'.'/api/items'.'post'.'operationId'", containsString("createUsingPOST"))
                .body("'paths'.'/api/items'.'post'.'requestBody'.'content'.'application/json'.'schema'.'$ref'", containsString("#/components/schemas/Item"))
                .body("'paths'.'/api/items'.'post'.'responses'.'200'.'description'", containsString("OK"))
                .body("'paths'.'/api/items'.'post'.'responses'.'200'.'content'.'*/*'.'schema'.'$ref'", containsString("#/components/schemas/ResponseEntity"))
                .body("'paths'.'/api/items'.'post'.'responses'.'201'.'description'", containsString("Created"))
                .body("'paths'.'/api/items'.'post'.'responses'.'401'.'description'", containsString("Unauthorized"))
                .body("'paths'.'/api/items'.'post'.'responses'.'403'.'description'", containsString("Forbidden"))
                .body("'paths'.'/api/items'.'post'.'responses'.'404'.'description'", containsString("Not Found"))
                .body("'paths'.'/api/items/{id}'.'get'.'tags'.size()", equalTo(1))
                .body("'paths'.'/api/items/{id}'.'get'.'tags'", hasItems("rest-api"))
                .body("'paths'.'/api/items/{id}'.'get'.'summary'", containsString("getById"))
                .body("'paths'.'/api/items/{id}'.'get'.'operationId'", containsString("getByIdUsingGET"))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'.size()", equalTo(1))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'name'", containsString("id"))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'in'", containsString("path"))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'description'", containsString("id"))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'required'", equalTo(true))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'style'", containsString("simple"))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'schema'.'type'", containsString("integer"))
                .body("'paths'.'/api/items/{id}'.'get'.'parameters'[0].'schema'.'format'", containsString("int64"))
                .body("'paths'.'/api/items/{id}'.'get'.'responses'.'200'.'description'", containsString("OK"))
                .body("'paths'.'/api/items/{id}'.'get'.'responses'.'200'.'content'.'*/*'.'schema'.'$ref'", containsString("#/components/schemas/Item"))
                .body("'paths'.'/api/items/{id}'.'get'.'responses'.'401'.'description'", containsString("Unauthorized"))
                .body("'paths'.'/api/items/{id}'.'get'.'responses'.'403'.'description'", containsString("Forbidden"))
                .body("'paths'.'/api/items/{id}'.'get'.'responses'.'404'.'description'", containsString("Not Found"))
                .body("'components'.'schemas'.'Item'.'title'", containsString("Item"))
                .body("'components'.'schemas'.'Item'.'type'", containsString("object"))
                .body("'components'.'schemas'.'Item'.'properties'.'cost'.'type'", containsString("integer"))
                .body("'components'.'schemas'.'Item'.'properties'.'cost'.'format'", containsString("int32"))
                .body("'components'.'schemas'.'Item'.'properties'.'description'.'type'", containsString("string"))
                .body("'components'.'schemas'.'Item'.'properties'.'name'.'type'", containsString("string"))
                .body("'components'.'schemas'.'Iterable«Item»'.'title'", containsString("Iterable«Item»"))
                .body("'components'.'schemas'.'Iterable«Item»'.'type'", containsString("object"))
                .body("'components'.'schemas'.'ResponseEntity'.'title'", containsString("ResponseEntity"))
                .body("'components'.'schemas'.'ResponseEntity'.'type'", containsString("object"))
                .body("'components'.'schemas'.'ResponseEntity'.'properties'.'body'.'type'", containsString("object"))
                .body("'components'.'schemas'.'ResponseEntity'.'properties'.'statusCode'.'type'", containsString("string"))
                .body("'components'.'schemas'.'ResponseEntity'.'properties'.'statusCode'.'enum'.size()", equalTo(68))
                .body("'components'.'schemas'.'ResponseEntity'.'properties'.'statusCode'.'enum'", hasItems("ACCEPTED", "ALREADY_REPORTED", "BAD_GATEWAY", "BAD_REQUEST", "BANDWIDTH_LIMIT_EXCEEDED", "CHECKPOINT", "CONFLICT", "CONTINUE", "CREATED", "DESTINATION_LOCKED", "EXPECTATION_FAILED", "FAILED_DEPENDENCY", "FORBIDDEN", "FOUND", "GATEWAY_TIMEOUT", "GONE", "HTTP_VERSION_NOT_SUPPORTED", "IM_USED", "INSUFFICIENT_SPACE_ON_RESOURCE", "INSUFFICIENT_STORAGE", "INTERNAL_SERVER_ERROR", "I_AM_A_TEAPOT", "LENGTH_REQUIRED", "LOCKED", "LOOP_DETECTED", "METHOD_FAILURE", "METHOD_NOT_ALLOWED", "MOVED_PERMANENTLY", "MOVED_TEMPORARILY", "MULTIPLE_CHOICES", "MULTI_STATUS", "NETWORK_AUTHENTICATION_REQUIRED", "NON_AUTHORITATIVE_INFORMATION", "NOT_ACCEPTABLE", "NOT_EXTENDED", "NOT_FOUND", "NOT_IMPLEMENTED", "NOT_MODIFIED", "NO_CONTENT", "OK", "PARTIAL_CONTENT", "PAYLOAD_TOO_LARGE", "PAYMENT_REQUIRED", "PERMANENT_REDIRECT", "PRECONDITION_FAILED", "PRECONDITION_REQUIRED", "PROCESSING", "PROXY_AUTHENTICATION_REQUIRED", "REQUESTED_RANGE_NOT_SATISFIABLE", "REQUEST_ENTITY_TOO_LARGE", "REQUEST_HEADER_FIELDS_TOO_LARGE", "REQUEST_TIMEOUT", "REQUEST_URI_TOO_LONG", "RESET_CONTENT", "SEE_OTHER", "SERVICE_UNAVAILABLE", "SWITCHING_PROTOCOLS", "TEMPORARY_REDIRECT", "TOO_EARLY", "TOO_MANY_REQUESTS", "UNAUTHORIZED", "UNAVAILABLE_FOR_LEGAL_REASONS", "UNPROCESSABLE_ENTITY", "UNSUPPORTED_MEDIA_TYPE", "UPGRADE_REQUIRED", "URI_TOO_LONG", "USE_PROXY", "VARIANT_ALSO_NEGOTIATES"))
                .body("'components'.'schemas'.'ResponseEntity'.'properties'.'statusCodeValue'.'type'", containsString("integer"))
                .body("'components'.'schemas'.'ResponseEntity'.'properties'.'statusCodeValue'.'format'", containsString("int32"));
        
        expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
    }
    
    
    @Test @Timeout(60)
    public void test_3() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"name\": \"_EM_135_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/items?EMextraParam123=42")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }


}
