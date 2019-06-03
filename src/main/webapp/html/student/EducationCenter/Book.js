
getBookByTuId();
function getBookByTuId(){
	
	$.ajax({
		url : localhostPath() + "/book/getBookByTuId.do",
		dataType : "json",
		type : "post",
		success : function(data){
			var book = data.bookList;
			for(var i=0;i<book.length;i++){
				$("#book").append(
						'<tr align="center">'
	                   +'<td>'
	                   + (i+1)
	                   +'</td>'
	                   +'<td>'
	                   + book[i].course_name
	                   +'</td>' 
	                   +'<td>&nbsp;'
	                   +'</td></tr>'   
				);
			}
			
		},
		error : function(){
			alert("error!");
		}
	});
}