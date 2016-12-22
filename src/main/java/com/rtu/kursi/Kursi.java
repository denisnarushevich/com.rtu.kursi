/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rtu.kursi;
import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author dnarushevich
 */
public class Kursi {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:./coursedb", "user", "");
        
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet tbls = meta.getTables(null, null, "COURSE", null);
        if(!tbls.next()){
            Statement statement = conn.createStatement();
            String createQuery = "CREATE TABLE COURSE (ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_82CB5ECF_D8F9_477A_BC3A_379B2F6E04BB)  NOT NULL GENERATED ALWAYS AS IDENTITY, \"NAME\" VARCHAR(255), AUTHOR VARCHAR(255), PLACE VARCHAR(255), MAX_SEATS INTEGER, DATE_FROM VARCHAR(255), DATE_TO VARCHAR(255), PRIMARY KEY (ID));";
            String insertQuery = "INSERT INTO COURSE (\"NAME\", AUTHOR, PLACE, MAX_SEATS, DATE_FROM, DATE_TO) VALUES ('Informacijas Sistemu Metodologijas', 'Marite Kirikova', 'RTU', 32, '01.09.2016', '22.12.2016');";
            String insertQuery2 = "INSERT INTO COURSE (\"NAME\", AUTHOR, PLACE, MAX_SEATS, DATE_FROM, DATE_TO) VALUES ('Lietiska Datorgrafika', 'Pavels Rusakovs', 'RTU', 16, '01.09.2016', '22.12.2016');";
            statement.execute(createQuery);
            statement.execute(insertQuery);
            statement.execute(insertQuery2);
            statement.close();
        }
        conn.close();
        
        MainFrame frame;
        frame = new MainFrame();
        frame.setVisible(true);
    }
}
