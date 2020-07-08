package info;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "pt", urlPatterns = { "/pt" })
public class PoolTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
  
    public PoolTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Context initCtx = new InitialContext();
			Context envCtx =(Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl1");
			conn = ds.getConnection();
			System.out.println("Ä¿³Ø¼Ç Ç®·Î ºÎÅÍ Ä¿³Ø¼Ç°´Ã¼¸¦ °¡Á®¿È.");
			
			// Äõ¸®¹® ¼öÇà
			
			
			// Ä¿³Ø¼Ç °´Ã¼ ¹Ý³³
			conn.close();
			System.out.println("Ä¿³Ø¼Ç °´Ã¼ ¹Ý³³");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ä¿³Ø¼Ç °´Ã¼ ¾ò¾î¿À±â ½ÇÆÐ"+e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
