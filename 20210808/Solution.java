class Solution {
    public int singleNumber(int[] nums) {
        
        int n = (nums.length + 2)/3;
        
        Pair[] table = new Pair[n];
        
        inputTable(nums, table);
        
        for (int i = 0; i < table.length; i ++) {
            if (table[i].value == 1) {
                return table[i].key;
            }
        }
        
        return 0;
    }
    
    public void inputTable (int[] nums, Pair[] table) {
        for (int i = 0; i < nums.length; i ++) {
            inputTable (nums[i], table);
        }
    }
    
    public void inputTable (int number, Pair[] table) {
        int hashed = Math.abs(number % table.length);
        
        System.out.print(hashed);
        
        int i = 0;
        
        while (!(table[(hashed + i) % table.length] == null || table[(hashed + i) % table.length].key == number)) {
            i ++;
        }
        
        if (table[(hashed + i) % table.length] == null) {
            table[(hashed + i) % table.length] = new Pair(number, 1);
        } else {
            table[(hashed + i) % table.length].value ++;
        }
        
    }
    
    
    class Pair {
        public int key;
        public int value;
        
        public Pair (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
