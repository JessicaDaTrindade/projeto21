<%@page import="br.com.site.dao.UserLoginDAO"%>
<%@page import="br.com.site.bean.UserLoginBEAN"%>
<% 

//Obter o email e a senha
String usuario = request.getParameter("usuario");
String senha = request.getParameter("senha");

//Obter dados do usuário
UserLoginBEAN user= new UserLoginBEAN();

user = new UserLoginDAO().login(usuario, senha);

//Redirecionamento
if(user.getCargo() == 0){
	response.sendRedirect("../login.jsp?msg=falha");
}else{
	session.setAttribute("user", user);
	response.sendRedirect("../index.jsp");
}

 %>