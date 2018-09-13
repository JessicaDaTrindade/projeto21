function enviardados(){
	
	if(document.formMateria.txtNomeMateria.value==""){
		
		
		document.getElementById("txtNomeMateria").style.border = "1px solid red";
		document.getElementById("lblNomeMateria").style.display = "inline";
		//alert("teste");
		return false;
		
	}
	
	return true;
	
	
}