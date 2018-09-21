<%@page import="br.com.site.bean.UserLoginBEAN"%>
<%
	//Verificar se há sessão
	UserLoginBEAN user = new UserLoginBEAN();
	try{
		
		user = (UserLoginBEAN) session.getAttribute("user");
		if(user.getUsuario() == null){
			response.sendRedirect("index.jsp");
		}
		
	}catch(Exception erro){
		user = new UserLoginBEAN();
		response.sendRedirect("login.jsp");
	}
%>