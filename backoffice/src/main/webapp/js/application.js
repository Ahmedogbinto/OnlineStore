/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();                                // Ce qui veut dire qu'au clique sur catalogue, la page par defaut sur laquelle on devrait atterir est annulee
        console.log($('body').children().length);
        
        
        if($('body').children().length<6) {                  //  Cette condition pour verifier qu'il n'y avait pas encore de catalogue affichée en dessous. pour ne pas l'afficher deux fois.
            $.ajax({                                        // requete ajax, a la suite de cette requette Ajax on a:
                url: "rest/work",
                
                success: function(result) {
                                                           // $("a[href=catalogue]").after('<br>' +result);
                   var catalog='';                         // un tableau en JS
                   result.forEach(function(nextWork){     // forEach va iterer sur le resultat fourni par le serveur (result), donc en Javascript un tableau
                       catalog=catalog.concat(nextWork.title+" ("+nextWork.release+")<BR/>");
                   });
                   $("a[href=catalogue]").after('<BR>' +catalog);
                }
            });
        }
    });
    
});