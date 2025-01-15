//@author Luis Encinas
package model;

public class OurHashMap<K, V> implements OurMap<K, V> {
	private class HashNode {
		private K key;
		private V value;

		private HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static int TABLE_SIZE = 100;
	private OurLinkedList<HashNode>[] lists;

	public OurHashMap() {
		lists = new OurLinkedList[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			lists[i] = new OurLinkedList();
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < TABLE_SIZE; i++) {
			result += " " + lists[i].toString() + "\n";
		}
		return result;
	}

	private int getIndex(K key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode % TABLE_SIZE);
	}

	public V put(K key, V value) {
		int index = getIndex(key);
		OurLinkedList<HashNode> currentList = lists[index];
		int currLength = currentList.size();
		for (int i = 0; i < currLength; i++) {
			HashNode node = currentList.get(i);
			if (node.key.equals(key)) {
				V oldValue = node.value;
				node.value = value;
				return oldValue;
			}
		}
		currentList.addFront(new HashNode(key, value));
		return null;
	}

	public int size() {
		int count = 0;
		for (int i = 0; i < lists.length; i++) {
			count += lists[i].size();
		}
		return count;
	}

	public V get(K key) {
		int index = getIndex(key);
		OurLinkedList<HashNode> currentList = lists[index];
		int currLength = currentList.size();
		for (int i = 0; i < currLength; i++) {
			HashNode node = currentList.get(i);
			if (node.key.equals(key)) {
				return node.value;
			}
		}

		return null;
	}

	public boolean containsKey(K key) {
		int index = getIndex(key);
		OurLinkedList<HashNode> currentList = lists[index];

		for (int i = 0; i < currentList.size(); i++) {
			HashNode node = currentList.get(i);
			if (node.key.equals(key)) {
				return true;
			}
		}

		return false;
	}

}
