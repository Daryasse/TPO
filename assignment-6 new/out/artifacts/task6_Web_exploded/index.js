let $component1 = $("#component1");
let $component2 = $("#component2");

function callback(response) {
    $("#regex").text(response.regex);
}

function ajax_post() {
    let aregex = $component1.val();
    let atext = $component2.val();
    if (aregex.length > 0) {
        $component2.prop("disabled", false)
        $.post(
            "regex",
            {
                component1: aregex,
                component2: atext,
            },
            callback,
            "json");
    } else {
        $component2.prop('disabled', true);
    }
}

function ajax_get() {
    let aregex = $component1.val();
    let atext = $component2.val();
    $.get(
        "regex",
        {
            component1: aregex,
            component2: atext,
        },
        callback,
        "json");
}
$component1.focusout(ajax_post);
$component2.focusout(ajax_get);