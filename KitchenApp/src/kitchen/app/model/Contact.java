package kitchen.app.model;

/**
 * @author Sabid
 *
 */
public class Contact {
	

	private String CNF;
	private String name;
	private String date;
	private String phone;
	
	public String getCNF() {
		return CNF;
	}
	public void setCNF(String cNF) {
		CNF = cNF;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	} 
}
