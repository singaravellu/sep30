package com.employee.emplpoyee.exceptions;

public class RecordNotFoundException  extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
    public RecordNotFoundException(String msg) {
        super(msg);
        this.setMsg(msg);
    }


    public RecordNotFoundException(Throwable cause, String msg) {
        super(msg, cause);
        this.setMsg(msg);
    }


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	


}