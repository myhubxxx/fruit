package cn.fruit.domain;

import java.util.Date;

public class Fruit {

	private String fid;
	private String fname;
	private Double fprice;
	private Integer famount;
	private String fpicture;
	private Integer sortorder;
	private Date fdate;
	private String place; // 地点(合作商家)
	
	
	/*to be reserve*/
	private String produceaddress;


	public String getFid() {
		return fid;
	}


	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public Double getFprice() {
		return fprice;
	}


	public void setFprice(Double fprice) {
		this.fprice = fprice;
	}


	public Integer getFamount() {
		return famount;
	}


	public void setFamount(Integer famount) {
		this.famount = famount;
	}


	public String getFpicture() {
		return fpicture;
	}


	public void setFpicture(String fpicture) {
		this.fpicture = fpicture;
	}


	public Integer getSortorder() {
		return sortorder;
	}


	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}


	public Date getFdate() {
		return fdate;
	}


	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getProduceaddress() {
		return produceaddress;
	}


	public void setProduceaddress(String produceaddress) {
		this.produceaddress = produceaddress;
	}


	@Override
	public String toString() {
		return "Fruit [fid=" + fid + ", fname=" + fname + ", fprice=" + fprice
				+ ", famount=" + famount + ", fpicture=" + fpicture
				+ ", sortorder=" + sortorder + ", fdate=" + fdate + ", place="
				+ place + ", produceaddress=" + produceaddress + "]";
	} 
	
	
	
}
