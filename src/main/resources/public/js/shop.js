getCategories();

getCart();

function getCategories() {
    var url = "http://localhost:8080/category/all";
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var categories = response.data;
            for (var i = 0; i < categories.length; i++) {
                var category = categories[i];
                $("#categoriesList").append(
                    '<li><a href="category.html?category=' + category.id + '&categoryName=' + category.name + '">' + category.name + '</a></li>'
                );
            }
        })
        .fail(function (e) {
            alert("Error in load categories. " + e.responseJSON.message)
        })
}

function getCart() {
    var cart = JSON.parse(localStorage.getItem("cart"));
    if (cart != null) {
        $("#cart").text("Cart List");
        $("#buy").show();
        for (var i = 0; i < cart.length; i++)  {
            var url = "http://localhost:8080/product/" + cart[i];
            $.ajax({
                url: url,
                type: "GET",
                dataType: "json"
            })
                .done(function (response) {
                    var product = response;
                    $("#cartList").append(
                        '<li><a href="/product.html?id=' + product.id + '">' + product.name + '</a></li>'
                    );
                })
                .fail(function (e) {
                    alert("Error in load categories. " + e.responseJSON.message)
                })
        }
    }
}

function buy() {
    var url = "http://localhost:8080/product/buy";
    var productsList = []
    var cart = JSON.parse(localStorage.getItem("cart"));
    for (var i = 0; i < cart.length; i++)  {
        productsList.push({
            productId: cart[i],
            amount:1
        })
    }
    var productRequest = {
        products: productsList,
        userId: user.id
    };
    console.log(JSON.stringify(productRequest));
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(productRequest)
    })
        .done(function (response) {
            localStorage.removeItem("cart");
            document.location.href = "/home.html"
        })
        .fail(function (e) {
            alert("Error  to login. " + e.responseJSON.message);
        });
}