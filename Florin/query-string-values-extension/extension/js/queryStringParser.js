function QueryStringParser(){
	this.regExPlusSymbol = /\+/g;
	this.regExQuerySearch = /([^&=]+)=?([^&]*)/g;

  function isBase64(str){
    //regex from http://stackoverflow.com/questions/475074/regex-to-parse-or-validate-base64-data
    var base64Regex = /^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$/;
    return base64Regex.test(str);
  }

	this.getValues = function(url){
		var query = this.getQueryFromUrl(url);
		var values = [];
		var match;
		while (!!(match = this.regExQuerySearch.exec(query))){
      var key = this.decode(match[1]);
      var val = this.decode(match[2]);

      if(key === 'locations' && isBase64(val)){
        val = atob(val);
      }

      var kv = {};
      kv[key] = val;
      values.push(kv);
		}
		return values;
	};

	this.decode = function(value){
		return decodeURIComponent(value.replace(this.regExPlusSymbol, " "));
	};

	this.getQueryFromUrl = function(url){
		var queryIndex = url.indexOf("?");
		if(queryIndex >= 0 && (queryIndex+1) < url.length)
		{
			return url.substring(queryIndex+1);
		}
		return "";
	};
}