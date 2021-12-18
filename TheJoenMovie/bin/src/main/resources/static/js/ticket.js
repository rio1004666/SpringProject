

$(function(){
	
	var select_cinema = $('select[name=cinema-cate]');
				
	var select_movie = $('select[name=movie-cate]');
	
	var select_date = $('select[name=date-cate]');
	
	$.get('/getCinemaCate',function(data){
		$.each(data, function(i,vo){
			select_cinema.append("<option value='"+vo.cinema_name+"'>"+vo.cinema_name+"</option>");
			
		});
	});
	select_cinema.change(function(){
		var cinema_name = $(this).val();
		
		$('.cinema-value').text(cinema_name);
		$('.movie-value').text('영화를 선택해주세요.');
		$('.date-value').text('날짜와시간을 선택해주세요.');
		var jsonData = {"cinema_name" : cinema_name};
		$.get("/getMovieCate",jsonData,function(data){
			select_movie.empty();
			select_date.empty();
			select_movie.append("<option value='0'> 영화 선택 </option>");
			select_date.append("<option value='0'> 날짜&시간 선택 </option>");
			
			$.each(data, function(i,vo){
				select_movie.append("<option value='"+vo.title+"'>"+vo.title+"</option>");
			});
		});
	});
	select_movie.change(function(){
		var title = $(this).val();
		$('.movie-value').text(title);
		$('.date-value').text('날짜와시간을 선택해주세요.');
		var jsonData = {"title" : title};
		$.get("/getTimeCate",jsonData,function(data){
			
			select_date.empty();
			select_date.append("<option value='0'> 날짜&시간 선택 </option>");
			
			$.each(data, function(i,vo){
				var temp = vo.date+' ' + vo.time_start+' ' + vo.time_end;
				select_date.append("<option value='"+temp+"'>"+ vo.date +
						
						" " + vo.time_start + "~" + vo.time_end + "</option>");
			});
			
		});
	});
	select_date.change(function(){
		var date = $(this).val();
		$('.date-value').text(date);
	});
	
	// 2. 해당 name과 동일한 체크박스 중 선택한 것들만 루프 > 해당 value 값 콘솔
	  $('input[type="checkbox"]:checked').each(function() {
	    var tmpVal = $(this).val();
	    console.log(tmpVal);
	  });
	
	$('.btn-danger').click(function(){
		var isCinemaOk = true;
	    var isMovieOk = true;
	    var isDateOk = true;
	    var isSeatsOk = true;
	    var isPriceOk = true;
		var movie_cinema = $('.cinema-value').text();
		if(movie_cinema === '영화관을 선택해주세요.'){
			isCinemaOk = false;
		}
		var movie_title = $('.movie-value').text();
		if(movie_title === '영화를 선택해주세요.'){
			isMovieOk = false;
			
		}
		var movie_date = $('.date-value').text();
		if(movie_date === '날짜와시간을 선택해주세요.'){
			isDateOk = false;
		}
		var movie_seats = $('.seat-value').text();
		if(movie_seats === '좌석을 선택해주세요.'){
			isSeatsOk = false;
		}
		var movie_price = $('.price-value').text().replace(/(,|원)/g, '');
		if(movie_price === '0'){
			isPriceOk = false;
		}
		if((isCinemaOk && isMovieOk && isDateOk && isSeatsOk && isPriceOk) == false){
			alert('티켓정보를 모두 입력하셔야 예매가 가능합니다.');
			return false;
		}
		var jsonData = {
				"movie_cinema": movie_cinema,
				"movie_title": movie_title,
				"movie_date": movie_date,
				"movie_seats": movie_seats,
				"movie_price": movie_price	
		};
		$.ajax({
			url: '/bookTicket',
			type: 'post',
			data: jsonData,
			success: function(data){
				alert('예매가 완료되었습니다!');
				location.href='/index';
			}
		});
	});
});
function getValue(){
	// 선택된 목록 가져오기 
	const query = 'input[name="checkSeat"]:checked';
	const selectedEls = document.querySelectorAll(query);
	let result = '';
	let cnt = 0;
	selectedEls.forEach((el)=>{
		result += el.value + ' ';
		cnt += 1;
	});
	if(cnt ==  0){
		document.getElementById('final-seat').innerText = '좌석을 선택해주세요.';
		document.getElementById('final-price').innerText = 0 + '원';
	}else{
		document.getElementById('final-seat').innerText = result;
		document.getElementById('final-price').innerText = cnt * 12000 + '원';
	}
	
}