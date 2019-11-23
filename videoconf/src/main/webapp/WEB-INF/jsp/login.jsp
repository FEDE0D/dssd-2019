<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<form method="POST" action="/bonita/login">
  <div class="form-group">
    <label for="username">Username</label>
    <input id="username" name="username" type="text" class="form-control" required="required">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input id="password" name="password" type="password" class="form-control" required="required">
  </div>
  <div class="form-group">
    <button name="submit" type="submit" class="btn btn-primary">Login</button>
  </div>
</form>