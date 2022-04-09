$(document).ready(function () {

    changeForm();

    $('#selection').change(changeForm);

    function changeForm() {

        var url = "/forms/";
        if ($('#selection').val() === "Content 1") {
            url = "AddEmployee";
        } else if ($('#selection').val() === "Content 2") {
            url = "RemoveEmployee";
        }

        $('#replace_div').load(url);
    }
})
