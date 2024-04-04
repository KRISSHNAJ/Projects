<%@ page import="youtube.krishnaitprojects.model.CustomerVo" %>
<%@ page import="youtube.krishnaitprojects.model.ProductsVo" %>
<%@ page import="youtube.krishnaitprojects.model.ProductVo" %>
<%@ page import="youtube.krishnaitprojects.model.OrdersVo" %> 
<%@ page import="youtube.krishnaitprojects.model.SellerVo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seller Dashboard</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo img {
            width: 50px;
        }

        .company-name {
            font-size: 1.5em;
            text-align: center;
            flex-grow: 1;
        }

        .customer-info {
            text-align: right;
        }

        .customer-info img {
            width: 30px;
            margin-left: 10px;
        }

        .filter-section {
            padding: 20px;
            background-color: #fff;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
        }

        th,
        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th:first-child,
        td:first-child {
            text-align: left;
        }

        th:last-child,
        td:last-child {
            text-align: center;
        }

        footer {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        .social-icons a {
            margin: 0 5px;
        }

        .social-icons img {
            width: 30px;
        }
                #addProductForm {
            margin-top: 20px;
        }

        #addProductForm input[type="text"],
        #addProductForm input[type="number"] { 
            margin-bottom: 10px;
            padding: 5px;
            width: 200px;
        }

        #addProductForm button {
            padding: 5px 10px;
            background-color: #333;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>

<body>

    <header>
        <div class="logo">
            <img src="logo.png" alt="Company Logo">
        </div>
        <h1 class="company-name">COMPANY NAME</h1>
        <div class="customer-info">
            <span>Welcome, <%= ((SellerVo)request.getAttribute("sellervo")).getSeller_Name() %></span>
            <a href="#"><img src="sellerPhoto.png" alt="Seller Photo"></a>
            <a href="#"><img src="addProdcutsIcon.png" alt="ADD Products Icon"></a>
            <a href="#"><img src="ordersTrackIcon.png" alt="Orders Track Icon"></a>
            <a href="#"><img src="logoutIcon.png" alt="Logout Icon"></a>
        </div>
    </header>
    
        <!-- Add product form -->
    <form id="addProductForm">
        <div>
            <!-- Row 1: ProductName, Product Image, Product Description -->
           <!-- <input type="number" id="sellerId" name="SellerId" value="<%= ((SellerVo)request.getAttribute("sellervo")).getSeller_Id() %>" required> -->
            <input type="number" id="sellerId" placeholder="sellerId" required>
            <input type="text" id="productName" placeholder="Product Name" required>
            <input type="text" id="productImage" placeholder="Product Image URL" required>
            <input type="text" id="productDescription" placeholder="Product Description" required>
        </div>
        <div>
            <!-- Row 2: Price, No. Qty -->
            <input type="number" id="productPerPrice" placeholder="Price" required>
            <input type="number" id="productQuantityObtained" placeholder="No. Qty" required>
        </div>
        <div>
            <!-- Submit button -->
            <button type="button" onclick="addProduct()">Submit</button>
        </div>
    </form>

    <div class="filter-section">
        <!-- Filter options here -->
        <label for="sortby">Sort by:</label>
        <select id="sortby">
            <option value="price">Price</option>
            <option value="name">Product Name</option>
        </select>
    </div>

    <table>
        <thead>
            <tr>
                <th>S.No</th>
                <th>Product ID</th>
                <th>Product Image</th>
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Price</th>
                <th>No. Qty</th>
                <th>Order Approve</th>
                <th>Order Decline</th>
                <th>Order Dispatch</th>
                <th>Product Review and Rating</th>
            </tr>
        </thead>
        <tbody>
            <!-- Table rows with product details -->
            <% 
            // Example data - replace with actual data from DashboardBean.java or other classes
           ProductsVo productsvo = (ProductsVo)request.getAttribute("productsvo");
            // Add data to productList using your logic
            if(productsvo != null && !productsvo.isEmpty()) {
            int count = 1;
         // Get the list of products
            List<ProductVo> productList = productsvo.getProducts();
            int size = productList.size(); // Get the size of the list
            
            // Iterate over each product using a traditional indexed loop
            for (int i = 0; i < size; i++) {
                ProductVo product = productList.get(i); // Get the product at index i
    %>
            <tr>
                <!-- Display serial number -->
                <td><%= count++ %></td>
                <!-- Display product details -->
                <td><%= product.getProduct_Id() %></td>
                <td><%= product.getProduct_Id() %></td>
                <td><%= product.getProduct_Name() %></td>
                <td><%= product.getProduct_Description() %></td>
                <td><%= product.getProduct_PerPrice() %></td>
                <td><%= product.getProduct_QtyObtained() %></td>            
                <!-- Add to cart link -->
                <td><a href="#">Approve</a></td>
                <td><a href="#">Decline</a></td>
                <td><a href="#">Dispatch</a></td>
                <td><%= product.getProduct_Review() %></td>  
            </tr>
<%
        }
    } else {
        // No products available, display a message
%>
        <tr>
            <td colspan="8">No products available</td>
        </tr>
<%
    }
%>
            <!-- Add more rows as needed -->
        </tbody>
    </table>

    <footer>
        <div class="copyright">&copy; 2024 Company Name. All Rights Reserved.</div>
        <div class="social-icons">
            Social media icons here
            <a href="#"><img src="facebook-icon.png" alt="Facebook"></a>
            <a href="#"><img src="twitter-icon.png" alt="Twitter"></a>
            <a href="#"><img src="instagram-icon.png" alt="Instagram"></a>
        </div>
    </footer>
    
    
        <!-- JavaScript for AJAX -->
    <script>
        function addProduct() {
            // Retrieve form data
            var sellerId = document.getElementById("sellerId").value;
            var productName = document.getElementById("productName").value;
            var productImage = document.getElementById("productImage").value;
            var productDescription = document.getElementById("productDescription").value;
            var productPerPrice = document.getElementById("productPerPrice").value;
            var productQuantityObtained = document.getElementById("productQuantityObtained").value;

            // AJAX request to submit form data
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "addProductRequest", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4){ 
                	if(xhr.status === 200) {
                    // Handle response from server
                    var response = JSON.parse(xhr.responseText);
                    if (response.success) {
                        // Product added successfully
                        alert("Product added successfully");
                        // Optionally, update the table or perform other actions
                     // Reload the page
                      //  window.location.reload();
                     // Optionally, update the table dynamically
                        updateTableWithNewProduct(productName, productImage, productDescription, productPerPrice, productQuantityObtained);
                    } else {
                        // Failed to add product
                        alert("Failed to add product");
                     // Reload the page
                      //  window.location.reload();
                    }
                }else {
                	// Request failed
                    alert("Failed to send request to server");
                 // Reload the page
                //    window.location.reload();
                }
            };
            // Send form data as JSON
            xhr.send(JSON.stringify({
            	sellerId: sellerId,
                productName: productName,
                productImage: productImage,
                productDescription: productDescription,
                productPerPrice: productPerPrice,
                productQuantityObtained: productQuantityObtained
            }));
        }
            
         // Function to update the table with the newly added product
            function updateTableWithNewProduct(productName, productImage, productDescription, productPerPrice, productQuantityObtained) {
                // Get reference to table body
                var tbody = document.querySelector("tbody");

                // Create new table row
                var newRow = document.createElement("tr");
                newRow.innerHTML = `
                    <td>${tbody.children.length + 1}</td>
                    <td>${productName}</td>
                    <td>${productImage}</td>
                    
                    
                    <td>${productDescription}</td>
                    <td>${productPerPrice}</td>
                    <td>${productQuantityObtained}</td>
                    <td><a href="#">Approve</a></td>
                    <td><a href="#">Decline</a></td>
                    <td><a href="#">Dispatch</a></td>
                    <td>Product Review and Rating</td>
                `;

                // Append the new row to the table
                tbody.appendChild(newRow);
            }
    </script>

</body>

</html>