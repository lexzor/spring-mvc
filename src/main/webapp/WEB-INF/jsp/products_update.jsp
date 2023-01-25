<% pageContext.setAttribute("activeTab", "products");  %>
<%@ include file="header.jsp" %>
<!-- Page content (Begin)  -->

<main class="max-w-[70%] p-[20px] h-[70%] rounded-[10px] mx-auto mt-[50px] flex flex-col items-center flex-nowrap gap-[25px] bg-[#ffbcbc09] text-white">

		<c:if test="${not empty errorPrice}">
		 	<div role="alert">
			  <div class="bg-red-500 text-white font-bold rounded-t px-4 py-2 w-fit pointer-events-none">
			    ${errorPrice}
			  </div>
			</div>
		</c:if>
		
		<c:if test="${not empty errorQuantity}">
		 	<div role="alert">
			  <div class="bg-red-500 text-white font-bold rounded-t px-4 py-2 w-fit pointer-events-none">
			    ${errorQuantity}
			  </div>
			</div>
		</c:if>
		

		
		<div class="w-full h-fit flex flex-nowrap justify-evenly">
			<form:form method="post" modelAttribute="product">
				<div class="text-black flex flex-col justify-evenly gap-[20px] align-center bg-[#161629] p-[30px] rounded-[7px]">
			     <div>
			     	<spring:bind path="name">
			         <div class="text-white${status.error ? ' has-error' : ''}">
			             <label for="name">Name</label>
			             <div class="text-black">
			                 <form:input  type="text" value="${product.name}" path="name" class="bg-[#2b2b3f] rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" placeholder="Product name"/>            
			             </div>
			         </div>
			         </spring:bind>
			    	</div>
			    	
			    	<div>
			         <spring:bind path="typeid">
				         <div class="text-white${status.error ? ' has-error' : ''}">
				             <label for="typeid">Type</label>
				             	<div>                    
					                <form:select class="bg-[#2b2b3f] w-full rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" path="typeid" required="true">
									<form:option class="bg-[#2b2b3f] rounded-[15px] border-[1px] border-[#5f5f73] text-white focus:outline-none" value="${current_type.id}">${current_type.name}</form:option>		
									<c:forEach var="type" items="${product_types}">
									    <c:if test="${current_type.id != type.id}">
										       	<form:option class="bg-[#2b2b3f] rounded-[15px] border-[1px] border-[#5f5f73] text-white focus:outline-none" value="${type.id}">${type.name}</form:option>		
										</c:if>
									</c:forEach>
									</form:select>                            
				             	</div>
			             	</div>
			         	</spring:bind>
			    	</div>
			
			    	 <div>
			         <spring:bind path="description">
			          <div class="text-white${status.error ? ' has-error' : ''}">
			              <label class="z" for="description">Description</label>
			              <div class="text-black">
			                  <form:textarea path="description" value="${product.description}" class="bg-[#2b2b3f] w-full rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" placeholder="Product Description" />                 
			              </div>
			          </div>
			         </spring:bind>
			    	</div>
			    	
			    	<div>
			         <spring:bind path="price">
			          <div class="text-white${status.error ? ' has-error' : ''}">
			              <label class="z" for="price">Price</label>
			              <div class="text-black">
			                  <form:input path="price" value="${product.price}" class="bg-[#2b2b3f] rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" placeholder="1"/>                 
			              </div>
			          </div>
			         </spring:bind>
			    	</div>
			    	
			    	<div>
			         <spring:bind path="quantity">
			          <div class="text-white${status.error ? ' has-error' : ''}">
			              <label class="z" for="quantity">Current quantity</label>
			              <div class="text-black">
			                  <form:input value="${product.quantity}" class="bg-[#2b2b3f] rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" path="quantity" placeholder="1"/>                 
			              </div>
			          </div>
			         </spring:bind>
			     	</div>
					<div>
			          <div>
			              <input type="submit" class="px-[10px] py-[5px] bg-green-500 hover:bg-green-600 text-white rounded-[4px] w-full hover:cursor-pointer hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" value="Edit product">
			          </div>
			      </div>
			 </div>
		</form:form>
	</div>
	
</main>


<!-- Page content (End)    -->
<%@ include file="footer.jsp" %>