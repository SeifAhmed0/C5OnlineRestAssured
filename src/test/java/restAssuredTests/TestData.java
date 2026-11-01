package restAssuredTests;

public class TestData {
    public static String getConversionData(){
        return """
                {
                    "fromTimeZone": "Africa/Cairo",
                    "dateTime": "2026-07-29 21:36:00",
                    "toTimeZone": "America/Los_Angeles",
                    "dstAmbiguity": ""
                }
                """;
    }

    public static String getConversionDataCorrelated(String fromTimeZone, String dateTime){
        return """
                {
                    "fromTimeZone": "%s",
                    "dateTime": "%s",
                    "toTimeZone": "America/Los_Angeles",
                    "dstAmbiguity": ""
                }
                """.formatted(fromTimeZone, dateTime);
    }
}
