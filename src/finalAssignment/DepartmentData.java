package finalAssignment;

public class DepartmentData {
	private String departmentName;
	private String departmentAddress;
	private int departmentID;
	
	public void DepartmentData(String departmentNameIn, String departmentAddressIn) {
		departmentName = departmentNameIn;
		departmentAddress = departmentAddressIn;
	}
	
	public void assignDepartmentID(int departmentIDIn) {
		departmentID = departmentIDIn;
	}

}
