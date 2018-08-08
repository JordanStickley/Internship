<%@ include file="/WEB-INF/layouts/include.jsp"%>

<div class="row">
	<h1 class="underline col-sm-12">Last.FM Checkout</h1>
</div>
	
<div class="main-primary col-md-9">
	<div id="sign-in-container" class="checkout-fragment content-wrap well">
		<div class="row">
			<div class="col-xs-9">
				<h1>
					<span id="sign-in-header">Signed In As</span>
				</h1>
			</div>
			<div class="col-xs-3">
				<a href="javascript:;" class="js-edit-section" style="display: inline;">Show</a>
			</div>
		</div>
		
		<div class="row">
			<div id="sign-in-content" class="checkout-content"
				style="opacity: 1; display: block;">
				<div class="js-signed-in"></div>
				<div class="col-sm-12">
					<div class="col-sm-12 sign-in-view">
						<strong>Jordan Stickley</strong><br> <span>jordanthestick@gmail.com</span>
					</div>
				</div>
			</div>
		</div>	
	</div>

	<div id="delivery-content" class="checkout-content well"
		style="opacity: 1; display: block;">
		<h1>
			<span id="delivery-header">Delivery</span>
		</h1>

		<fieldset class="checkout-section">

			<h2 class="checkout-heading2 col-xs-12">Shipping Address</h2>
			<form id="shippingInfoForm" novalidate="novalidate">

				<div class="col-sm-6 form-group">
					<label for="firstName">First Name<em class="req">*</em></label> <input
						id="firstName"
						class="form-control js-chkt-ship-first-name form-error-highlight"
						type="text" name="address.firstName" aria-required="true"
						maxlength="120" value="" aria-describedby="firstName-error"><em
						id="firstName-error" class="form-error">First name is
						required.</em>
				</div>
				<div class="col-sm-6 form-group">
					<label for="lastName">Last Name<em class="req">*</em></label> <input
						id="lastName"
						class="form-control js-chkt-ship-last-name form-error-highlight"
						type="text" name="address.lastName" aria-required="true"
						maxlength="120" value="" aria-describedby="lastName-error"><em
						id="lastName-error" class="form-error">Last name is required.</em>
				</div>
				<div class="clearfix"></div>
				<div class="col-sm-6 form-group">
					<label for="addressLine1">Address<em class="req">*</em></label> <input
						id="addressLine1"
						class="form-control js-chkt-ship-address form-error-highlight"
						type="text" name="address.addressLine1" aria-required="true"
						maxlength="35" value="" aria-describedby="addressLine1-error"
						aria-invalid="true"><em id="addressLine1-error"
						class="form-error">Address is required.</em>
				</div>
				<div class="col-sm-6 form-group">
					<label for="addressLine2">Address Line 2 (optional)</label> <input
						id="addressLine2" class="form-control js-chkt-ship-address2"
						type="text" name="address.addressLine2" maxlength="35" value="">
				</div>
				<div class="clearfix"></div>
				<div class="col-sm-6 form-group">
					<label for="city">City<em class="req">*</em></label> <input
						id="city"
						class="form-control js-chkt-ship-city form-error-highlight"
						type="text" name="address.city" aria-required="true"
						maxlength="30" value="" aria-describedby="city-error"><em
						id="city-error" class="form-error">City is required.</em>
				</div>
				<div class="col-sm-3 form-group">
					<label>State<em class="req">*</em></label>
					<div class="o-select_wrap">
						<select id="state"
							class="o-select form-control js-chkt-ship-state placeholder form-error-highlight"
							name="address.stateProvinceRegion" data-placeholder="State"
							aria-required="true" aria-describedby="state-error">
							<option value="" selected="selected">Select</option>
							<option value="AL">ALABAMA</option>
							<option value="AK">ALASKA</option>
							<option value="AZ">ARIZONA</option>
							<option value="AR">ARKANSAS</option>
							<option value="CA">CALIFORNIA</option>
							<option value="CO">COLORADO</option>
							<option value="CT">CONNECTICUT</option>
							<option value="DE">DELAWARE</option>
							<option value="DC">DISTRICT OF COLUMBIA</option>
							<option value="FL">FLORIDA</option>
							<option value="GA">GEORGIA</option>
							<option value="HI">HAWAII</option>
							<option value="ID">IDAHO</option>
							<option value="IL">ILLINOIS</option>
							<option value="IN">INDIANA</option>
							<option value="IA">IOWA</option>
							<option value="KS">KANSAS</option>
							<option value="KY">KENTUCKY</option>
							<option value="LA">LOUISIANA</option>
							<option value="ME">MAINE</option>
							<option value="MD">MARYLAND</option>
							<option value="MA">MASSACHUSETTS</option>
							<option value="MI">MICHIGAN</option>
							<option value="MN">MINNESOTA</option>
							<option value="MS">MISSISSIPPI</option>
							<option value="MO">MISSOURI</option>
							<option value="MT">MONTANA</option>
							<option value="NE">NEBRASKA</option>
							<option value="NV">NEVADA</option>
							<option value="NH">NEW HAMPSHIRE</option>
							<option value="NJ">NEW JERSEY</option>
							<option value="NM">NEW MEXICO</option>
							<option value="NY">NEW YORK</option>
							<option value="NC">NORTH CAROLINA</option>
							<option value="ND">NORTH DAKOTA</option>
							<option value="OH">OHIO</option>
							<option value="OK">OKLAHOMA</option>
							<option value="OR">OREGON</option>
							<option value="PA">PENNSYLVANIA</option>
							<option value="RI">RHODE ISLAND</option>
							<option value="SC">SOUTH CAROLINA</option>
							<option value="SD">SOUTH DAKOTA</option>
							<option value="TN">TENNESSEE</option>
							<option value="TX">TEXAS</option>
							<option value="UT">UTAH</option>
							<option value="VT">VERMONT</option>
							<option value="VA">VIRGINIA</option>
							<option value="WA">WASHINGTON</option>
							<option value="WV">WEST VIRGINIA</option>
							<option value="WI">WISCONSIN</option>
							<option value="WY">WYOMING</option>
						</select><em id="state-error" class="form-error">State is required.</em> <b
							class="dropdown" role="presentation"></b>
					</div>
				</div>
				<div class="col-sm-3 form-group">
					<label for="zipCode">Zip<em class="req">*</em></label> <input
						id="zipCode"
						class="form-control js-chkt-ship-zip form-error-highlight"
						name="address.postalCode" type="tel" maxlength="5"
						pattern="\d{5,5}(-\d{4,4})?" aria-required="true" value=""
						aria-describedby="zipCode-error"><em id="zipCode-error"
						class="form-error">Zip Code is required.</em>
				</div>
				<div class="col-sm-4 form-group">
					<label for="shippingSaveAddress"> <input type="checkbox"
						name="saveAddressOnCustomer" id="shippingSaveAddress" value="true">
						Save this address for later
					</label>
				</div>
				<input type="hidden" id="shippingFullName" name="address.fullName">
				<input type="hidden" value="US" name="address.isoCountryAlpha2">
				<input type="hidden" name="address.zipFour" value=""> <input
					type="hidden" name="address.verificationLevel" value="">
				<div class="clearfix"></div>


				<input type="hidden" name="csrfToken"
					value="21RZ-EY1C-VI9H-A2XQ-KLPW-SEUJ-9U19-4J18">
			</form>






			<!-- Fulfillment Options -->
			<div class="checkout-shipping-method">
				<h2 class="checkout-heading2 col-xs-12" style="margin-top: 30px;">Shipping
					Method</h2>
				<div class="shipping-method-list">
					<div class="col-sm-4 csm_method">
						<label for="shipping-method-4"> <input
							class="csm_method_input" type="radio" name="fulfillmentOptionId"
							data-friendly-type="Ground" checked="checked"
							id="shipping-method-4" value="4" data-total="$29.46">
							<div class="csm_method_text">
								<strong>UPS&nbsp;Ground:&nbsp;</strong><span class="amount">$5.50</span>
								<br> <span>Estimated 5-10 Business Days</span>
							</div>
						</label>
					</div>
					<div class="col-sm-4 csm_method">
						<label for="shipping-method-3"> <input
							class="csm_method_input" type="radio" name="fulfillmentOptionId"
							data-friendly-type="Two Day" id="shipping-method-3" value="3"
							data-total="$34.21">
							<div class="csm_method_text">
								<strong>UPS&nbsp;Two Day:&nbsp;</strong><span class="amount">$10.25</span>
								<br> <span>Estimated 2-3 Business Days</span>
							</div>
						</label>
					</div>
					<div class="col-sm-4 csm_method">
						<label for="shipping-method-2"> <input
							class="csm_method_input" type="radio" name="fulfillmentOptionId"
							data-friendly-type="Next Day" id="shipping-method-2" value="2"
							data-total="$44.26">
							<div class="csm_method_text">
								<strong>UPS&nbsp;Next Day:&nbsp;</strong><span class="amount">$20.30</span>
								<br> <span>Estimated 1-2 Business Days</span>
							</div>
						</label>
					</div>
					<div class="csm_method_disclaimer">
						<span>Orders received after 4 p.m. EST may not be processed
							until the next business day.</span>
					</div>
				</div>
			</div>


			<div id="js-voc-err-modal" class="modal fade" tabindex="-1"
				role="dialog" aria-labelledby="js-voc-err-modal" aria-hidden="true">
				<div class="modal-dialog modal-md" role="document">
					<div class="modal-content">
						<div class="modal-body">
							<div class="voc-err-modal">
								<div class="voc-err-msg">
									<strong>Important</strong>
									<p>
										Due to state or local regulations and restrictions, we cannot
										ship the following <span class="voc-plural">item</span> to the
										addess you have specified. Please remove the <span
											class="voc-plural">item</span> from your shopping cart or
										enter a different shipping address.
									</p>
								</div>
								<ul class="voc-err-items"></ul>
								<button type="button"
									class="btn btn-secondary checkout-white-button"
									data-dismiss="modal">Cancel</button>
								<button type="button" class="checkout-green-button"
									id="js-voc-err-goto-cart" data-href="/cart?voc-error=">
									Go To Cart</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fieldset>



		<!-- <div class="col-xs-12">
			<div data-czid="Checkout Banner Content Zone"
				class="content-zone-container"></div>
			<div class="delivery-error" style="display: none;"></div>
			<button type="button" class="checkout-green-button"
				id="continueToPayment">
				Continue To Payment
				<svg>
					<use xmlns:xlink="http://www.w3.org/1999/xlink"
						xlink:href="#shape-cta"></use></svg>
			</button>
		</div> -->

	</div>

	<div id="payment-content" class="checkout-content well"
		style="opacity: 1; display: block;">
		<h1>
			<span id="payment-header">Payment</span>
		</h1>
		<form id="giftCardForm" class="gift-card-area" novalidate="novalidate">
			<fieldset class="checkout-section">
				<div class="gc-available" data-remaing-total="29.69"
					data-applied-gc="true" data-allow-gc="true"></div>
				<h2 class="checkout-heading2 pay-w-gc col-xs-12">
					Gift Card <a href="javascript:;"
						class="js-add-giftcard-payment add-payment js-cgc_add">Add a
						payment</a> <span class="js-cgc_limit cgc_limit" style="display: none">You
						can apply up to 3 gift cards</span>

				</h2>


				<div class="checkout-gift-cards js-cgc">
					<div class="clearfix"></div>
					<div class="col-sm-6 form-group gc-form-group">
						<label for="giftcardPhoneNumber">Phone Number<em
							class="req">*</em></label> <input id="giftcardPhoneNumber"
							class="form-control js-masked-phone js-phone-format" type="tel"
							name="PHONE_NUMBER" aria-required="true">
					</div>
					<div class="cgc-card-list js-cgc-card-list col-sm-12">


						<div class="cgc-wrap js-cgc-wrap" style="display: none">
							<div class="cgc-error js-cgc-error hidden"></div>
							<div class="row">
								<div class="cgc-card js-cgc-card col-xs-12">
									<div class="col-xs-12 col-sm-6 form-group">
										<label for="giftCardNumber">Gift Card #<em class="req">*</em></label>
										<input id="giftCardNumber"
											class="form-control js-cgc-card-num js-masked-cc"
											name="card-num" type="tel" pattern="[0-9]*"
											aria-required="true">
									</div>
									<div class="col-xs-12 col-sm-4 form-group">
										<label for="giftCardPin">Gift Card Pin<em class="req">*</em></label>
										<div class="row">
											<div class="col-xs-7 col-sm-6">
												<input id="giftCardPin"
													class="form-control js-cgc-card-pin form-control--hide-spinner"
													name="card-pin" maxlength="4" type="number"
													pattern="[0-9]*" aria-required="true" autocomplete="off">
											</div>
											<div class="col-xs-5 col-sm-6">
												<a href="#"
													class="btn-green-lg js-cgc-card_apply btn-action btn--lg">Apply</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 cgc-applied js-cgc-applied cgc-card">
								<input name="orderPaymentId" type="hidden"> <input
									name="lastFour" type="hidden"> <input name="pin"
									type="hidden"> <input name="amount" type="hidden">
								<div class="row">
									<div class="col-xs-7 col-sm-4 col-lg-3">
										<label class="cgc-applied_heading">Gift Card Number</label><br>
										<span class="js-cgc-masked cgc-applied_text"></span>
									</div>
									<div class="col-xs-3 col-sm-2">
										<label class="cgc-applied_heading">Amount</label><br> <span
											class="js-cgc-amount cgc-applied_text"></span>
									</div>
									<div class="col-xs-2 col-sm-3">
										<a href="#" class="cgc-remove js-cgc_remove"> <span
											class="cgc-remove_text">Remove</span>
										</a>
									</div>
								</div>
							</div>
						</div>


					</div>
					<div class="col-xs-12">
						<a href="#" class="cgc_add-another js-cgc_add-another"
							style="display: block"> <span>Add Another</span>
						</a>
					</div>
					<div class="gift-card-icon"></div>
				</div>

				<div class="gc-payment-fulfilled cp_section--whattoknow">
					<span class="gc-payment-fulfilled_text">Payment fulfilled by
						the amount on the gift card</span>
				</div>
			</fieldset>
			<input type="hidden" name="csrfToken"
				value="VYL5-W3DT-BEMB-TLYC-8RDJ-ZF28-RZDU-NJPY">
		</form>
		<div class="checkout-section">
			<form id="billingInfoForm" novalidate="novalidate">
				<fieldset class="billing-section js-checkout-section-billing">
					<div class="col-xs-12">
						<div class="bill-ship-wrap">
							<label for="checkout-bill-ship"> <input type="checkbox"
								id="checkout-bill-ship" name="useShippingAddress"
								class="js-checkout-billship-check" value="false">&nbsp;
								Yes, my billing and shipping addresses are the same.
							</label>
						</div>
					</div>
					<input type="hidden" name="_useShippingAddress" value="false">
					<div class="billing-main-form js-billing-main-form">
						<h2 class="checkout-heading2 col-xs-12">
							Billing Address <small>as it appears on your statement</small>
						</h2>
						<div class="col-sm-6 form-group">
							<label for="billingFirstName">First Name<em class="req">*</em></label>
							<input id="billingFirstName"
								class="form-control js-chkt-bill-first-name" type="text"
								name="address.firstName" aria-required="true" maxlength="120"
								value="">
						</div>
						<div class="col-sm-6 form-group">
							<label for="billingLastName">Last Name<em class="req">*</em></label>
							<input id="billingLastName"
								class="form-control js-chkt-bill-last-name" type="text"
								name="address.lastName" aria-required="true" maxlength="120"
								value="">
						</div>
						<div class="clearfix"></div>
						<div class="col-sm-6 form-group">
							<label for="billingAddressLine1">Address<em class="req">*</em></label>
							<input id="billingAddressLine1"
								class="form-control js-chkt-bill-address" type="text"
								name="address.addressLine1" maxlength="35" value="">
						</div>
						<div class="col-sm-6 form-group">
							<label for="billingAddressLine2">Address Line 2</label> <input
								id="billingAddressLine2"
								class="form-control js-chkt-bill-address2" type="text"
								name="address.addressLine2" maxlength="35" value="">
						</div>
						<div class="clearfix"></div>
						<div class="col-sm-6 form-group">
							<label for="billingCity">City<em class="req">*</em></label> <input
								id="billingCity" class="form-control js-chkt-bill-city"
								type="text" name="address.city" aria-required="true"
								maxlength="30" value="">
						</div>
						<div class="col-sm-3 form-group">
							<label for="">State<em class="req">*</em></label>
							<div class="o-select_wrap">
								<select
									class="o-select form-control js-chkt-bill-state placeholder"
									name="address.stateProvinceRegion" data-placeholder="State">
									<option value="" text="Select" selected="selected">Select</option>
									<option value="AL">ALABAMA</option>
									<option value="AK">ALASKA</option>
									<option value="AZ">ARIZONA</option>
									<option value="AR">ARKANSAS</option>
									<option value="CA">CALIFORNIA</option>
									<option value="CO">COLORADO</option>
									<option value="CT">CONNECTICUT</option>
									<option value="DE">DELAWARE</option>
									<option value="DC">DISTRICT OF COLUMBIA</option>
									<option value="FL">FLORIDA</option>
									<option value="GA">GEORGIA</option>
									<option value="HI">HAWAII</option>
									<option value="ID">IDAHO</option>
									<option value="IL">ILLINOIS</option>
									<option value="IN">INDIANA</option>
									<option value="IA">IOWA</option>
									<option value="KS">KANSAS</option>
									<option value="KY">KENTUCKY</option>
									<option value="LA">LOUISIANA</option>
									<option value="ME">MAINE</option>
									<option value="MD">MARYLAND</option>
									<option value="MA">MASSACHUSETTS</option>
									<option value="MI">MICHIGAN</option>
									<option value="MN">MINNESOTA</option>
									<option value="MS">MISSISSIPPI</option>
									<option value="MO">MISSOURI</option>
									<option value="MT">MONTANA</option>
									<option value="NE">NEBRASKA</option>
									<option value="NV">NEVADA</option>
									<option value="NH">NEW HAMPSHIRE</option>
									<option value="NJ">NEW JERSEY</option>
									<option value="NM">NEW MEXICO</option>
									<option value="NY">NEW YORK</option>
									<option value="NC">NORTH CAROLINA</option>
									<option value="ND">NORTH DAKOTA</option>
									<option value="OH">OHIO</option>
									<option value="OK">OKLAHOMA</option>
									<option value="OR">OREGON</option>
									<option value="PA">PENNSYLVANIA</option>
									<option value="RI">RHODE ISLAND</option>
									<option value="SC">SOUTH CAROLINA</option>
									<option value="SD">SOUTH DAKOTA</option>
									<option value="TN">TENNESSEE</option>
									<option value="TX">TEXAS</option>
									<option value="UT">UTAH</option>
									<option value="VT">VERMONT</option>
									<option value="VA">VIRGINIA</option>
									<option value="WA">WASHINGTON</option>
									<option value="WV">WEST VIRGINIA</option>
									<option value="WI">WISCONSIN</option>
									<option value="WY">WYOMING</option>
								</select> <b class="dropdown" role="presentation"></b>
							</div>
						</div>
						<div class="col-sm-3 form-group">
							<label for="billingZipCode">Zip<em class="req">*</em></label> <input
								id="billingZipCode" class="form-control js-chkt-bill-zip"
								name="address.postalCode" maxlength="5"
								pattern="\d{5,5}(-\d{4,4})?" type="tel" aria-required="true"
								value="">
						</div>
						<input type="hidden" name="address.zipFour" value=""> <input
							type="hidden" value="US" name="address.isoCountryAlpha2">
					</div>
				</fieldset>
				<input type="hidden" name="csrfToken"
					value="VYL5-W3DT-BEMB-TLYC-8RDJ-ZF28-RZDU-NJPY">
			</form>

			<form id="paymentInfoForm" novalidate="novalidate">
				<fieldset class="payment-section" style="">
					<h2 class="checkout-heading2 col-sm-12">Payment</h2>
					<div class="col-sm-6 form-group">
						<label for="chkt-payment-cc-name"> Name on Card<em
							class="req">*</em>
						</label> <input id="chkt-payment-cc-name" class="form-control" type="text"
							name="CREDIT_CARD_NAME" pattern="[a-zA-Z]*" aria-required="true"
							maxlength="100">
					</div>
					<div class="col-sm-6 form-group">
						<label for="billingPhoneNumber">Phone Number<em
							class="req">*</em></label> <input id="billingPhoneNumber"
							class="form-control js-masked-phone js-phone-format" type="tel"
							name="PHONE_NUMBER" value="">
					</div>
					<div class="clearfix"></div>
					
					<div class="row longRow">
						<div class="col-sm-5 form-group">
							<label for="chkt-payment-card"> Credit Card #<em
								class="req">*</em> <small> <a rel="nofollow"
									data-html="true" class="js-message" data-type="modal"
									tabindex="-1"
									href="/messages?message=international-restrictions"
									data-msgtitle="Can I ship my order to an international address? Can I pay with an international credit card?">U.S.
										Cards Only</a>
							</small>
							</label> <input id="chkt-payment-card" class="form-control" type="tel"
								name="CREDIT_CARD_NUMBER" aria-required="true"
								aria-describedby="cardInfo">
							<div class="credit-cards-icon"></div>
							<span class="screen-reader-only-text" id="cardInfo">We
								accept Visa, MasterCard, Discover, American Express, and JCB</span>
						</div>
						
						<div class="cc-mo-year form-group col-sm-5">
						
							<label for="">Expiration Date<em class="req">*</em></label>		
							<div>					
								<div class="col-xs-6">
									<div class="o-select_wrap">
										<select class="o-select js-chkt-month placeholder"
											name="CC_EXP_MONTH" data-placeholder="Month">
											<option value="">Month</option>
											<option value="01">01-January</option>
											<option value="02">02-February</option>
											<option value="03">03-March</option>
											<option value="04">04-April</option>
											<option value="05">05-May</option>
											<option value="06">06-June</option>
											<option value="07">07-July</option>
											<option value="08">08-August</option>
											<option value="09">09-September</option>
											<option value="10">10-October</option>
											<option value="11">11-November</option>
											<option value="12">12-December</option>
										</select> <b class="dropdown" role="presentation"></b>
									</div>
								</div>
														
								<div class="col-xs-5 moveRight">
									<div class="o-select_wrap">
										<select class="o-select js-chkt-year placeholder"
											name="CC_EXP_YEAR" data-placeholder="Year">
											<option value="">Year</option>
											<option value="18">2018</option>
											<option value="19">2019</option>
											<option value="20">2020</option>
											<option value="21">2021</option>
											<option value="22">2022</option>
											<option value="23">2023</option>
											<option value="24">2024</option>
											<option value="25">2025</option>
											<option value="26">2026</option>
											<option value="27">2027</option>
										</select> <b class="dropdown" role="presentation"></b>
									</div>
								</div>
							</div>
							
						</div>
						
						<div class="cid-col form-group col-sm-2">
							<label for="paymentCID">CID<em class="req">*</em></label> 
								<a rel="nofollow" data-html="true" class="btn--info js-message"
								   data-type="modal" href="/messages?message=cid"
								   data-msgtitle="What is a CID?"> 							
								</a> 
								<input aria-required="true" id="paymentCID" class="form-control"
									   type="tel" pattern="[0-9]*" placeholder="" name="CREDIT_CARD_CVV"
								       maxlength="4">
						</div>
						
					</div>					
				</fieldset>
				<input type="hidden" name="csrfToken"
					value="VYL5-W3DT-BEMB-TLYC-8RDJ-ZF28-RZDU-NJPY">
			</form>
		</div>
		<input type="hidden" id="totalAfterAppliedPayments" value="29.69">
		<input type="hidden" id="giftCardsOnly" value="false">	
	</div>
</div>
	<!-- <form action="" class="form" data-dojo-type="dijit/form/Form" id="basicDialogForm">
			<div class="row"> 		
				<div class="form-group col-sm-3">
					<label for="" class="control-label">Send Via SMS</label> 
					<input type="text" class="form-control"
						   placeholder="Ex. 417-429-7123" name="phone" id="phone"
						   data-dojo-id="phone" 
						   data-dojo-type="dijit/form/TextBox"
						   data-dojo-props="required: false">								   			  
				</div>
				<div class="form-group col-sm-2">
					<button id="basicFormSubmitBtn" class="btn btn-primary btn-form"
							type="submit" 
							data-dojo-type="oreilly/types/form/Button"
							data-dojo-props="spinOnClick: true">Send
					</button>
				</div>		
			</div>
		</form>
			
		<div class="row mt10">
			<div class="col-sm-12">
				<div class="table-responsive">
					Declare the memory store
					<div data-dojo-id="carPartStore" 
						 data-dojo-type="dojo/store/Memory"
						 data-dojo-props="data: [], idProperty: 'eventId'">
					</div>
					Build the table (head only)
					<div id="table-container4" class="span12">
						<table id="carParts" class="table table-striped table-bordered"
							   data-dojo-type="oreilly/types/dgrid/PagingGridCheckBox" 
							   data-dojo-props="store: carPartStore, loadDataOnStartup: true">
							<thead>
								<tr>
									<th class="hyperlink"
										data-dgrid-column='{field: "eventId",name: "eventId"}'>Event Id</th>
									<th class="hyperlink"
										data-dgrid-column='{field: "eventDate", name: "eventDate"}'>Event Date</th>
									<th class="hyperlink"
										data-dgrid-column='{field: "lovedDate", name: "LovedDate"}'>Loved Date</th>
									<th class="hyperlink"
										data-dgrid-column='{field: "trackName", name: "trackName"}'>Track Name</th>
									<th class="hyperlink"
										data-dgrid-column='{field: "artistName", name: "artistName"}'>Artist Name</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
</div>

<div class="row hidden"></div> -->


<script type="text/javascript">
	require([ 'dojo/request', 'dijit/registry', 'dojo/ready' ], function(
			request, registry, ready) {
		ready(function() {
			var grid = registry.byId("carParts");
			var store = registry.byId("carPartStore");
			request('<c:url value="/carParts/getCarParts" />').then(function(data) {
				grid.store.setData(JSON.parse(data));
				grid.refresh();
			}, function(err) {
				console.log("Error: " + err);
			});
			grid.refresh();
		});
	});
</script>