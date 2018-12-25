package util;

import java.security.*;
/**
 *    Copyright (C) 2003 Alberto Gimeno
 *
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * @author Alberto Gimeno
 * @version 1.0
 */

public class MD5 {

    /**
     * Metodo que te da el hash MD5 en un String en caracteres
     hexadecimales
     * @param data Cadena de la cual queremos calcular el hash MD5
     * @param key Clave que emplearemos en el calculo del hash.
     * @return Un String con el valor resultante del hash en caracteres
     hexadecimales
    */
    public static String digest(String data, String key) {
        try{
            //Generamos un objeto MessageDigest que implementa el algoritmo MD5
            //esto puede lanzar una NoSuchAlgorithmException si el algoritmo
            //no está soportado. Pero se supone que esto nunca ocurrirá
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //Actulizamos el digest
            md5.update(data.getBytes());
            //En ocasiones se quiere aplicar una clave al algoritmo, esto
            //se consigue actualizando el digest con los bytes de la clave
            //Esto se utiliza por ejemplo en el método de autentificación
            //APOP de POP3 en el que a una marca de tiempo (timestamp)
            //se le aplica el algorimto MD5 con la contraseña de usuario
            //como clave.
            //En el protocolo MSN el método de autentificación es similar
            //Realmente obtendremos el mismo resultado si concatenamos
            //los datos y la clave y asumimos la clave como una
            //cadena de longitud cero. Esto se puede comprobar en el ejemplo del main()
            byte[] result =  md5.digest(key.getBytes());
            //Creamos un StringBuffer donde guardaremos el hash como caracteres
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<result.length; i++){
                //Obtenemos el string correspondiente al byte
                String s = Integer.toHexString(result[i]);
                int length = s.length();
                //Si es de dos dígitos o más
                //añadimos los dos últimos dígitos
                //El byte representado en hexadecimal tendrá más de dos
                //caracteres si es negativo, por ejemplo. Pero
                //a nosotros sólo nos interesan los dos últimos caracteres
                if(length >= 2)
                    sb.append(s.substring(length - 2, length));
                //Si es de solo un dígito añadimos un 0 y el dígito.
                else {
                    sb.append("0");
                    sb.append(s);
                }
            }
            //Finalmente devolvemos un String con el contenido del StringBuffer
            return sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            //esto ocurre si el algoritmo MD5 no está soportado
            return null;
        }
    }

    /**
     * Ejemplo de uso de la funcion digest().
     * Este ejemplo lo he cogido de
     * <a href="http://www.rfc-es.org/rfc/rfc1939-es.txt">http://www.rfc-es.org/rfc/rfc1939-es.txt</a>, pagina 15
     */
    public static void main(String[] args) {
        //String data = "<1896.697170952@dbc.mtview.ca.us>";
        //String key = "tanstaaf";
        String dataTeo = "paladinpgfiis";
        String key = "";
        System.out.println("Ejemplo hash MD5");
        System.out.println("Este ejemplo lo he cogido de<http://www.rfc-es.org/rfc/rfc1939-es.txt>, página 15");
        System.out.println("\tdata :  "+dataTeo);
        System.out.println("\tkey  :  "+key);
        System.out.println("\thash :  "+digest(dataTeo, key));

        System.out.println("Podemos comprobar que el resultado es el mismo con lossiguientes datos:");
        dataTeo = dataTeo + key;
        key = "";
        System.out.println("\tdata :  "+dataTeo);
        System.out.println("\tkey  :  "+key);
        System.out.println("\thash :  "+digest(dataTeo, key));
        
        System.out.println("\totro hash :  "+getMD5toString(dataTeo));
    }
    
	/**
	 * @param input
	 * @return
	 * @link http://www.spiration.co.uk/post/1199
	 */
	public static String getMD5toString (String input) {
		String output = null;
		byte[] defaultBytes = input.getBytes();
		try{
		     MessageDigest algorithm = MessageDigest.getInstance("MD5");
		     algorithm.reset();
		     algorithm.update(defaultBytes);
		     byte messageDigest[] = algorithm.digest();
		                     
		     StringBuffer hexString = new StringBuffer();
		     for (int i = 0; i < messageDigest.length; i++) {
		    	 String hex=Integer.toHexString(0xff & messageDigest[i]);
		    	 if (hex.length() == 1) {
		    		 hexString.append('0');
		    	 }
		         hexString.append(hex);
		     }
		     output = hexString.toString();
		}
		catch(NoSuchAlgorithmException nsae) {
		                     
		}
		return output;
	}
}
