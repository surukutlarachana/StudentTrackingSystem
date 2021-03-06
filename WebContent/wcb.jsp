<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Talk to Watson</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./resource/style.css" />
<script>
	var GLOBAL_LAYOUT = '<%=com.ats.util.Configuration.getInstance().getLayout() %>';
</script>
</head>
<body class="<%=com.ats.util.Configuration.getInstance().getLayout() %>">
	<header class="_demo--heading">
		<div class="_demo--container">
			<a class="wordmark" href="wcb.jsp">
				<span class="wordmark--left">Talk to</span>
				<span class="wordmark--right">Watson</span>
				
			</a>
			
			<a class="wordmark" href="student.jsp">
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span class="wordmark--right">Back</span>
			</a>
			<nav class="heading-nav">
				<a class="heading-nav--item chatbot signout hidden">
					Sign out
				</a>
				<a class="heading-nav--item signout hidden" href="login.jsp">Student Login</a>
				<a class="heading-nav--item signout hidden" href="student.jsp">Back</a>
			</nav>
		</div>
	</header>
	<div class="_demo--container">

		<div class="_container--sn">
			<form class="sn-form-container">
				<div class="sn-form-cell">
					<div class="sn-input"><label>Your serial number</label><input type="text" value="" placeholder="" class="input-sn" minlength="6" /></div>
					<div class="sn-input"><label>Your name</label><input type="text" value="" placeholder="" class="input-name" minlength="6" /></div>
					<div class="sn-input"><label>Your phone number</label><input type="text" value="" placeholder="" class="input-phone" minlength="6" /></div>
					<div class="sn-button"><input type="button" class="input-go" value="Go" /></div>
				</div>
			</form>
		</div>

		<article class="_demo--content base--article page hidden" ref="chatbot">
			<div class="_content--dialog">
				<div class="chat-window">
					<div class="chat-box">
						<div class="chat-box--pane">
							<div class="chat-box--item_WATSON chat-box--item chat-box--item_HIDDEN">
								<div class="chat-box--container">
									<div class="img-container chat-box--avatar chat-box--avatar_WATSON">
										<img src="images/icons/avatar-watson.svg" class="chat-box--avatar-img">
									</div>
									<div class="chat-box--message">
										<div class="chat-box--message-vertical">
											<p class="chat-box--message-text base--p"></p>
										</div>
									</div>
								</div>
							</div>
							<div class="chat-box--item_YOU chat-box--item chat-box--item_HIDDEN">
								<div class="chat-box--container">
									<div class="chat-box--message">
										<div class="chat-box--message-vertical">
											<p class="chat-box--message-text base--p"></p>
										</div>
									</div>
									<div class="img-container chat-box--avatar chat-box--avatar_YOU">
										<img src="images/icons/avatar-me.svg" class="chat-box--avatar-img" />
									</div>
								</div>
							</div>
							<!-- adding extra space hack -->
							<div class="loader">
								<div class="loader--fallback"><img src="images/watson.gif" width="50" alt=""></div>
							</div>
						</div>
					</div>
	
					<input type="text" placeholder="Type a response and hit enter" value="" autocomplete="off" class="chat-window--message-input base--text-input ui-input-message" />
					<input type="button" value="Speak" class="base--button ui-button-microphone" />
				</div>
			</div>

			<div class="_content--data">
				<div class="tab-panels" role="tabpanel">
					<ul class="tab-panels--tab-list" role="tablist">
						<li class="tab-panels--tab-list-item base-li" role="presentation">
							<a class="tab-panels--tab base--a active" href="#control-panel" aria-controls="control" role="tab">Manufacture</a>
						</li>
						<li class="tab-panels--tab-list-item base-li" role="presentation">
							<a class="tab-panels--tab base--a" href="#vr-panel" aria-controls="json" role="tab" class="">Verification</a>
						</li>
						<li class="tab-panels--tab-list-item base-li" role="presentation">
							<a class="tab-panels--tab base--a" href="#json-panel" aria-controls="vr" role="tab">JSON</a>
						</li>
					</ul>
					<div class="tab-panels--tab-content">
						<div id="json-panel" class="tab-panels--tab-pane" role="tab-panel">
							<textarea class="base--textarea"></textarea>
						</div>
						<div id="control-panel" class="tab-panels--tab-pane active" role="tab-panel">
							<form class="icecream-controller">
								<h2>Watson Ice Cream Manufacture</h2>

								<div class="form-ice-cream">
									<div class="form-item form-item-inline">
										<label>Qty:</label>
										<div>
											<input type="number" name="qty" placeholder="Qty" value="1" min="1" max="999" class="input input-qty" />
										</div>
									</div>
									
									<div class="form-item">
										<label>Flavour:</label>
										<div>
											<select name="flavour" class="input input-flavour">
												<option>Loading...</option>
											</select>
										</div>
									</div>

									<div class="form-item">
										<label class="note">Shipping address: </label>
										<div>
											<input type="text" name="address" placeholder="Shipping address" required="required" class="input input-shipping-address" />
										</div>
									</div>

									<div class="form-item">
										<label class="note">Consignee: </label>
										<div>
											<input type="text" name="consignee" placeholder="Consignee" required="required" class="input input-consignee" />
										</div>
									</div>

									<div class="form-item">
										<div class="input input-price">
											<label>Price: </label>
											<span class="price-number">1.00</span>
											<span class="price-unit">$</span>
										</div>
									</div>
	
									<div class="form-item">
										<input type="button" value="" class="input button-submit button-start" />
									</div>
								</div>

							</form>
						</div>
					
						<div id="vr-panel" class="tab-panels--tab-pane" role="tab-panel">
							<form class="vr-controller" enctype="multipart/form-data">
								<h2>Verify your cooler box after delivery</h2>

								<div>
									<label>Blockchain service URL:</label>
									<div class="ui-app-link">
										<a href="<%=com.ats.util.Configuration.getInstance().getAppURL() %>" target="webchatbot"><%=com.ats.util.Configuration.getInstance().getAppURL() %></a>
									</div>
								</div>
								<div class="form-ice-cream">
									<div class="form-item">
										<label class="note">Take a photo of the cooler box then upload it after delivery: </label>
										<div>
											<input type="file" name="file" class="input input-file" />
										</div>
										<div><progress></progress></div>
									</div>
									<div class="form-item">
										<div class="verify-result">
											<span class="ui-message-succeed hidden">
												Congratulations, the ice cream is delivered successfully. 
												<br /> 
												<span class="score"></span>
												<br /> 
												<span class="class"></span>
											</span>
											<span class="ui-message-failure hidden">This is highly possible that this photo is not cooler box.</span>
											<span class="ui-message-loading hidden">Loading...</span>
										</div>
									</div>
									<div class="form-item">
										<input type="button" value="Verify the cooler box" class="input button-submit button-verify" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			
			</div>

			<div class="ui-transcription"></div>
		</article>

	</div>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/watson-speech.js"></script>
  	<script src="js/talk-to-watson.js"></script>
</body>
</html>
