# 学习心得

这是我第一次静下心来学习算法，通过覃超老师的深情讲解，让我明白了算法的重要性，也明白了算法是作为编程人员的内功，算法也是一切系统的基础，它能很好的解决我们生活中的问题，所有编程语言的工具包中都充满着各种算法，所以学好算法有助于我们更好的使用工具，更好的写出高性能的代码，也能更好的理解计算机这个系统。学习算法也是一个枯燥的过程，需要我们坚持练习，不断的精进，才能对算法乐然于心，所以加油吧，开始我们的算法之旅。
# 一、学习方法
## 1、精通一个领域
1. Chunk it up 切碎知识点
 将大的知识点切为多个有联系的知识点
2. Deliberate Practicing 刻意练习
3. Feedback 反馈
    1. 主动反馈
    2. 被动反馈
### 1.1、Chunk it up切分
#### 1.1.1、数据结构切分
1. 一维
    1. 基础：数组array（string），链表linked list
    2. 高级：栈stack，队列queue，双端队列deque，集合set，映射map（hash or map），etc
2. 二维
    1. 基础：树tree，图graph
    2. 高级：二叉搜索树binary search tree（red-black tree，AVL），堆heap，并查集disjoint set，字典树Trie，etc
3. 特殊
    1. 位运算Bitwise，布隆过滤器BloomFilter
    2. LRU Cash
#### 1.1.2、算法切分
1. 基础：
    1. if-else，switch -->branch
    2. for，while loop --> Iteraton
    3. 递归Recursion（Divide &Conquer 分治法，Backtrace回溯法）
2. 高级：
    1. 搜索Search：深度优先搜索Depth first search，广度优先搜索Breadth first search，A*，etc
    2. 动态规划Dynamic Programming
    3. 二分查找Binary Search
    4. 贪心Greedy
    5. 数学Math，几何Geometry
#### 1.1.3、四步切题法
1. clarification 审题
2. possible solutions(compare,optimal) 思考所有可能性，比较答案，找到最优解
3. coding 多写
4. test cases 测试

### 1.2、Deliberate Practicing刻意练习
1. 刻意练习--过遍数（五毒神掌）
2. 练习缺陷、弱点地方
3、不舒服、不爽、枯燥
4. 生活中的例子：乒乓球、台球、游戏等等
#### 1.2.1、五毒神掌学习法
1. 第一遍：
    1. 5-15分钟：读题+思考
    2. 直接看题解：注意！多解法，比较解法优劣（LeetCode题解、国际站的Top Discuss）
    3. 背诵、默写好的解法
2. 第二遍：
    1. 马上自己写-->LeetCode提交
    2. 多种解法比较、体会-->优化
3. 第三遍：
    1. 一天后再进行练习
    2. 不同解法的熟练程度-->专项练习
4. 第四遍：一周后再进行练习，对不熟悉题目进行专项练习
5. 第五遍：面试前一到两周进行恢复性练习

### 1.3、Feedback 反馈
1. 即时反馈
2. 主动型反馈（自己去找）
    1. 高手代码（GitHub，LeetCode，etc）
    2. 第一视角直播
3. 被动式反馈（高手给你指点）
    1. code review
    2. 教练看你打，给你反馈
## 2、编程技巧
1. 电脑设置
    1. Chrome
    2. MAC：Iterm2 + zsh（oh my zsh）
    3. Windows Microsoft New Terminal
    4. VSCode；Java：Idea
2. Code Style：规范自己的编程风格，如：Google code style、Facebook、Airbnb
3. 熟练IDE的使用技巧
    1. home、end（行头、行尾）
    2. Word单词、选单词、选整行
    3. IDE自动补全功能
    4. Top tips for IDE

# 二、知识整理
## 1、递归的理论
### 1.1、递归注意要点
1. 抵制人肉递归的诱惑
2. 找最近重复性，也就是找子问题
3. 数学归纳法思维
### 1.2、递归代码模板
``` java
public void recur(int level, int param){
    //terminator
    if(level > MAX_LEVEL){
        //process result
        return;
    }
    //process current logic
    process(level, param);
    //drill down
    recur(level + 1, newParam);
    //restore current status
}
```

# 三、Array算法总结

## [26_删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

### 方法一 快慢双指针法
> 时间复杂度:O(n)</br>空间复杂度:O(1)

通过快慢双指针i和j，使用i慢指针指向非重复元素下标，实现代码如下：
``` java
 class Solution {
    public int removeDuplicates(int[] nums) {
        //判断0
        if(nums.length == 0){
            return 0;
        }
        int i = 0; //慢指针
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
```

### 方法二 重复数计数
> 时间复杂度:O(n)</br>空间复杂度:O(1)

通过变量count记录重复元素的个数，然后将非重复元素移动到最近一个重复元素位置，实现代码如下：
``` java
class Solution {
   public int removeDuplicates(int[] nums) {
    //判断0
    if (nums.length == 0) {
        return 0;
    }
    int count = 0, len = nums.length;
    for (int i = 1; i < len; i++) {
        if (nums[i] == nums[i - 1]) {
            count++;
        } else {
            nums[i - count] = nums[i];
        }
    }
    return len - count;
}
```

## [1_两数之和](https://leetcode-cn.com/problems/two-sum/)
### 方法一 暴力算法，双层循环
> 时间复杂度:O(n^2)</br>空间复杂度:O(n)

通过2重循环，依次遍历i和i+1的元素，判断是否nums[i] = target - nums[i + 1]，代码如下：
``` java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("参数错误");
    }
}
```
### 方法二 两遍hash法
> 时间复杂度:O(n^2)</br>空间复杂度:O(n)

通过将所有元素都存入hash表中，利用hash表进行降维O(n) -> O(1),但是如果存在hash冲突，则可能变为O(n)，然后比较target-nums[i]是否在hash表中且hash元素的索引不等于i，代码如下：
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //将所有元素放入hash表中
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //获取hash表中的对应元素=target - nums[i] 且 i != hash中存储元素的索引
        for (int i = 0; i < nums.length - 1; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i) {
                return new int[]{i, map.get(key)};
            }
        }
        throw new IllegalArgumentException("参数错误");
    }
}
```
### 方法三 一遍hash法
> 时间复杂度:O(n)</br>空间复杂度:O(n)

逻辑和方法二相同，但是可以在存入hash的同时进行比较，代码如下：
``` java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //一边将元素放入hash表中，
        //一边判断 是否 获取hash表中的对应元素=target - nums[i] 且 i != hash中存储元素的索引
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i - 1], i - 1);
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            }
        }

        throw new IllegalArgumentException("参数错误");
    }
}
```


## [11_盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
### 方法一 双指针夹逼法
> 时间复杂度:O(n)</br>空间复杂度:O(1)

通过左右两边指针i,j，其中i < j，分别将两个指针往内夹逼，分别记录每次移动后的面积，直到i=j为止，另外移动原则为每次移动height小的一块，这样下一次得到的面积才会增加，否则只会减少，所以得到公式：<font color=#0099ff size=3 face="黑体">S(i,j) = Max(Min(h[i],h[j]) * (j - i)) </font>，代码如下：
``` java
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        //S(n) = (j - i) * min(height[i],height[j])
        while (i < j) {
            maxArea = height[i] < height[j] ?
                    Math.max(maxArea, height[i] * (j - i++)) :
                    Math.max(maxArea, height[j] * (j-- - i));
        }
        return maxArea;
    }
}
```
### 方法二 双指针夹逼法-效率最高
> 时间复杂度:O(n)</br>空间复杂度:O(1)

逻辑和方法一相同，减少函数使用
``` java
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        //S(n) = (j - i) * min(height[i],height[j])
        int hi = height[i];
        int hj = height[j];
        int minHeight = hj;
        int weight = j - i;
        while (i < j) {
            if (hi < hj) {
                minHeight = hi;
                i++;
            } else {
                j--;
            }
            int tempArea = weight * minHeight;
            if (maxArea < tempArea) {
                maxArea = tempArea;
            }
        }
        return maxArea;
    }
}
```
## [70_爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
### 方法一 暴力递归
> 时间复杂度:O(2^n)</br>空间复杂度:O(n)

该问题为一个斐波拉契数列，f(n) = f(n-1) + f(n-2)，所以可以使用递归方法，代码如下：
```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```
### 方法二 动态规划-缓存数组
> 时间复杂度:O(n)</br>空间复杂度:O(n)

使用缓存数组，将每一步走过的步数都存储下来，代码如下：
``` java
class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;
        //使用数组将每步都记录下来
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
```
### 方法三 动态规划-降低空间
> 时间复杂度:O(n)</br>空间复杂度:O(1)

使用2个变量记录前两步的步数，代码如下：
``` java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        //使用变量记录之前的2步结果
        int i = 1;
        int j = 2;
        int result = 0;
        for (int k = 2; k < n; k++) {
            result = i + j;
            i = j;
            j = result;
        }
        return result;
    }
}
```
### 方法四 公式
> 时间复杂度:O(logn)</br>空间复杂度:O(1)

斐波拉契数列公式推导太复杂了，只知道公式是：<font size=3 color=#0099ff face=黑体>Fn=1/sqrt(5)*[((1 + sqrt(5)) / 2)^(n+1) - ((1 - sqrt(5)) / 2)^(n+1)]</font>，代码如下:
```java
class Solution {
    public int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fn = (Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1));
        return (int) (fn / sqrt_5);
    }
}
```
### 方法五 暴力递归-缓存
> 时间复杂度:O(n)</br>空间复杂度:O(n)

使用递归，但是使用缓存存储已走过的部署，代码如下:
```java
class Solution {
public int climbStairs(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    return climbStairsRecur(n, map);
}

private int climbStairsRecur(int n, Map<Integer, Integer> map) {
    if (n < 3) return n;
    if (map.containsKey(n)) return map.get(n);
    int m = climbStairsRecur(n - 1, map) + climbStairsRecur(n - 2, map);
        map.put(n, m);
        return m;
    }
}
```
### 方法六 动态规划-降低空间-简洁版
> 时间复杂度:O(n)</br>空间复杂度:O(1)

使用2个变量记录前两步的步数，但是只使用一个变量，代码如下:
``` java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        //使用变量记录之前的2步结果
        int pre = 1;
        int result = 2;
        for (int k = 2; k < n; k++) {
            pre = (result += pre) - pre;
        }
        return result;
    }
}
```
## [283_移动零](https://leetcode-cn.com/problems/move-zeroes/)
### 方法一 两层循环-双指针
> 时间复杂度:O(n^2)</br>空间复杂度:O(1)

两层循环分两步，第一步，先将原数组的非0元素前移，第二步，在数组末尾赋0
``` java
class Solution {
     public void moveZeroes(int[] nums) {
        //先将原数组的非0元素前移
        nt j = 0;
        or (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        //将0元素补入数组尾部
        for (int i = j; i < nums.length; i++) {
          nums[i] = 0;
        }
    }
}
```
### 方法二 一层循环
> 时间复杂度:O(n)</br>空间复杂度:O(1)

通过快排的思想，使用双指针i,j，j指向0元素，当遇到非0元素就交互第一个0元素位置，代码如下：
``` java
class Solution {
    public void moveZeroes(int[] nums) {
        //使用i,j两个指针，i指向非0元素，j指向第一个0元素，遇到非零就swap空间
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] != 0) {
               nums[j++] = nums[i];
               nums[i] = 0;
           }
       }
    }
}
```
### 方法三：一层循环-变种
> 时间复杂度:O(n)</br>空间复杂度:O(1)

和方法二一样，只是重点记录非0元素
```java
class Solution {
    public void moveZeroes(int[] nums) {
        //使用i,j两个指针，i指向非0元素，j指向第一个0元素，遇到非零就swap空间
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else if (j > 0) {
                nums[i - j] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
```

## [15_三数之和](https://leetcode-cn.com/problems/3sum/)
### 方法一 三重循环
> 时间复杂度:O(n^3)</br>空间复杂度:O(1)

使用暴力方法，三重循环，但是需要使用Set进行去重，代码如下：
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        //因为结果唯一，不能重复，所以使用set集合
        Set<List<Integer>> set = new LinkedHashSet<>();
        //a + b = -c
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List list = Arrays.asList(nums[i], nums[j], nums[k]);
                        //排序结果，用于去重
                        list.sort(Comparator.naturalOrder());
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
```
### 方法二 两重暴力+hash
> 时间复杂度:O(n^2)</br>空间复杂度:O(n)

使用hash进行降维，但是也需要考虑去重结果，代码如下：
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        //因为结果唯一，不能重复，所以使用set集合
        Set<List<Integer>> set = new LinkedHashSet<>();
        //a + b = -c
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i]; //-c
            Map<Integer, Integer> map = new HashMap(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j]; //a = -c - b
                Integer exist = map.get(v);
                if (exist != null) {
                    List list = Arrays.asList(nums[i], exist, nums[j]);
                    //排序结果，用于去重
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                } else {
                    //将nums.length - i个元素放入hash中
                    //存储b，由于a和b都是以同一个数组，所以，这里的b就相当于a
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
```
### 方法三 双指针夹逼法
> 时间复杂度:O(n^2)</br>空间复杂度:O(1)

固定3个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引(k, len(nums))(k,len(nums))两端，通过双指针交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合，[详解参考地址](https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/)，代码如下：
```java
/**
 * 方法二 2层遍历-双指针夹逼法
 * 时间复杂度：O（n^2）
 * 空间复杂度：O（1）
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> set = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; //最小元素不能大于0
            if (k > 0 && nums[k] == nums[k - 1]) continue; //去除重复元素
            int i = k + 1, j = nums.length - 1; //双指针 i < j
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]); //去除重复元素,并右移i
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]); //去除重复元素,并左移j
                } else {
                    set.add(Arrays.asList(nums[k] , nums[i] , nums[j]));
                    while (i < j && nums[i] == nums[++i]); //去除重复元素,并右移i
                    while (i < j && nums[j] == nums[--j]); //去除重复元素,并左移j
                }
            }
        }
        return new ArrayList<>(set);
    }
}
```
# 四、LinkedList算法
## [206_反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
### 方法一 迭代
> 时间复杂度:O(n)</br>空间复杂度:O(1)

通过一个pre节点来交换链表的next方向，代码如下：
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        //通过pre和cur节点来交换两个节点的next的方向
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //保存一下个节点
            ListNode nextTemp = cur.next;
            //交换next节点
            cur.next = pre;
            //再将节点切换到下一个节点
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
}
```

### 方法二 递归
> 时间复杂度:O(n)</br>空间复杂度:O(n)

通过递归的方式，从链表尾到头的顺序将next调转，代码如下：
``` java
class Solution {
    public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode cur = reverseList(head.next);
        //调转指向
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
```
### 方法三 递归-增加前节点参数
> 时间复杂度:O(n)</br>空间复杂度:O(n)

通过2个参数的递归反正，代码如下：
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseListRecur(head, null);
    }

    public ListNode reverseListRecur(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        //调转指向
        head.next = newHead;
        return reverseListRecur(head.next, head);
    }
}
```
### 方法四 魔幻化双指针
> 时间复杂度:O(n)</br>空间复杂度:O(1)

定义指针 cur，初始化为 head，然后cur = head.next.next，实现一次反转，然后cur和head.next都同时再移动一个位置，循环上述过程直到到底终点，代码如下：
``` java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while (head.next != null){
            ListNode tempNode = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = tempNode;
        }
        return cur;
    }
}
```
## [24_两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
### 方法一 递归
每次递归都处理2个节点，并进行交互，代码如下：
``` java
/**
 * 方法一 递归
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swapPairsRecur(head);
    }
    private ListNode swapPairsRecur(ListNode head) {
        //终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //swap的处理顺序永远是依次处理=右边的变量
        //每次处理2个节点,所以这里要缓存一个节点,且进行反转
        ListNode nextNode = head.next;
        //子函数返回head.next.next节点
        head.next = swapPairsRecur(nextNode.next);
        //让第二个节点指向第一个节点
        nextNode.next = head;
        //返回子链表
        return nextNode;
    }
}
```
### 方法二 迭代
我们把链表分为两部分，即奇数节点为一部分，偶数节点为一部分，A 指的是交换节点中的前面的节点，B 指的是要交换节点中的后面的节点。在完成它们的交换，我们还得用 preNode 记录 A 的前驱节点。
``` java
/**
 * 方法二 迭代
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
        //用于存储头节点
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode preNode = dump;
        //终止条件
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            //开始交换节点
            preNode.next = secondNode;  //preNode指向前驱节点
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            //初始化head和preNode节点
            preNode = firstNode;
            head = firstNode.next; //jump
        }
        return dump.next;
    }
}
```
## [21_合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
### 方法一 迭代
> 时间复杂度：O（n）
> 空间复杂度：O（1）

我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点向后移一位
``` java
/**
 * 方法一 迭代
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode preNode = newHead;
        while (l1 != null && l2 != null) {
            //依次比较2个链表的元素大小,小的next -> 大的节点；大的节点指向
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        //将最后不为空的节点合并就可以了
        preNode.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
```

### 方法二 递归
> 时间复杂度：O（n）
> 空间复杂度：O（n）

如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
```java
/**
 * 方法三 递归-简洁
  * 时间复杂度：O（n）
  * 空间复杂度：O（n）
  */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
           //终止条件
          if (l1 == null || l2 == null) return l2 == null ? l1 : l2;
          ListNode smaller = l1.val < l2.val ? l1 : l2;
          smaller.next = mergeTwoLists(smaller.next, smaller == l2 ? l1 : l2);
          return smaller;
    }
}
```

## [141_环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
### 方法一 哈希hash
> 时间复杂度：O（n）
> 空间复杂度：O（n）

我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
```java
/**
 * 方法一 hash
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
```
### 方法二 双指针
> 时间复杂度：O（n）
> 空间复杂度：O（1）

现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
``` java
/**
 * 方法二 快慢指针
  * 时间复杂度：O（n）
  * 空间复杂度：O（1）
  */
public class Solution {
    public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode slowNode = head;
    ListNode fastNode = head.next;
    while (slowNode != fastNode) {
    //终止条件
    if (fastNode == null || fastNode.next == null) {
        return false;
    }
        slowNode = slowNode.next;
    fastNode = fastNode.next.next;
    }
          return true;
    }
}
```

## [142_环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
### 方法一 hash
> 时间复杂度：O（n）
> 空间复杂度：O（n）

如果我们用一个 `Set` 保存已经访问过的节点，我们可以遍历整个列表并返回第一个出现重复的节点
```java
/**
 * 方法一 hash
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
```

### 方法二 Floyd算法
> 时间复杂度：O（n）
> 空间复杂度：O（1）

floyd 的算法被划分成两个不同的 _阶段_ 。在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 `null` 并退出。否则，用 `相遇节点` 来找到环的入口。[详细解法参考](https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/)
```java
/**
 * 方法二 Floyd算法
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slowNode = head, fastNode = head;
        while (true) {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) break;
        }
        fastNode = head;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }
}
```
#  五、栈、队列
## [20_有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
### 方法一  stack+hash
> 时间复杂度：O（n）
> 空间复杂度：O（1）

通过将左括号压入栈中，当遇到右括号时匹配栈顶括号是否匹配，匹配则出栈，不匹配则退出。
```java
/**
 * 方法一 stack
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                Character top = stack.isEmpty() ? '$' : stack.pop();
                if (!top.equals(map.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

```

## [155_最小栈](https://leetcode-cn.com/problems/min-stack/)
### 方法一  辅助栈和数据栈同步
> 时间复杂度：O（1）
> 空间复杂度：O（n）

使用栈和数据同步栈来做核心，代码如下：
``` java
/**
 * 方法一 辅助栈和数据栈同步
 * 时间复杂度：O（1）
 * 空间复杂度：O（n）
 */
class MinStack {
    private Deque<Integer> deque;
    private Stack<Integer> minStack;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        deque = new LinkedList<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        this.deque.addFirst(x);
        if (!minStack.isEmpty() && minStack.peek() < x) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(x);
        }
    }
    public void pop() {
        this.deque.removeFirst();
        this.minStack.pop();
    }
    public int top() {
        return this.deque.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
```
### 方法二  辅助栈和数据栈不同步
> 时间复杂度：O（1）
> 空间复杂度：O（n）

使用栈和数据不同步栈来做核心，代码如下：
``` java
/**
 * 方法二 辅助栈和数据栈不同步
 * 时间复杂度：O（1）
 * 空间复杂度：O（n）
 */
class MinStack {
    private Deque<Integer> deque;
    private Deque<Integer> minDeque;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        deque = new LinkedList<>();
        minDeque = new LinkedList<>();
    }
    public void push(int x) {
        deque.addFirst(x);
        if (minDeque.isEmpty() || minDeque.peek() >= x) {
            minDeque.addFirst(x);
        }
    }
    public void pop() {
        if (!deque.isEmpty()) {
            int top = deque.removeFirst();
            if (top == minDeque.peekFirst()) {
                minDeque.removeFirst();
            }
        }
    }
    public int top() {
        if (deque.isEmpty()) {
            throw new RuntimeException("当前栈为空");
        }
        return deque.peekFirst();
    }
    public int getMin() {
        if (minDeque.isEmpty()) {
            throw new RuntimeException("当前栈为空");
        }
        return minDeque.peekFirst();
    }
}
```
## [84_柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)
### 方法一 暴力求解
> 时间复杂度：O（n^2）
> 空间复杂度：O（1）
```java
/**
 * 方法一 暴力求解
 * 时间复杂度：O（n^2）
 * 空间复杂度：O（1）
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            //向右找当大于等于当前柱子高的下标
            int right = i;
            while (right < heights.length - 1 && height <= heights[right + 1]) right++;
            //向左找当大于等于当前柱子高的下标
            int left = i;
            while (left > 0 && height <= heights[left - 1]) left--;
            int width = right - left + 1;
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}
```
### 方法二 栈
> 时间复杂度：O（n）
> 空间复杂度：O（n）
```java
/**
 * 方法二 栈
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        //为了便于用同一公式计算宽度
        //通过栈来存储右边边界，即height[i]>=height[i+1]
        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i]; //防止下标越界
            //当到达右边边界时,依次计算从最大高度到最低高度的面积，随着高度较低，宽度也会同时增加
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int cur = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peekFirst() - 1;
                res = Math.max(res, width * heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
```
### 方法三 array-模拟栈
> 时间复杂度：O（n）
> 空间复杂度：O（n）
```java
/**
 * 方法三 array-模拟栈
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] stack = new int[heights.length + 1];
        int index = -1;
        //通过栈来存储右边边界，即height[i]>=height[i+1]
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            //当到达右边边界时,依次计算从最大高度到最低高度的面积，随着高度较低，宽度也会同时增加
            while (index != -1 && heights[stack[index]] > height) {
                int curHeight = heights[stack[index--]];
                int width = index == -1 ? i : i - stack[index] - 1;
                res = Math.max(res, width * curHeight);
            }
            stack[++index] = i;
        }
        return res;
    }
}

```
# 六、哈希、映射
## [49_字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
### 方法一  排序+hash
> 时间复杂度：O（NKlogK）
> 空间复杂度：O（NK）

```java
/**
 * 方法一 排序+hash
 * 时间复杂度：O（NKlogK）
 * 空间复杂度：O（NK）
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) return Collections.emptyList();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //对每个单词排序，并放入hash的key进行存储
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```
### 方法二  array + 计数分类
> 时间复杂度：O（NK）
> 空间复杂度：O（NK）

```java
/**
 * 方法二 array + 计数分类
 * 时间复杂度：O（NK）
 * 空间复杂度：O（NK）
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) return Collections.emptyList();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            //这里利用异位词中相同的字母-'a'得到相同数字，即数组下标相同，从而得到count数组相同
            for (char c : str.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString(); //所以这里的异位词的key相同
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```

## [242_有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
### 方法一 暴力- 排序+对比
> 时间复杂度：O（NlogN）
> 空间复杂度：O（1）

```java
/**
 * 方法一 暴力- 排序+对比
 * 时间复杂度：O（NlogN）
 * 空间复杂度：O（1）
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);
    }
}

```
### 方法二 array+出现次数
> 时间复杂度：O（n）
> 空间复杂度：O（1）

```java
/**
 * 方法二 array+出现次数
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] chars = new int[26]; //记录26个字母
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int c :chars){
            if(c != 0) return false;
        }
        return true;
    }
}
```
### 方法三 array+出现次数
> 时间复杂度：O（n）
> 空间复杂度：O（1）

```java
/**
 * 方法三 array+出现次数
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] chars = new int[26]; //记录26个字母
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
            if(chars[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
```
### 方法四 hash+出现次数
> 时间复杂度：O（n）
> 空间复杂度：O（1）

```java
/**
 * 方法四 hash+出现次数
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}
```