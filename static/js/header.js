function renderHeader(){
	if(localStorage.getItem("log")=="true"){
		renderLog();
	}else{
		renderNotLog();
	}
}
function renderNotLog(){
	$("#mainHeader").empty();
	$("#mainHeader").append('<div><ul class="memenu skyblue text-center">\
		<li class="active">\
		<button class="btn-evento" data-toggle="modal" data-target="#portsModal">VIEW PORTS</button>\
		</li></ul></div>');
	console.log('Header establecido como NADIE.');

}
function renderLog(){
	$("#mainHeader").empty();
	$("#mainHeader").append(
		'<ul class="memenu skyblue text-center">\
			<li class="active">\
			<button class="btn-evento" onclick="ListUsers();" data-toggle="modal" data-target="#myModalListUsers">USUARIOS</button>\
			<button class="btn-evento" onclick="ListExercises();" data-toggle="modal" data-target="#myModalListExercises">EJERCICIOS</button>\
			<button class="btn-evento" onclick="ListTables();" data-toggle="modal" data-target="#myModalListTables">TABLAS</button>\
			<button class="btn-evento" onclick="LogoutUser();" data-toggle="modal" data-target="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></button>\
			</li>\
		</ul>'
		);
	console.log('Header establecido como ALGUIEN.');
}


// function renderHeader(){
// 	if(localStorage.getItem("log")=="true"){
// 		if(localStorage.getItem("cUserKind")== 0 || localStorage.getItem("cUserKind")== 1 ){
// 			renderAdmin();
// 		}else{
// 			renderUser();
// 		}
// 	}else{
// 		renderNotLog();
// 	}
// }
// function renderNotLog(){
// 	$("#mainHeader").empty();
// 	$("#mainHeader").append('<div><ul class="memenu skyblue">\
// 		<li class="active">\
// 		<button class="btn-evento" data-toggle="modal" data-target="#myModalLogin">Login</button>\
// 		<button class="btn-evento" data-toggle="modal" data-target="#myModalCreateAccount">Register</button>\
// 		</li></ul></div>');
// 	console.log('Header establecido como NADIE.');
//
// }
// function renderUser(){
// 	$("#mainHeader").empty();
// 	$("#mainHeader").append(
// 		'<ul class="memenu skyblue">\
// 			<li class="active">\
// 			<button class="btn-evento" onclick="ReadAndFillUserTables()" data-toggle="modal" data-target="#">My Tables</button>\
// 			<button class="btn-evento" onclick="LogoutUser()" data-toggle="modal" data-target="#">Logout</button>\
// 			</li>\
// 		</ul>'
// 		);
// 	console.log('Header establecido como ALGUIEN.');
// }
// function renderAdmin(){
// 	$("#mainHeader").empty();
// 	$("#mainHeader").append(
// 		'<ul class="memenu skyblue">\
// 			<li class="active">\
// 			<button class="btn-evento" onclick="List()" data-toggle="modal" data-target="#myModalListUsers">List Users</button>\
// 			<button class="btn-evento" onclick="ListTables()" data-toggle="modal" data-target="#">My Tables</button>\
// 			<button class="btn-evento" onclick="LogoutUser()" data-toggle="modal" data-target="#">Logout</button>\
// 			</li>\
// 		</ul>'
// 		);
// 	console.log('Header establecido como ALGUIEN.');
// }
