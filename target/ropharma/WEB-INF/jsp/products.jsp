<% pageContext.setAttribute("activeTab", "products");  %>
<%@ include file="header.jsp" %>
<!-- Page content (Begin)  -->

<main class="w-[65%] h-fit p-[20px] rounded-[10px] justify-center items-center mx-auto mt-[50px] bg-[#ffbcbc09] text-white mb-[200px]">

		<c:if test="${not empty message}">
	    	<div class="bg-teal-100 border-t-4 border-teal-500 rounded-b text-teal-900 px-4 py-3 shadow-md" role="alert">
			  <div class="flex">
			    <div>
			      <p class="font-bold">${message}</p>
			    </div>
			  </div>
			</div>
		</c:if>

		
	    <c:if test="${not empty errorMessage}">
		 	<div role="alert">
			  <div class="bg-red-500 text-white font-bold rounded-t px-4 py-2">
			    Error while trying to delete product!
			  </div>
			  <div class="border border-t-0 border-red-400 rounded-b bg-red-100 px-4 py-3 text-red-700">
			    <p>${errorMessage}</p>
			  </div>
			</div>
		</c:if>
		
	<div class="min-w-full flex flex-col justify-center items-center gap-[100px]">
		<div class="min-w-[80%] flex flex-col gap-[20px]">
			<div class="mb-[30px] w-[600px]">
				<h1 class="font-bold text-[28px] text-red-500">Products</h1>
				<h1 class="text-[15px] ml-[15px]">Here you can see our products! You can add a new one or to change an existing one</h1>
			</div>
			
			<a href="<c:url value='/products/add_product'/>" class="max-w-fit max-h-fit mx-auto px-[10px] py-[5px] bg-green-500 hover:bg-green-600 rounded-[3px] text-[16px]"><button class="w-inherit h-inherit">Add product</button></a>
			
			<div class="min-w-full flex flex-nowrap flex-column">
				<div class="w-full h-full flex flex-col align-center gap-[10px] mt-[20px] p-[20px] bg-[#3e3e74cc] border-[1px] border-[#595959] rounded-[10px]">
					<div class="px-[10px] py-[15px] bg-[#212a40] flex flex-row flex-nowrap justify-between items-center">
						<h1 class="w-full">Denumire </h1>
						<h1 class="w-full">Descriere</h1>
						<h1 class="w-full">Tipul </h1>
						<h1 class="w-full">Cantitate</h1>
						<h1 class="w-full">Pret</h1>
						<div class="w-full flex flex-nowrap justify-evenly gap-[20px]">
							<div class="w-fit rounded-[5px] align-center px-[10px] py-[5px] border-[1px] border-[#878787]"><a class="w-full h-full text-center" >Editeaza</a></div>
							<div class="w-fit rounded-[5px] align-center px-[10px] py-[5px] border-[1px] border-[#878787]"><a class="w-full h-full text-center" >Sterge</a></div>
						</div>
					</div>
					<c:choose>
					   <c:when test="${products.size() > 0}">
						   	<c:forEach items="${products}" var="product">
								<div class="px-[10px] py-[15px] bg-[#161629] flex flex-row flex-nowrap justify-between items-center">
									<h1 class="w-full">${product.name}</h1>
									<h1 class="w-full">${product.description}</h1>
									<h1 class="w-full">${product.type.name}</h1>
									<h1 class="w-full">${product.quantity}</h1>
									<h1 class="w-full">${product.price}.0 RON</h1>
									<div class="flex flex-nowrap justify-evenly gap-[20px]">
										<div class="w-fit rounded-[5px] align-center px-[10px] py-[5px] bg-cyan-500 hover:bg-cyan-600"><a class="w-full h-full text-center" href="<c:url value='/product/update_product?id=${product.id}'/>">Update</a></div>
										<div class="w-fit rounded-[5px] align-center px-[10px] py-[5px] bg-red-500 hover:bg-red-600"><a class="w-full h-full text-center" href="<c:url value='/product/delete?id=${product.id}'/>">Delete</a></div>
									</div>
								</div>
							</c:forEach>
					   </c:when>
					   <c:when test="${products.size() == 0}"><h1 class="flex justify-self-center align-center text-[25px]">No products!</h1></c:when>
					</c:choose>
				</div>
			</div>
		</div>			
	
		
		<div class="min-w-full flex flex-col justify-center items-center gap-[20px]">
			<div class="min-w-[80%] flex flex-col gap-[20px]">
				<div class="mb-[30px] w-[600px]">
					<h1 class="font-bold text-[28px] text-red-500">Categories</h1>
					<h1 class="text-[15px] ml-[15px]">Here you can see our categories for products! You can add a new one or to change an existing one</h1>
				</div>
				
				<a href="<c:url value='/products/add_category'/>" class="max-w-fit max-h-fit mx-auto px-[10px] py-[5px] bg-green-500 hover:bg-green-600 rounded-[3px] text-[16px]"><button class="w-inherit h-inherit">Add category</button></a>
				
				<div class="min-w-full flex flex-nowrap flex-column">
					<div class="w-full h-full flex flex-col align-center gap-[10px] mt-[20px] p-[20px] bg-[#3e3e74cc] border-[1px] border-[#595959] rounded-[10px]">
						<div class="px-[10px] py-[15px] bg-[#212a40] flex flex-row flex-nowrap justify-between items-center">
							<h1 class="w-full">Tip de medicament</h1>
							<h1 class="w-full">Descriere</h1>
							<div class="w-full flex flex-nowrap justify-evenly gap-[20px]">
								<div class="w-fit rounded-[5px] align-center px-[10px] py-[5px] border-[1px] border-[#878787]"><a class="w-full h-full text-center" >Editeaza</a></div>
								<div class="w-fit rounded-[5px] align-center px-[10px] py-[5px] border-[1px] border-[#878787]"><a class="w-full h-full text-center" >Sterge</a></div>
							</div>
						</div>
						<c:choose>
						   <c:when test="${product_types.size() > 0}">
							   	<c:forEach items="${product_types}" var="type">
							   	
									<div class="px-[10px] py-[15px] bg-[#161629] flex flex-row flex-nowrap justify-between items-center">
										<h1 class="w-full">${type.name}</h1>
										<h1 class="w-full">${type.description}</h1>
										<div class="w-full flex flex-nowrap justify-evenly gap-[20px]">
											<div class="w-fit justify-self-center rounded-[5px] align-center px-[10px] py-[5px] bg-cyan-500 hover:bg-cyan-600"><a class="w-full h-full text-center" href="<c:url value='/product/update_type?id=${type.id}'/>">Update</a></div>
											<div class="w-fit justify-self-center rounded-[5px] align-center px-[10px] py-[5px] bg-red-500 hover:bg-red-600"><a class="w-full h-full text-center" href="<c:url value='/product/delete_type?id=${type.id}'/>">Delete</a></div>
										</div>
									</div>
								</c:forEach>
						   </c:when>
						   <c:when test="${products.size() == 0}"><h1 class="flex justify-self-center align-center text-[25px]">No categories!</h1></c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>


<!-- Page content (End)    -->
<%@ include file="footer.jsp" %>