package Utils;

public class Payload {
	public static String CreateIssue() {
		return "{\r\n  \"fields\": \r\n  {\r\n    \"project\":\r\n    {\r\n      \"key\": \"JP\"\r\n    },\r\n    \"summary\": \"Creating new bug\",\r\n    \"description\": \"Creating new bug\",\r\n    \"issuetype\": \r\n    {\r\n      \"name\": \"Bug\"\r\n    }\r\n    }\r\n  }";
	}
	public static String getSessionPayLoad()
	{
		return "{ \"username\": \"dhana17111985\", \"password\": \"June@2020\" }";
	}

}
