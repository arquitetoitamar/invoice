package br.com.emissor.repository.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7325001852279249311L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "id", table = "company")
	private int id;
	@JsonProperty
	@Column(length = 45)
	private String name;
	@JsonProperty
	@Column(length = 60)
	private String email;
	@JsonProperty
	@Column(length = 45)
	private String phone;
	@JsonProperty
	@Column(length = 45)
	private String cel;
	@JsonProperty
	@Column
	private String address;
	@JsonProperty
	@Column
	private String cnae;
	@JsonProperty
	@Column(length = 20)
	private String document;
	@JsonProperty
	@Column
	private String nickname;
	@JsonProperty
	@Column
	private String note;
	@JsonProperty
	@Column
	private String createDate;

	// bi-directional many-to-one association to Pedido
	@JsonManagedReference
	@OneToMany(mappedBy = "company")
	private List<Invoice> invoices;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Company() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

}