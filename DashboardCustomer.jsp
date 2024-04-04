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
    <title>Customer Dashboard</title>
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
    </style>
</head>

<body>

    <header>
        <div class="logo">
            <img src="logo.png" alt="Company Logo">
        </div>
        <h1 class="company-name">COMPANY NAME</h1>
        <div class="customer-info">
            <span>Welcome, <%= ((CustomerVo)request.getAttribute("customervo")).getCustomer_Name() %></span>
            <a href="#"><img src="customerPhoto.png" alt="Customer Photo"></a>
            <a href="#"><img src="cartIcon.png" alt="Cart Icon"></a>
            <a href="#"><img src="ordersIcon.png" alt="Orders Icon"></a>
            <a href="#"><img src="logoutIcon.png" alt="Logout Icon"></a>
        </div>
    </header>

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
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Price</th>
                <th>Add Qty</th>
                <th>Add to Cart</th>
                <th>Buy</th>
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
                <td><%= product.getProduct_Name() %></td>
                <td><%= product.getProduct_Description() %></td>
                <td><%= product.getProduct_PerPrice() %></td>
                <!-- Add quantity input field -->
                <td><input type="number" name="product_QuantityNeeded" value="1" min="1"></td>
                <!-- Add to cart link -->
                <td><a href="#">Add to Cart</a></td>
                <!-- Buy now link -->
                <td><a href="#">Buy Now</a></td>
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

</body>

</html>
