<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>
<h4>Create post</h4>
<form action="createBlog" method="POST">
    <div class="form-group has-error">
        <label for="slug">Title <span class="require">*</span></label>
        <input type="text" class="form-control" id="slug" name="slug" />
    </div>

    <div class="form-group">
        <label for="title">Subtitle <span class="require">*</span></label>
        <input id="title"type="text" class="form-control" name="title" />
    </div>

    <div class="form-group">
        <label for="description">Category <span class="require">*</span></label>
        <input id="description"type="text" class="form-control" name="title" />
    </div>

    <div class="form-group">
        <label for="description">Description <span class="require">*</span></label>
        <textarea rows="5" class="form-control" name="description"
                  cols=""></textarea>
    </div>

    <div class="form-group py-2">
        <button type="submit" class="btn btn-primary">Create</button>
        <button class="btn btn-danger">Cancel</button>
    </div>

</form>
