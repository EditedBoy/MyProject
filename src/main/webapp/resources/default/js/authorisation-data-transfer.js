$(function() {
    $('#registerUser').submit(function() {
        var form = $( this ),
            url = form.attr('action'),
            email = form.find('input[name="email"]').val(),
            password = form.find('input[name="password"]').val(),
            data = JSON.stringify({ "email" : email,
                                    "password" : password });

        $.ajax({
            url : "authorization/register",
            type : "POST",
            traditional : true,
            contentType : "application/json",
            dataType : "json",
            data : data,
            success : function (response) {
                alert('success ' + response);
            },
            error : function (response) {
                alert('error ' + response);
            }
        });

        return false;
    });


    $('#loginUser').submit(function() {
        var form = $( this ),
            url = form.attr('action'),
            email = form.find('input[name="email"]').val(),
            password = form.find('input[name="password"]').val();

        $.ajax({
            url : "authorization/login?email=" + email + "&password=" + password,
            type : "POST",
            contentType : "application/json",
            dataType : "json"
        });

        return false;
    });


    $('#resetUser').submit(function() {
        var form = $( this ),
            url = form.attr('action'),
            email = form.find('input[name="email"]').val();

        $.ajax({
            url : "authorization/reset?email=" + email,
            type : "POST",
            contentType : "application/json",
            dataType : "json"
        });

        return false;
    });
});