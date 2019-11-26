<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<form method="POST" action="/bonita/solicitud?id=${processInstanceId}">
  <div class="form-group">
      <label for="solicitante_id">Solicitante</label>
      <div>
        <select id="solicitante_id" name="solicitante_id" class="custom-select" required="required">
          <option value="101">Federico Pacheco</option>
          <option value="201">Luis Melo</option>
        </select>
      </div>
    </div>
  <div class="form-group">
    <label for="nro_causa">Causa</label>
    <div>
      <select id="nro_causa" name="nro_causa" class="custom-select" required="required">
        <option value="1">Causa 1</option>
        <option value="2">Causa 2</option>
        <option value="3">Causa 3</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="unidad_id">Unidad</label>
    <div>
      <select id="unidad_id" name="unidad_id" class="custom-select" required="required">
        <option value="1">Unidad 1</option>
        <option value="2">Unidad 2</option>
        <option value="3">Unidad 3</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="motivo">Motivo</label>
    <textarea id="motivo" name="motivo" cols="40" rows="2" class="form-control" required="required">Motivo 1</textarea>
  </div>
  <div class="form-group">
    <label for="fecha">Fecha</label>
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">
          <i class="fa fa-calendar"></i>
        </div>
      </div>
      <input id="fecha" name="fecha" type="text" class="form-control" value="22/11/2019" required="required">
    </div>
  </div>
  <div class="form-group">
    <label for="hora">Hora</label>
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">
          <i class="fa fa-clock-o"></i>
        </div>
      </div>
      <input id="hora" name="hora" type="text" class="form-control" value="20:12:56" required="required">
    </div>
  </div>
  <div class="form-group">
    <label for="juez_id">Juez</label>
    <div>
      <select id="juez_id" name="juez_id" class="custom-select" required="required">
        <option value="1">Juez 1</option>
        <option value="2">Juez 2</option>
        <option value="3">Juez 3</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="interno_id">Interno</label>
    <div>
      <select id="interno_id" name="interno_id" class="custom-select" required="required">
        <option value="1">Interno 1</option>
        <option value="2">Interno 2</option>
        <option value="3">Interno 3</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="abogado_id">Abogado</label>
    <div>
      <select id="abogado_id" name="abogado_id" class="custom-select" required="required">
        <option value="1" selected>Abogado 1</option>
        <option value="2">Abogado 2</option>
        <option value="3">Abogado 3</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="procurador_id">Procurador</label>
    <div>
      <select id="procurador_id" name="procurador_id" class="custom-select" required="required">
        <option value="1">Procurador 1</option>
        <option value="2">Procurador 2</option>
        <option value="3">Procurador 3</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <button name="submit" type="submit" class="btn btn-primary">Solicitar</button>
  </div>
</form>