package week10;


public class Implement_Trie_208 {
    public static void main(String[] args) {
        Implement_Trie_208 foo = new Implement_Trie_208();
        foo.insert("apple");
        System.out.println(foo.startsWith("app"));
    }

    Implement_Trie_208[] children;
    boolean isEnd;

    public Implement_Trie_208() {
        children = new Implement_Trie_208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Implement_Trie_208 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Implement_Trie_208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Implement_Trie_208 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Implement_Trie_208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
