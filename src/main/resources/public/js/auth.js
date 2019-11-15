var basicURL = "http://localhost:8080/";

var userId;

function login() {
    console.log("Login");
    var login = $("#email").val();
    var password = $("#password").val();
    var url = basicURL+"login";
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
           userId = response;
        })
        .fail(function (e) {
            alert("Error  to login. " + e.responseJSON.message)
        })
}