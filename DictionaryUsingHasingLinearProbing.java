
enum STATUS {
    OCCUPIED,
    AVAILABLE,
    EMPTY //null
}
class PairWithStatus{
    Pair aPair;
    STATUS status;
    public  PairWithStatus(){
        aPair = new Pair();
        status = STATUS.EMPTY;
    }

    public PairWithStatus(Pair aPair, STATUS status) {
        this.aPair = aPair;
        this.status = status;
    }

}
public class DictionaryUsingHasingLinearProbing {
    final int HASHTABLE_SIZE = 23;
    PairWithStatus arr [] ;
    int size = 0;

    public DictionaryUsingHasingLinearProbing(){
        arr = new PairWithStatus[HASHTABLE_SIZE];
        arr[6] = new PairWithStatus();
        arr[6].aPair.key = 29;
        arr[6].status= STATUS.OCCUPIED;

        arr [9]  = new PairWithStatus();
        arr[9].aPair.key = 32;
        arr[9].status= STATUS.OCCUPIED;

        arr [12]  =new PairWithStatus();
        arr[12].aPair.key = 58 ;
        arr[12].status= STATUS.OCCUPIED;

        arr [21]  = new PairWithStatus();
        arr[21].aPair.key = 21;
        arr[21].status= STATUS.OCCUPIED;


    }
    int hashCode_(int a){
        return a % HASHTABLE_SIZE;
    }
    int getHashIndex(int a){
        int hashIndex = hashCode_(a);

        return hashIndex;

    }
    //
    int probe(int index, int key) { //index is integer value the key
        // Searches the probe sequence that begins at index.
        // Returns the index of either the element
        // containing key or an available element in the hash table.
        boolean found = false;

        while (!found && arr[index].status != STATUS.EMPTY) { //key is not found and hashTable[index] is not null
//            if (arr[index].status != STATUS.AVAILABLE) { //hashTable[index] references an entry in the dictionary
                if (arr[index].aPair.key ==  key) //the entry in hashTable[index] contains key
                    found = true;
                else {
                    index = (index + 1) % HASHTABLE_SIZE;//next probe index
                    found = true;
                }

//            } else // hashTable[index] is available
//            {
//                if (this is the first available element encountered)
//                availableStateIndex = index
//                index = next probe index
//            }
        }

//        if (key is found or an available element was not encountered)
        return index;
//        else
//            return availableStateIndex // Index of first entry removed
    }
    void insert(int key, String value){
//        if(!this.contains(key)){
            //insertion
            Pair newPiar = new Pair(key, value);
            PairWithStatus newPairWithStatus = new PairWithStatus(newPiar, STATUS.OCCUPIED);
            arr[probe(hashCode_(key), key)] = newPairWithStatus;

//            arr[size] = newPair;
            size++;
//        }
        // else, nothing
    }

//    void remove(int key){
//        if(this.contains(key)){
//            for(int i = 0; i < size ; i++) {
//                if (arr[i].key == key)
//                    arr[i] = arr[size - 1];
//            }
//            size--;
//        }
//        // else, nothing
//    }

//    void modify(int key, String value){
//        for(int i = 0; i < size ; i++) {
//            if (arr[i].key == key)
//                arr[i].value = value;
//            //modify
//        }
//    }

//    String lookup(int key){
//        for(int i = 0; i < size ; i++) {
//            if (arr[i].key == key){
//                return arr[i].value;
//            }
//            //modify
//        }
//        return "";
//    }
//    boolean contains(int key){
////        for(int i = 0; i < size ; i++){
//        if(arr[probe(key)].key == key)
//            return true;
////        }
//        return false;
//    }
    public static void main(String[] args) {

        DictionaryUsingHasingLinearProbing aDictionary = new DictionaryUsingHasingLinearProbing(); // built-in Java dictionary
        aDictionary.insert(81, "any value"); // should be inserted at index 13
    }
}
