public class Homework2 {

    /**
     *
     * @param p
     * @param k int between 0 and p.length
     * @param c character that will replace char at index k
     * @return
     * @throws Exception
     */
    public  String replaceChar(String p, int  k,  char  c) throws Exception {
        if (k >= p.length()) throw new Exception("Error: the int entered is greater than the length of the string.");
        String output = "";
        for(int i = 0; i < p.length(); i++){
            if (i == k){
                output = output.concat(Character.toString(c));
            } else {
                output = output.concat(Character.toString(p.charAt(i)));
            }
        }
        return output;
    }
}
