function purchase(productName) {
console.log(productName);
    openProductsPopup(productName);
    }

function openProductsPopup(productName) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/candy-shop/store/product?name=" + encodeURIComponent(productName), true);
    xhr.setRequestHeader("Content-Type", "text/plain");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Response from server: " + xhr.responseText);
        }
    };
    xhr.send();

    window.open("products.html", "Storage", "width=400,height=400");
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