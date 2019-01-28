<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图转文字</title>
</head>
<body>
<form action="/tess" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
<div>
</div>
<#if tessResult??>
<textarea style="width: 700px;height: 500px ;margin-top: 20px">
${tessResult}
</textarea>
</#if>
</body>
</html>