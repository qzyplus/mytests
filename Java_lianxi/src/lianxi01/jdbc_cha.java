package lianxi01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc_cha {
	
	private final static String DRIVER="com.mysql.jdbc.Driver";	//���ݿ���������
	private final static String URL="jdbc:mysql:///myschool";		//���ӵ�ַ           
	private final static String USERNAME="root";				//�û���
	private final static String PASSWORD="123";				//����
	private static Connection con=null;						//���ݿ����Ӷ���
	public static void main(String[] args) throws Exception {
		selectData();
	}
	public static void selectData() throws Exception {
		Class.forName(DRIVER);
		//��ȡ���Ӷ���
		con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		//����prepareStatement����
		String sql="SELECT count(*) from `subjects` where fenshu>?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 81);
		ResultSet rs = ps.executeQuery();
	     while(rs.next()){
			System.out.println("����81������"+rs.getInt(1)+"����");
		}
		
	}
}
