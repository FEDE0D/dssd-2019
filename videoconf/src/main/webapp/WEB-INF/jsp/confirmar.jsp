<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<form method="POST" action="/bonita/confirm?id=${processInstanceId}">
  <div class="form-group">
    <label for="schedule_id">Confirmar solicitud</label>
    <div>
      ${solicitud}
    </div>
  </div>
  <div class="form-group">
    <button name="submit" type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>