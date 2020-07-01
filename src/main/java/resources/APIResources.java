package resources;

public enum APIResources {
	SessionCreation("rest/auth/1/session"),
	HttpCreateIssuePOSTMethos("rest/api/2/issue"),
	HttpCreateIssueGETMethos("rest/api/2/issue/");
	
	private String resources;
	
	APIResources(String resources)
	{
		this.resources=resources;
	}
	
	public String getResources()
	{
		return resources;
	}
}
