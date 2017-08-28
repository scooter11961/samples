wapqa
{
	betweenRefresh:10000,
	mapPage:{
		load:'interstitial',
		interstitial:{
			type:'tomtomInterstitial',
			order:0,
			shouldShow:function(){
				if(!this.isDeviceCompatible()){ return false; }
				if(mqm.Util.isInterstitialShowing){ return true; }
				var cookie=mqm.Util.getCookie('mqm_'+this.type),
					o=parseInt(cookie);
				if(isNaN(o)){
					return true;
				}else{
					return o<this.order?true:false;
				}
			},
			isDeviceCompatible: function() {
				var ua=navigator.userAgent.toLowerCase(),
					matches = ua.match(/os [0-9]_[0-9]/),
					sub, maj, min;
				if (mqm.Util.isSendToMobile()) return false;
				if(ua.indexOf('android') > -1) {
					return true;
				} else if(ua.indexOf('iphone')>-1 || ua.indexOf('ipad')>-1 || ua.indexOf('ipod')>-1){
					if(matches.length > 0) {
						var prefix = 'ox ';
						sub = matches[0];
						maj = sub.substring(sub.indexOf(prefix) + prefix.length, sub.indexOf('_'));
						min = sub.substring(sub.indexOf('_') + 1);
						if(maj > 4) {
							return true;
						} else if(maj == 4 && min >= 3) {
							return true;
						}
					}
				}
				return false;
			},
			show:function(mqad,config,create){
				$.modal.close();
				var deviceType =(mqm.Util.isIOS() ? "iphone": "android"),
					w=$(window),
					ww=w[0].innerWidth ? w[0].innerWidth : w.width(),
					wh=w[0].innerHeight ? w[0].innerHeight : w.height(),
					closeClick = function(){
						$.modal.close();
						mqm.Util.isInterstitialShowing = false;
						$('#interstitalClose').unbind();
						$('#interstitalCloseText').unbind();
						$('#downloadButton').unbind();
						return false;
					},
					downloadClick = function(){
						mqm.omniture("tomtom.download"+ deviceType);
						$.modal.close();
						mqm.Util.isInterstitialShowing = false;
						if (mqm.Util.isIOS()){
							window.open("http://itunes.apple.com/us/app/mapquest-4-mobile/id316126557","ICE");
						}else {
							window.location="market://details?id=com.mapquest.android.ace";
						}
					};
					mqm.omniture("tomtom.InterstitialShow");

				$.modal($('<div class="color:#434343;font-size:0.8em"/>').append(""+
					"<div style='float:right; padding-bottom:5px;'>\
						<div id='interstitalClose' class='intersitialClose interstitial-sprite'></div>\
					</div>\
					<div style='float:left; margin-right: -7px;'>\
						<div class='"+ deviceType+"InterstitialTop interstitial-sprite'></div> \
						<div class='"+ deviceType+"Download interstitial-sprite' id='downloadButton' style='cursor: pointer;'></div>\
						<div id='interstitalCloseText' style='color:#009ade; padding:15px 15px 0;text-align: center;cursor: pointer;'>Continue to MapQuest.com</div>\
					</div>\
					</div>\
					<div class='clearb'></div>"),
					{
						overlayClose:true,
						autoResize:true,
						minHeight:wh-50,
						minWidth:ww-50,
						maxHeight:wh,
						maxWidth:ww,
						onClose: closeClick
					}
				);
				$('#interstitalClose').bind('tap click',closeClick );
				$('#interstitalCloseText').bind('tap click', closeClick);
				$('#downloadButton').bind('tap click', downloadClick);
				$('.simplemodal-container').css({
        			'border-color': '#744D71',
        			'border-width': '5px',
        			'-moz-border-radius': '0em',
       				'-webkit-border-radius': '0em',
        			'border-radius': '0em',
        			'background-color': 'white',
					'left':'8px',
				});

				if (mqm.Util.isTablet() || (deviceType && deviceType!='iphone') ){
					$('.simplemodal-container').css({
						'width':'auto',
						'height':'auto',
						'left':'5%',
					});
				}
				$('#simplemodal-container a.modalCloseImg').hide();

				mqm.Util.setCookie('mqm_'+this.type,this.order);
			}
		},
		underSearchBar:{
			type:'madmen',
			location:'underSearchBar',
			counter:0,
			request:{
				appid:'10000597',
				pageurl:escape(document.location),
				geo:true,
				hw:'web',
				format:'html',
				height:'50',
				width:'320',
				ip:true,
				uuid:true,
				cat:true
			},
			dataType:'html',
			display:{
				hide:10000,
				style:{
					'background-color':'black',
					'width': '100%',
					'height':'60px'
				}
			},
			shouldShow:function(){
			  /*  if (mqm.Util.isSendToMobile()) return false;
				  if($('.mqad.bannerlocator').length > 0) return false;
				  return true; */
                                return false;
			},
			show:function(mqad,config,create,animateLater){
				/* config.utils.showUnderSearchBar(mqad,create, animateLater); */
			},
			hide:function(mqad,config){
		 		config.utils.hideUnderSearchBar(mqad);
			},
			click:function(mqad,config) {
				var searchTerm,
					href = $('.madmen a')[0].href;

				console.log('Ad click function clicked: ' + href);
				searchTerm = config.utils.parseSearchTerm(href, 'SearchTerm');
				console.log('Search term: ' + searchTerm);

				if(!this.activated) {
					mqm.adController.clearTimer('underSearchBar');
					mqm.mapController.carouselManager.activateBannerLocator(searchTerm);
					this.activated = true;

					$(mqad).append('<div id="bannerLocatorClose" class="sprite dismiss"></div>');
					$('#bannerLocatorClose').click(function() {
						mqm.mapController.carouselManager.deactivateBannerLocator(searchTerm);
						this.activated = false;
						config.utils.hideUnderSearchBar(mqad);
					});
				}
				return false;
			}
		},
		campaignUnderSearchBar :{
			type:'campaign',
			location:'underSearchBar',
			counter:0,
			request:{
				callUrl:'fromCampaign'
			},
			dataType:'html',
			display:{
				hide:10000,
				style:{
					'background-color':'black',
					'width': '100%',
					'height':'60px'
				}
			},
			shouldShow:function(){if (mqm.Util.isSendToMobile()) return false;
				if($('.mqad.campaign').length > 0) return false;
				return true; /* check if campaign exists*/
			},
			show:function(mqad,config,create,animateLater){
				config.utils.showUnderSearchBar(mqad,create, animateLater);
			},
			hide:function(mqad,config){
		 		config.utils.hideUnderSearchBar(mqad);
			}
		}
	},
	mapSearchResults:{
		load:'carouselRestaurants',
		underSearchBar:{
			type:'citygrid_internal',
			location:'underSearchBar',
			dismissable:true,
			dismissed: false,
			display:{
				style:{
					'background-color':'black',
					'width': '100%',
					'height':'60px',
					'zIndex':1
				}
			},
			shouldShow:function(){
				return !($('.mqad.bannerlocator').length > 0);
			},
			show:function(mqad,config,create){
				if(SearchService.lastSearch && this.dismissed == SearchService.lastSearch.query) return;

				var loc=config.utils.lookupCityGrid(),
					ex=$('.underSearchBar'),
					poi=null;

				if(loc){
					poi=mqm.Util.findPoi(loc);
				}
				if (loc && poi){
					var ll=poi.getLatLng(),
						type=loc.isSearchResult ? 'result' : 'location',
						halo=new MQA.Poi(ll),
					  	icon=new MQA.Icon(null,40,40,"mqadPoiHalo"),
					  	adKey = loc.overlayKey.replace('_OVERLAY','').toLowerCase();

			 		mqad.addClass(adKey);
					halo.setShadow(null);
					halo.setIcon(icon);
					halo.setKey('CITYGRID_AD_HALO');

					mqm.mapController.map.getShapeCollection(poi.overlayKey).add(halo);
					halo.setIconOffset({x:-20,y:-34});
					mqad.append('<div class="mqadPoiHalo"><div class="icon '+poi.getIcon().classAttr+'"></div></div>');
					mqad.append('<div class="desc"><div class="name">'+loc.name+'</div>'+mqm.Util.formatStars(loc.rating)+'</div>');
					mqad.height(50);

					mqad.click(function(){
						poi=mqm.Util.findPoi(loc);
						$.mobile.loadingMessage=messages.loadingProgress;
						var placement = 'AdUnderSearch';
						placement += mqm.Util.getCarouselItemLabel(poi.location);
						mqm.mapController.details(type,loc, poi.getIcon(), false, placement);
					});
					config.utils.showUnderSearchBar(mqad,create);
				}else{
					config.utils.hideUnderSearchBar(ex);
				}

			},
			hide:function(mqad,config){
				this.dismissed = SearchService.lastSearch.query;
				config.utils.clearHalo();
				config.utils.hideUnderSearchBar(mqad);
			}
		},
		carouselRestaurants:{
			type:'madmen',
			backup:'underSearchBar',
			location:'underSearchBar',
			counter:0,
			request:{
				appid:'10000076',
				pageurl:escape(document.location),
				geo:true,
				hw:'web',
				format:'html',
				height:'50',
				width:'320',
				ip:true,
				uuid:true,
				cat:true
			},
			dataType:'html',
			display:{
				hide:10000,
				style:{
					'background-color':'black',
					'width': '100%',
                                        'height':'60px'
				}
			},
			shouldShow:function(){
				if($('.mqad.bannerlocator').length > 0) return false;

				var lastSearch = SearchService.lastSearch,
					categories = ['Restaurants','Coffee'],
					category;
				if(lastSearch && lastSearch.mostPopularCategory) {
					category = lastSearch.mostPopularCategory;
				}

				return ($.inArray(category, categories) > -1);

			},
			show:function(mqad,config,create){
				config.utils.showUnderSearchBar(mqad,create);
			},
			hide:function(mqad,config){
				config.utils.hideUnderSearchBar(mqad);
			}
		}

	},
	directionsFormPage:{
		load:'bottom',
		bottom:{
			type:'madmen',
			location:'directionsForm',
			request:{
				appid:"10000007",
				pageurl:escape(document.location),
				geo:true,
				hw:'web',
				format:'html',
				height:'50',
				width:'320',
				useragent:navigator.userAgent,
				ip:true,
				uuid:true,
				osver: (navigator.userAgent.indexOf('Android') > 0) ? 'android' : (mqm.Util.isIOS() ? 'ios' : ''),
				cat:true
			},
			dataType:'html',
			display:{
				style:{
					'background-color':'black',
					'position':'absolute',
					'width': '100%',
					'bottom': '0px',
				}
			},
			show:function(mqad,config,create){
				var wh=$(window).height();
				$('.mqad.directionsForm').remove();
				$('#directionsFormPage').append(mqad);

			},
			hide:function(mqad){
				mqad.slideUp();
			}
		}
	},
	  searchResultsPage:{
		load:'underHeader',
		underHeader:{
		location:'searchListHeader',
		type:'yp',
		request:{
			client:'mobile-mapquest',
			term:'query',
			searchloc:true,
			listingCount:1,
			visitorid:true,
			ip:true,
			useragent:escape(navigator.userAgent),
			ip:true,
			referrer:'internalReferer',
			format:'json',
			sort:'distance'
		/*	secondaryLocation:'searchResultsPageBottomAd',
	 	type:'google',
		request:{
			client:'mobile-mapquest',
			q:'query',
			num:'0',
			output:'xml_no_dtd',
			useragent:escape(navigator.userAgent),
			ip:true,
			channel:'directory',
			adpage:'1',
			adext:'ctc1',
			ad:'w2n0'*/
		},
		dataType:'json',
		display:{
			hide:7000,
			style:{
				'background-color':'white',
				'position':'relative'
			}
		},
		shouldShow:function(){
			/* Dont want this ad in direction-search mode */
			return !model.locations && (SearchService.lastSearch!=null);
		},
		show:function(mqad,config,create){
			var ex=$('.searchListHeader');

			if(ex){
				ex.remove();
			}
			$('#searchResultsPageWrapper').prepend(mqad);
			mqm.mapController.setupScroller('searchResultsPage');
		 	if ($('.xadPhone')) $('.xadPhone').trigger('create');
		},
		showSecond:function(mqad,config,create){
			var ex=$('.searchResultsPageBottomAd'),
				scrolldiv=$('#searchResultsPageScroller');
			if(ex){
				ex.remove();
			}
			$('#carouselResultsList').append(mqad);
			if (scrolldiv){
				scrolldiv.height(scrolldiv.height()+mqad.height());
			}
		},
		hide:function(mqad){
		}
	  }
	},
	utils:{
/*
		showUnderSearchBar:function(mqad,create){
			var ex=$('.underSearchBar'),
				hd=$('#header'),
				eggo=$('#eggo');

			if(create || (!ex || !ex.html()) ){
				mqad.hide();
				hd.append(mqad);

			    hd.stop(true,true);
                mqad.stop(true,true);

                hd.css("height", "auto");
                mqm.mapController.changeMapSize(-mqad.outerHeight(true),400);
                mqad.slideDown(400);

				if(eggo)eggo.stop(true,true).animate({top:'+='+hd.height()},1000);
			}else{
				if(ex.html().trim()==''){
					ex.html(mqad.html());
					ex.attr('class',mqad.attr('class'));
				}else{
					ex.slideUp(400);
					ex.promise().done(function(){
                          ex.remove();
                          mqad.hide();
                          hd.append(mqad);

                          hd.css("height", "auto");

                          mqm.mapController.changeMapSize(-mqad.outerHeight(true),400);
                          mqad.slideDown(400);
					  });
				}
			}
		},
		hideUnderSearchBar:function(mqad){
			mqm.adController.hideUnderSearchBar(mqad);
		},

		lookupCityGrid:function(){
			var cityGrid=[],
				last=SearchService.lastResult,
				i,
				sr,
				sources;
			if(last && last.searchResults){
				for(i=0;i<10;i++){
					sr=last.searchResults[i];
					if(sr!=null){
						sources=sr.sources;
						if(sources){
							$(sources).each(function(idx,value){
								if(value.vendorId=='999'){
									cityGrid.push(sr);
								}
							});
						}
					}
				}
			}
			return cityGrid.length>0?cityGrid[0]:null;
		},

		clearHalo: function() {
			var shapes = mqm.mapController.map.getShapeCollections(),
				poi;
			for(var i=0,ilen = shapes.length; i < ilen; i++) {
				poi = shapes[i].getByKey('CITYGRID_AD_HALO');
				if(poi) {
					shapes[i].removeItem(poi);
					break;
				}
			}
		},

		parseSearchTerm: function(url, key) {
			var ind1 = url.lastIndexOf(';SearchTerm=');
			var sub = url.substring(ind1+12);
			var ind2 = sub.lastIndexOf(';');

			var out = sub.substring(0,ind2);
			return out;
		}
*/
	}
}