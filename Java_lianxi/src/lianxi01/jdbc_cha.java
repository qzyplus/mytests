package lianxi01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc_cha {
	
	private final static String DRIVER="com.mysql.jdbc.Driver";	//数据库驱动名称
	private final static String URL="jdbc:mysql:///myschool";		//连接地址           
	private final static String USERNAME="root";				//用户名
	private final static String PASSWORD="123";				//密码
	private static Connection con=null;						//数据库连接对象
	public static void main(String[] args) throws Exception {
		selectData();
	}
	public static void selectData() throws Exception {
		Class.forName(DRIVER);
		//获取连接对象
		con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		//创建prepareStatement对象
		String sql="SELECT count(*) from `subjects` where fenshu>?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 81);
		ResultSet rs = ps.executeQuery();
	     while(rs.next()){
			System.out.println("大于81的人有"+rs.getInt(1)+"个。");
		}
		
	}
}
