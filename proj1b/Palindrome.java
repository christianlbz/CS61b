public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        if (word == null){
            return null;
        } else{
            LinkedListDeque deque = new LinkedListDeque();
            for (int i = 0;i < word.length(); i++){
                deque.addLast(word.charAt(i));
                }
            return deque;
        }
    }

    public boolean isPalindrome(String word){
        if (word == ""){
            return true;
        }
        else if (word.length() == 1){
            return true;
        } else{
            Deque temp = wordToDeque(word);
            return recursiveDeque(temp);
        }

    }

    public boolean recursiveDeque(Deque dq){
        if(dq.size() <= 1){
            return true;
        }
        else if (dq.get(0) == dq.get(dq.size()-1)){
            dq.removeLast();
            dq.removeFirst();
            return recursiveDeque(dq);
        }
        else{
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator f){
        Deque dq = new Palindrome().wordToDeque(word);
        return  recursiveDeque(dq,f);
    }

    public boolean recursiveDeque(Deque<Character> dq,CharacterComparator f) {
        if (dq.size() == 1 | dq.size() == 0) {
            return true;
        } else {
            char first = dq.get(0);
            char last = dq.get(dq.size() - 1);
            int diff = Math.abs(first - last);
            if (diff == 0 | f.equalChars(first, last)) {
                dq.removeLast();
                dq.removeFirst();
                return recursiveDeque(dq,f);
            } else {
                return false;
            }
        }
    }
}
