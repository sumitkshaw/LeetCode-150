class RandomizedSet {
  public boolean insert(int val) {
    if (valToIndex.containsKey(val))
      return false;
    valToIndex.put(val, vals.size());
    vals.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!valToIndex.containsKey(val))
      return false;
    final int index = valToIndex.get(val);
    valToIndex.put(last(vals), index);
    valToIndex.remove(val);
    vals.set(index, last(vals));
    vals.remove(vals.size() - 1);
    return true;
  }

  public int getRandom() {
    final int index = rand.nextInt(vals.size());
    return vals.get(index);
  }
  private Map<Integer, Integer> valToIndex = new HashMap<>();
  private List<Integer> vals = new ArrayList<>();
  private Random rand = new Random();

  private int last(List<Integer> vals) {
    return vals.get(vals.size() - 1);
  }
}
