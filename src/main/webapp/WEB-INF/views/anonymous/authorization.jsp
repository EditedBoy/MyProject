
<link rel="stylesheet" href="resources/default/css/registration-form.css">

<body>

    <div class="container">
        <div class="flat-form">
            <ul class="tabs">
                <li>
                    <a href="#login" class="active">Login</a>
                </li>
                <li>
                    <a href="#register">Register</a>
                </li>
                <li>
                    <a href="#reset">Reset password</a>
                </li>
            </ul>

            <!--#login.form-action-->
            <div id="login" class="form-action show">
                <h1>Login</h1>
                <form id="loginUser">
                    <ul>
                        <li>
                            <input type="text" name="email" placeholder="Email" />
                        </li>
                        <li>
                            <input type="password" name="password" placeholder="Password" />
                        </li>
                        <li>
                            <input type="submit" value="Login" class="button" />
                        </li>
                    </ul>
                </form>
            </div>
            <!--/#login.form-action-->

            <!--#register.form-action-->
            <div id="register" class="form-action hide">
                <h1>Register</h1>
                <form id="registerUser">
                    <ul>
                        <li>
                            <input type="text" name="email" placeholder="Email" />
                        </li>
                        <li>
                            <input type="password" name="password" placeholder="Password" />
                        </li>
                        <li>
                            <input type="submit" value="Sign Up" class="button" />
                        </li>
                    </ul>

                </form>
            </div>
            <!--/#register.form-action-->

            <!--#reset.form-action-->
            <div id="reset" class="form-action hide">
                <h1>Reset Password</h1>
                <form id="resetUser">
                    <ul>
                        <li>
                            <input type="text" name="email" placeholder="Email" />
                        </li>
                        <li>
                            <input type="submit" value="Send" class="button" />
                        </li>
                    </ul>
                </form>
            </div>
            <!--/#reset.form-action-->

            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
            <script src="resources/default/js/authorisation-data-transfer.js"></script>
        </div>
    </div>

    <script class="cssdeck" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="resources/default/js/authorisation-functional.js"></script>
</body>
