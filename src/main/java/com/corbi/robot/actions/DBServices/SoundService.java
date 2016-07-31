/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbi.robot.actions.DBServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * a class, that delivers path to soundfiles and takes care of the sound table
 *
 * @author Stiglmair
 */
public class SoundService {

    private final String TABLENAME;
    private final Connection con;

    protected SoundService(String DBNAME, Connection con) {
        TABLENAME = DBNAME + ".SOUNDS";
        this.con = con;
    }

    /**
     * returns a path to a requested soundfile
     *
     * @param name the argument that is given in order to play the sound
     * @return the path to the requested soundfile
     * @throws SQLException
     */
    public String getPath(String name) throws SQLException {
        PreparedStatement statement = con.prepareStatement("SELECT path FROM " + TABLENAME
                + " WHERE name=?");
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        //returns path, if it exists; otherwise throws SQLException
        result.next();
        String path = result.getString("path");
        statement.close();
        return path;

    }

    /**
     * increments the total amount of requests for a soundfile
     *
     * @param name identifier for a soundfile
     * @throws SQLException
     */
    public void incrementRequestAmount(String name) throws SQLException {
        PreparedStatement statement = con.prepareStatement("UPDATE " + TABLENAME
                + " SET amount_requests = amount_requests + 1"
                + "WHERE name=?");
        statement.setString(1, name);
        DBService.execute(statement);
    }

}