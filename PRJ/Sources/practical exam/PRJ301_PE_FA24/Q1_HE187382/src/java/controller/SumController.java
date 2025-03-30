/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh Cuong
 */
public class SumController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String numString = request.getParameter("num");

        try {
            int num = Integer.parseInt(numString);
            if (num <= 1) {
                out.print("You input wrong");
            }
            out.print(sumPrime(num));

        } catch (NumberFormatException e) {
            out.print("You input wrong");
        }
    }

    private int sumPrime(int n) {
        int sum = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
