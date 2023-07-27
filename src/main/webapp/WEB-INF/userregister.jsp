<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
<style>
   body {
     font-family: Arial, sans-serif;
     background-color: #f2f2f2;
   }

   .container {
     max-width: 400px;
     margin: 0 auto;
     padding: 20px;
     background-color: #fff;
     border-radius: 5px;
     box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
   }

   .container h2 {
     text-align: center;
   }

   .container input[type="text"],
   .container input[type="password"],
   .container input[type="email"] {
     width: 100%;
     padding: 12px;
     border: 1px solid #ccc;
     border-radius: 4px;
     box-sizing: border-box;
     margin-bottom: 10px;
   }

   .container input[type="submit"] {
     background-color: #4CAF50;
     color: white;
     padding: 12px 20px;
     border: none;
     border-radius: 4px;
     cursor: pointer;
     width: 100%;
   }

   .container input[type="submit"]:hover {
     background-color: #45a049;
   }
</style>
</head>
<body>
<div class="container">
<h2>Registration</h2>
<form action="/register" method="post">
<label for="username">Username</label>
<input type="text" id="username" name="username" placeholder="Choose a username">

<label for="email">Email</label>
<input type="email" id="email" name="email" placeholder="Your email address">

<label for="password">Password</label>
<input type="password" id="password" name="password" placeholder="Choose a password">

<input type="submit" value="Register">
</form>
</div>
</body>
</html>