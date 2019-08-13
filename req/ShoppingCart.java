import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShoppingCart extends HttpServlet
{
   public void doPost (HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
   {
     HttpSession session = req.getSession (true);     		// Get session object
      ArrayList cart = (ArrayList) session.getAttribute ("cart");	 // Get the cart
if (cart == null)		 // if the session is new, the cart won't exist.
      {
         cart = new ArrayList ();
         session.setAttribute ("cart", cart);
      }
     res.setContentType ("text/html");
      PrintWriter out = res.getWriter ();
     String[] itemsSelected= req.getParameterValues ("it");    // Retrieve Form Data
      String itemName;
    if (itemsSelected != null)        // if items selected, add them to the session object.
     {
        for (int i=0; i<itemsSelected.length; i++)	 // Loop through selected items
         {
            itemName = itemsSelected[i];
            cart.add (itemName);
         }
      }
     out.println ("<HTML>");			// Print current contents of Cart
     out.println ("<HEAD>");
      out.println (" <TITLE>Shopping Cart Contents</TITLE>");
      out.println ("</HEAD>");
      out.println ("<BODY>");
      out.println ("<H1>Items currently in your Shopping Cart</H1>");
      out.println ("<HR>");   
      for(int i=0;i<cart.size(); i++)
      {
        out.println(cart.get(i));
      }
      out.println ("<HR>");
      out.println ("<P>");
     out.print   ("<A HREF=\"ShoppingCart.html\" >Back to the shop </A>");      
      out.println ("</P>");
      out.println ("</BODY>");
      out.println ("</HTML>");
      out.close();
   } // End doPost()
}
