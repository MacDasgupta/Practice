package DailyCodingProblem;

public class WordEncoding {
    public static void main(String[] args) {
        String s="AAAABBBCCDAA";
        encodeWord(s);
    }
    static void encodeWord(String s){
        String encodeWord="";
        char prevLetter='\0';
        int count=1;
        for(int i=1;i<s.length();i++){

            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                if(count>=1)
                    encodeWord+=count;
                encodeWord+=s.charAt(i-1);
                count=1;
            }

        }
        if(count>=1)
            encodeWord+=count;
        encodeWord+=s.charAt(s.length()-1);
        System.out.println("The encoded value is : "+encodeWord);
    }

}
