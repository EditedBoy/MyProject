
<link rel="stylesheet" type="text/css" href="resources/default/css/user-list.css">

<div class="container" id="body">
    <h3>The columns titles are merged with the filters inputs thanks to the placeholders attributes</h3>

    <div class="row" id="table-wrapper">
        <div class="panel panel-primary filterable" id="table-scroll">
            <div class="panel-heading">
                <h3 class="panel-title">Users</h3>
                <div class="pull-right">
                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Filter</button>
                </div>
            </div>
            <table class="table table-hover" id="userTable" >
                <thead>
                    <tr class="filters sticky-wrap">
                        <th><input type="text" class="form-control" placeholder="#" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Email" disabled></th>
                        <th><input type="text" class="form-control" placeholder="First Name" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Last Name" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Phone" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Role" disabled></th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
</div>


<script src="resources/default/js/user-list-functional.js" type="text/javascript"></script>
<script src="resources/default/js/user-list-data-transfer.js" type="text/javascript"></script>