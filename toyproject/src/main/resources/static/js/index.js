
		function adjustHeightOfPage(pageNo) {

			var offset = 80;
			var pageContentHeight = 0;

			var pageType = $('div[data-page-no="' + pageNo + '"]').data(
					"page-type");

			if (pageType != undefined && pageType == "gallery") {
				pageContentHeight = $(
						".cd-hero-slider li:nth-of-type(" + pageNo
								+ ") .tm-img-gallery-container").height();
			} else {
				pageContentHeight = $(
						".cd-hero-slider li:nth-of-type(" + pageNo
								+ ") .js-tm-page-content").height() + 20;
			}

			if ($(window).width() >= 992) {
				offset = 120;
			} else if ($(window).width() < 480) {
				offset = 40;
			}

			// Get the page height
			var totalPageHeight = $('.cd-slider-nav').height()
					+ pageContentHeight + offset + $('.tm-footer').height();

			// Adjust layout based on page height and window height
			if (totalPageHeight > $(window).height()) {
				$('.cd-hero-slider').addClass('small-screen');
				$('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css(
						"min-height", totalPageHeight + "px");
			} else {
				$('.cd-hero-slider').removeClass('small-screen');
				$('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css(
						"min-height", "100%");
			}
		}

		$(window)
				.load(
						function() {

							adjustHeightOfPage(1);
							/* Gallery One pop up
							-----------------------------------------*/
							$('.gallery-one').magnificPopup({
								delegate : 'a', // child items selector, by clicking on it popup will open
								type : 'image',
								gallery : {
									enabled : true
								}
							});

							/* Gallery Two pop up
							-----------------------------------------*/
							// 1번 카드뷰 디자인을 직접해서 클릭시 보이도록 수정
							// 							$('.gallery-two a').click(function() {
							// 								var img_name = $(this).attr("href");
							// 								var html = `<div class="card" style="width:500px">\
							// 									  <img class="card-img-top" src="${img_name}" alt="Card image">\
							// 									  <div class="card-img-overlay">\
							// 									    <h4 class="card-title">John Doe</h4>\
							// 									    <p class="card-text">Some example text.</p>\
							// 									    <a href="#" class="btn btn-primary">See Profile</a>\
							// 									  </div>\
							// 									</div>`;
							// 								$('body').append(html);
							// 								return false;
							// 							});
							// 2번 magnificPopup 라이브러리를 분석해서 원하는 모습으로 보이도록
							// 2-1번 이미지 + 글자 모습 지원 여부 확인 <== 지원이 된다면 가장 쉬운 방법
							// 2-2번 이미지를 만드는 자바스크립트를 코드를 찾아서 원하는 모습으로 수정
							// 							$('.gallery-two').magnificPopup({
							// 								delegate : 'a',
							// 								type : 'image',
							// 								gallery : {
							// 									enabled : true
							// 								}
							// 							});
							/* Gallery Three pop up*/
// 							$('.gallery-three').magnificPopup({
// 								delegate : 'a',
// 								type : 'image',
// 								gallery : {
// 									enabled : true
// 								}
// 							});
							/* Gallery Three pop up*/
// 							$('.gallery-three').magnificPopup({
// 								delegate : 'a',
// 								type : 'image',
// 								gallery : {
// 									enabled : true
// 								}
// 							});
							/* Gallery Three pop up*/
// 							$('.gallery-three').magnificPopup({
// 								delegate : 'a',
// 								type : 'image',
// 								gallery : {
// 									enabled : true
// 								}
// 							});
							/* Gallery Three pop up*/
// 							$('.gallery-three').magnificPopup({
// 								delegate : 'a',
// 								type : 'image',
// 								gallery : {
// 									enabled : true
// 								}
// 							});
							/* Gallery Three pop up*/
// 							$('.gallery-three').magnificPopup({
// 								delegate : 'a',
// 								type : 'image',
// 								gallery : {
// 									enabled : true
// 								}
// 							});
							
							
							/* Gallery Three pop up*/
							$('.gallery-three').magnificPopup({
								delegate : 'a',
								type : 'image',
								gallery : {
									enabled : true
								}
							});

							/* Gallery Three pop up
							-----------------------------------------*/
							$('.gallery-three').magnificPopup({
								delegate : 'a',
								type : 'image',
								gallery : {
									enabled : true
								}
							});

							/* Collapse menu after click 
							-----------------------------------------*/
							$('#tmNavbar a').click(function() {
								$('#tmNavbar').collapse('hide');

								adjustHeightOfPage($(this).data("no")); // Adjust page height       
							});
							
							/* Collapse menu after click */
							$(function() {
								$("#logout").on("click", function() {
									location.href = 'logout';
									location.href = 'loginResistForm';
									return false;
								});
							});

							/* Collapse menu after click */
							$(function() {
								$("#logout").on("click", function() {
									location.href = 'logout';
									return false;
								});
							});

							$('#two').hide();
							$('#two').show();

							/* Browser resized */
							$(window)
									.resize(
											function() {
												var currentPageNo = $(
														".cd-hero-slider li.selected .js-tm-page-content")
														.data("page-no");

												// wait 3 seconds
												setTimeout(
														function() {
															adjustHeightOfPage(currentPageNo);
														}, 1000);

											});

							// Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
							$('body').addClass('loaded');

						});

		/* Google map*/
		var map = '';
		var center;

		function initialize() {
			var mapOptions = {
				zoom : 14,
				center : new google.maps.LatLng(37.769725, -122.462154),
				scrollwheel : false
			};

			map = new google.maps.Map(document.getElementById('google-map'),
					mapOptions);

			google.maps.event.addDomListener(map, 'idle', function() {
				calculateCenter();
			});

			google.maps.event.addDomListener(window, 'resize', function() {
				map.setCenter(center);
			});
		}

		function calculateCenter() {
			center = map.getCenter();
		}

		function loadGoogleMap() {
			var script = document.createElement('script');
			script.type = 'text/javascript';
			script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&'
					+ 'callback=initialize';
			document.body.appendChild(script);
		}

		// DOM is ready
		$(function() {
			loadGoogleMap(); // Google Map
		});
		
		a();
		
		function a() {
			$.ajax({
				url: '/info.json',
				success: function(res) {
					var tag = '';
					for(var i = 0; i < res.length; i++) {
						tag += `<div class="grid-item">\
									<figure class="effect-bubba">\
										<img src="${res[i].thumbnailUrl}" alt="Image" class="img-fluid tm-img">\
										<figcaption>\
											<h3 class="tm-figure-title">\
											${res[i].id}\
												<span><strong>${res[i].title}</strong></span>\
											</h3>\
											<p class="tm-figure-description"></p>\
											<a class="btn btn-primary" data-toggle="modal" href="#modal-video"><i class="fa fa-play"></i> watch video</a>\
											<div class="modal fade" id="modal-video" style="display: none;">\
											  <div class="modal-dialog">\
											    <div class="modal-content">\
											      <div class="modal-header">\
											        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">close <i class="fa fa-times"></i></button>\
											      </div>\
											      <div class="modal-body">\
											        <iframe type="text/html" width="640" height="360" src="//www.youtube.com/embed/${res[i].videoId}" frameborder="0" allowfullscreen=""></iframe>\
											        <p>Your video</p>\
											      </div>\
											    </div>\
											  </div>\
											</div>\
										</figcaption>\
									</figure>\
								</div>`;
					}
					
					$('#three').after(tag);
				}
			});
		}
