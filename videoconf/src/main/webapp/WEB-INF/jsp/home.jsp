<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<div><b>Bienvenido: ${username}</b><div>

<form method="POST" action="/bonita/iniciarSolicitud">
  <div class="form-group">
    <button name="submit" type="submit" class="btn btn-primary">Iniciar Solicitud</button>
  </div>
</form>

<div><a href="/forms/logout">Salir</a></div>