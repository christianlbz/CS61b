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
}
