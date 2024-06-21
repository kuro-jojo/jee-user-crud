<%@ include file="fragments/header.jsp"%>

<title>Add User</title>
</head>
<body>
	<%@ include file="fragments/navbar.jsp"%>
	<div class="container row mx-auto col-md-4">

		<h2>Add User</h2>
		<form action="add" method="post" class="row g-3 needs-validation"
			novalidate>
			<div class="">
				<label for="lastName" class="form-label">Last Name:</label>
				<div class="input-group has-validation">
					<input class="form-control" type="text" id="lastName"
						name="lastName" aria-describedby="inputGroupPrepend" required>
					<div class="invalid-feedback">Please enter a last name.</div>
				</div>

			</div>

			<div class="">
				<label for="firstName" class="form-label">First Name:</label>
				<div class="input-group has-validation">
					<input class="form-control" type="text" id="firstName"
						name="firstName" aria-describedby="inputGroupPrepend" required />
					<div class="invalid-feedback">Please enter a first name.</div>
				</div>
			</div>
			<div class="">
				<label for="login" class="form-label">Login:</label>
				<div class="input-group has-validation">
					<input class="form-control" type="text" id="login" name="login"
						aria-describedby="inputGroupPrepend" required />
					<div class="invalid-feedback">Please enter a login.</div>
				</div>
			</div>
			<div class="">
				<label for="password" class="form-label">Password:</label>
				<div class="input-group has-validation">
					<input class="form-control" type="password" id="password"
						name="password" aria-describedby="inputGroupPrepend" required />
					<div class="invalid-feedback">Please enter a password.</div>
				</div>
			</div>
			<div class="d-grid gap-2 col-6 mx-auto">
				<button class="btn btn-primary" type="submit">Add user</button>
			</div>

		</form>
	</div>
	<script type="text/javascript">
	(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	const forms = document.querySelectorAll('.needs-validation')
	const inputs = document.querySelectorAll('.form-control')
	Array.from(inputs).forEach(inp => {
		inp.addEventListener('input', event => {
					if(!/\S/.test(inp.value)){
						inp.value =""
					}
				})
		})
	  // Loop over them and prevent submission
	Array.from(forms).forEach(form => {
		form.addEventListener('submit', event => {
			
			if (!form.checkValidity()) {
				event.preventDefault()
				event.stopPropagation()
			}
			
			form.classList.add('was-validated')
	    }, false)
	  })
	})()

</script>
</body>
</html>
