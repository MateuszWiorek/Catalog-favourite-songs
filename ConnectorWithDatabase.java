package com.wiorekmateusz;
import java.sql.*;
import java.util.List;
import java.util.Vector;

public class ConnectorWithDatabase {
    String data = "jdbc:mysql://localhost:3306/favouritesongs";
    ResultSet rec;
    FavouriteSongsList song = new FavouriteSongsList();

    public List<FavouriteSongs> viewAll() {
        try (
                Connection conn = DriverManager.getConnection(data, "root", "");
                Statement st = conn.createStatement()) {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    rec = st.executeQuery(
                        "SELECT id, title, author, link FROM songs ORDER BY author");
                    zapiszJakoWektor();
                    st.close();
                return song.listaPiosenek;
        } catch (SQLException sqle) {
            System.out.println(new StringBuilder().append("Błąd SQL").append(sqle.toString()).append(" ").append(sqle.getErrorCode()).append(" ").append(sqle.getSQLState()).toString());
        } catch (Exception ioe) {
            System.out.println(new StringBuilder().append("ee").append(ioe.getMessage()).toString());
        }
    return null;
    }


public List<FavouriteSongs> searchByTitle(String searchingTitle){
    try(
            Connection conn = DriverManager.getConnection(data, "root","");
            Statement st = conn.createStatement()){
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                rec = st.executeQuery(
                        "SELECT id, title, author, link FROM songs WHERE title LIKE '%"+searchingTitle +"%'ORDER BY author");
                zapiszJakoWektor();
                st.close();
            return song.listaPiosenek;
    }catch (SQLException sqle){
        System.out.println("Błąd SQL" + sqle.toString()+" " + sqle.getErrorCode()+ " " + sqle.getSQLState());
    } catch (Exception ioe){
        System.out.println("ee");
    }
    return null;
}

public  List <FavouriteSongs> searchByAuthor(String searchingAuthor) {
    try (

            Connection conn = DriverManager.getConnection(data, "root", "");
            Statement st = conn.createStatement()) {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                rec = st.executeQuery(
                    "SELECT id, title, author, link FROM songs WHERE author LIKE '%" + searchingAuthor + "%' ORDER BY author");
                zapiszJakoWektor();
                st.close();
            return song.listaPiosenek;
    } catch (SQLException sqle) {
        System.out.println("Błąd SQL" + sqle.toString() + " " + sqle.getErrorCode() + " " + sqle.getSQLState());
    } catch (Exception ioe) {
        System.out.println("ee");
    }
    return null;
}


    private void zapiszJakoWektor() throws SQLException{
        while (rec.next()){
            FavouriteSongs song1 = new FavouriteSongs();
            song1.setId((Integer.parseInt(rec.getString(1))));
            song1.setTitle( rec.getString(2));
            song1.setAuthor(rec.getString(3));
            song1.setLink(rec.getString(4));
            song.addToListaPiosenek(song1);
        }
    }



    public void addToDatabase (String songTitle, String songAuthor, String songLink){
        try (
                Connection conn = DriverManager.getConnection(data, "root", "");){
                    PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO songs(title,author,link)"+
                        "VALUES(?,?,?)");
                ps.setString(1,songTitle);
                ps.setString(2,songAuthor);
                ps.setString(3,songLink);
                ps.executeUpdate();
                ps.close();
                conn.close();

        } catch (SQLException sqle) {
            System.out.println("Błąd SQL" + sqle.toString() + " " + sqle.getErrorCode() + " " + sqle.getSQLState());
        } catch (Exception ioe) {
            System.out.println("ee");
        }
    }

}