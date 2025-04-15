package com.kodilla.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @BeforeEach
    void resetUsersTable() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();

        // Clear dependent data first
        statement.executeUpdate("DELETE FROM POSTS");
        statement.executeUpdate("DELETE FROM ISSUES");

        // Then clean USERS
        statement.executeUpdate("DELETE FROM USERS");

        // Seed USERS table
        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('John', 'Doe')");
        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Jane', 'Smith')");
        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Alice', 'Johnson')");
        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Bob', 'Brown')");
        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Charlie', 'Davis')");

        // Insert issues for users
        ResultSet rs = statement.executeQuery("SELECT ID FROM USERS ORDER BY ID");
        int[] userIds = new int[5];
        int index = 0;
        while (rs.next()) {
            userIds[index++] = rs.getInt("ID");
        }
        rs.close();

        statement.executeUpdate("INSERT INTO ISSUES(SUMMARY, USER_ID_ASSIGNEDTO) VALUES ('Issue 1', " + userIds[0] + ")");
        statement.executeUpdate("INSERT INTO ISSUES(SUMMARY, USER_ID_ASSIGNEDTO) VALUES ('Issue 2', " + userIds[1] + ")");
        statement.executeUpdate("INSERT INTO ISSUES(SUMMARY, USER_ID_ASSIGNEDTO) VALUES ('Issue 3', " + userIds[2] + ")");
        statement.executeUpdate("INSERT INTO ISSUES(SUMMARY, USER_ID_ASSIGNEDTO) VALUES ('Issue 4', " + userIds[3] + ")");
        statement.executeUpdate("INSERT INTO ISSUES(SUMMARY, USER_ID_ASSIGNEDTO) VALUES ('Issue 5', " + userIds[4] + ")");

        statement.close();
    }

    @Test
    void testConnect() throws SQLException {
        // Given
        // When
        DbManager dbManager = DbManager.getInstance();
        // Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        // When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        // Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndTasks() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY\n" +
                "  FROM USERS U\n" +
                "  JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("SUMMARY"));
            System.out.println("Row count: " + counter);
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }
}
