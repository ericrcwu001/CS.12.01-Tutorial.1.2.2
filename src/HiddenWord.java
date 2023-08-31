public class HiddenWord {
    private String hiddenWord;

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase();
    }

    public String getHiddenWord() {return hiddenWord;}

    public String getHint(String guess) {
        if (!(guess.equals(guess.toUpperCase()))) {
            throw new IllegalArgumentException("Your guess ( "+guess+" ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }
        if (guess.length() != hiddenWord.length()) {
            throw new IllegalArgumentException("Your guess ( "+guess+" ) has 7 characters. The hidden word has 9 characters. Your guess must be a word with 9 characters!");
        }
        String hint = "";
        for (int i = 0; i < guess.length(); ++i) {
            char guessLetter = guess.charAt(i);
            boolean present = false, same = false;
            for (int j = 0; j < hiddenWord.length(); ++j) {
                if (guessLetter == hiddenWord.charAt(j)) {
                    present = true;
                    if (i == j) same = true;
                    break;
                }
            }

            if (same) {
                hint += guess.charAt(i);
            } else if (present) {
                hint += "+";
            } else {
                hint += "*";
            }
        }
        return hint;
    }

}
