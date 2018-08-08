					<div class="row">
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
							<div class="col-xs-6">
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