<#macro addform path>

<form method="post">
    <div class="input-group mb-3">

        <input type="content" class="form-control" name="content" placeholder="Add content"
               aria-describedby="basic-addon2">
        <input type="title" class="form-control" name="title" placeholder="Add title"
               aria-describedby="basic-addon2">
        <input type="slug" class="form-control" name="slug" placeholder="Add slug"
               aria-describedby="basic-addon2">
        <div class="input-group-append">
            <button class="btn btn-dark" type="submit">Add</button>
        </div>

    </div>
</form>
</#macro>