# leetcode_java学习笔记

配合cs61b和普林斯顿算法食用更香哦~

## 第一节：[链表](https://github.com/jinzijian/leetcode_java/tree/master/lists)

链表是最基础的数据结构，具有插入删除等无需移动元素且无需事先估计存储空间的特点，但缺陷是无法随机访问任意元素，只能通过遍历的方法来访问。

链表题的基础在于对节点的保存和重定向，常用的技巧为虚拟头结点和双指针方法。

（1）首先我们从一道双指针问题开始：[LeetCode 876 寻找链表的中点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

**这道题的重点在于链表长度分别为奇数和偶数时如何处理，当为偶数时如何根据题意控制中点位置。**

具体解答如下：[jzj Github Solutions](https://leetcode-cn.com/problems/middle-of-the-linked-list/)