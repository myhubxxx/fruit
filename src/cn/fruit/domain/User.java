package cn.fruit.domain;

import java.util.Date;

public class User {
	
	private String uid;
	private String unumber;
	private String upass;
	private Integer sortorder;
	
	
	/*new add property*/
	private String uname;
	private Date udate;
	private String address;
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public Integer getSortorder() {
		return sortorder;
	}
	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", unumber=" + unumber + ", upass=" + upass
				+ ", sortorder=" + sortorder + ", uname=" + uname + ", udate="
				+ udate + ", address=" + address + "]";
	}
	
	
	
	
	

}
