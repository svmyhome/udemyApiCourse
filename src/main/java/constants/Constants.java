package constants;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.Servers.*;

public class Constants {
    public static class RunVariable {
        public static String server = JSON_PLASEHOLDER_URL;
        public static String path = "";
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.py4e.com/"; //"https://swapi.dev/";
        public static String JSON_PLASEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
        public static String XML_BIN_URL = "https://eniyb07bhh0op.x.pipedream.net/";
    }
    public static class Path {
        public static String SWAPI_PATH = "api/";
    }
    public static class Actions {
        public static String SWAPI_GET_PEOPLE = "people/";
        public static String JSON_PLASEHOLDER_GET = "comments/";
        public static String JSON_PLASEHOLDER_PUT = "posts/1";
        public static String JSON_PLASEHOLDER_DELETE = "posts/1";
        public static String JSON_PLASEHOLDER_POST = "posts";
    }

}
