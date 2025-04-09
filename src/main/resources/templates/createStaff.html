<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="email"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h2>Create New Employee</h2>

<form id="creatStaffForm" >
    <label for="name">Full Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="phone">Phone Number:</label>
    <input type="text" id="phone" name="phone" required>

    <label for="password">Password:</label>
    <input type="text" id="password" name="password" required>

    <label for="confirmPassword">Password Confirm:</label>
    <input type="text" id="confirmPassword" name="confirmPassword" required>

    <button type="submit">Create Employee</button>
</form>

</body>
<script>
    document.getElementById("creatStaffForm").addEventListener("submit", function(event) {
        event.preventDefault();
        var formData = new FormData(this) ;
        var data = {
            name : formData.get("name") ,
            email :formData.get("email") ,
            telephone : formData.get("phone") ,
            password : formData.get("password") ,
            confirmPassword: formData.get("confirmPassword"),
            roles : "admin"
        }
        fetch("api/auth/createStaff" , {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then (data => {
                if (data.success){
                    alert("Dang ky thanh cong")
                }
                else{
                    alert(data.message)
                }
            })
            .catch(error =>console.error("Error :" , error))

    });
</script>
</html>
