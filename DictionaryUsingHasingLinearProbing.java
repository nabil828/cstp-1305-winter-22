public class DictionaryUsingHasingLinearProbing {
    final int HASHTABLE_SIZE = 23;
    Pair arr []  = new Pair [HASHTABLE_SIZE];
    int size = 0;
    public DictionaryUsingHasingLinearProbing(){
        arr[6].key = 29;
        arr[9].key = 32;
        arr[12].key = 58 ;
        arr[21].key = 21;

    }
    int hashCode_(int a){
        return a % HASHTABLE_SIZE;
    }
    int getHashIndex(int a){
        int hashIndex = hashCode_(a);

        return hashIndex;

    }

    //
    void probe(int index, int key){
//        // Searches the probe sequence that begins at index. Returns the index of
//                either the element
//        // containing key or an available element in the hash table.
//                while (key is not found and hashTable[index] is not null) {
//                    if (hashTable[index] references an entry in the dictionary) {
//                        if (the entry in hashTable[index] contains key)
//                        Exit loop
//            else
//                        index = next probe index
//                    } else // hashTable[index] is available
//                    {
//                        if (this is the first available element encountered)
//                        availableStateIndex = index
//                        index = next probe index
//                    }
//                }
//                if (key is found or an available element was not encountered)
//                return index
//        else
//                return availableStateIndex // Index of first entry removed
    }
    void insert(int key, String value){
        if(!this.contains(key)){
            //insertion
            Pair newPair = new Pair(key, value);
            arr[size] = newPair;
            size++;
        }
        // else, nothing
    }

    void remove(int key){
        if(this.contains(key)){
            for(int i = 0; i < size ; i++) {
                if (arr[i].key == key)
                    arr[i] = arr[size - 1];
            }
            size--;
        }
        // else, nothing
    }

    void modify(int key, String value){
        for(int i = 0; i < size ; i++) {
            if (arr[i].key == key)
                arr[i].value = value;
            //modify
        }
    }

    String lookup(int key){
        for(int i = 0; i < size ; i++) {
            if (arr[i].key == key){
                return arr[i].value;
            }
            //modify
        }
        return "";
    }
    boolean contains(int key){
        for(int i = 0; i < size ; i++){
            if(arr[i].key == key)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {

        DictionaryUsingHasingLinearProbing aDictionary = new DictionaryUsingHasingLinearProbing(); // built-in Java dictionary
        aDictionary.insert(81, "any value"); // should be inserted at index 13
    }
}
