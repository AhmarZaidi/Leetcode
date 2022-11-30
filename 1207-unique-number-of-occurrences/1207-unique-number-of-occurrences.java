class Solution 
{
    public boolean uniqueOccurrences(int[] arr) 
    {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) 
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        
        Set<Integer> freqSet = new HashSet<>(freq.values());
        
        // If the set size is equal to the map size, it implies frequency counts are unique.
        return freq.size() == freqSet.size();
    }
}