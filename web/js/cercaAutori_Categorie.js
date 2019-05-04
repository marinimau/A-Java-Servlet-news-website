/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElementCategorie(single_categoria)
{
    //<li><a href="notizie.html?categoria=${categoria.getId()}">${categoria.getNome()}</a></li>
    var li_categoria=$("<li>");
    
    //link
    var link_e_testo = $("<a>").attr("href","notizie.html?categoria="+single_categoria.idCategoria).html(single_categoria.nomeCategoria);

    //unisco
    li_categoria.append(link_e_testo);
    
    return li_categoria;
}

function createElementAutori(single_autore)
{
    var li_autore=$("<li>");
    
    //img profilo
    var img_profilo=$("<img>").attr("src",single_autore.urlImgProfilo);
    
    //link
    var link_e_testo = $("<a>").attr("href","notizie.html?autore="+single_autore.idUtente).html(single_autore.nomeUtente +" "+ single_autore.cognomeUtente);

    //unisco
    li_autore.append(img_profilo,link_e_testo);
    
    return li_autore;
}


function stateSuccess(data,state){
    var categorie_div = $("#listaCategorie");
    var autori_div=$("#listaAutori");
    
    $(categorie_div).empty();
    $(autori_div).empty();
    
    if(data.categorie<=0){
        $(categorie_div).append(createMessage()); 
    }
    for(var instance in data.categorie){
        $(categorie_div).append(createElementCategorie(data.categorie[instance]));
    }
    
    
    if(data.autori<=0){
        $(autori_div).append(createMessage()); 
    }
    for(var instance in data.autori){
        $(autori_div).append(createElementAutori(data.autori[instance]));
    }
}

function createMessage(){
    var messaggio=$("<p>").html("Nessuna corrispondenza");
    return messaggio;
}

function stateFailture(data,state){
   
}


 $(document).ready(function () {
    $("#cerca").click(function (event) {
        //alert("Hai cliccato sulla search");
    });
    $("#cerca").keyup(function (){
        $.ajax({
            url: "filter.json",
            data: {
                cmd: "cerca",
                query: $("#cerca").val()
            },
            dataType: 'json',
            success: function (data, state) {stateSuccess(data,state);},
            error: function (data, state) {stateFailture(data,state);} 
        });
        
        
    });
    
});


