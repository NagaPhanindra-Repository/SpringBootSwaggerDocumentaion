package com.codemer.giftcard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api; 
import io.swagger.annotations.ApiImplicitParam; 
import io.swagger.annotations.ApiImplicitParams; 
import io.swagger.annotations.ApiOperation; 
import io.swagger.annotations.ApiParam; 
import io.swagger.annotations.ApiResponse; 
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.codemer.giftcard.exception.ResourceNotFoundException;
import com.codemer.giftcard.model.ContactUpdate; 
import com.codemer.giftcard.model.ETCProcessCards; 
import com.codemer.giftcard.model.appInfo; 
import com.codemer.giftcard.model.card; 
import com.codemer.giftcard.model.consents; 
import com.fasterxml.jackson.databind.JsonNode; 
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController 
@RequestMapping(value="resource",produces="application/json") 
@Api(value = "Resource Management System", description = "These are Protected API rest endpoints (CustomAuthHeader header is required to call every method from Protected API :An example for email: 'test_email@mpts.com' and NIF: '123456789').")
public class ProtectedResourceController {

	@Autowired
	private ObjectMapper objectMapper;

	@ApiOperation(value = "This method gets details for logged-in and main/additional user. In case of getting all data, the SUCCESS status is returned")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Success"),
	    @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	    @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	    @ApiResponse(code = 401, message = "Authentication failed"),
	    @ApiResponse(code = 404, message = "Resource not found")
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
	     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
	  })
	@GetMapping("/user/details")
	public ResponseEntity<ObjectNode> getUserCardsDeatils() {
		
		ObjectNode cardHolderAddress = objectMapper.createObjectNode();
		//JSONObject cardHolderAddress=new JSONObject();
		cardHolderAddress.put("addressLine1", "Avenida da Liberdade nº 23");
		cardHolderAddress.put("addressLine2", "");
		cardHolderAddress.put("city", "Lisbon");
		cardHolderAddress.put("businessphone", "4567888");
		cardHolderAddress.put("Homephone", "765434");
		cardHolderAddress.put("mobilephone", "7543");
		cardHolderAddress.put("email", "test@blackcap.com");
		
		
		
		ObjectNode cardHolderTitle = objectMapper.createObjectNode();
		//JSONObject cardHolderTitle=new JSONObject();
		cardHolderTitle.put("code", "SRA");
		cardHolderTitle.put("name", "SRA");
		
		ObjectNode cardHolderMaritalStatus = objectMapper.createObjectNode();
		//JSONObject cardHolderMaritalStatus=new JSONObject();
		cardHolderMaritalStatus.put("code", "V");
		cardHolderMaritalStatus.put("name", "VIUVO");
		
		
		ObjectNode cardHolderNationality = objectMapper.createObjectNode();
		//JSONObject cardHolderNationality=new JSONObject();
		cardHolderNationality.put("code", "PRT");
		cardHolderNationality.put("name", "PORTUGAL");
		
		
		ObjectNode one = objectMapper.createObjectNode();
		//JSONObject cardHolderNationality=new JSONObject();
		one.put("NIF", "0000000001");
		one.put("card", "PORTUGAL");
		
		ObjectNode card = objectMapper.createObjectNode();
		//JSONObject cardHolderNationality=new JSONObject();
		card.put("cardNumber", "5182********5814");
		card.put("loyaltyId","2251300140042");
		card.put("seqNum","1");
		
		
		ObjectNode map = objectMapper.createObjectNode();
		
		
		map.putAll(one);
		map.put("contactDetails", "1985-10-17");
		map.put("cardHolderAddress", cardHolderAddress);
		map.put("cardHolderEmail", "test.test@britenet.com.pl");
		map.put("cardHolderFirstName", "First");
		map.put("cardHolderLastName", "Last");
		map.put("cardholderFullName", "First Middle Last");
		map.put("cardHolderTitle", cardHolderTitle);
		map.put("cardHolderNationality", cardHolderNationality);
		map.put("cardHolderMaritalStatus", cardHolderMaritalStatus);
		map.put("cardHolderBirthDate", "1985-10-17");
		map.put("otherNationalities", "CHN");
		map.put("birthPlace", "SANTA COMBA DAO SANTA CRU");
		map.put("numberOfDependent", "07");
		map.put("identityCardType", "003-B.I. ESTRANGEIRO RESIDENTE");
		map.put("identityCardNumber", "IFLUOUU12552");
		map.put("homeType", "X-DESCONHECIDO");
		map.put("otherResidence", "false");
		map.put("position", "92-DESEMPREGADO / SEM PROFISSAO");
		map.put("typeOfContract", "0-Not applicable");
		map.put("contractExpiryDate", "19690224");
		map.put("employmentContractDate", "196106");
		map.put("companyName", "ING GROUP");
		map.put("isPublicPerson", "false");
		map.put("publicOffice", "CITIGROUP");
		map.put("monthlyIncome", "244440");
		map.put("eMailStatement", "true");
		map.put("stopMail", "2-NAO RECEBE NENHUMA COMUNICACAO + DATA FIM REACTIVIDAD");
	ObjectNode map2 = objectMapper.createObjectNode();

	map2.putAll(one); map2.put("contactDetails", "1985-10-17"); map2.put("cardHolderAddress", cardHolderAddress); map2.put("cardHolderEmail", "test.test@britenet.com.pl"); map2.put("cardHolderFirstName", "First"); map2.put("cardHolderLastName", "Last"); map2.put("cardholderFullName", "First Middle Last"); map2.put("cardHolderTitle", cardHolderTitle); map2.put("cardHolderNationality", cardHolderNationality); map2.put("cardHolderMaritalStatus", cardHolderMaritalStatus); map2.put("cardHolderBirthDate", "1985-10-17"); map2.put("otherNationalities", "CHN"); map2.put("birthPlace", "SANTA COMBA DAO SANTA CRU"); map2.put("numberOfDependent", "07"); map2.put("identityCardType", "003-B.I. ESTRANGEIRO RESIDENTE"); map2.put("identityCardNumber", "IFLUOUU12552"); map2.put("homeType", "X-DESCONHECIDO"); map2.put("otherResidence", "false"); map2.put("position", "92-DESEMPREGADO / SEM PROFISSAO"); map2.put("typeOfContract", "0-Not applicable"); map2.put("contractExpiryDate", "19690224"); map2.put("employmentContractDate", "196106"); map2.put("companyName", "ING GROUP"); map2.put("isPublicPerson", "false"); map2.put("publicOffice", "CITIGROUP"); map2.put("monthlyIncome", "244440"); map2.put("eMailStatement", "true"); map2.put("stopMail", "2-NAO RECEBE NENHUMA COMUNICACAO + DATA FIM REACTIVIDAD");

		//Map map=new HashMap();
		ObjectNode list = objectMapper.createObjectNode();
		
		 list.put("1", map);
		list.put("2",map2);
		ObjectNode opcard = objectMapper.createObjectNode();
		//JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("clientDetails",  list);
		opcard.put("clientSequenceNumber", "1");
		
		
		return ResponseEntity.ok().body(opcard);
	}





	@ApiOperation(value = "This method gets banking details of logged-in user. In case of getting all data,the SUCCESS status is returned")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Success"),
	    @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	    @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	    @ApiResponse(code = 401, message = "Authentication failed"),
	    @ApiResponse(code = 404, message = "Resource not found")
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
	     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
	  })
	@GetMapping("/user/banking-details")
	public ResponseEntity<ObjectNode> getUserBankingDetails() {
		ObjectNode usage = objectMapper.createObjectNode();
		usage.put("amount", "2500.00");
		usage.put("currency", "EUR");
		 
		ObjectNode currentAmount = objectMapper.createObjectNode();
		currentAmount.put("amount", "1393.91");
		currentAmount.put("currency", "EUR");
		 
		ObjectNode two = objectMapper.createObjectNode();
		two.put("iban", "PT50007909251000064500005");
		two.put("ibanUniverso", "U50007909251000064500005");
		two.put("contractNumber", "00150200000000000645");
		two.put("currentAmount", currentAmount);
		two.put("MaxAmount", usage);
		
		
		 ObjectNode one = objectMapper.createObjectNode();
		 one.put("iban", "ASDC463883290945688314814635632861");
		 one.put("ibanUniverso", "U463883290945688314814635632861");
		 one.put("atmReference", "52364105122211");
		 one.put("directDebit", "32276101671178114");
		 one.put("contractNumber", "00150100000000000645");
		 one.put("degressivity", "70%");
		 one.put("lastBillingDate", "20170718");
		 one.put("nextBillingDate", "20170818");
		 one.put("nextBillingAmount", "999.99");
		 one.put("insuranceFlag", "true");
		 one.put("extCreditLimit", "2500.00");
		 one.put("creditStatus", "0");
		 one.put("tanRev", "247,24%");
		 one.put("tanInst", "251,28%");
		 one.put("taeg", "61,30%");
		 one.put("fromYear", "2017");
			
		
		
		
		 ObjectNode opcard = objectMapper.createObjectNode();
		//JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("creditAccount", one);
		opcard.put("debitAccount", two);
		
		
		return ResponseEntity.ok().body(opcard);
	}




	@ApiOperation(value = "Method returns user’s account details.")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Success"),
	    @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	    @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	    @ApiResponse(code = 401, message = "Authentication failed"),
	    @ApiResponse(code = 404, message = "Resource not found")
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
	     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
	  })
	@GetMapping("/user/account-details")
	public ResponseEntity<ObjectNode> getUserAccountDetails() {
		
		
		
		
		 ObjectNode opcard = objectMapper.createObjectNode();
		//JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("limit", 9999);
		opcard.put("entity", "75000701826");
		opcard.put("authorization", "PT41100946");
		opcard.put("bank","BANCO COMERCIAL PORTUGUES");
		
		
		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method returns user’s balance.")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Success"),
	    @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	    @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	    @ApiResponse(code = 401, message = "Authentication failed"),
	    @ApiResponse(code = 404, message = "Resource not found")
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
	     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
	  })
	@GetMapping("/user/saldo")
	public ResponseEntity<ObjectNode> getUserBalance() {
		ObjectNode debit = objectMapper.createObjectNode();
		debit.put("balance", 67);
		debit.put("currency", "EUR");
		debit.put("contractNumber", "00150200000000001018");
		
		ObjectNode credit = objectMapper.createObjectNode();
		credit.put("balance", 6778);
		credit.put("currency", "EUR");
		credit.put("contractNumber", "0015020000000001018");
		
		
		
		
		 ObjectNode opcard = objectMapper.createObjectNode();
		//JSONObject opcard=new JSONObject();
		 opcard.put("Status","SUCCESS");
		opcard.put("debit", debit);
		opcard.put("credit", credit);
		opcard.put("balanceUsed", "732.31");
		opcard.put("loyaltyPointsBalance", "VLL_ERROR");
		
		    	
		return ResponseEntity.ok().body(opcard);
	}


	 @ApiOperation(value = "Method changes user’s contact details..")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/user/contact-details")
	    public ResponseEntity<ObjectNode> editUserContactDetails(
	        @ApiParam(value = "phone and email are required", required = true) @Valid @RequestBody ContactUpdate card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }


	 
	 @ApiOperation(value = "Method returns consents of GDPR for currently logged user.")
	    @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success"),
	        @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	        @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	        @ApiResponse(code = 401, message = "Authentication failed"),
	        @ApiResponse(code = 404, message = "Resource not found")
	    })
		@ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @GetMapping("/user/consents")
	    public ResponseEntity<ObjectNode> getGDPRConsents() {
			
			ObjectNode consents = objectMapper.createObjectNode();
			consents.put("SFS1", true);
			consents.put("SFS2", false);
			consents.put("SFS3", true);
			consents.put("BNP1", false);
			consents.put("BNP2", true);
	    	
			
			
	    	
	    	 ObjectNode opcard = objectMapper.createObjectNode();
	    	//JSONObject opcard=new JSONObject();
	    	 opcard.put("Status","SUCCESS");
	    	opcard.put("consents", consents);
	    	
	    	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 
	 @ApiOperation(value = "Method changes user consents..")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 404, message = "Card not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })	  
	    @PutMapping("/user/consents")
	    public ResponseEntity<ObjectNode> editGDPRConsents(
	        @ApiParam(value = "Consents object", required = true) @Valid @RequestBody consents card) throws ResourceNotFoundException {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 @ApiOperation(value = "This method returns details about all users associated with the accounts of the logged-in user. In case of getting all data, the SUCCESS status is returned.")
	    @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success"),
	        @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	        @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	        @ApiResponse(code = 401, message = "Authentication failed"),
	        @ApiResponse(code = 404, message = "Resource not found")
	    })
		@ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @GetMapping("/users")
	    public ResponseEntity<ObjectNode> getCardHolderDetails() {
			
		    ObjectNode statusCode = objectMapper.createObjectNode();
		    statusCode.put("code", "00");
		    statusCode.put("name", "BLACKCAP");
			
		 
			ObjectNode cards = objectMapper.createObjectNode();
			cards.put("cardId", "54b13718b3a66c355c7d437d45fa9fe1b6c4eb57a88289e65f4ee2944549ae57");
			cards.put("cardNumber", "5198********2709");
			cards.put("loyaltyId", "2251100318313");
			cards.put("seqNum", 1);
			cards.put("statusCode", statusCode);
			cards.put("dateOpen", "2019-06-06");
			cards.put("cardType", "BUSINESS");
			
			ObjectNode contactDetails = objectMapper.createObjectNode();
	    	//JSONObject cardHolderAddress=new JSONObject();
			contactDetails.put("TAXaddressLine1", "Avenida da Liberdade nº 23");
			contactDetails.put("taxaddressLine2", "");
			contactDetails.put("taxcity", "Lisbon");
			contactDetails.put("taxZIPCode", "7821-839");
			contactDetails.put("taxbusinessphone", "4567888");
			contactDetails.put("Homephone", "765434");
			contactDetails.put("mobilephone", "7543");
			contactDetails.put("email", "test@blackcap.com");
	    	
			ObjectNode cardHolderTitle = objectMapper.createObjectNode();
	    	//JSONObject cardHolderTitle=new JSONObject();
	    	cardHolderTitle.put("code", "SRA");
	    	cardHolderTitle.put("name", "SRA");
	    	
	    	ObjectNode cardHolderMaritalStatus = objectMapper.createObjectNode();
	    	//JSONObject cardHolderMaritalStatus=new JSONObject();
	    	cardHolderMaritalStatus.put("code", "V");
	    	cardHolderMaritalStatus.put("name", "VIUVO");
	    	
	    	
	    	ObjectNode cardHolderNationality = objectMapper.createObjectNode();
	    	//JSONObject cardHolderNationality=new JSONObject();
	    	cardHolderNationality.put("code", "PRT");
	    	cardHolderNationality.put("name", "PORTUGAL");
	    	
		 
			ObjectNode cardholdersDetails = objectMapper.createObjectNode();
			cardholdersDetails.put("clientNumber", "000078308");
			cardholdersDetails.put("clientSequenceNumber", 1);
			cardholdersDetails.put("cards", cards);
			cardholdersDetails.put("contactDetails", contactDetails);
			cardholdersDetails.put("firstName", "BACLk");
			cardholdersDetails.put("lastName", "CAP");
			cardholdersDetails.put("fullName", "BLACK JACK CAP");
			cardholdersDetails.put("title", cardHolderTitle);
			cardholdersDetails.put("nationality", cardHolderNationality);
			cardholdersDetails.put("maritalStatus", cardHolderMaritalStatus);
	    	
	    	
			cardholdersDetails.put("dateOfBirth", "26-12-1920");
			cardholdersDetails.put("birthPlace", "ÍLHAVO");
			cardholdersDetails.put("gender", "Male");
			cardholdersDetails.put("numberOfDependent", "05");
			cardholdersDetails.put("identityCardType", "009-CARTAO RESIDENCIA (UE)");
			cardholdersDetails.put("identityCardNumber", "ZWF110052");
			cardholdersDetails.put("idDocExpiryDate", "20200422");
			cardholdersDetails.put("homeType", "P-PROPRIETARIO");
			cardholdersDetails.put("otherResidence", "false");
			cardholdersDetails.put("otherCountry", "PRT");
			cardholdersDetails.put("position", "40-PUBL. DIRECTORES-QUADRO SUPERIOR");
			cardholdersDetails.put("office", "A82-OPERARIO QUALIFICADO");
			cardholdersDetails.put("typeOfContract", "2-Not efectiv (Termo Certo / Prazo)");
			cardholdersDetails.put("contractExpiryDate", "20241127");
			cardholdersDetails.put("activitySector", "S01-AGRICULTURA");
			cardholdersDetails.put("employmentContractDate", "202110");
			cardholdersDetails.put("companyName", "MELO");
			cardholdersDetails.put("monthlyIncome", "190613");
			cardholdersDetails.put("employmentContractDate", "202110");
			cardholdersDetails.put("eMailStatement", "false");
			cardholdersDetails.put("stopMail", "2-NAO RECEBE NENHUMA COMUNICACAO + DATA FIM REACTIVIDAD");
	    	
			
			
	    	
	    	 ObjectNode opcard = objectMapper.createObjectNode();
	    	//JSONObject opcard=new JSONObject();
	    	 opcard.put("Status","SUCCESS");
	    	 opcard.put("cardholdersDetails", cardholdersDetails);
	    	
	    	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 @ApiOperation(value = "Method checks Multichannel Code for logged-in user.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/multichannel/check")
	    public ResponseEntity<ObjectNode> checkMultichannelCodeForLoggedInUser(
	        @ApiParam(value = "MMCode is required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 @ApiOperation(value = "Method checks Multichannel Code with provided cardId.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/multichannel/check-for-card")
	    public ResponseEntity<ObjectNode> checkMultichannelCodeWithCardId(
	        @ApiParam(value = "CardId and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 @ApiOperation(value = "Method changes Multichannel Code with provided cardId.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/multichannel/change-for-card")
	    public ResponseEntity<ObjectNode> changeMultichannelCodeWithCardId(
	        @ApiParam(value = "CardId, newMCCode and oldMCCode are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 
	 @ApiOperation(value = "Method activates a card. Possible only for cards with the 99 status. ")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/cards/activateCard")
	    public ResponseEntity<ObjectNode> activateCard(
	        @ApiParam(value = "publicKeyId, cardId, encryptedPin and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 @ApiOperation(value = "Method changes the status of a card specified in request. In case of correct data, card status is changed and the SUCCESS status is returned")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/cards/status")
	    public ResponseEntity<ObjectNode> changeCardStatus(
	        @ApiParam(value = "cardId,newStatus and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 
	 @ApiOperation(value = "Method allows to order the card duplicate.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/cards/order-duplicate")
	    public ResponseEntity<ObjectNode> orderDuplicateCard(
	        @ApiParam(value = "cardId,newStatus and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 @ApiOperation(value = "Method changes (or creates) PIN number for a chosen card of a currently logged in user.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/cards/pin")
	    public ResponseEntity<ObjectNode> changeCardPinNumber(
	        @ApiParam(value = "publicKeyId,cardId, encrypedPin and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 
	 @ApiOperation(value = "Method gets cards details of a currently logged in user. In case of getting all data, the SUCCESS status is returned.")
	    @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success"),
	        @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	        @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	        @ApiResponse(code = 401, message = "Authentication failed"),
	        @ApiResponse(code = 404, message = "Resource not found")
	    })
		@ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @GetMapping("/cards/list-details")
	    public ResponseEntity<ObjectNode> getCradListDetails() {
		   ObjectNode status = objectMapper.createObjectNode();
			
		   status.put("code", "05");
		   status.put("name", "Do not honour");
				
		 
			ObjectNode card = objectMapper.createObjectNode();
			
			card.put("cardId", "6d74f87f-3447-4ed1-8300-b9b64b7d3b17");
			card.put("cardNumber", "5182********5814");
			card.put("status", status);
			card.put("cardName", "LAUREANA CASTRO");
			card.put("productionStatus", "Active");
			card.put("productionEvent", "NWOPIN");
			card.put("expiryDate", "2005");
			
	        ObjectNode cards = objectMapper.createObjectNode();
			
			cards.put("expiryDate", "2005");
			cards.put("baseType", "CREDIT");
			cards.put("cards", card);
			cards.put("debitCardId", "47f4eb36-bed3-4103-b4f8-c4b4b9905fd4");
			cards.put("cardId", "6d74f87f-3447-4ed1-8300-b9b64b7d3b17");
			cards.put("cardNumber", "5182********5814");
			cards.put("cardOwnerName", "LAUREANA CASTRO");
			cards.put("productionStatus", "Active");
			cards.put("productionEvent", "NWOPIN");
			cards.put("name", "LAUREANA CASTRO");
			cards.put("status", status);
			cards.put("type", "COMBO_MAIN");
			
			
	    	
	    	 ObjectNode opcard = objectMapper.createObjectNode();
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("Status","SUCCESS");
	    	opcard.put("cards", cards);
	    	
	    	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 
	 @ApiOperation(value = "This method returns informations about all cards associated with the accounts of the logged-in user.")
	    @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success"),
	        @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	        @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	        @ApiResponse(code = 401, message = "Authentication failed"),
	        @ApiResponse(code = 404, message = "Resource not found")
	    })
		@ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @GetMapping("/cards")
	    public ResponseEntity<ObjectNode> getAllCards() {
		   
	    	
	    	 ObjectNode opcard = objectMapper.createObjectNode();
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("Status","SUCCESS");
	    	
	    	
	    	 //Yet to work onthe return object   	
	    	return ResponseEntity.ok().body(opcard);
	    }

	 
	 
	 @ApiOperation(value = "Method gets a list of transactions for given input parameters.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/transactions/summary-portal")
	    public ResponseEntity<ObjectNode> getTransactionsSummery(
	        @ApiParam(value = "accountType,dateFrom, dateTo,category, NIF and legacy are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	//Yet to work on the response object
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 
	 @ApiOperation(value = "Method gets a transactions history for given input parameters.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/transactions/history")
	    public ResponseEntity<ObjectNode> getTransactionsHistrory(
	        @ApiParam(value = "accountType,dateFrom, dateTo,category, NIF and legacy are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	//Yet to work on the response object
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 @ApiOperation(value = "Method requests to change the amortization value. If the amortization value change has been performed successfully, the SUCCESS status is returned..")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 404, message = "Card not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })	  
	    @PutMapping("/credit-bank-account/degressivity")
	    public ResponseEntity<ObjectNode> editAccountDegressivity(
	        @ApiParam(value = "ETCProcessCards object", required = true) @Valid @RequestBody ETCProcessCards card) throws ResourceNotFoundException {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 
	 @ApiOperation(value = "Method returns the IBAN number, details of the user’s credit and debit account and available payment options.")
	    @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success"),
	        @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	        @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	        @ApiResponse(code = 401, message = "Authentication failed"),
	        @ApiResponse(code = 404, message = "Resource not found")
	    })
		@ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @GetMapping("/credit-bank-account")
	    public ResponseEntity<ObjectNode> getIBNDetails() {
		   
	    	
	    	 ObjectNode opcard = objectMapper.createObjectNode();
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("Status","SUCCESS");
	    	
	    	
	    	 //Yet to work onthe return object   	
	    	return ResponseEntity.ok().body(opcard);
	    }
	 
	 @ApiOperation(value = "Method transfers balance amount from credit/debit account to a linked account or from the linked account to the credit/debit account with specified payment option code – see method to get IBAN details and available payment options.")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
	            @ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
	            @ApiResponse(code = 401, message = "Authentication Failed"),
	            @ApiResponse(code = 404, message = "Resource not found")
	        })
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "email", value = "Card user's email", required = true, dataType = "string", paramType = "query"),
		     @ApiImplicitParam(name = "NIF", value = "Card user's NIF", required = true, dataType = "long", paramType = "query")
		  })
	    @PostMapping("/credit-bank-account/transfer")
	    public ResponseEntity<ObjectNode> transferBalance(
	        @ApiParam(value = "amount,MCCode and paymentOption are required", required = true) @Valid @RequestBody ETCProcessCards card) throws Exception {
	    	ObjectNode opcard = objectMapper.createObjectNode();
	    	
	    	//JSONObject opcard=new JSONObject();
	    	opcard.put("status", "Success");
	    	
	    	
	    	return ResponseEntity.ok().body(opcard);
	    }
	
	
	
	
}
