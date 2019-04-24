<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">


<title>Formulaire</title>
</head>
<body>
	<section class="Container">
		<h1>Formulaire</h1>



		<form action="ServletPersonne">
			<div class="form-group">
				<div>
					<input type="hidden" name="id" value="${id }" /> 
					
					<label for="prenom">Prenom</label> <input id="prenom"
						class="form-control" placeholder="Mon Prenom" type="text"
						name="firstname" value="${firstname }" required />
				</div>


				<div class="form-group">
					<label for="nom">nom</label> <input id="nom" class="form-control"
						type="text" placeholder="Mon nom" name="lastname"
						value="${lastname }" required />
				</div>

				<div class="form-group">
					<label for="age">age</label> <input id="age" class="form-control"
						type="text" placeholder="Mon age" name="age" value="${age }" />
				<%-- </div>
				
				<div class="form-group">
					<label for="login">login</label> <input id="login" class="form-control"
						type="text" placeholder="Mon login" name="login" value="${login }" />
				</div>
				
				<div class="form-group">
					<label for="mdp">pass</label> <input id="mdp" class="form-control"
						type="password" placeholder="Mon pass" name="mdp" value="${mdp}" />
				</div> --%>
				<div>

					<input type="submit" name="ajouter" value="Ajouter" /> 
					<input
						type="submit" name="modifier" value="Modifier" />
				</div>
				<div>
					Adresse: <select name="adr">
						<optgroup>
							<option value="0">--</option>
							<c:if test="${!empty adresses}">
								<c:forEach items="${adresses}" var="a">
									<option value="${a.idAdresse}">
										<c:out value="${a.nomrue} }"></c:out>
									</option>
								</c:forEach>
							</c:if>
						</optgroup>
					</select>
					<!-- Adresse :<select name=idAdr>
								<optgroup>
									<option>--</option>
									<option>Adresse1</option>
									<option>Adresse2</option>
								</optgroup>
								</br>

							</select> -->

				</div>
		</form>
	</section>



	<div class=container>

		<h2>Liste des personnes en BDD</h2>
		<table class="table table-bordered">
			<thead class="orange">
				<tr>
					<th>ID</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>AGE</th>
					<th>SUPPRIMER</th>
					<th>MODIFIER</th>

				</tr>
			</thead>
			<tbody>

				<c:if test="${!empty personnes}">
					<c:forEach items="${personnes}" var="x">
						<tr>
							<td><c:out value="${x.id}" /></td>
							<td><c:out value="${x.nom}" /></td>
							<td><c:out value="${x.prenom}" /></td>
							<td><c:out value="${x.age}" /></td>


							<td><a href="SupprimerPersonne?idPersonne=${x.id}">supprimer</a></td>
							<td><a href="ModifierPersonne?idPersonne=${x.id}">modifier</a></td>
						</tr>

					</c:forEach>
				</c:if> 
			</tbody>
		</table>
	</div>
</body>
</html>