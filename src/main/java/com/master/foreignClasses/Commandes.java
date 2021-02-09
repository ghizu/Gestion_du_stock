package com.master.foreignClasses;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public  class Commandes  {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codeCmd;
	@Column
	private Integer codePdt;
	@Column
	private Integer client;
	@Column
	private int qteCmd;
	@Column
	private Date dateCmd;

	// Constructors

	/** default constructor */
	public Commandes() {
	}

	/** minimal constructor */
	public Commandes(Integer codeCmd, Integer codePdt, Integer client) {
		this.codeCmd = codeCmd;
		this.codePdt = codePdt;
		this.client = client;
	}

	/** full constructor */
	public Commandes(Integer codeCmd, Integer codePdt, Integer client, int qteCmd, Date dateCmd) {
		this.codeCmd = codeCmd;
		this.codePdt = codePdt;
		this.client = client;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
	}

	// Property accessors

	public Integer getCodeCmd() {
		return this.codeCmd;
	}

	public void setCodeCmd(Integer codeCmd) {
		this.codeCmd = codeCmd;
	}

	public Integer getCodePdt() {
		return this.codePdt;
	}

	public void setCodePdt(Integer codePdt) {
		this.codePdt = codePdt;
	}

	public Integer getClient() {
		return this.client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public int getQteCmd() {
		return this.qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

}