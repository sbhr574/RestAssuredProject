package API_Concept;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Path_QueryParam
{
    public static void test1()
    {
        //"https://dev.azure.com/BIB-IT-AzurePipeline/Project1/_apis/pipelines/4?api-version=7.1-preview.1";
        RestAssured.baseURI = "";

        /**
         *  1. for path param defined variables can be anything that's why needs to add inside get.
         *  https://www.youtube.com/watch?v=kxPC6wEbbaU&list=PLUDwpEzHYYLvLZX_QEGTNolPvNADXid0I&index=3  --- Mins 11.12
         *
         *  2. But for query param need to define same param name as its define on the url
         */
        given()
                .pathParam("commonPath", "Project1/_apis") //Path param
                .pathParam("mypath", "pipelines/4") //Path param
                .queryParam("api-version", "7.1-preview.1"). //Query param.when()
        when()
                .get("https://dev.azure.com/BIB-IT-AzurePipeline/{commonPath}/{mypath}");
    }
}
