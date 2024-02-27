function purchase(productName) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/candy-shop/store/product?name=" + encodeURIComponent(productName), true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () {

            if (xhr.readyState === 4 && xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                var amount = response.amount;
                var price = response.price;

                    console.log(amount);
                    console.log(price);
                localStorage.setItem('productName', productName);
                localStorage.setItem('amount', amount);
                localStorage.setItem('price', price);

                window.open("products.html", "Storage", "width=400,height=400");
            }
        };
        xhr.send()
}

function openStoragePopup() {
    var width = 400;
    var height = 400;
    var left = window.innerWidth / 2 - width / 2;
    var top = window.innerHeight / 2 - height / 2;
    var features = `width=${width},height=${height},left=${left},top=${top}`;

    window.open("storage.html", "Storage", features);
}

   window.onload = function() {
        var xhr = new XMLHttpRequest();
           xhr.onreadystatechange = function() {
               if (xhr.readyState === XMLHttpRequest.DONE) {
                   if (xhr.status === 200) {
                       console.log(xhr.responseText);
                   } else {
                       console.error('Error:', xhr.status, xhr.statusText);
                   }
               }
           };

           xhr.open('GET', '/candy-shop/store', true);
           xhr.send();
   };