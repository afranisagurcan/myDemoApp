package myDemoApp;
import java.util.ArrayList;

import spark.Service;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import org.apache.logging.log4j.Logger ;
import org.eclipse.jetty.util.log.Log;
import org.apache.logging.log4j.LogManager ;


import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {

    public static void main(String[] args) {

        Logger log = LogManager.getLogger();
        log.error("hello!!!");

        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        System.out.println(isSameElement(array1,array2,0));

        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        get("/compute",
        (rq, rs) -> {
          Map<String, String> map = new HashMap<String, String>();
          map.put("result", "not computed yet!");
          return new ModelAndView(map, "compute.mustache");
        },
        new MustacheTemplateEngine());

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));
  
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
              int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
              inputList1.add(value);
            }
            sc1.close();
            System.out.println(inputList1);


            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
              int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
              inputList2.add(value);
            }
            sc2.close();
            System.out.println(inputList2);
  
  
            String input3 = req.queryParams("input3").replaceAll("\\s","");
            int input2AsInt = Integer.parseInt(input3);
  
            boolean result = App.isSameElement(inputList1,inputList2 ,input2AsInt);
  
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
          }, new MustacheTemplateEngine());
  
       
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public String getGreeting() {
        return "Hello world.";
    }

    public static boolean isSameElement(ArrayList<Integer> list1 , ArrayList<Integer> list2 , Integer k){

        if ( list1 == null || list1.size() == 0 )
            return false ;

        if ( list2 == null || list2.size() == 0 )
            return false ;
        
        
        if ( list1.size() > k && list2.size() > k && list1.get(k) == list2.get(k) )
            return true;
        
        return false ;
    }


    
}
