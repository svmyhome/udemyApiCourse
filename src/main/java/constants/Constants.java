package constants;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.Servers.JSON_PLASEHOLDER_URL;
import static constants.Constants.Servers.SWAPI_URL;

public class Constants {
    public static class RunVariable {
        public static String server = JSON_PLASEHOLDER_URL;
        public static String path = "";
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JSON_PLASEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
    }
    public static class Path {
        public static String SWAPI_PATH = "api/";
    }
    public static class Actions {
        public static String SWAPI_GET_PEOPLE = "people/";
        public static String JSON_PLASEHOLDER_GET = "comments/";
    }

}
