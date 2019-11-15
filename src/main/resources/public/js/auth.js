var basicURL = "http://localhost:8080/auth/";

isAlreadyLogined();

function isAlreadyLogined() {
    console.log(document.location.pathname)
    if (localStorage.getItem("user") != null) {
        if (document.location.pathname == "/index.html" ||
            document.location.pathname == "/login.html" ||
            document.location.pathname == "/register.html" ||
            document.location.pathname == "/") {
            document.location.href = "./home.html"
        }
    } else {
        if (document.location.pathname != "/index.html" && document.location.pathname != "/login.html" && document.location.pathname != "/register.html") {
            document.location.href = "/index.html"
        }
    }
}

function login() {
    console.log("Login");
    event.preventDefault();
    var login = $("#email").val();
    var password = $("#password").val();
    console.log(login + password);
    var url = basicURL + "login";
    var loginRequest = {
        email: login,
        password: password
    };
    console.log(JSON.stringify(loginRequest));
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(loginRequest, loginRequest)
    })
        .done(function (response) {
            console.log(response);
            user = response;
            localStorage.setItem("user", JSON.stringify(response));
            document.location.href = "/"
        })
        .fail(function (e) {
            alert("Error  to login. " + e.responseJSON.message);
        });
    event.preventDefault();
}


function register() {
    console.log("Register");
    event.preventDefault();
    var login = $("#email").val();
    var password = $("#password").val();
    console.log(login + password);
    var url = basicURL + "register";
    var loginRequest = {
        email: login,
        password: password
    };
    console.log(JSON.stringify(loginRequest));
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(loginRequest, loginRequest)
    })
        .done(function (response) {
            console.log(response);
            user = response;
            localStorage.setItem("user", JSON.stringify(response));
            document.location.href = "/"
        })
        .fail(function (e) {
            alert("Error  to login. " + e.responseJSON.message);
        });
    event.preventDefault();
}
