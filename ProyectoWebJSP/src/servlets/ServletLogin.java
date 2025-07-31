package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.codec.digest.DigestUtils;

import entidades.Usuario;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();

    public ServletLogin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Si acceden por GET, los mando al login.jsp (o donde tengas tu login)
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        // Encriptar la contraseña con SHA-256
        String passwordHasheado = DigestUtils.sha256Hex(password);

        // Llamar a la capa negocio para validar usuario
        Usuario usuarioEncontrado = usuarioNegocio.login(usuario, passwordHasheado);

        if (usuarioEncontrado != null) {
            // Usuario válido
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuarioEncontrado);

            // Redireccionar según tipo de usuario
            if (usuarioEncontrado.esAdmin()) {
                response.sendRedirect("AdminDashboard.jsp");
            } else if (usuarioEncontrado.esCliente()) {
                response.sendRedirect("ClienteDashboard.jsp");
            } else {
                // Si es otro tipo o no definido
                request.setAttribute("error", "Tipo de usuario no válido.");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else {
            // Usuario o contraseña incorrectos
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
