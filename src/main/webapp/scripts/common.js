function getFormParams(formId){
	var queryParams = {};
	$('input,select,textarea',document.getElementById(formId)).each(function(){
		if($(this).attr('name') && (!this.disabled || this.disabled=="")) {
			if(queryParams[$(this).attr('name')]) {
				if(queryParams[$(this).attr('name')+"_length"]) {
					queryParams[$(this).attr('name')+"["+queryParams[$(this).attr('name')+"_length"]+"]"] = $(this).val();
					queryParams[$(this).attr('name')+"_length"] = new Number(queryParams[$(this).attr('name')+"_length"])+1;
				}
				else {
					var value = queryParams[$(this).attr('name')];
					queryParams[$(this).attr('name')+"[0]"] = value;
					queryParams[$(this).attr('name')+"[1]"] = $(this).val();
					queryParams[$(this).attr('name')+"_length"] = 2;
				}
			}
			else {
				queryParams[$(this).attr('name')]=$(this).val();
			}
		}
	});
	return queryParams;
}