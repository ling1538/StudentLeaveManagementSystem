var temp=1;
function hidetext(){  
	  var mychar = document.getElementById("exq");
      if(temp%2==0){ //本来是显示的，再点那就隐藏咯
           mychar.style.display="none";
      }else{
           mychar.style.display="block";
      }
      temp++;
}


function loginOut() {
           if(confirm("你确定要退出登陆吗？")){
           window.location=("servlet/ExitServlet"); 
           }
        }


