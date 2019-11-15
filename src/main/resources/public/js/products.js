getProductsByCategory();

function getProductsByCategory() {
    var url = new URL(document.location.href);
    var categoryId = url.searchParams.get("category");
    document.title = url.searchParams.get("categoryName");


    url = "http://localhost:8080/product/category/" + categoryId;
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var products = response.data;
            for (var i = 0; i < products.length; i++) {
                var product = products[i];
                $("#productsList").append(
                    '<li><a href="/product.html?id=' + product.id + '">' + product.name + '</a></li>'
                );
            }
        })
        .fail(function (e) {
            alert("Error in load products. " + e.responseJSON.message)
        })
}