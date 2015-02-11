package kitchen.app.rest.responses;


public class AppResponse {

	public final static String ERROR = "error";
	public final static String SUCCESS = "success";
	
	private String status;
	private String msg;
	private Object payload;
	
	public AppResponse () {
		this.status = SUCCESS;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
