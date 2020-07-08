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
			System.out.println("Ŀ�ؼ� Ǯ�� ���� Ŀ�ؼǰ�ü�� ������.");
			
			// ������ ����
			
			
			// Ŀ�ؼ� ��ü �ݳ�
			conn.close();
			System.out.println("Ŀ�ؼ� ��ü �ݳ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ��ü ������ ����"+e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
