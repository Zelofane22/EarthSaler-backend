<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Land</title>
</head>
<body>
<h1>EarthSaler</h1>
<form action="search" method="get">
    City: <input type="text" name="city" required><br>
    District: <input type="text" name="district" required><br>
    Min Price: <input type="number" name="minPrice" required><br>
    Max Price: <input type="number" name="maxPrice" required><br>
    Min Area: <input type="number" name="minArea" required><br>
    Max Area: <input type="number" name="maxArea" required><br>
    <input type="submit" value="Search">
</form>
</body>
</html>