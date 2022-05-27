<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
$(function() {
	/* $.get("stduent.xml", function(data) {
		console.log(data);
		var dataXml = $.parseXML(data);
		console.log(dataXml);
		
	$(dataXml).find("student").each(function() {
			console.log(this);
			var no = $(this).find("no").text();
			var name = $(this).find("name").text();
			var score = $(this).find("score").text();
			
			console.log(no, name, score);
		})
	}, "text") */
	
	$.get("it", {rss:'https://www.hani.co.kr/rss/international'}, function(data) {
		console.log(data);
		var dataXml = $.parseXML(data);
		console.log(dataXml);
		
	var str = "<table border='1'>"	
	$(dataXml).find("item").each(function() {
			var title = $(this).find("title").text();
			var link = $(this).find("link").text();
			var description = $(this).find("description").text();
			var pubDate = $(this).find("pubDate").text();
			
			str += "<tr>"
			str += "<td><a href='" + link + "'>" + title + "</a></td>"
			str += "<td>" + pubDate + "</td>"
			str += "</tr>"
			
			console.log(title, link, description, pubDate);
		})
	str += "</table>"
	
	$("body").append(str);
	}, "text")
})
</script>
</head>
<body>
</body>
</html>