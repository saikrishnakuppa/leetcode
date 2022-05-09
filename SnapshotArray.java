import java.util.TreeMap;

public class SnapshotArray {

    TreeMap<Integer, Integer>[] snapshotArray;
    int snap_id;

    public SnapshotArray(int length) {
        this.snapshotArray = new TreeMap[length];
        this.snap_id = 0;
        for (int i = 0; i < length; i++) {
            snapshotArray[i] = new TreeMap<>();
            snapshotArray[i].put(0, 0);
        }
    }

    public void print() {
        for(TreeMap<Integer, Integer> a : this.snapshotArray)
            System.out.println(a);
    }

    public void set(int index, int val) {
        snapshotArray[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return snapshotArray[index].floorEntry(snap_id).getValue();
    }
    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        snapshotArr.print();
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.print();
        snapshotArr.set(0,6);
        snapshotArr.print();
        System.out.println(snapshotArr.get(0,0));
        snapshotArr.print();

    }
}
