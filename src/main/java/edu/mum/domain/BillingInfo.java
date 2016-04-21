package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingInfo implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="{BillingInfo.cardName.empty}")
	@Column(name="CARD_NAME")
	private String cardName;
	
	@NotEmpty(message="{BillingInfo.cardType.empty}")
	@Column(name="CARD_TYPE")
	private String cardType;
	
	@NotEmpty(message="{BillingInfo.cardNumber.empty}")
	@Column(name="CARD_NUMBER")
	private String cardNumber;
	
	@NotEmpty(message="{BillingInfo.cardExpiry.empty}")
	@Column(name="CARD_EXPIRY")
	private String cardExpiry;
	
	@NotEmpty(message="{BillingInfo.cardPin.empty}")
	@Column(name="CARD_PIN")
	private String cardPin;
	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}
	
	public BillingInfo() {
		super();
	}

	public BillingInfo(String cardName, String cardNumber, String cardExpiry,String cardPin)
	{
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardPin = cardPin;
	}
}
