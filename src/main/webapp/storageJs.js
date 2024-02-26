async function addProduct() {
    const productName = document.getElementById("productName").value;
    const amount = document.getElementById("amount").value;
    const password = document.getElementById("password").value;
    const url = "/candy-shop/store/product" + `?productName=${productName}&amount=${amount}&password=${password}`;
    try {
        const response = await fetch(url, { method: "PUT" });
        console.log(response.ok);
        if (response.ok) {
            alert("Product added successfully: " + response.status);
        } else {
            alert("Password or Name is incorrect: " + response.status);
        }
    } catch (error) {
        console.error("Error adding product:", error);
        alert("Error adding product: " + error.message);
    }
}

