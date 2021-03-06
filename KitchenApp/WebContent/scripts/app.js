/**
 * 
 */
"use strict";

(function() {

	$(function() {

		$('#btn_addReservation').click(function() {

         var person = {
          "name" : $("#reserveName").val(),
          "date" : $("#reserveDate").val(),
          "time" : $("#reserveTime").val(),
          "email" : $("#reserveEmail").val(),
          "phone" : $("#reservePhone").val(),
          "partySize": $("#reserveSize").val(),
          "comments": $("#reserveComment").val()
          };
            //console.dir(person);
          $.ajax({
                method : 'POST',
                url : 'api/people/addReservation',
                cache : false,
                dataType : 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(person),
                error : function(jqXHR, textStatus, error) {
                    console.log(error);
                },
                success : function(data) {
                    console.log(data);
                    var content = "Well done! Your reservation is complete. \nYour confirmation number is "+ data.payload.cnf;
                    $('#reserveSuccess').append(content);

                    $("#reserveSuccess").css("display","inline");
                }
            });
		});

		$('#dropContact').click(function() {
			
			$.ajax({
				method : 'GET',
				url : 'api/people/contactList',
				cache : false,
				dataType : 'json',
				error : function(jqXHR, textStatus, error) {
					console.log(error);
				},
				success : function(data) {
					//console.log(data.payload.length);
			     var content = "<table class=\"table table-condensed table-striped\"><thead><tr><th>CNF#</th><th>Name</th><th>Date</th><th>Contact</th></tr></thead><tbody>";
				  		
					    for ( var i = 0; i < data.payload.length; i++) {
					    	//console.log(data.length);
						  content += '<tr><td>' + data.payload[i].cnf + '</td><td>';
						  content += data.payload[i].name + '</td><td>';
						  content += data.payload[i].date + '</td><td>';
						  content += data.payload[i].phone + '</td></tr>';

				       }
				  content += "</tbody></table>";
				  $('#here_table_contact').append(content);


				}
			});
			 

		});


		$('#btn_getContactList').click(function() {

			$.ajax({
				method : 'GET',
				url : 'api/people/all',
				cache : false,
				dataType : 'json',
				error : function(jqXHR, textStatus, error) {
					console.log(error);
				},
				success : function(data) {
					console.log(data);
				}
			});
		});

		$('#btn_getReservation').click(function() {

			var personID = $('#reserveEditCNF').val();
            console.log(personID);
				$.ajax({
					method : 'GET',
					url : 'api/people/getReservation/' + personID,
					cache : false,
					dataType : 'json',
					error : function(jqXHR, textStatus, error) {
						console.log(error);
					},
					success : function(data) {
						console.log(data.payload.name);

						console.log(data);
                        $("#reserveNameEdit").prop("placeholder", data.payload.name);
                        $("#reserveDateEdit").prop("placeholder", data.payload.date);
                        $("#reserveTimeEdit").prop("placeholder", data.payload.time);
                        $("#reserveEmailEdit").prop("placeholder", data.payload.email);
                        $("#reservePhoneEdit").prop("placeholder", data.payload.phone);
                        $("#reserveSizeEdit").prop("placeholder", data.payload.partySize);
                        $("#reserveCommentEdit").prop("placeholder", data.payload.comments);

					}
				});

		});

		$('#cancelbtn').click(function() {

			var personID = $('#reserveID').val();
            console.log(personID);
				$.ajax({
					method : 'GET',
					url : 'api/people/getCancel/' + personID,
					cache : false,
					dataType : 'json',
					error : function(jqXHR, textStatus, error) {
						console.log(error);
					},
					success : function(data) {
						console.log(data);
	                   if(data.payload == "Success"){
						var content = "Your reservation is canceled. \n Wish you a good day!";
	                   }
	                   else
	                	   var content = "Can't be canceled! Please call authority.";
						$('#cancelSuccess').append(content);

	                    $("#cancelSuccess").css("display","inline");

					}
				});

		});


		
	});

})();