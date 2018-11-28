<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html lang="en">
<head>
  <title>All Policy</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/main.css" />
</head>
<style type="text/css" >
footer {
            color: white;
            background-color: black;
            width: 100%;
            bottom: 0;
            position: relative;
        } 
</style>
<script type="text/javascript">
function invokeAjaxCall(url,type){
	if(window.XMLHttpRequest){
		req=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		isIE=true;
		req=new ActiveXObject("Mocrosoft.XMLHTTP");
	}
	req.open(type,url,false);
	req.send(null);
	return req.responseText;
	
}
$(document).ready(function($)
{
	//ajax row data
	var ajax_data =invokeAjaxCall("/getAllPolicyData","GET");
	var obj123=jQuery.parseJSON(ajax_data);
	
/* var ajax_data =
	[
		{slNo:"Code", policyName:"With Mark", policyDetails:"mark@codewithmark.com"}, 
		{slNo:"Code", policyName:"With Mark", policyDetails:"mark@codewithmark.com"},
		
	] */


	
	//--->create data table > start
	var tbl = '';
	tbl +='<table class="table table-hover">'

		//--->create table header > start
		tbl +='<thead>';
			tbl +='<tr>';
			tbl +='<th>Sl NO.</th>';
			tbl +='<th>Policy Name</th>';
			tbl +='<th>Policy Details</th>';
			tbl +='<th>Options</th>';
			tbl +='</tr>';
		tbl +='</thead>';
		//--->create table header > end

		
		//--->create table body > start
		tbl +='<tbody>';

			//--->create table body rows > start
			$.each(obj123, function(index,val) 
			{
				 var slNo=index+1;
				    
				//you can replace with your database row id
				var row_id = val['policyNo'];
				

				//loop through ajax row data
				   tbl +='<tr row_id="'+row_id+'">';
					tbl +='<td >'+slNo+'</td>';
					tbl +='<td ><div class="row_data" edit_type="click" col_name="policyName">'+val['policyName']+'</div></td>';
					tbl +='<td ><div class="row_data" edit_type="click" col_name="policyDetail">'+val['policyDetail']+'</div></td>';

					//--->edit options > start
					tbl +='<td>';
					 
						tbl +='<span class="btn_edit" > <a href="#" class="btn btn-link " row_id="'+row_id+'" > Edit</a> </span>';

						//only show this button if edit button is clicked
						tbl +='<span class="btn_save"> <a href="#" class="btn btn-link"  row_id="'+row_id+'"> Save</a> | </span>';
						tbl +='<span class="btn_cancel"> <a href="#" class="btn btn-link" row_id="'+row_id+'"> Cancel</a> | </span>';

					tbl +='</td>';
					//--->edit options > end
					
				tbl +='</tr>';
			});

			//--->create table body rows > end

		tbl +='</tbody>';
		//--->create table body > end

	tbl +='</table>'	
	//--->create data table > end

	//out put table data
	$(document).find('.tbl_user_data').html(tbl);

	$(document).find('.btn_save').hide();
	$(document).find('.btn_cancel').hide(); 


	//--->make div editable > start
	$(document).on('click', '.row_data', function(event) 
	{
		event.preventDefault(); 

		if($(this).attr('edit_type') == 'button')
		{
			return false; 
		}

		//make div editable
		$(this).closest('div').attr('contenteditable', 'true');
		//add bg css
		$(this).addClass('bg-warning').css('padding','5px');

		$(this).focus();
	})	
	//--->make div editable > end


	
	//--->save single field data > end

 
	//--->button > edit > start	
	$(document).on('click', '.btn_edit', function(event) 
	{
		event.preventDefault();
		var tbl_row = $(this).closest('tr');

		var row_id = tbl_row.attr('row_id');

		tbl_row.find('.btn_save').show();
		tbl_row.find('.btn_cancel').show();

		//hide edit button
		tbl_row.find('.btn_edit').hide(); 

		//make the whole row editable
		tbl_row.find('.row_data')
		.attr('contenteditable', 'true')
		.attr('edit_type', 'button')
		.addClass('bg-warning')
		.css('padding','3px')

		//--->add the original entry > start
		tbl_row.find('.row_data').each(function(index, val) 
		{  
			//this will help in case user decided to click on cancel button
			$(this).attr('original_entry', $(this).html());
		}); 		
		//--->add the original entry > end

	});
	//--->button > edit > end


	//--->button > cancel > start	
	$(document).on('click', '.btn_cancel', function(event) 
	{
		event.preventDefault();

		var tbl_row = $(this).closest('tr');

		var row_id = tbl_row.attr('row_id');

		//hide save and cacel buttons
		tbl_row.find('.btn_save').hide();
		tbl_row.find('.btn_cancel').hide();

		//show edit button
		tbl_row.find('.btn_edit').show();

		//make the whole row editable
		tbl_row.find('.row_data')
		.attr('edit_type', 'click')
		.removeClass('bg-warning')
		.css('padding','') 

		tbl_row.find('.row_data').each(function(index, val) 
		{   
			$(this).html( $(this).attr('original_entry') ); 
		});  
	});
	//--->button > cancel > end

	
	//--->save whole row entery > start	
	$(document).on('click', '.btn_save', function(event) 
	{
		event.preventDefault();
		var tbl_row = $(this).closest('tr');

		var row_id = tbl_row.attr('row_id');

		
		//hide save and cacel buttons
		tbl_row.find('.btn_save').hide();
		tbl_row.find('.btn_cancel').hide();

		//show edit button
		tbl_row.find('.btn_edit').show();


		//make the whole row editable
		tbl_row.find('.row_data')
		.attr('edit_type', 'click')
		.removeClass('bg-warning')
		.css('padding','') 

		//--->get row data > start
		var arr = {}; 
		tbl_row.find('.row_data').each(function(index, val) 
		{   
			var col_name = $(this).attr('col_name');  
			var col_val  =  $(this).html();
			arr[col_name] = col_val;
		});
		//--->get row data > end

		//use the "arr"	object for your ajax call
		$.extend(arr, {policyNo:row_id});

		//out put to show
		$('.post_msg').html( '<pre class="bg-success">'+JSON.stringify(arr, null, 2) +'</pre>')
	
		 $.ajax({
	            type: 'POST', // method attribute of form
	            url: '/updatePolicy',  // action attribute of form
	            dataType : 'json',
	            contentType : "application/json",
		    // convert form data to json format
	            data : JSON.stringify(arr),
	        });
		 

	});
	//--->save whole row entery > end


}); 
</script>

<body>
<header>
<center><h1>Policy Management System</h1></center>
</header>
<section>
<nav>
<ul>
  <li><a href="/">Logout</a></li>
  </ul>
</nav>
</section>
<body>
 </body>
<div class="container">
 
  <form:form class="form-horizontal"  id="showUserPolicy" method="post" modelAttribute="user">
  
  <div>
  <p>welcome <b><c:out value="${ user.userId}" /></b></p>
  
  </div>
   <section><div>
   			<p>Available Policies </p>
   			<div class="panel panel-default">
  <div class="panel-heading"><b> Policy </b> </div>

  <div class="panel-body">
	
	<div class="tbl_user_data"></div>

  </div>

</div>


</div>
   
</section>

</form:form>
</div>
<footer>
<p>&copy; 2018 Policy Management System. All rights reserved.</p>
</footer>

</body>
</html>