package it.synclab.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String filePath = (String) request.getParameter("pathCv");
		Path p = Paths.get(filePath);
		String fileName = p.getFileName().toString();

		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\"");

		// use inline if you want to view the content in browser, helpful for
		// pdf file
		// response.setHeader("Content-Disposition","inline; filename=\"" +
		// filename + "\"");
		FileInputStream fileInputStream = new FileInputStream(filePath);

		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();

		request.getRequestDispatcher("/candidateDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String filePath = (String) request.getParameter("pathCv");
		Path p = Paths.get(filePath);
		String fileName = p.getFileName().toString();

		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\"");

		// use inline if you want to view the content in browser, helpful for
		// pdf file
		// response.setHeader("Content-Disposition","inline; filename=\"" +
		// filename + "\"");
		FileInputStream fileInputStream = new FileInputStream(filePath);

		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();

		request.getRequestDispatcher("/candidateDetail.jsp").forward(request, response);

	}

}
