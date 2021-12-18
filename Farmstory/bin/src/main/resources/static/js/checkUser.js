/**
 *  회원가입 사용자 중복 체크 
 */


// 정규표현식(Regular Expression)
var reUid  = /^[a-z]+[a-z0-9]{3,10}$/;
var rePass = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,}$/;
var reName = /^[가-힣]{2,10}$/;
var reNick = /^[a-z가-힣0-9]{2,10}$/;


// 최종 유효성 검사에 사용될 상태변수
var isUidOk  = false;
var isPassOk = false;
var isNameOk = false;
var isNickOk = false;


$(document).ready(function(){
    		
	// 아이디 중복 체크 
	$('input[name=uid]').focusout(function(){
		
		var uid = $(this).val();
		/*포커스가 빠졋을때 제대로 작동하는지를 확인
		alert(uid);*/
		var jsonData = {'uid':uid};
		 /*$.get('member/checkUid', jsonData, function(data){});
		-> 밑의 $.ajax방식과 동일한 방식이다 다만 type이 get방식일때 사용한다
		type이 post일땐 $.post()를 사용한다
		-> /member/checkUid?uid=abcd 의 형식으로 전달이 될것이다.*/
		
		$.get('/member/checkUid', jsonData, function(data){
			
	 			if(data.reult == 1){
					$('.resultId').css('color', 'red').text('이미 사용중인 아이디 입니다.');
					isUidOk = false;
				}else{
					//아이디 유효성 검사
					if(reUid.test(uid)){
						$('.resultId').css('color','green').text('사용 가능한 아이디 입니다.');
						isUidOk = true;
					}else{
						$('.resultId').css('color','red').text('아이디는 영문 소문자, 숫자 조합 4~10자 까지 입니다.');
					}
				}
			},'json');/*-> return 되는 형식을 지정해주기위하여 json을 사용해주엇다 */ 	
		});
	
	// 비밀번호 유효성 검사
	$('input[name=pass2]').focusout(function(){
		
		var pass1 = $('input[name=pass1]').val();
		var pass2 = $('input[name=pass2]').val();
		
		if(pass1 == pass2){
			
			if(rePass.test(pass2)){
				$('.resultPass').css('color', 'green').text('비밀번호가 일치 합니다.');
				isPassOk = true;
			}else{				
				$('.resultPass').css('color', 'red').text('비밀번호는 영문,숫자 조합 최소 4이상 이어야 합니다.');
				isPassOk = false;
			}
			
		}else{
			$('.resultPass').css('color', 'red').text('비밀번호가 일치 하지 않습니다.');
			isPassOk = false;
		}
		
	});
	
	// 이름 유효성 검사
	$('input[name=name]').focusout(function(){
		
		var name = $(this).val();
		 var jsonData = {'name':name};

		if(reName.test(name)){
			isNameOk = true;
		}else{
			$('.resultName').css('color', 'red').text('이름이 유효하지 않습니다.');
			isNameOk = false;
		}	
	});
	
	// 닉네임 중복 체크
	$('input[name=nick]').focusout(function(){
		
		var nick = $(this).val();
		var jsonData = {'name':name};
		
		$.get('/member/checkNick', jsonData, function(data){
			
			if(data.result == 1){
				$('.resultNick').css('color', 'red').text('이미 사용중인 닉네임 입니다.');
				isNickOk = false;
			}else{
				if(reNick.test(nick)){
					$('.resultNick').css('color','green').text('사용 가능한 닉네임 입니다.');
					isNickOk = true;
				}else{
					$('.resultNick').css('color', 'red').text('닉네임은 영문, 한글, 숫자포함 2~10자 입니다.');
					isNickOk = false;
				}
			}
		},'json');
	});
	
	// 이메일 중복 체크
	$('input[name=email]').focusout(function(){
		
		var email = $(this).val();
		var jsonData = {'email':email};

		$.get('/member/checkEmail', jsonData, function(data){
			
			if(data.result == 1){                      
               $('.resultEmail').css('color', 'red').text('이미 사용중인 이메일 입니다.');
               isEmailOk = false;
	            }else if( email==''){
	               $('.resultEmail').css('color', 'red').text('이메일을 입력하세요.');
	               isEmailOk = false;
	            }else if(data.result==0){
	                if(reEmail.test(email)){
	                  $('.resultEmail').css('color','green').text('사용 가능한 이메일 입니다.');
	                  isEmailOk = true;
	               }else{//유효성검사하기
	               $('.resultEmail').css('color', 'red').text('이메일 양식에 맞지 않습니다.');
	               isEmailOk = false;
	               }
	            }               
      },'json');
   });
	// 휴대폰 중복 체크
		$('input[name=hp]').focusout(function(){
			
			var hp = $(this).val();
			
			$.get('/member/checkHp', jsonData, function(data){
				
				if(data.result == 1){                      
               $('.resultHp').css('color', 'red').text('이미 사용중인 휴대폰번호 입니다.');
	            }else if(hp==''){
	               $('.resultHp').css('color', 'red').text('휴대폰 번호를 입력하세요.');
	            }else if(data.result==0){
	               $('.resultHp').css('color', 'green').text('사용 가능한 휴대폰번호 입니다.');
	            }
	            
         	}, 'json');                

     });
});   