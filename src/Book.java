
class Book {
    private String name, author, publisher, ISBN;

    Book(String[] info){
        if(info.length < 4) return;

        this.name      = info[0];
        this.author    = info[1];
        this.publisher = info[2];
        this.ISBN      = info[3];
    }

    String[] getAll(){
        return new String[]{name, author, publisher, ISBN};
    }

    boolean isMatchs(String[] word){
        boolean isMatch = true;

        if(word[0].length() > 0){
            isMatch = name.contains(word[0]);
        }
        if(word[1].length() > 0 && isMatch){
            isMatch = author.contains(word[1]);
        }
        if(word[2].length() > 0 && isMatch){
            isMatch = publisher.contains(word[2]);
        }
        if(word[3].length() > 0 && isMatch){
            isMatch = ISBN.contains(word[3]);
        }

        return isMatch;
    }
}
