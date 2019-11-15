var basicURL = "http://localhost:8080/";

var userId;

function login(e) {
    console.log("Login");
    e.preventDefault();
    var login = $("#email").val();
    var password = $("#password").val();
    console.log(login + password);
    var url = basicURL + "login";
    var fd = new FormData();
    fd.append("email", login);
    fd.append("password", password);
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: fd
    })
        .done(function (response) {
            console.log(response);
        })
        .fail(function (e) {
            alert("Error  to login. " + e.responseJSON.message)
        })
}