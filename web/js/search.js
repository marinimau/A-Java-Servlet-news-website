/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(single_news)
{
    //box_principale
    var box_notizia=$("<div>").addClass("news-box");
    
    //box titolo
    var box_titolo = $("<div>").addClass("box-titolo").css("background-color",single_news.colore);
    var titolo = $("<h1>").html("["+single_news.categoria+"] "+single_news.titolo);
    box_titolo.append(titolo);
    
    //box contenuto
    var box_contenuto =$("<div>").addClass("box-contenuto");
    //box-sinistra
    var box_immagine =$("<div>").addClass("box-immagine");
    //immagine
    var immagine_link =$("<a>").attr("href","notizia.html?id="+single_news.id);
    var img=$("<img>").attr("src",single_news.urlImg);
    //unisco box-immagine
    immagine_link.append(img);
    box_immagine.append(immagine_link);
    //destra
    var box_data=$("<div>").addClass("box-data");
    var intestazione= $("<h4>").html("["+single_news.autore+"] "+single_news.dataScrittura);
    var contenuto = $("<p>").html(single_news.corpo+" [...]");
    //bottone
    var p_bottone=$("<p>");
    var bottone=$("<a>").addClass("art_btn").attr("href","notizia.html?id="+single_news.id).css("background-color",single_news.colore).html("Leggi di più");
    //unisco il bottone
    p_bottone.append(bottone);
    
    //unisco il box di destra
    box_data.append(intestazione, contenuto, p_bottone);
    
    //unisco i due box
    box_contenuto.append(box_immagine, box_data);
    
    //e li collego al box_titolo completando il box
    box_notizia.append(box_titolo,box_contenuto);
    
    return box_notizia;
}


function showNews(notizie){
    var notizie_div = $("#box-notizie");
    
    $(notizie_div).empty();
    for(var instance in notizie){
        $(notizie_div).append(createElement(notizie[instance]));
    }
}

$(document).ready(function () {
    $("#cerca").click(function () {
        //
        //alert("Hai cliccato sulla search");
    });
    $("#cerca").keyup(function (){
        $.ajax({
            url: "searchAjax",
            data: {
                cmd: "cerca",
                query: $("#cerca").val()
            },
            dataType: 'json',
            success: function (data, state) {
                showNews(data);
            },
            error: function (data, state) {
            } });
        
        /*var query =  $("#cerca").val();
        console.log(query);*/
    });
    
});