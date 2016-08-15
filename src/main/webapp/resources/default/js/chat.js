
$(document).ready(function(){
    $.ajax({
        url: 'chatMy/getMyUsers',
        type: 'POST',
        contentType : 'application/json',
        dataType : 'json',
        success: function (userList) {
            var userSelector = document.getElementById('myUserList');// Chose the possition to create elements on HTML-page

            var div = document.createElement('div');
            div.setAttribute('class', 'col-md-3');
            var select = document.createElement('select');
            select.setAttribute('id', 'selectedUser');

            // Creating options in select
            var option = document.createElement('option');
            select.appendChild(option);
            for(var i = 0; i < userList.length; ++i){
                var option = document.createElement('option');
                option.value = userList[i].id;
                option.text = userList[i].email;

                select.appendChild(option);
            }
            div.appendChild(select);
            userSelector.insertBefore(div, userSelector.firstChild);
        }
    });
});

$(function() {
    $( '#btn-chat' ).click(function() {

        var message = parent.document.getElementById('btn-input').value;
        var receiver = $('#selectedUser option:selected').val();// Get chosen user

        // Do not post message if input is empty and do not make URL request
        if (message != '') {

            var currentDate = new Date();
            var datetime = currentDate.getDate() + '/'
                            + (currentDate.getMonth()+1)  + '/'
                            + currentDate.getFullYear() + ' '
                            + currentDate.getHours() + ':'
                            + currentDate.getMinutes() + ':'
                            + currentDate.getSeconds();

            var messageData = JSON.stringify({ 'message' : message,
                                               'datetime' : datetime,
                                               'receiver' : receiver});
            $.ajax({
                url : 'chatMy/inComingMessage',
                type : 'POST',
                traditional : true,
                contentType : 'application/json',
                dataType : 'json',
                data: messageData
            });
             postMyMessage("Taras", message, datetime);
        }
    });


    // Load message's for current user
    var select = document.getElementById('myUserList');
    select.onchange=function(){
        var idUser = $('#selectedUser option:selected').val();

        // Clear chat after change user change
        var clearChat = document.getElementById('chat-panel');
        clearChat.innerHTML = '';



        // Load messages of current dialog
        $.ajax({
            url: 'chatMy/outComingMessage/' + idUser,
            type: 'POST',
            contentType : 'application/json',
            dataType : 'json',
            success: function (messages) {

                for (var i = 0; i < messages.length; ++i){
                    var datetime = messages[i].datetime.dayOfMonth + '/'
                                    + messages[i].datetime.monthValue  + '/'
                                    + messages[i].datetime.year + ' '
                                    + messages[i].datetime.hour + ':'
                                    + messages[i].datetime.minute + ':'
                                    + messages[i].datetime.second;

                    if (idUser == messages[i].author.id){
                        postCustomMessage(messages[i].author.email,
                                      messages[i].message,
                                      datetime);
                    }
                    if (idUser == messages[i].receiver.id){
                        postMyMessage(messages[i].author.email,
                                          messages[i].message,
                                          datetime);
                    }
                }
            }
        });
    }


    // Clear message input after POST message
    var clearMessageInput = document.getElementById('btn-chat');
    clearMessageInput.onclick = function () {
        document.getElementById('btn-input').value='';
    }


    function postMyMessage(userName ,message, datetime){
        // Chose parent element for all message elements
        var chatPanel = document.getElementById('chat-panel');

        // Create elements for chat
        var li = document.createElement('li');
        li.setAttribute('class', 'right clearfix');

        var span1 = document.createElement('span');
        span1.setAttribute('class', 'chat-img pull-right');

        var img = document.createElement('img');
        img.setAttribute('src', 'http://placehold.it/50/FA6F57/fff&text=Me');
        img.setAttribute('alt', 'User Avatar');
        img.setAttribute('class', 'img-circle');

        var div1 = document.createElement('div');
        div1.setAttribute('class', 'chat-body clearfix');

        var div2 = document.createElement('div');
        div2.setAttribute('class', 'header');

        var small = document.createElement('small');
        small.setAttribute('class', 'text-muted');

        var span2 = document.createElement('span');
        span2.setAttribute('class', 'glyphicon glyphicon-time');

        var strong = document.createElement('strong');
        strong.setAttribute('class', 'pull-right primary-font');

        var p = document.createElement('p');

        // Make relations for created elements
        small.appendChild(span2);
        small.appendChild(document.createTextNode(datetime));
        strong.appendChild(document.createTextNode(userName));
        div2.appendChild(small);
        div2.appendChild(strong);
        p.appendChild(document.createTextNode(message));
        div1.appendChild(div2);
        div1.appendChild(p);
        span1.appendChild(img);
        li.appendChild(span1);
        li.appendChild(div1);
        chatPanel.appendChild(li)
    }

    function postCustomMessage(userName, message, datetime){
        // Chose parent element for all message elements
        var chatPanel = document.getElementById('chat-panel');

        // Create elements for chat
        var li = document.createElement('li');
        li.setAttribute('class', 'left clearfix');

        var span1 = document.createElement('span');
        span1.setAttribute('class', 'chat-img pull-left');

        var img = document.createElement('img');
        img.setAttribute('src', 'http://placehold.it/50/55C1E7/fff&text=Him');
        img.setAttribute('alt', 'User Avatar');
        img.setAttribute('class', 'img-circle');

        var div1 = document.createElement('div');
        div1.setAttribute('class', 'chat-body clearfix');

        var div2 = document.createElement('div');
        div2.setAttribute('class', 'header');

        var small = document.createElement('small');
        small.setAttribute('class', 'pull-right text-muted');

        var span2 = document.createElement('span');
        span2.setAttribute('class', 'glyphicon glyphicon-time');

        var strong = document.createElement('strong');
        strong.setAttribute('class', 'primary-font');

        var p = document.createElement('p');

        // Make relations for created elements
        small.appendChild(span2);
        small.appendChild(document.createTextNode(datetime));
        strong.appendChild(document.createTextNode(userName));
        div2.appendChild(strong);
        div2.appendChild(small);
        p.appendChild(document.createTextNode(message));
        div1.appendChild(div2);
        div1.appendChild(p);
        span1.appendChild(img);
        li.appendChild(span1);
        li.appendChild(div1);
        chatPanel.appendChild(li)
    }
});