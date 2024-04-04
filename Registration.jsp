<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <style>
        /* CSS Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
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
            margin-right: 10px;
        }
        .company-name {
            font-size: 1.5em;
            text-align: center;
        }
        .registration-container {
            text-align: center;
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"],
        select {
            width: 300px;
            padding: 10px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        footer {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        .social-media a {
            margin: 0 5px;
        }
        .social-media img {
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
    </header>

    <div class="registration-container">
        <h2>Registration</h2>
        <form action="RegisterRequest" method="post">
            <div class="form-group">
                <input type="hidden" id="registration" name="action" value="Registration" required>
            </div>
            <div class="form-group">
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" required>
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address">
            </div>
            <div class="form-group">
                <label for="role">Select Role:</label>
                <select id="role" name="role">
                	<option value="selectRole">Select Your ROLE</option>
                    <option value="admin">Admin</option>
                    <option value="seller">Seller</option>
                    <option value="customer">Customer</option>
                </select>
            </div>
            <div class="form-group">
                <button type="submit">Sign Up</button>
            </div>
        </form>
    </div>

    <footer>
        <div class="social-media">
            <a href="#"><img src="facebook-icon.png" alt="Facebook"></a>
            <a href="#"><img src="twitter-icon.png" alt="Twitter"></a>
            <a href="#"><img src="instagram-icon.png" alt="Instagram"></a>
        </div>
        <div>
            &copy; 2024 Company Name. All Rights Reserved.
        </div>
    </footer>
</body>
</html>
