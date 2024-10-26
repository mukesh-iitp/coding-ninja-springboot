package com.cn.cnpayment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private int id;

	@Column
	private String paymentType;

	@Column
	private String description;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private PaymentDetails paymentDetails;

	@OneToMany(fetch = FetchType.EAGER,mappedBy= "payment",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PaymentReview> paymentReviews;

	//add proper annotation for establishing many-to-many relationship with Order.
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "payments")
	@JsonIgnore
	private List<Orders> orders;

	public int getId() {
		return id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public List<PaymentReview> getPaymentReviews() {
		return paymentReviews;
	}

	public void setPaymentReviews(List<PaymentReview> paymentReviews) {
		this.paymentReviews = paymentReviews;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", paymentType='" + paymentType + '\'' +
				", description='" + description + '\'' +
				'}';
	}

	public Payment(int id, String paymentType, String description) {
		this.id=id;
		this.paymentType = paymentType;
		this.description = description;
	}

	public Payment() {
	}

	public void setId(int id) {
		this.id = id;
	}
}
