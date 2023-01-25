<% pageContext.setAttribute("activeTab", "products");  %>
<%@ include file="header.jsp" %>
<!-- Page content (Begin)  -->

<main class="max-w-[70%] p-[20px] h-[70%] rounded-[10px] mx-auto mt-[50px] flex justify-center items-center flex-nowrap gap-[25px] bg-[#ffbcbc09] text-white">
		<form:form method="post" modelAttribute="type">
			<div class="text-black flex flex-col justify-evenly gap-[20px] align-center bg-[#161629] p-[30px] rounded-[7px]">
		        <div>
		        	<spring:bind path="name">
		            <div class="text-white${status.error ? ' has-error' : ''}">
		                <label for="name">Name</label>
		                <div class="text-black">
		                    <form:input  type="text" path="name" value="${type.name}" class="bg-[#2b2b3f] rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" placeholder="Category name"/>            
		                </div>
		            </div>
		            </spring:bind>
	        	</div>
	
	        	<div>
		            <spring:bind path="description">
			            <div class="text-white${status.error ? ' has-error' : ''}">
			                <label class="z" for="description">Description</label>
			                <div class="text-black">
			                    <form:textarea path="description" value="${type.description}" class="bg-[#2b2b3f] w-full rounded-[15px] border-[1px] border-[#5f5f73] px-[10px] py-[5px] text-white focus:outline-none hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" placeholder="Category Description" />                 
			                </div>
			            </div>
		            </spring:bind>
	        	</div>
	        	
	        	<div>
		            <div>
		                <input type="submit" class="px-[10px] py-[5px] bg-green-500 hover:bg-green-600 text-white rounded-[4px] w-full hover:cursor-pointer hover:border-[#49cca3] focus:border-[#49cca3] hover:cursor-pointer" value="Update category">
		            </div>
		        </div>
	        </div>
		</form:form>
</main>


<!-- Page content (End)    -->
<%@ include file="footer.jsp" %>