import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class SendServlet extends HttpServlet{
	

		public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
			JSONArray req= new JSONArray();
			int type = Integer.parseInt(request.getParameter("type"));
			 JSONLoader temp = new JSONLoader();
			 try {
				req = temp.read_json(type);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.setCharacterEncoding("UTF-8");
			 response.setContentType("text/html");
			 response.getWriter().write(req.toString());
				
		}

		
	
}
