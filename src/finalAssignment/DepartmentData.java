package finalAssignment;

public class DepartmentData {
	private String departmentName;
	private String departmentAddress;
	private int departmentID;
	static private boolean isDepartment;
	static private int depCount = 1;
	
	public DepartmentData(String departmentNameIn, String departmentAddressIn) {
		departmentName = departmentNameIn;
		departmentAddress = departmentAddressIn;
		departmentID = DepartmentData.depCount;
		DepartmentData.depCount++;
	}
	
	
	public void setDepartmentName(String departmentNameIn) {
		departmentName = departmentNameIn;
	}
	
	public void setDepartmentAddress(String departmentAddressIn) {
		departmentAddress = departmentAddressIn;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public String getDepartmentNameByID(int depIDIn) {
		if (depIDIn == departmentID)
			return departmentName;
		else {return " ";}
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	
	static public boolean verifyDepartmentID(int depIDIn) {
		if (depIDIn > 0 && depIDIn <depCount) {
			isDepartment = true;
		}		
		else {
			isDepartment = false;
		}
		return isDepartment;
	}
}
