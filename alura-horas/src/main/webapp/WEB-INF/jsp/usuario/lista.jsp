<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />

<a href="${linkTo[UsuarioController].form()}">Novo Usuario</a>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Login</th>
			<th>Editar</th>
			<th>Remover</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<c:set var="id" value="${u.id}" scope="request"></c:set>
			<tr>
				<td>${u.id}</td>
				<td>${u.nome}</td>
				<td>${u.email}</td>
				<td>${u.login}</td>

				<td><a href="editar?id=${u.id}">Editar</a></td>
				<td>
					<form action="/usuario" method="post">
						<input name="usuario.id" value="${usuario}" type="hidden" />						   
						<button type="submit" name="_method" value="DELETE">remover</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />