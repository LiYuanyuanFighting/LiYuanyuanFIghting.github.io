 **How to check if two words are anagrams**  
 a simple fast O(n) solution without using sorting or multiple loops or hash maps   
 class AnagramsFaster{
    
        private static boolean compare(String a, String b){
            char[] aArr = a.toLowerCase().toCharArray(), bArr = b.toLowerCase().toCharArray();
            if (aArr.length != bArr.length)
                return false;
            int[] counts = new int[26]; // An array to hold the number of occurrences of each character
            for (int i = 0; i < aArr.length; i++){
                counts[aArr[i]-97]++;  // Increment the count of the character at i
                counts[bArr[i]-97]--;  // Decrement the count of the character at i
            }
            // If the strings are anagrams, the counts array will be full of zeros
            for (int i = 0; i<26; i++)
                if (counts[i] != 0)
                    return false;
            return true;
        }
    
        public static void main(String[] args){
            System.out.println(compare(args[0], args[1]));
        }
    }
