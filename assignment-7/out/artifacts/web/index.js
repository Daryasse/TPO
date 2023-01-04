function callback(responseText){
    $("#date").html(responseText.currentTime);
}
function ajax(){
    $.post("date",callback, "json");
}

$(document).ready(function() {
    $("input").blur(function() {
        $form = $('#f1');
        $.get($form.attr('action'), $form.serialize(), function(responseText) {
            $('#result').text(responseText);
        });
        return false;
    });
});
setInterval(ajax,1000);
