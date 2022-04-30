<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>

<h4>Profile</h4>
<form action="UpdateUser" method="POST">
    <div class="form-group has-error">
        <label for="firstName">First Name <span class="require">*</span></label>
        <input type="text" class="form-control" id="firstName" name="firstName" value="${user.firstName}" />
    </div>

    <div class="form-group">
        <label for="lastName">Last Name <span class="require">*</span></label>
        <input id="lastName"type="text" class="form-control" name="lastName" value="${user.lastName}"/>
    </div>

    <div class="form-group">
        <label for="address">Address <span class="require">*</span></label>
        <input id="address"type="text" class="form-control" name="address" value="${user.address}"/>
    </div>

    <div class="form-group">
        <label for="userName">Username <span class="require">*</span></label>
        <input id="userName" type="text" class="form-control" name="userName" value="${user.userName}"/>
    </div>

    <div class="form-group">
        <label for="email">Email <span class="require">*</span></label>
        <input id="email" type="email" class="form-control" name="email" value="${user.email}"/>
    </div>

    <div class="form-group">
        <label for="about">About <span class="require">*</span></label>
        <input id="about" type="text" class="form-control" name="about" value="${user.about}"/>
    </div>

    <div class="form-group">
        <label for="password">password <span class="require">*</span></label>
        <input id="password" type="text" class="form-control" name="password" value="${user.password}"/>
    </div>


    <div class="form-group py-2">
        <button type="submit" class="btn btn-primary">Update</button>
        <button type="reset" class="btn btn-danger">Cancel</button>
    </div>

</form>