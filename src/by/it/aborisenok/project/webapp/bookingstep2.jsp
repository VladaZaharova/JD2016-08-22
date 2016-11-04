<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Список поликлиник</label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="">Option one</option>
      <option value="">Option two</option>
    </select>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button1id"></label>
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-primary" formaction="do?command=BOOKINGSTEP1" method="GET">Назад</button>
    <button id="button2id" name="button2id" class="btn btn-success" formaction="do?command=BOOKINGSTEP3" method="POST">Вперёд</button>
  </div>
</div>

</fieldset>
</form>




<%@ include file="include/end-html.jsp" %>
