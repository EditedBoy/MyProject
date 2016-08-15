
$(document).ready(function(){
    $.ajax({
        url: "user-list/getAllUsers",
        type: "POST",
        contentType : "application/json",
        dataType : "json",
        success: function (userList) {
            var body = document.getElementsByTagName("body");

            // creates a <table> element and a <tbody> element
            var tbl     = document.getElementById("userTable");
            var tblBody = document.createElement("tbody");

            // creating all cells
            for (var i = 0; i < userList.length; i++) {
                var row = document.createElement("tr");

                var value = userList[i];
                for (var index in value){
                    if (value[index] == value.password){
                        continue;
                    }

                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(value[index]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    // add the row to the end of the table body
                    tblBody.appendChild(row);
                }
            }
            // put the <tbody> in the <table>
            tbl.appendChild(tblBody);
            // appends <table> into <body>
            body.appendChild(tbl);
            // sets the border attribute of tbl to 2;
            tbl.setAttribute("border", "2");
        }
    });
});