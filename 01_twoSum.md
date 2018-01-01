###问题描述：
- 给定一个整数数组和一个目标整数，要求找出数组中两个元素的和等于目标整数，并返回这两个元素的索引  
例：<pre>Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].</pre>
答案一：<pre> //for循环嵌套 
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("no result");
    }
</pre> 
答案二：<pre>  //使用基于hash表的map，提高检索效率
	  //先全部放到map，然后再遍历
public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int tmp=target-nums[i];
            if(map.containsKey(tmp)&&map.get(tmp)!=i){
                return new int[]{i,map.get(tmp)};
            }
        }
        throw new RuntimeException("no result");
    }</pre>
答案三：<pre>  //使用基于hash表的map，put的时候检索map中是否已存在
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("no result");
}</pre>	

----------
Java基础技术点：  
1. 结束方法的执行  
   a>return语句  
   b>throw Exception （抛出异常没有catch的情况）  
2. for循环嵌套解决多维遍历问题  
3. hash表的特点：  
   &emsp;大大降低数据的存储和查找消耗的时间，几乎可以看成是常数时间；而代价是消耗比较多的内存。所以在可利用内存比较多的情况下，用空间换时间的做法是值得的。另外，编码比较容易也是它的特点之一。 

>拓展：关于对For循环嵌套优化的问题  
>  
	for (int i = 0; i < 1000; i++)  
    	for (int j = 0; j < 100; j++)  
        	for (int k = 0; k < 10; k++)  
            	testFunction (i, j, k);    
   
  方案一: 
<pre> for (int i = 0; i < 10; i++)  
     for (int j = 0; j < 100; j++)  
         for (int k = 0; k < 1000; k++)  
             testFunction (k, j, i);
</pre> 
理由：将循环次数最少的放到外面，循环次数最多的放里面，这样可以最大程度的减少相关循环变量的实例化次数、初始化次数、比较次数、自增次数，另外，从虚拟机执行指令的角度，大循环在外所需要执行的指令数量大于大循环在内所需要执行的指令数量，所以此方案效率较高  
方案二：  
<pre> int i, j, k;  
    for (i = 0; i < 10; i++)  
        for (j = 0; j < 100; j++)  
            for (k = 0; k < 1000; k++)  
                testFunction (k, j, i);
</pre>  
理由：在方案一的基础上，将循环变量的实例化放到循环外，这样可以进一步减少相关循环变量的实例化次数