/**
 * 
 */
 function validateDate()
 {
	let enteredDate=document.getElementById("dueDate").value;
	let dueDate=new Date(enteredDate);
	let todayDate=new Date();
	console.log(todayDate);
	console.log(dueDate);
	let dateToday=todayDate.getDate()+''+todayDate.getMonth()+''+todayDate.getFullYear();
	let dateDue=dueDate.getDate()+''+dueDate.getMonth()+''+dueDate.getFullYear();
	console.log(dateToday);
	console.log(dateDue);
	if(dateToday===dateDue)
		return true;
	if(todayDate>dueDate)
	{
		if(todayDate==dueDate)
			return true;
		else
		{
			alert("Please Enter upcomming date!");
			return false;
		}
	}
	return true;
 }