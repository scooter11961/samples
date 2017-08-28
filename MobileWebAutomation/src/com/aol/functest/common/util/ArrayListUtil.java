/**
 * 
 */
package com.aol.functest.common.util;

import java.util.ArrayList;

/**
 * @author freebeachler
 *
 */
public class ArrayListUtil
{

   public static String toString(ArrayList<?> in, String delim) {
      if (null == in) {
         return null;
      }
      StringBuilder out = new StringBuilder();
      if (0 < in.size()) {
         out.append(in.get(0).toString());
      }
      for (int i = 1; i < in.size(); i++) {
         out.append(delim).append(in.toString());
      }
      return out.toString();
   }
}
