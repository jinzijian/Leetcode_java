# leetcode_java学习分享

## 第一节：[链表](https://github.com/jinzijian/leetcode_java/tree/master/lists)

链表是最基础的数据结构，具有插入删除等无需移动元素且无需事先估计存储空间的特点，但缺陷是无法随机访问任意元素，只能通过遍历的方法来访问。

链表题的基础在于对节点的保存和重定向，常用的技巧为虚拟头结点和双指针方法。

链表题一般递归法和迭代法都可以解决，但是不推荐递归法因为效率不高—递归法可作为自己递归思路的练习

常考的题型是反转链表

（1）首先我们来看一道反转链表的题——LeetCode 206 [反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

​         经典中的经典——一定要背下来！！！

​	同类型拓展题：

​		LeetCode 092

​		LeetCode 206

（2）接下来我们看一道双指针问题：[LeetCode 876 寻找链表的中点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

**这道题的重点在于链表长度分别为奇数和偶数时如何处理，当为偶数时如何根据题意控制中点位置。**

具体解答如下：[jzj Github Solutions]([https://github.com/jinzijian/leetcode_java/blob/master/01%20LinkedLists/876%20%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%82%B9%20%E5%BF%AB%E6%85%A2%E6%8C%87%E9%92%88%E6%B3%95/solution.java](https://github.com/jinzijian/leetcode_java/blob/master/01 LinkedLists/876  链表中点 快慢指针法/solution.java))

双指针题目比较灵活所以还是要多刷多看

同类型拓展题：

​		LeetCode 141——很重要

​		LeetCode 142——很重要

​		LeetCode 328——比较特别

（3）最后我们看一道反转和双指针综合的题目 [LeetCode 234](https://leetcode-cn.com/problems/palindrome-linked-list/)

​		思路：先找中点，再反转，再比较