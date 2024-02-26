function purchase(productName) {
            openProductsPopup(productName);
        }
        function openProductsPopup(productName) {
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