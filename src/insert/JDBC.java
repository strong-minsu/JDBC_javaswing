package insert;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBC {

    // Expense 추가
    public static void addExpense(Integer userId, Integer expense, Date expenseDate,
                                  String content, String category, Integer accountId){

        String sqlInsert_expense = "INSERT INTO saengji.expense(userId, expense, expenseDate, content, category, accountId)"
                + "VALUES(?,?,?,?,?,?)";

        Connection conn2 = null;

        try (Connection conn = JDBC_Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert_expense);
        ){

            conn.setAutoCommit(false);

            conn2 = conn;

            pstmt.setInt(1, userId);
            pstmt.setInt(2, expense);
            pstmt.setDate(3, expenseDate);
            pstmt.setString(4, content);
            pstmt.setString(5, category);
            pstmt.setInt(6, accountId);

            int rowAffected = pstmt.executeUpdate();

            if(rowAffected == 1) {
                conn.commit();
            }
            else {
                conn.rollback();
            }

        } catch (SQLException ex) {
            try{
                if(conn2 != null)

                    conn2.rollback();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

            System.out.println(ex.getMessage());

        }
    }


    // Income 추가
    public static void addIncome(Integer userId, Integer income, Date incomeDate,
                                 String content, String category, Integer accountId){

        String sqlInsert_income = "INSERT INTO saengji.income(userId, income, incomeDate, content, category, accountId)"
                + "VALUES(?,?,?,?,?,?)";

        Connection conn2 = null;

        try (Connection conn = JDBC_Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert_income);
        ){

            conn.setAutoCommit(false);

            conn2 = conn;

            pstmt.setInt(1, userId);
            pstmt.setInt(2, income);
            pstmt.setDate(3, incomeDate);
            pstmt.setString(4, content);
            pstmt.setString(5, category);
            pstmt.setInt(6, accountId);

            int rowAffected = pstmt.executeUpdate();

            if(rowAffected == 1) {
                conn.commit();
            }
            else {
                conn.rollback();
            }

        } catch (SQLException ex) {
            try{
                if(conn2 != null)

                    conn2.rollback();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

            System.out.println(ex.getMessage());
        }
    }
}