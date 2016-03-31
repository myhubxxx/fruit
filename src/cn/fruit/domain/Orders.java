package cn.fruit.domain;

import java.util.Date;

public class Orders {
	
	private String oid;
	private Date odate;
	private Integer number;
	private Integer sortorder;
	private Integer status;
	
//	private String udi;
//	private String fid;
	private User user;
	private Fruit fruit;
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getSortorder() {
		return sortorder;
	}
	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", odate=" + odate + ", number=" + number
				+ ", sortorder=" + sortorder + ", status=" + status + ", user="
				+ user + ", fruit=" + fruit + "]";
	}
	
	
	
	
	
}
