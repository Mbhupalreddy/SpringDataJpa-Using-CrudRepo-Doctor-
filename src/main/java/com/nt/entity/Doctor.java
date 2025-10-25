package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	@Column(name="DOC_ID")
	@Id
	//@SequenceGenerator(name="gen1",sequenceName = "DNo_SEQ",initialValue = 100,allocationSize = 1)
	//@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docid;
	@Column(name="DOC_NAME",length=25)
	private String docname;
	@Column(name="SPECIALIZATION",length=20)
	private String specialization;
	@Column(name="INCOME")
	private Double income;
	public Doctor(String docname, String specialization, Double income) {
		super();
		this.docname = docname;
		this.specialization = specialization;
		this.income = income;
	}
	
	
	
	

}
