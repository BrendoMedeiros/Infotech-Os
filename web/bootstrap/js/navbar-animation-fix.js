var t = true;
$('#collapse-navbar').on('click',function(){
	if(t){
		$(".topCasaFina-banner").css("transform","translate(-50%,10%)");
		t=false;
	}else{
		$(".topCasaFina-banner").css("transform","translate(-50%,-50%)");
		t=true;
	}
});