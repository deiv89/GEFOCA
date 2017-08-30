package it.synclab.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import it.synclab.business.Candidate;
import it.synclab.business.CandidateFactory;
import it.synclab.service.ICandidateService;

@WebServlet("/CandidateCreateServlet")
@MultipartConfig
public class CandidateCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "D:/CORSO/UploadedFiles/";

	public void init() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
 
		ICandidateService candidateService = CandidateFactory.getJPACandidate();
		Candidate candidate = new Candidate();
		Candidate currentCandidate = new Candidate();
		String user = (String) request.getAttribute("user");
		String user1 = (String) request.getParameter("user");
		try {
			String name = null;
			String surname = null;
			String dateOfBirth = null;
			String qualification = null;
			
			//Create a factory for disk-based file items
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		    //Configure a repository (to ensure a secure temp location is used)
		    ServletContext servletContext = this.getServletConfig().getServletContext();
		    File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		    factory.setRepository(repository);
		    //Create a new file upload handler
		    ServletFileUpload upload = new ServletFileUpload(factory);
		    //Parse the request
		    List<FileItem> items = upload.parseRequest(request);
		    Iterator<FileItem> iter = items.iterator();
		    while (iter.hasNext()) {
		        FileItem item = iter.next();
		            InputStream input = item.getInputStream();
		            if(item.getFieldName().equals("name") && name == null){
		                byte[] str = new byte[input.available()];
		                input.read(str);
		                name = new String(str,"UTF8");
		                candidate.setName(capitalise(name));
		            }
		            if(item.getFieldName().equals("surname") && surname == null){
		                byte[] str = new byte[input.available()];
		                input.read(str);
		                surname = new String(str,"UTF8");
		                candidate.setSurname(capitalise(surname));
		            }
		            if(item.getFieldName().equals("dateOfBirth") && dateOfBirth == null){
		                byte[] str = new byte[input.available()];
		                input.read(str);
		                dateOfBirth = new String(str,"UTF8");
		                candidate.setDateOfBirth(dateOfBirth);
		            }
		            if(item.getFieldName().equals("qualification") && qualification == null){
		                byte[] str = new byte[input.available()];
		                input.read(str);
		                qualification = new String(str,"UTF8");
		                candidate.setQualification(qualification);
		            }
		            if(item.getFieldName().equals("pathCv")){
		            	//Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		    		    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    		    String fileName = new File(item.getName()).getName();
		                item.write(new File(UPLOAD_DIRECTORY + fileName));
		    		    System.out.println(fileName);
		    		    System.out.println(UPLOAD_DIRECTORY + fileName);
		            	candidate.setPathCv(UPLOAD_DIRECTORY + fileName);
		            }
		        }
			candidateService.create(candidate);
			currentCandidate = candidateService.read(candidate.getIdCandidate());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("messageFile", "Non hai caricato il CV!");
			request.setAttribute("username", user);
			//request.setAttribute("message", e);
			request.getRequestDispatcher("/candidateCreate.jsp").forward(request, response);
		}

		if (currentCandidate.getSurname() != null) {
			request.setAttribute("message", "Candidato " + candidate.getSurname() + " salvato con successo!");
			// File uploaded successfully
			request.setAttribute("messageFile", "CV caricato con successo!");
			request.setAttribute("username", user);
			request.setAttribute("idCandidate", currentCandidate.getIdCandidate());
			request.setAttribute("surname", currentCandidate.getSurname());
			request.setAttribute("firstTime", "yes");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/EvaluationCreateServlet");
			rd.forward(request, response);
		} else {
			request.setAttribute("username", user);
			request.setAttribute("message", "ERRORE: Creazione candidato non riuscita");
			request.getRequestDispatcher("/candidateCreate.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String user = (String) request.getParameter("user");
		request.setAttribute("username", user);
		request.getRequestDispatcher("/candidateCreate.jsp").forward(request, response);
	}
	
	public static String capitalise(final String word) {
	    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}

}
