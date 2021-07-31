package com.model;
import com.model.countryVO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="State")
public class stateVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="StateName")
	private String sname;
	
	@Column(name="Description")
	private String sdesc;
	
	@ManyToOne
	@JoinColumn(name="CountryID")
	private countryVO cVO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	public countryVO getcVO() {
		return cVO;
	}
	public void setcVO(countryVO cVO) {
		this.cVO = cVO;
	}
	

}