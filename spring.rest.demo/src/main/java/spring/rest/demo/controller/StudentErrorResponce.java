package spring.rest.demo.controller;

public class StudentErrorResponce {

	private int status;

	private String error;

	private long timeStamp;

	public StudentErrorResponce(int status, String error, long timeStamp) {
		this.status = status;
		this.error = error;
		this.timeStamp = timeStamp;
	}

	public StudentErrorResponce() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
