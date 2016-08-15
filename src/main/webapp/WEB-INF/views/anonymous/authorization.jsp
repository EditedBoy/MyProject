<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
                <c:url value="/j_spring_security_check" var="loginUrl" />
                <form method="post" id="loginForm">
                    <ul>
                        <li>
                            <input type="text" name="j_username" placeholder="Email" />
                        </li>
                        <li>
                            <input type="password" name="j_password" placeholder="Password" />
                        </li>
                        <li>
                            <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </li>
                        <li>
                            <input type="submit" formaction="${loginUrl}" value="Login" class="button" />
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
                            <input type="submit"  value="Send" class="button" />
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
