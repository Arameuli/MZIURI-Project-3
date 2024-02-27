document.addEventListener('DOMContentLoaded', function() {
    var productName = localStorage.getItem('productName');
    var amount = localStorage.getItem('amount');
    var price = localStorage.getItem('price');
    console.log(productName);
    console.log(amount);
    console.log(price);
    var headerElement = document.getElementById("productName");
    var priceElement = document.getElementById("price");
    var availableElement = document.getElementById("available");
    if (priceElement && availableElement && headerElement) {
        headerElement.textContent = productName;
        priceElement.textContent = price;
        availableElement.textContent = amount;
    }
});
async function buyNow() {
    var productName = localStorage.getItem('productName');
    var amount = localStorage.getItem('amount');
    var quantity = document.getElementById("quantity").value;
    console.log(productName + " " + amount + " " + quantity);
    const url = "/candy-shop/store/product" + `?productName=${productName}&amount=${amount}&quantity=${quantity}`;
    try{
        const response = await fetch(url, { method: "POST" });
        console.log(response.ok);
        if (response.ok) {
            alert("Product bought successfully: " + response.status);
            localStorage.removeItem('productName');
            localStorage.removeItem('amount');
            localStorage.removeItem('price');
        }else{
        alert("Amount is not enought: " + response.status)
        }
    }catch (error) {
        console.error("Error buying product:", error);
        alert("Error buying product: " + error.message);
    }
}
