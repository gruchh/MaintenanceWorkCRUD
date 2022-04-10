$(document).ready(function () {

    changeForm();

    $('#selection').change(changeForm);

    function changeForm() {

        var url = "";
        if ($('#selection').val() === "Content 1") {
            url = "/addNewEmployee";
        } else if ($('#selection').val() === "Content 2") {
            url = "/forms/RemoveEmployee";
        }

        $('#replace_div').load(url);
    }
})
