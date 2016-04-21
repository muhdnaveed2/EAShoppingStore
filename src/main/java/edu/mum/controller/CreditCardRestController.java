package edu.mum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.mum.domain.BillingInfo;

@Path("/authenticate")
public class CreditCardRestController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BillingInfo> getCreditCards() {
		List<BillingInfo> listOfCards = new ArrayList<BillingInfo>();
		listOfCards = createCardList();
		return listOfCards;
	}

	//test url : http://localhost:8080/EAShoppingStore/rest/authenticate/creditcard?cardnumber=22222&cardname=Naveed&cardexpiry=03/17&cardpin=014
	@GET
	@Path("/creditcard")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean isCardExists(@QueryParam("cardnumber") String cardnumber,@QueryParam("cardname") String cardname,@QueryParam("cardexpiry") String cardexpiry,@QueryParam("cardpin") String cardpin ) {
		List<BillingInfo> listOfCards = new ArrayList<BillingInfo>();
		listOfCards = createCardList();

		for (BillingInfo card : listOfCards) {
			if (card.getCardNumber().equals(cardnumber) && card.getCardName().equals(cardname) && 
					card.getCardExpiry().equals(cardexpiry) && card.getCardPin().equals(cardpin))
				return true;
		}

		return false;
	}

	// Utiliy method to create card list.
	public List<BillingInfo> createCardList() {

		BillingInfo naveedCard = new BillingInfo("Naveed","2222222222222222", "03/17", "014");
		BillingInfo amitCard = new BillingInfo("Amit", "1111111111111111", "03/17", "014");
		BillingInfo mosaddekCard = new BillingInfo("Mosaddek", "3333333333333333", "03/17", "014");

		List<BillingInfo> listOfCards = new ArrayList<BillingInfo>();
		listOfCards.add(naveedCard);
		listOfCards.add(amitCard);
		listOfCards.add(mosaddekCard);
		return listOfCards;
	}
}
