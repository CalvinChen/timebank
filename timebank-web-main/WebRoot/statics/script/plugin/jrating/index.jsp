
<html>
<head>
	<link rel="stylesheet" href="jquery/jRating.jquery.css" type="text/css" />
</head>
<body>
1111111111111111111
<div class="exemple">
	<div class="basic" data="12_1"></div>
</div>
<div class="exemple">
	<div class="exemple2" data="10_2"></div>
</div>
<div class="exemple">
	<div class="exemple3" data="18_3"></div>
</div>
<div class="exemple">
	<div class="exemple4" data="10_4"></div>
</div>
<div class="exemple">
	<div class="exemple5" data="10_5"></div>
</div>
<div class="exemple">
	<div class="exemple6" data="10_5"></div>
</div>


	<script type="text/javascript" src="jquery/jquery.js"></script>
	<script type="text/javascript" src="jquery/jRating.jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.basic').jRating();
			
			$('.exemple2').jRating({
				type:'small',
				length : 40,
				decimalLength : 1
			});
			
			$('.exemple3').jRating({
				step:true,
				length : 20
			});
			
			$('.exemple4').jRating({
				isDisabled : true
			});
			
			$('.exemple5').jRating({
				length:10,
				decimalLength:1,
				onSuccess : function(){
					alert('Success : your rate has been saved :)');
				},
				onError : function(){
					alert('Error : please retry');
				}
			});
			
			$(".exemple6").jRating({
			  length:10,
			  decimalLength:1,
			  showRateInfo:false
			});
		});
	</script>
</body>
</html>
