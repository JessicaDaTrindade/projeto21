<%@page import="javax.security.auth.callback.ConfirmationCallback"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.site.dao.MateriaDao"%>
<%@page import="br.com.site.bean.MateriaBean"%>


<%

//Objeto
MateriaBean obj = new MateriaBean();

//Obter dados
obj.setIdMateria(Integer.parseInt(request.getParameter("idMateria")));
obj.setNomeMateria(request.getParameter("nomeMateria"));


//Executar método
new MateriaDao().alterarDadosMateria(obj);

//Redirecionar
response.sendRedirect("../materias.jsp");

%>
