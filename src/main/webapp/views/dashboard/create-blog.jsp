<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>
<h4>Create post</h4>
<form action="NewBlog" method="POST">
    <div class="form-group has-error">
        <label for="title">Title <span class="require">*</span></label>
        <input type="text" class="form-control" id="title" name="title" />
    </div>

    <div class="form-group">
        <label for="subtitle">Subtitle <span class="require">*</span></label>
        <input id="subtitle"type="text" class="form-control" name="subtitle" />
    </div>

    <div class="form-group">
        <label for="content">Description <span class="require">*</span></label>
        <textarea rows="5" class="form-control" name="content" id="content"
                  cols=""></textarea>
    </div>

    <div class="form-group text-center py-2">
        <button type="reset" class="btn btn-danger">Cancel</button>
        <button type="submit" class="btn btn-primary">Create</button>
    </div>



</form>
