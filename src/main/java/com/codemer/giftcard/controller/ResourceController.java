package com.codemer.giftcard.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//import org.json.JSONException; import org.json.JSONObject; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.http.HttpStatus; import org.springframework.http.ResponseEntity; import org.springframework.http.ResponseEntity.BodyBuilder; import org.springframework.web.bind.annotation.DeleteMapping; import org.springframework.web.bind.annotation.GetMapping; import org.springframework.web.bind.annotation.PathVariable; import org.springframework.web.bind.annotation.PostMapping; import org.springframework.web.bind.annotation.PutMapping; import org.springframework.web.bind.annotation.RequestBody; import org.springframework.web.bind.annotation.RequestMapping; import org.springframework.web.bind.annotation.RestController;

import com.codemer.giftcard.exception.ResourceNotFoundException;
import com.codemer.giftcard.model.ETCProcessCards;
import com.codemer.giftcard.model.appInfo;
import com.codemer.giftcard.model.card;
import com.codemer.giftcard.model.contactForm;
import com.codemer.giftcard.model.loyaltyCard;
import com.codemer.giftcard.repository.CardRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "resource", produces = "application/json")
@Api(value = "Resource Management System", description = "These are PUBLIC API rest endpoints (no AUthentication is required).")
public class ResourceController {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private RequestMappingHandlerMapping requestHandlerMapping;

	
	@ApiOperation(value = "View the Applivation version", response = appInfo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@GetMapping("/info/version")
	public ResponseEntity<appInfo> getVersion() {

		appInfo app1 = new appInfo("7", "2017-08-22 15:01:13", "67fd2405ed");
this.printURLS();
		return ResponseEntity.ok().body(app1);
	}

	
	public void printURLS() {
		this.requestHandlerMapping.getHandlerMethods()
        .forEach((key, value) ->  System.out.println(key+" -- "+value));
	}
	@ApiOperation(value = "smsRequest loyaltyCard")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping(value = "/loyalty/smsRequest")
	public ResponseEntity<ObjectNode> createSmsRequest(
			@ApiParam(value = "loyalty and  mainCardLoyalty Required", required = true) @Valid @RequestBody loyaltyCard card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("ResultCode", new Integer(00));
		opcard.put("SessionId", "a34f3423");

		// return ResponseEntity.ok(opcard);
		return new ResponseEntity<>(opcard, HttpStatus.OK);
	}

	@ApiOperation(value = "linkRequest loyaltyCard")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/loyalty/linkRequest")
	public ResponseEntity<ObjectNode> createlinkRequest(
			@ApiParam(value = "loyalty, mainCardLoyalty, sessionId and token are required ", required = true) @Valid @RequestBody loyaltyCard card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Card temporary user verification")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/cards/temporary/verify-user")
	public ResponseEntity<ObjectNode> verifyUser(
			@ApiParam(value = "nif and pvl are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("Degressivity", "20%");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method activates temporary card")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/cards/temporary/activate")
	public ResponseEntity<ObjectNode> activateTemporaryCard(
			@ApiParam(value = "nif, etc,degressivity and pvl are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("ActiveCardLoyaltyId", "12345678901234567");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "This method checks account and card given in request (pan).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/cards/account_and_card_checks")
	public ResponseEntity<ObjectNode> checkAccountAndCard(
			@ApiParam(value = "cardNumber and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("LoyaltyId", "4234234");
		opcard.put("SeqNum", "1");
		opcard.put("Degressivity", "50");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method activates card in force activation manner.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/cards/forceActivateCard")
	public ResponseEntity<ObjectNode> forceActivateCard(
			@ApiParam(value = "publicKeyId, cardNumber, encryptedPin, oldMCCode, newMCCode and degressivity are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method gets the transport public key in order to change the card�s PIN number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@GetMapping("/security/transport-public-key")
	public ResponseEntity<ObjectNode> getTransportPublicKey() throws Exception {

		ObjectNode card = objectMapper.createObjectNode();
		// JSONObject card=new JSONObject();
		card.put("status", "Success");
		card.put("publicKeyId", "A1421829528875");
		card.put("ZpublicKey",
				"MIIBIjANBgkqh-kiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzoE2bhrbfV5iKvDSKBmtlSSaSuwHFBr++M5+KBDX7h4ebEHmaqIhOF4hJBarddmptwQ0KcqTzBckPSgQ3pQj3oPyKG9b7qDcg+ejva/7WjKeVfk0jJydRN/H9HzF1atdOQPbWUtn7nMMqgiSo3dG1w949JVgASO5YvFIlYSeqAx7aj5ItSawiQrIlySEJQfh+eaJQcI1Cq/39vZkdjDp9I1nTry-DSwf331XSc8COPqMzLKHRWnoqbYRt4LT44OphaWz+/YzW4I+DcHxc0Jo1a+skN6Ss7p/gGDApHZKAQnqJzEkr8KIUfNjybCdcN0S1ZtiTuCp63fwPyTjQI1QIDAQAB");

		return ResponseEntity.ok().body(card);
	}

	@ApiOperation(value = "Method checks Multichannel Code with provided PAN (cardNumber).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "INVALID_PAN_OR_MCCODE not found") })
	@PostMapping("/multichannel/check-for-pan")
	public ResponseEntity<ObjectNode> checkMultipleChannelCode(
			@ApiParam(value = "cardNumber and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method sets Multichannel Code for provided PAN (cardNumber) and cardholder (nif).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "INVALID_PAN_OR_MCCODE not found") })
	@PostMapping("/multichannel/code")
	public ResponseEntity<ObjectNode> forceMultipleChannelCodeSetting(
			@ApiParam(value = "cardNumber,nif and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "This method sends message to Universo. Method is available for both non-authenticated and authenticated users. For logged-in user, there is a dedicated method to get user contact de-tails, which can be used to fill json content.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "INVALID_PAN_OR_MCCODE not found") })
	@PostMapping("/contact")
	public ResponseEntity<ObjectNode> submitContactForm(
			@ApiParam(value = "lista,lista, lang, formid, fname_77, lname_78, campoe_27_79, email_75, ind_telemovel_76, telemovel_76_numero, campoe_31_81,campoe_29_80 are required", required = true) @Valid @RequestBody contactForm card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("response",
				"(…)<div class=\"easygoi-message\" style=\"text-align: center;\">\n<p>Os seus dados foram alterados com sucesso.</p> (…)</body>\n</html>\n");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method retrieves information about CardHolder.")
	@GetMapping("/wallet/user/{NIF}/info")
	public ResponseEntity<ObjectNode> getcardHolderInfo(
			@ApiParam(value = "NIF id from which cardHolderInfo object will retrieve", required = true) @PathVariable(value = "NIF") Long NIF)
			throws ResourceNotFoundException {
		ObjectNode cardHolderAddress = objectMapper.createObjectNode();
		// JSONObject cardHolderAddress=new JSONObject();
		cardHolderAddress.put("addressLine1", "Avenida da Liberdade nº 23");
		cardHolderAddress.put("addressLine2", "");
		cardHolderAddress.put("city", "Lisbon");
		cardHolderAddress.put("postalCode", 1200);

		ObjectNode cardHolderCountry = objectMapper.createObjectNode();
		// JSONObject cardHolderCountry=new JSONObject();
		cardHolderCountry.put("code", "PRT");
		cardHolderCountry.put("name", "PORTUGAL");

		ObjectNode cardHolderTitle = objectMapper.createObjectNode();
		// JSONObject cardHolderTitle=new JSONObject();
		cardHolderTitle.put("code", "SRA");
		cardHolderTitle.put("name", "SRA");

		ObjectNode cardHolderMaritalStatus = objectMapper.createObjectNode();
		// JSONObject cardHolderMaritalStatus=new JSONObject();
		cardHolderMaritalStatus.put("code", "V");
		cardHolderMaritalStatus.put("name", "VIUVO");

		ObjectNode cardHolderNationality = objectMapper.createObjectNode();
		// JSONObject cardHolderNationality=new JSONObject();
		cardHolderNationality.put("code", "PRT");
		cardHolderNationality.put("name", "PORTUGAL");

		ObjectNode map = objectMapper.createObjectNode();

		// Map map=new HashMap();

		map.put("cardHolderAddress", cardHolderAddress);
		map.put("cardHolderBirthDate", "1985-10-17");
		map.put("cardHolderCountry", cardHolderCountry);
		map.put("cardHolderEmail", "test.test@britenet.com.pl");
		map.put("cardHolderFirstName", "First");
		map.put("cardHolderLastName", "Last");
		map.put("cardholderFullName", "First Middle Last");
		map.put("cardHolderTitle", cardHolderTitle);
		map.put("cardHolderMaritalStatus", cardHolderMaritalStatus);
		map.put("cardHolderHomePhone", "911584043");
		map.put("cardHolderMobilePhone", "221112233");
		map.put("cardHolderNationality", cardHolderNationality);
		map.put("contractStatus", "Active");
		map.put("customerCardName", "Test Test");
		map.put("hasDefinitiveCard", false);
		map.put("isMainCustomer", false);
		map.put("isUniversoClient", true);
		map.put("relatedCardholderNIF", "000000020");
		map.put("relatedCustomerCardName", "First2 Last2");
		map.put("universoLoyaltyId", 100000123);
		map.put("isCreditworthy", true);

		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("cardHolderInfo", map);

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method checks Multichannel Code for the user’s current card - user identified by NIF (no au-thentication required).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/wallet/multichannel/validate")
	public ResponseEntity<ObjectNode> validateMC(
			@ApiParam(value = "nif and MCCode are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method add card to cardHolder wallet (no authentication required).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "INVALID_PAN_OR_MCCODE not found") })
	@PostMapping("/wallet/cards/add")
	public ResponseEntity<ObjectNode> addCradToCradHolder(
			@ApiParam(value = "cardBIN,cardBrand, cardHolderName, cardHolderNIF, cardIdentifier, cardNumber, cardStatus, expiryDate and registrationDate are required", required = true) @Valid @RequestBody card card)
			throws Exception {
		ObjectNode cardInfo = objectMapper.createObjectNode();
		// JSONObject cardInfo=new JSONObject();
		cardInfo.put("cardBIN", "518224");
		cardInfo.put("cardBrand", "MASTERCARD");
		cardInfo.put("cardHolderName", "BLACKCAP");
		cardInfo.put("cardHolderNIF", "000000019");
		cardInfo.put("cardIdentifier", "0000001201202");
		cardInfo.put("cardNumber", "5182244842630181");
		cardInfo.put("cardStatus", "ACTIVE");
		cardInfo.put("expiryDate", "201903");
		cardInfo.put("registrationDate", "2015-03-01 10:15:42");
		cardInfo.put("walletFlag", "true");

		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("cardInfo", cardInfo);

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method deactivate Wallet Card with specified cardId (no authentication required).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Card not found") })
	@PutMapping("/wallet/cards/{cardId}/deactivate")
	public ResponseEntity<ObjectNode> updateEmployee(
			@ApiParam(value = "cardId  to deactivate Wallet Card object", required = true) @PathVariable(value = "cardId") Long cardId,
			@ApiParam(value = "deactivate Wallet Card with specified cardId ", required = true) @Valid @RequestBody card card)
			throws ResourceNotFoundException {
		ObjectNode opcard = objectMapper.createObjectNode();

		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method returns last issued card applications from Way4 or Wallet cards for user with specified NIF (no authentication required).")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "INVALID_REQUEST or Failed"),
			@ApiResponse(code = 503, message = "SERVICE_TEMPORARILY_UNAVAILABLE"),
			@ApiResponse(code = 404, message = "Card not found") })
	@PostMapping("/wallet/cards")
	public ResponseEntity<ObjectNode> getAllCards(
			@ApiParam(value = "nif and cardsType are required", required = true) @Valid @RequestBody ETCProcessCards card)
			throws Exception {
		ObjectNode cardInfo = objectMapper.createObjectNode();
		// JSONObject cardInfo=new JSONObject();
		cardInfo.put("cardBIN", "518224");
		cardInfo.put("cardBrand", "MASTERCARD");
		cardInfo.put("cardHolderName", "BLACKCAP");
		cardInfo.put("cardHolderNIF", "000000019");
		cardInfo.put("cardIdentifier", "0000001201202");
		cardInfo.put("cardNumber", "5182244842630181");
		cardInfo.put("cardStatus", "ACTIVE");
		cardInfo.put("expiryDate", "201903");
		cardInfo.put("registrationDate", "2015-03-01 10:15:42");
		cardInfo.put("walletFlag", "true");

		ObjectNode cardInfo1 = objectMapper.createObjectNode();
		// JSONObject cardInfo1=new JSONObject();
		cardInfo1.put("cardBIN", "518224");
		cardInfo1.put("cardBrand", "MASTERCARD");
		cardInfo1.put("cardHolderName", "BLACKCAP");
		cardInfo1.put("cardHolderNIF", "000000019");
		cardInfo1.put("cardIdentifier", "0000001201202");
		cardInfo1.put("cardNumber", "5182244842630181");
		cardInfo1.put("cardStatus", "ACTIVE");
		cardInfo1.put("expiryDate", "201903");
		cardInfo1.put("registrationDate", "2015-03-01 10:15:42");
		cardInfo1.put("walletFlag", "true");

		ObjectNode cardsList = objectMapper.createObjectNode();

		// List cardsList=new ArrayList();

		cardsList.putAll(cardInfo);
		cardsList.putAll(cardInfo1);
		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("cards", cardsList);

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method gets Wallet Card with specified cardId (no authentication required).")
	@GetMapping("/wallet/cards/{cardId}")
	public ResponseEntity<ObjectNode> getcard(
			@ApiParam(value = "cardId  from which cardInfo object will retrieve", required = true) @PathVariable(value = "cardId") Long cardId)
			throws ResourceNotFoundException {
		ObjectNode cardInfo = objectMapper.createObjectNode();
		// JSONObject cardInfo=new JSONObject();
		cardInfo.put("cardBIN", "518224");
		cardInfo.put("cardBrand", "MASTERCARD");
		cardInfo.put("cardHolderName", "BLACKCAP");
		cardInfo.put("cardHolderNIF", "000000019");
		cardInfo.put("cardIdentifier", "0000001201202");
		cardInfo.put("cardNumber", "5182244842630181");
		cardInfo.put("cardStatus", "ACTIVE");
		cardInfo.put("expiryDate", "201903");
		cardInfo.put("registrationDate", "2015-03-01 10:15:42");
		cardInfo.put("walletFlag", "true");

		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");
		opcard.put("cardInfo", cardInfo);

		return ResponseEntity.ok().body(opcard);
	}

	@ApiOperation(value = "Method deletes virtual card with given cardId (no authentication required)")
	@DeleteMapping("/incontrol/vcn/{cardId}")
	public ResponseEntity<ObjectNode> deleteVcn(
			@ApiParam(value = "cardId from which virtual card  object will delete from database table", required = true) @PathVariable(value = "cardId") Long cardId)
			throws ResourceNotFoundException {
		ObjectNode opcard = objectMapper.createObjectNode();
		// JSONObject opcard=new JSONObject();
		opcard.put("status", "Success");

		return ResponseEntity.ok().body(opcard);
	}
}