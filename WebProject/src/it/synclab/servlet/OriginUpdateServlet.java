package it.synclab.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.synclab.business.CandidateFactory;
import it.synclab.business.Origin;
import it.synclab.service.IOriginService;

@WebServlet("/OriginUpdateServlet")
public class OriginUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String surname = request.getParameter("surname");
		IOriginService originService = CandidateFactory.getJPAOrigin();
		Origin origin = new Origin();
		int idOrigin = Integer.parseInt(request.getParameter("idOrigin"));

		try {
			origin.setDescription(request.getParameter("description"));
			origin.setAddress(request.getParameter("address"));
			origin.setPhone(request.getParameter("phone"));
			origin.setIdOrigin(idOrigin);

			originService.update(origin);

			originService = CandidateFactory.getJPAOrigin();
			Origin currentOrigin = originService.read(idOrigin);

			if (currentOrigin != null) {
				request.setAttribute("surname", surname);
				request.setAttribute("message", "Candidato " + surname + " salvato con successo!");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/CandidateDetailServlet");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "ERRORE: Creazione canale provenienza non riuscita");
				request.getRequestDispatcher("/originUpdate.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e);
			request.getRequestDispatcher("/originUpdate.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		IOriginService originService = CandidateFactory.getJPAOrigin();
		Origin currentOrigin = new Origin();
		int idOrigin = Integer.parseInt(request.getParameter("idOrigin"));
		int idCandidate = Integer.parseInt(request.getParameter("idCandidate"));
		String surname = request.getParameter("surname");

		try {
			currentOrigin = originService.read(idOrigin);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("origin", currentOrigin);
		request.setAttribute("idCandidate", idCandidate);
		request.setAttribute("idOrigin", idOrigin);
		request.setAttribute("surname", surname);
		request.getRequestDispatcher("/originUpdate.jsp").forward(request, response);
	}

}
