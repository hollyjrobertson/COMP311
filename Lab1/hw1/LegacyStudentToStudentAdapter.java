package hw1;

public class LegacyStudentToStudentAdapter implements Student{

	private LegacyStudent student;
	
	//Parses int to String & sets ID
	//To go from Student to LegacyStudent
	@Override
	public int getId()
	{
		return Integer.parseInt(student.getId());
	}

	//Parses String to int & gets ID
	//To go from LegacyStudent to Student
	@Override
	public void setId(int id)
	{
		student.setId(String.valueOf(id));
	}

	//Gets first name of full name, trims at whitespace
	@Override
	public String getFirstName()
	{
		return student.getFullName().trim();
	}
	
	//Sets first name and adds a space to separate first & last
	@Override
	public void setFirstName(String firstName)
	{
		student.setFullName(firstName + " ");
		
	}

//Gets last name. Starts at the whitespace character and ends at last index of fullName
	@Override
	public String getLastName()
	{
		return student.getFullName().substring(student.getFullName().indexOf(' '), student.getFullName().length() - 1);
	}

	//Sets fullName for LegacyStudent by adding firstName and lastName
	@Override
	public void setLastName(String lastName)
	{
		student.setFullName(student.getFullName() + lastName);
		
	}

}

