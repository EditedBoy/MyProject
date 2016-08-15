<link rel="stylesheet" type="text/css" href="resources/default/css/chat.css">

<div class="container">
    <div class="row" id="myUserList">

        <div class="col-md-5">
            <div class="panel panel-primary">
                <div class="panel-heading" id="accordion">
                    <span class="glyphicon glyphicon-comment"></span> Chat
                    <div class="btn-group pull-right">
                        <a type="button" id="chatButton" class="btn btn-default btn-xs" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </a>
                    </div>
                </div>
            <div class="panel-collapse body" id="collapseOne">
                <div class="panel-body">
                    <ul class="chat" id="chat-panel">

                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input id="btn-input" type="text" class="form-control input-sm" placeholder="Enter message..." />
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="btn-chat">Send</button>
                        </span>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>

<script src="resources/default/js/chat.js" type="text/javascript"></script>