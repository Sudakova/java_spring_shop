var user = getUser();

function getUser() {
    return JSON.parse(localStorage.getItem("user"));
}


