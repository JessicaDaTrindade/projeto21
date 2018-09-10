$(function () {
    $("#pesquisarAluno").keyup(function () {
        var index = $(this).parent().index();
        var nth = "#tabela td:nth-child(2)";
        var valor = $(this).val().toUpperCase();
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
