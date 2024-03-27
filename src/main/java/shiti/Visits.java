package shiti;

import java.sql.Date;

public class Visits {
	public int visitsId;
	public String cars_number;
	public String visit_phone;
	public Date reg_time;
	public Date start_time;
	public Date end_time;
	public String reason_text;
	public String permission_text;
	public String state;
	public String notes;
	
	public String approval_status;
	
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	public int getVisitsId() {
		return visitsId;
	}
	public void setVisitsId(int visitsId) {
		this.visitsId = visitsId;
	}
	public String getCars_number() {
		return cars_number;
	}
	public void setCars_number(String cars_number) {
		this.cars_number = cars_number;
	}
	public String getVisit_phone() {
		return visit_phone;
	}
	public void setVisit_phone(String visit_phone) {
		this.visit_phone = visit_phone;
	}
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getReason_text() {
		return reason_text;
	}
	public void setReason_text(String reason_text) {
		this.reason_text = reason_text;
	}
	public String getPermission_text() {
		return permission_text;
	}
	public void setPermission_text(String permission_text) {
		this.permission_text = permission_text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Visits(int visitsId, String cars_number, String visit_phone, Date reg_time, Date start_time, Date end_time,
			String reason_text, String permission_text, String state, String notes) {
		super();
		this.visitsId = visitsId;
		this.cars_number = cars_number;
		this.visit_phone = visit_phone;
		this.reg_time = reg_time;
		this.start_time = start_time;
		this.end_time = end_time;
		this.reason_text = reason_text;
		this.permission_text = permission_text;
		this.state = state;
		this.notes = notes;
	}
	
}
