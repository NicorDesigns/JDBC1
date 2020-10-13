package com.nicordesigns;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class DriverManagerAppTest
{

    private final DriverManagerApp driverManagerApp = new DriverManagerApp();

    @BeforeEach
    void setUpDBConnection() {
        driverManagerApp.setDbms("mariadb");
        driverManagerApp.setUserName("root");
        driverManagerApp.setPassword("secret");
        driverManagerApp.setServerName("localhost");
        driverManagerApp.setPortNumber("3306");
        driverManagerApp.setDbName("charityDB");
    }
    @Test
    void testDBConnection() {
        try (Connection sqlConnection = driverManagerApp.getConnection()) {
            System.out.println("SQL Connection Catalog: " + sqlConnection.getCatalog());
            assertEquals("charityDB", sqlConnection.getCatalog());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

}
