let $component1 = $("#component1");
let $component2 = $("#component2");


function callback(response) {
    $("#regex").text(response.regex);
}

function ajax_post() {
    let regexValue = $component1.val();
    let textValue = $component2.val();
    if (regexValue.length > 0) {
        $component2.prop("disabled", false)

        $.post(
            "regex",
            {
                component1: regexValue,
                component2: textValue,
            },
            callback,
            "json");

    } else {
        $component2.prop('disabled', true);
    }
}

function ajax_get() {
    let regexValue = $component1.val();
    let textValue = $component2.val();
    $.get(
        "regex",
        {
            component1: regexValue,
            component2: textValue,
        },
        callback,
        "json");
}
$component1.focusout(ajax_post);
$component2.focusout(ajax_get);