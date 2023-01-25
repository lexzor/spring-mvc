<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% if (pageContext.getAttribute("activeTab") == null) { pageContext.setAttribute("activeTab", "home"); } %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>ROPharma</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="<c:url value='/resources/style.css' />">
</head>

<body class="h-full">
	<header>
        <div class="w-full h-[60px] bg-[#2b2b3f]">
            <ul class="w-[100px] h-full mx-auto flex gap-[20px] items-center text-white text-[20px] justify-center">
                <li class='${activeTab eq "home" ? "active":"none"}'><a class="h-full w-full" href="<c:url value='/' />">Home</a></li>
                <li class='${activeTab eq "products" ? "active":"none"}'><a class="h-full w-full" href="<c:url value='/products' />">Products</a></li>
            </ul>
        </div>
    </header>