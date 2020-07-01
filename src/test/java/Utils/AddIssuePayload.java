package Utils;

public class AddIssuePayload {
	
public static AddIssue getValues()
{
	AddIssue add=new AddIssue();
	Fileds f=new Fileds();
	f.setSummary("Creating bug from deserialization");
	f.setDescription("Creting description for DeSerailization");
	IssueType issu=new IssueType();
	issu.setName("Bug");
	Project p=new Project();
	p.setKey("JP");	
	f.setIssuetype(issu);
	f.setProject(p);
	add.setFields(f);
	return add;
	
}
}
