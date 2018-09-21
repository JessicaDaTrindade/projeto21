$(function () {
    $("#pesquisarAluno").keyup(function () {
        var index = $(this).parent().index();
        var valor = $(this).val().toUpperCase();
        if(isNaN(valor)){
    	var nth = "#tabela td:nth-child(2)";
        }else{
        	var nth = "#tabela td:nth-child(1)";
        }
        $("#tabela tbody tr").show();
        $(nth).each(function () {
            if ($(this).text().toUpperCase().indexOf(valor) < 0) {
                $(this).parent().hide();
                
            }
        });
    });

    $("#pesquisarAluno").blur(function () {
        $(this).val("");
    });
});
