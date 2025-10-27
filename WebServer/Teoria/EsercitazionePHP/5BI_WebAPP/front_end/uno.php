<!DOCTYPE html>
<html lang="it">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

  <div class="container vh-100 d-flex flex-column justify-content-center">
    <div class="row mb-5">
      <div class="col text-center">
        <h2>Benvenuto</h2>
        <p>Accedi per continuare</p>
      </div>
    </div>

    <div class="row justify-content-center">
      <div class="col-md-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <h4 class="card-title text-center mb-4">Login</h4>
            <form id="loginForm" action="controllo.php" method="get">
              <!-- Campi visibili -->
              <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" placeholder="Inserisci username" required>
              </div>
              <div class="mb-3">
                <label for="passwordInput" class="form-label">Password</label>
                <input type="password" class="form-control" id="passwordInput" placeholder="Inserisci password" required>
              </div>

              <!-- Campi nascosti codificati -->
              <input type="hidden" name="login" id="encodedLogin">
              <input type="hidden" name="password" id="encodedPassword">

              <div class="d-grid mb-3">
                <button type="submit" class="btn btn-primary">Accedi</button>
              </div>
              <div class="text-center">
                <a href="registrazione.html">Registrati</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <div class="row mt-5">
      <div class="col text-center">
        <small>&copy; 2025 - La tua azienda</small>
      </div>
    </div>
  </div>

  <script>
    document.getElementById("loginForm").addEventListener("submit", function(e) {
      const login = document.getElementById("username").value;
      const password = document.getElementById("passwordInput").value;

      // Codifica URL (equivalente a urlencode in PHP)
      document.getElementById("encodedLogin").value = encodeURIComponent(login);
      document.getElementById("encodedPassword").value = encodeURIComponent(password);

      // Rimuove i campi visibili dal submit
      document.getElementById("username").removeAttribute("name");
      document.getElementById("passwordInput").removeAttribute("name");
    });
  </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>