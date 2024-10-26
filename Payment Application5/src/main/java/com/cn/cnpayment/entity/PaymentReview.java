package com.cn.cnpayment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name="payment_review")
public class PaymentReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private int id;

	@Column
	public String queryPersonName;

	@Column
	public String queryType;

	@Column
	public String queryDescription;

	@ManyToOne
	@JoinColumn(name="payment_id")
	@JsonBackReference
	private Payment payment;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public String getQueryPersonName() {
		return queryPersonName;
	}

	public void setQueryPersonName(String queryPersonName) {
		this.queryPersonName = queryPersonName;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	@Override
	public String toString() {
		return "PaymentReview{" +
				", queryPersonName='" + queryPersonName + '\'' +
				", queryType='" + queryType + '\'' +
				", queryDescription='" + queryDescription + '\'' +
				'}';
	}

	public PaymentReview() {
	}

	public PaymentReview(int id, String queryPersonName, String queryType, String queryDescription) {
		this.id = id;
		this.queryPersonName = queryPersonName;
		this.queryType = queryType;
		this.queryDescription = queryDescription;

	}
}
