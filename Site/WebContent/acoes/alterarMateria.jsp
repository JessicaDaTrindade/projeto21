<%@page import="javax.security.auth.callback.ConfirmationCallback"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.site.dao.MateriaDao"%>
<%@page import="br.com.site.bean.MateriaBean"%>


<%

//Obter dados matéria
String nome = request.getParameter("nomeMateria");

//Criar obketo matéria
MateriaBean obj = new MateriaBean();
obj.setNomeMateria(nome);

//Executar comando DAO
new MateriaDao().cadastrarMateria(obj);

//Redirecionamento
response.sendRedirect("../materias.jsp");
%>
