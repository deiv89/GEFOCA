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

@WebServlet("/OriginCreateServlet")
public class OriginCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		if (request.getAttribute("firstTime") != null) {
			String surname = request.getParameter("surname");
			int idCandidate = (Integer) request.getAttribute("idCandidate");
			request.setAttribute("idCandidate", idCandidate);
			request.setAttribute("surname", surname);
			request.getRequestDispatcher("/originCreate.jsp").forward(request, response);
		} else {
			IOriginService originService = CandidateFactory.getJPAOrigin();
			Origin origin = new Origin();
			Origin currentOrigin = null;

			try {
				origin.setDescription(request.getParameter("description"));
				origin.setAddress(request.getParameter("address"));
				origin.setPhone(request.getParameter("phone"));

				String surname = request.getParameter("surname");

				currentOrigin = originService.create(origin);

				// non accetta int
				String idCandidateString = request.getParameter("idCandidate");
				int idCandidate = Integer.parseInt(idCandidateString);

				originService.updateIdOriginCandidate(idCandidate, currentOrigin.getIdOrigin());

				if (currentOrigin != null) {
					request.setAttribute("surname", surname);
					request.setAttribute("message", "Candidato " + surname + " salvato con successo!");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/CandidateListServlet");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", "ERRORE: Creazione canale provenienza non riuscita");
				request.getRequestDispatcher("/originCreate.jsp").forward(request, response);
			}

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/originCreate.jsp").forward(request, response);
	}

}
