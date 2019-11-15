getProduct();

var p;
function getProduct() {
    var url = new URL(document.location.href);
    var id = url.searchParams.get("id");

    url = "http://localhost:8080/product/" + id;
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var product = response;
            p = product;
            console.log(this.product);
            $("#name").text(product.name);
            $("#price").text(product.price);
            $("#size").text(product.size);
            $("#gender").text(product.genderId);
            document.title = product.name;
        })
        .fail(function (e) {
            alert("Error in load categories. " + e.responseJSON.message)
        })
}

function addToCart() {
    var cart = JSON.parse( localStorage.getItem("cart"));
    if(cart == null) cart = [];
    cart.push(p.id);
    localStorage.setItem("cart", JSON.stringify(cart))
}