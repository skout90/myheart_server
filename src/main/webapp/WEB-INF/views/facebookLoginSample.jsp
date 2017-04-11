<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="//connect.facebook.net/ko_KR/sdk.js"></script>
</head>
<body>
<script type="text/javascript">
//initialize and setup facebook js sdk
window.fbAsyncInit = function() {
	FB.init({
		appId : '123354464869468',
		xfbml : true,
		version : 'v2.2'
	});

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/ko_KR/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
	
$("#facebookContainer").click(function(){
    // 로그인 체크 함수.
    /* var type = $("#login_type").val();
    var url  = $("#url").val(); */

    var type = "facebook";
    var url  = "/test";

    FB.getLoginStatus(function(response) {  //facebook 로그인 상태일때 로그인창 띄우지 않고 바로 로그인 
       
       if (response.status === 'connected') { // 연결성공   
            FB.api("/v2.2/me?fields=email,name",function(me_info){ 
                facebook_check(response, type, url, me_info);
                console.log(response);
                console.log(me_info);
 
            });
        } else {
            FB.login(function(response){   // 로그인 팝업 호출
                if (response.status === 'connected') { // 연결성공
                    FB.api("/v2.2/me?fields=email,name",function(me_info) { 
                        facebook_check(response, type, url, me_info);
                    });
                }
            } , { 
                scope : 'public_profile,user_friends,email',
                return_scopes : true
            });
        }

    });
});




function facebook_check(response, type, url, me_info) { 
 
        FB.api("/v2.2/me/friends?fields=installed,name",function(friends_info) { 
            var friends_id = [];
            var lens  = friends_info.data.length;
            for(var i=0; i < lens; i++ ){
                friends_id.push(friends_info.data[i].id);
            }
            $.ajax({
                type:"POST",
                url: "/user/facebook_login_check",
                dataType: "json",
                data:{
                    "uid" : response.authResponse.userID,
                    "accessToken" : response.authResponse.accessToken,
                    "friends_info" : $.param({ friends_id: friends_id }, true),
                    "me_email"  : me_info.email,
                    "me_name"   : me_info.name,
                    "type"   : type,
                    "url"   : url
                },
                success:function(data) {
                    if(data.msg) {  // 오류메시지가 있다면 출력후 링크이동 
                        alert(data.msg);
                        location.href = data.url;
                    } else {
                        if(data.systemCode == 4420) { // 회원가입시 
                            sendPost2(CONTEXT_PATH+"/facebook/facebook_add_info",{
                            uid:data.uid,
                            accessToken:data.accessToken,
                            friends_info:data.friends_info,
                            me_name:data.me_name,
                            me_email:data.me_email });
                        } else {
                             location.href = data.url;
                        }
                    }
                    
                 } 

            });
            
        });
     
	}

</script>
<button id="facebookContainer">facebookTest</button>

</body>
</html>