package kitchen.app.model;

public class Reservation {

	private String name;
	private String date;
	private String time;
	private String email;
	private String phone;
	private String partySize;
	private String comments;
	private String CNF;
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPartySize() {
		return partySize;
	}
	public void setPartySize(String partySize) {
		this.partySize = partySize;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCNF() {
		return CNF;
	}
	public void setCNF(String cNF) {
		CNF = cNF;
	}
	
}
