/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import java.util.*;

/**
 *
 * @author user 
 */
public class Main {
    public static void main(String[] args)
    {
       ReadFile f = new ReadFile();
       f.openFile();
       f.readText();
       f.closeFile();
    }

}
