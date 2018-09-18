function enviardados(){
	
	if(document.formMateria.txtNomeMateria.value==""){
		
		
		document.getElementById("txtNomeMateria").style.border = "1px solid red";
		document.getElementById("lblNomeMateria").style.display = "inline";
		return false;
		
	}
	
	return true; 
	
	
}