/**
 * 
 */
 function del(task,s1) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById(task+s1).innerHTML ="";
    }
  };
  xhttp.open("GET", "AddHistory?task="+task+"&category="+s1, true);
  xhttp.send();
}
 function history() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() 
  {
    if (this.readyState == 4 && this.status == 200) 
    {
     document.getElementsByTagName("div")[0].innerHTML ="";
    }
  }
  xhttp.open("GET","CleartheHistory" , true);
  xhttp.send();
}
