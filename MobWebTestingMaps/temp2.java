wapstg
{
    betweenRefresh:10000,
    mapPage:{
        load:'underSearchBar',
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
if (deviceType && deviceType!='iphone'){
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
request:{
appid:'10000173',
pageurl:escape(document.location),
useragent:navigator.userAgent,
geo:true,
hw:'web',
format:'html',
uuid:true,
height:'50',
width:'320',
osver: (navigator.userAgent.indexOf('Android') > 0) ? 'android' : (mqm.Util.isIOS() ? 'ios' : ''),
mq_cb:new Date().getTime()
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
if (mqm.Util.isSendToMobile()) return false;
return true;
},
show:function(mqad,config,create){
if(config && config.mapPage && config.mapPage.underSearchBar && config.mapPage.underSearchBar.request){
config.mapPage.underSearchBar.request.mq_cb=new Date().getTime();
}
config.utils.showUnderSearchBar(mqad,create);
},
hide:function(mqad,config){
config.utils.hideUnderSearchBar(mqad);
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
show:function(mqad,config,create){
if(SearchService.lastSearch && this.dismissed == SearchService.lastSearch.query) return;

var loc=config.utils.lookupCityGrid(),
ex=$('.underSearchBar');

if(loc){
var poi=mqm.Util.findPoi(loc),
ll=poi.getLatLng(),
type=loc.isSearchResult ? 'result' : 'location',
halo=new MQA.Poi(ll),
icon=new MQA.Icon(null,40,40,"mqadPoiHalo");

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
mqm.mapController.details(type,loc, poi.getIcon(), false, 'AdUnderSearch');
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
appid:'10000189',
pageurl:escape(document.location),
useragent:navigator.userAgent,
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
},
carouselGasStations:{
type:'madmen',
backup:'underSearchBar',
location:'underSearchBar',
counter:0,
request:{
appid:'10000536',
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
'position':'absolute',
'top': '44px',
'width': '100%',
'height':'60px'
}
},
shouldShow:function(){
if($('.mqad.bannerlocator').length > 0) return false;

var lastSearch = SearchService.lastSearch,
categories = ['Gas Stations'],
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
},
carouselShopping:{
type:'madmen',
backup:'underSearchBar',
location:'underSearchBar',
counter:0,
request:{
appid:'10000537',
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
'position':'absolute',
'top': '44px',
'width': '100%',
'height':'60px'
}
},
shouldShow:function(){
if($('.mqad.bannerlocator').length > 0) return false;

var lastSearch = SearchService.lastSearch,
categories = ['Shopping Centers & Malls'],
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
},
carouselGroceries:{
type:'madmen',
backup:'underSearchBar',
location:'underSearchBar',
counter:0,
request:{
appid:'10000538',
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
'position':'absolute',
'top': '44px',
'width': '100%',
'height':'60px'
}
},
shouldShow:function(){
if($('.mqad.bannerlocator').length > 0) return false;

var lastSearch = SearchService.lastSearch,
categories = ['Grocery Stores'],
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
appid:"10000174",
pageurl:escape(document.location),
useragent:navigator.userAgent,
geo:true,
hw:'web',
format:'html',
uuid:true,
cat:true,
height:'50',
width:'320',
osver: (navigator.userAgent.indexOf('Android') > 0) ? 'android' : (mqm.Util.isIOS() ? 'ios' : ''),
mq_cb:new Date().getTime()
},
dataType:'html',
display:{
style:{
'background-color':'black',
'position':'absolute',
'width': '100%',
'text-align':'center'
}
},
show:function(mqad,config,create){
if(config && config.directionsFormPage && config.directionsFormPage.bottom && config.directionsFormPage.bottom.request){
config.directionsFormPage.bottom.request.mq_cb=new Date().getTime();
}

var wh=$(window).height();
$('.mqad.directionsForm').remove();
$('#directionsFormPage').append(mqad);

},
hide:function(mqad){
mqm.mapController.hideUnderSearchBar(mqad);
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
utils:{}
}