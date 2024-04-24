package com.commonMethods;

import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Data_provider {

   @DataProvider(name = "jsonDataProvider")
    public Iterator<Object[]> jsonDataProvider() throws IOException, ParseException {
        String jsonFilePath = "C:\\Users\\Itsqe\\IdeaProjects\\TestAutomationFramework\\testData\\Demo.json";
        Object obj = new JSONParser().parse(new FileReader(jsonFilePath));
        JSONArray jsonArray = (JSONArray) obj;
        return (Iterator<Object[]>) jsonArray.stream()
                .map(data -> new Object[]{data})
                .iterator();
    }

}