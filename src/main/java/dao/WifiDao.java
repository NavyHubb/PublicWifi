package dao;

import domain.WifiInfo;

import java.sql.*;

public class WifiDao {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";  // jdbc 드라이버 주소
    static final String DB_URL = "jdbc:mariadb://172.30.1.23:3306/testdb1"; // DB 접속 주소
    //localhost는 접속하려는 데이터베이스 주소를 입력하시면 됩니다. localhost를 사용하면 됩니다.
    //3306은 데이터베이스에 접속할때 사용하는 포터번호입니다. 설치할때 설정한 포트번호를 사용합니다.
    //yourWeather에는 접속하려는 database의 name을 입력해줍니다.
    static final String USERNAME = "testuser1"; // DB ID
    static final String PASSWORD = "zerobase"; // DB Password

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    // VillageWeather객체를 입력받으면 객체안의 속성에 초기화된 데이터들을 데이터베이스에 인설트하는 메소드입니다.
    public void insertWifiInfo(WifiInfo w) {
        String query = "INSERT INTO wifi"
                + " VALUE(" + "'0'" +",'"+w.getAdminNumber() + "','" + w.getBorough()
                + "','" + w.getWifiName() + "','" + w.getRoadName()+"','"
                +w.getDetailAddress() +"','" +w.getInstallPosition() + "','"
                + w.getInstallType() + "','" + w.getInstallAgency()+ "','"
                + w.getServiceType() + "','" + w.getNetType() + "','"
                + w.getInstallYear()+"','" + w.getInOutDoorType() + "','"
                + w.getWifiConnEnv()+"','" + w.getPosX() +"','" + w.getPosY()
                + "','" + w.getDateTime() +"');";
//                + "ON DUPLICATE KEY UPDATE admin_number=" + w.getAdminNumber() + ";";
        System.out.print("PublicWifi Database 접속 : ");
        try {
            //데이터베이스에 접속합니다.
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            // 데이터베이스 접속 결과를 출력합니다.
            if (conn != null){System.out.println("성공");}
            else{System.out.println("실패");}

            System.out.println(query); // 실행될 쿼리문을 출력합니다.

            stmt = conn.createStatement(); // 쿼리문을 전송할 Statement 객체를 만듭니다.
            stmt.executeUpdate(query);// 쿼리문을 실행시킵니다.
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exection");
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }

    public void truncateWifiInfo() {
        String query = "truncate wifi;";
        System.out.print("PublicWifi Database 접속 : ");
        try {
            //데이터베이스에 접속합니다.
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            // 데이터베이스 접속 결과를 출력합니다.
            if (conn != null){System.out.println("성공");}
            else{System.out.println("실패");}

            System.out.println(query); // 실행될 쿼리문을 출력합니다.

            stmt = conn.createStatement(); // 쿼리문을 전송할 Statement 객체를 만듭니다.
            stmt.executeUpdate(query);// 쿼리문을 실행시킵니다.
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exection");
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }
}
