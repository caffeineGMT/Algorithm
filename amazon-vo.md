# Amazon VO 算法面经

## VO cheatsheet

Coded

1. 3sum\(fix 1 ptr, then 2sum\)
2. Random Pick with Weight\(prefixSum + binary search\)
3. write a function that 50% return 1, 50% return 0. follow up: utilize the function you just wrote, write another function 75% return 1 and 25% return 0 \(bit\) \([https://massivealgorithms.blogspot.com/2016/08/generate-0-and-1-with-25-and-75.html](https://massivealgorithms.blogspot.com/2016/08/generate-0-and-1-with-25-and-75.html)\)
4. \(bonus\) input is a TreeNode. update all the node values with the sum of its all children \(in-order traversal, update self from left and right, return sum\)
5. Minimum Path Sum \(dp on matrix\)
6. Simplify Paths\(split + stack\)
7. Pow\(x,y\) \(divideConquer / bit\)
8. Evaluate Division \(graph dfs\)
9. Minimum Genetic Mutation \(bfs / dfs, same as word ladder\)
10. First Unique Character in a String \(2 pass map, can be optimized based on different scenario in both space and time\)
11. Interval List Intersections\(merge 2 sorted list + max & min for start and end\)
12. Count Good Nodes in Binary Tree\(preorder dfs\)
13. Non-overlapping Intervals\(reverse thinking + sort based on end + dp\)
14. Design HashMap\(bucket + linkedlist\)
15. Bulls and Cows\(hashmap, 1 pass, look before\)
16. Copy List with Random Pointer \(similar to clone graph \| O\(1\) space: change in-place, copy, then rewind\)
17. Happy Number \(set / list cycle I O\(1\) space\)
18. Design In-Memory File System \(trie-like structure\)
19. Design File System\(same as trie\)
20. Search Suggestions System \(trie search\)
21. Subarray Sum Equals K \(prefix sum\)
22. partition label \(greedy, shoot far, expand window, slide window\)
23. Longest Univalue Path \(l, r, leftMost, rightMost, global\)
24. Top K Frequent Words \(pq: minheap, lexicographically bigger\)
25. Daily Temperatures \(push when t\[stack.peek\(\)\] &gt;= t\[i\], pop otherwise, remember push the last one in after popping\)
26. Single Element in a Sorted Array \(binary search, l &lt; r exit, remember to use clean boundary as we move mid instead of normal template\)
27. Insert Delete GetRandom O\(1\) \(\)
28. 
Reviewed

1. Robot Bounded In Circle \(dir = \(dir + 3\) % 4 / dir = \(dir + 1\) % 4\)
2. Rotting Oranges \(same as walls and gates, start from rotten oranges and keep fress counts\)
3. Most Common Word\(replaceAll, split, set\)
4. Find Peak Element \(nums\[mid\] &gt; nums\[mid + 1\], go to left, else go to right\)

## 1

[https://www.1point3acres.com/bbs/thread-763755-1-1.html](https://www.1point3acres.com/bbs/thread-763755-1-1.html)

25 分鐘 BQ: 1. beyond manager expectation 2. most challenging project 面試官會從你講的故事繼續問問題

25 分鐘Coding: 1. write a function that 50% return 1, 50% return 0 follow up: utilize the function you just wrote, write another function 75% return 1 and 25% return 0 2. 力口時舞 3. \(bonus\) input is a TreeNode. update all the node values with the sum of its all children

## 2.

[https://www.1point3acres.com/bbs/thread-763418-1-1.html](https://www.1point3acres.com/bbs/thread-763418-1-1.html)

1：3 BQ + 1 coding 算法是贰零零的变种（BFS） 2. 3BQ + OOD 设计一个游戏。每个玩家有一定数量的卡，每张卡有不同颜色和数字。根据不同的积分策略去决定winner。提示是考虑如何计算根据策略计算积分并比较出winner和未来积分策略的增添性 3 2BQ + Coding

算法没找到对应的题号。input是有一个dictionary， 每个字母pattern有一些dependency。 然后有一个给定了一个最后的一个字母pattern。 给出其中一种顺序能够到达A的。 比如dictionary: A -&gt; \[B\], B-&gt; \[C, D\], C-&gt;\[\], D-&gt;\[\] 到达点是A. 其中一种正确结果是\[D C B A\] follow up： 你的解法什么时候会出错。如何出错怎么去解决 4. 纯BQ。

BQ都是常规题。如tight/miss deadline; most chanlleng/sinificant, simple solution to resolve complex, hard to debug, disagree opinioin, give a new approach/idea which the team agrees/doesn't agree with...

## 3.

[https://www.1point3acres.com/bbs/thread-760977-1-1.html](https://www.1point3acres.com/bbs/thread-760977-1-1.html)

关于VO：全程用Amazon chime开摄像头面试，coding的场会受到一个写代码的链接，system design可以自己用一个画图网站，然后分享屏幕 每场半小时的BQ，半小时的technical。三场technical是coding，一场system design coding 1: 设计一个文件查找的数据结构和API coding 2: Leetcode的word break 1和2 coding 3: fizz buzz题与多线程（进程）优化 sys design: 设计气象数据收集与显示的服务器

每场都是两个BQ，一个BQ大概讲10-15分钟。我用的所有的故事素材都是过去两三年的工作经验，面试前反复在练习和回忆这些场景，在面试的时候面试官会对你讲的某一些部分进行深挖，问很多细节，比如你具体做了什么，是什么算法之类的。

整个技术面试的过程，都比较注意沟通，包括拿到问题后先问clarification question，确定要做什么之后，告诉对方我要开始写了，而且我会用这种方法写。很多时候当我说完方法后，对方没有回应，或者说cool，这并不意味着我要用的方法是最高效的，但也要把代码写好并且写正确。写的过程中面试官会一直在检查code，有一些细节的错误会给你指出来，写完后会问你有没有什么地方可以优化。

## 4. 

{% embed url="https://www.1point3acres.com/bbs/thread-761371-1-1.html" %}

设计book store 

rotate array

 job generator 

写一个iterator，按给定的比例生成list of string 比如\[foo, bar\]比例\[1:1\]，总量500 那就返回250个foo和250个bar

follow up是用iterator节约内存

节约内存就是给定一个counter，这个counter根据范围来返回string， 比如\[0, 100\]返回foo \[100, 200\]返回bar 这样就不需要生成一个200长度的数组，O\(1\) SPACE

## 5.

[https://www.1point3acres.com/bbs/thread-761571-1-1.html](https://www.1point3acres.com/bbs/thread-761571-1-1.html)

Round 1: System Design, Principle Engineer \(Scale & Operational\) 先自我介绍，然后问了两题 LP，接下来是设计停车场

Round 2: Coding, BI Data Engineer \(Problem Solving\) 自我介绍，两题 LP，哩扣舞酒

Round 3: LP, Hiring Manager

* not able to meet the commitments
* Tell me a time that I strongly disagreed with sth and had to compromise
* a time that I suggested sth outside my responsibilities

最后问题的时候，我问 HM 这个职缺的之后的 project 有什么，他说他大概会把我跟其他资深工程师 pair \(希望是好迹象?\)

Round 4: Coding, SDE L5 \(Functional\) 自我介绍，两题 LP，哩扣衣舞舞，用 Amazon Go 包装的 哩扣漆毵尔，问 Amazon Go 在某个时间点最多人同时在商店的数量是多少

Round 5: Coding, SDE L6 \(Logical & Maintainable\) 自我介绍，两题 LP 第一题 Coding: [https://www.geeksforgeeks.org/a-data-structure-question](https://www.geeksforgeeks.org/a-data-structure-question) 我给两个解法 a\) MinHeap, MaxHeap 这样 GetMax, GetMin 是 O\(1\) 但 DeleteMin, DeleteMax 是 O\(n\) b\) BST, int min, int max, 这样 GetMax, GetMin 是 O\(1\), DeleteMin, DeleteMax 是 O\(log n\) 面试官叫我写 a 解法，说要看我写多一点 code 第二题 Coding: [https://www.geeksforgeeks.org/flattening-a-linked-list/](https://www.geeksforgeeks.org/flattening-a-linked-list/) 我给的解法跟连结差不多

## 6. 

[https://www.1point3acres.com/bbs/thread-761643-1-1.html](https://www.1point3acres.com/bbs/thread-761643-1-1.html)

第一轮设计一个根据用户浏览历史推荐商品的系统

第二轮OOD，写一个input\(\)一个check\_prefix\(\), check\_prefix要求return之前有input单词prefix的数量

第三题coding给出一个binary tree要你return left view 比如 1 3 6 4 5 7 return \[1, 3, 4, 7\]

第四题要求把一个sentence里面的cost reduce by 15% 比如 "1 can of pepsi costs $2" -&gt; "1 can of pepsi costs $1.7" 后面follow up问你如何handle不同的数字format

## 7.

{% embed url="https://www.1point3acres.com/bbs/thread-762446-1-1.html" %}



1. 设计个能同时控制多个repo的git系统
2. [https://www.geeksforgeeks.org/taxicab-numbers/](https://www.geeksforgeeks.org/taxicab-numbers/)
3. [https://leetcode.com/discuss/int](https://leetcode.com/discuss/int) ... pular-page-sequence

系统设计：类似prime video加广告

然后除了第一轮是个hispanic小哥以外另外三轮都是烙印面的。

个人觉得技术面的没太大问题，从头到尾不需要任何提示就能想出算法写好代码，也没有人让我code enhancement，follow up也能秒答也没被人纠过错。除了有一面写着写着漏了一行被面试官提醒才补上，然后读txt文件的api我忘了，直接和面试官说清楚了这块不记得具体怎么写了，就写的伪代码，就这一行。题目本身也不难，基本上都是各种排列组合的可能性存到hashmap里面就能出最优结果。系统设计题目还是我以前工作内容接触过的东西。而且我听说技术面的不好的会发降级offer是不？

我估计就是behavioral挂的，不过我之前花了挺长时间掏空脑袋想例子，每个都用STAR format写了稿，还搜了好多据说是原题的题找人mock interview来着，面试的时候也确认了基本没押错题。但还是过不了，让我对自己讲故事的能力产生了深深的怀疑…… 话说有什么奇技银巧能拿到feedback不，我recruiter嘴咬得很紧不肯给我说，谢谢大家

## 8.

{% embed url="https://www.1point3acres.com/bbs/thread-762149-1-1.html" %}

第一轮：天竺manager System Design Amazon Locker + BQ 大哥很面善，follow up指向性很强，比如问系统怎么实时监控各个locker的状态，就加个heart beat机制就可以

第二轮：白人manager 计算两个日期是否在30天之内 + BQ 这题明显自己编的，输入是两个Date类型的object，其实有点无聊，但是注意要考虑leap year问题。

第三轮：白人principal dev LRU + BQ 没啥特别的，复杂度问的比较具体

第四轮：天竺小哥dev number of island 进阶版 + BQ 我也没见过原题，可能是我刷题有点少。就是一个N\*M矩阵，每个点的value代表这个点的高度，问能trap water的最大连通面积是多大，就是DFS就可以了

平均每轮BQ都是20 ~ 25分钟，就那些常规的问题，比如收到过什么critical feedback，miss deadline，犯过什么错误之类的。

## 9.

[https://www.1point3acres.com/bbs/thread-762097-1-1.html](https://www.1point3acres.com/bbs/thread-762097-1-1.html)

1. 现在工作内容，个人背景介绍（注意说的内容，因为面试官会从这些内容开始深扒。。。）
2. Leadership Principle Questions

   Tell me about a case when you and your teammates had different solutions to the work

   Tell me about a case that you overcame challenging situation at work

   Tell me about a case that you had a hard decision to make

   Tell me about a case that you had a simple solution to the a complex question

   Tell me about a case that you had to work with incomplete information or data

3. Coding

Given two n-ary trees and a sum, write a function that will find all combinations. Please define the data structure that will present in the tree. Eample:

```text
             1                          5
           2  3                      2  6
                 4        
  Sum: 9
  Output: (3, 6), (4, 5)
```

{% embed url="https://4.反馈以及提问" %}

## 10

{% embed url="https://www.1point3acres.com/bbs/thread-760976-1-1.html" %}

OA2: 给出一条包含'_'和'\|'的String\(比如说这样_\|**\|**_**\|**_\)，和两个index，返回index内，被包含在在两个\|的\*的数量 VO1:用任意一种高级语言实现linux find功能，可以find任何pattern的文件名，和文件大小 VO2:给出一个word list，检查每个词可不可以由list里其他\(两个或以上\)词合成，返回可被合成的数量 VO3:纯bq VO4:有n个卡片，正反面各有一个字母，在给出一个词，问卡片能不能拼出给出的词

## 11.

[https://www.1point3acres.com/bbs/thread-760868-1-1.html](https://www.1point3acres.com/bbs/thread-760868-1-1.html)

1. 设计push notification。 说说有什么难点。。瞎扯
2. 一个2d数组每个都有一棵树和一个随机的数。 一个松鼠每次只能上下左右跳去比现在的数小和相等的树。 问最多可以爬过多少棵树。可以从任意地方开始。
3. 从最简单的cache开始一步一步根据面试官的要求优化，最后自己选择写LRU还是LFU。。 我没出息的写了LRU。。这轮我感觉最重要是沟通明白面试官想要啥。默写LRU是蛮不重要的
4. 一个根据客户浏览记录推荐货品的题。记得不是太清楚。 input是两个数组， 就是浏览记录一定要出现在货品之前。 用了一个hashmap 和两个pointer解决。 记忆中类似merge linkedlist的题。偏easy的题

## 12

{% embed url="https://www.1point3acres.com/bbs/thread-760782-1-1.html" %}

一共4轮coding，基本上每轮BQ/LP用了一半时间吧。题都不难，也基本上没有什么follow up。 1. 问了两道dp，说完思路后让选一道写。选了第一个。 1. 向右下走的min path sum， followup 有障碍物 2. 0/1 matrix， 求1组成“+”形状的长度 2. unix file system。 3. k most freq 4. 不记得题目了。。。题目不难，十几分钟做完，之后的时间都用来聊天了

## 13.

{% embed url="https://www.1point3acres.com/bbs/thread-760835-1-1.html" %}

考了一道design， 设计一个student ID系统，给学生分配1到无限的ID，然后学生毕业之后回收ID，有新的学生注册的时候给可以用的最小的ID。

然后是两道behavioral questions，因为HR说的是technical screening所以没准备，这是最头痛的。

## 14.

{% embed url="https://www.1point3acres.com/bbs/thread-760851-1-1.html" %}

1， 类似 求tree的 root 到 leaf 节点的 最远距离， 但给的 input 是 一个 child--&gt; parent 数组， 以及 每个 parent 往下传递 所需要的 cost 一开始 我理解 错了 以为要求 到所有节点的 cost 和 最后 搞清了 是 只求 最远的那个 值

2， inorder traversal tree,. 需要用iterative, 就是 用个stack.. 这一轮很奇怪， 面窝的是一个 sdm 重点是 放在 怎么写comment上。。就是要把 逻辑步骤写清楚

3， 类似 吴玲伞 但也是 简单版 不是circular的 没有就-1。。。

4， system design, 这轮又来一个 sdm, 都没让我画图， 就是空口说， 设计一个 统计 的 query 返回 ： 商品， 或 类别 在 不同仓库的 库存之类的信息 每个 商品 有不同的 分类 类似 book 下 有 textbook, cookbook 等， 主要 重点 放在了 怎么scale 上， 说假设 同样的 system 要scale 10X的load 哪里是 最主要的 bootleneck, 然后 怎么 检查 每个 server 的 performance 之类的。。 然后 如果发现有机器 突然慢了 怎么办。。 这轮 基本就在胡说 因为 我之前没做过。。

bq 方面就是 高频的 那几个， 没有meet dead line；negetive feedback from boss；自学某个 知识 最后用在 工作上的 most challenge project之类的

总的 来说 code不难 甚至有点简单。。。design 就真的没办法了。。但似乎 不一定 这一轮不好就 完全没机会了。。

我这边 5点面完 负责我的 recuiter 7点就打电话 来， 我想说 挂人这么快的吗 周末都不让人过了。，，， 然后 说是要约我跟 supply chain 的dirctor和 hm 做个information call, 我问是不是要加面， 他说不是 就是一个普通的 聊天 聊聊 每个组用的 tech stack之类的 ，，然后 说了一个口头的包（我本来觉得可能 可以降级险过，但是他说base 160k那应该就是 还是sde2 吧） 但没说有offer， 我问了 朋友, 似乎就是 过了的意思。。希望是这样.

## 15.

{% embed url="https://www.1point3acres.com/bbs/thread-756932-1-1.html" %}

三轮代码➕bq,一轮系统设计。 design tiny url coding总结一下，基本都是变了一点的刷题网题 电话那道题，但是变种，给一个字典里面有valid的words,其实很简单，就做一个check就好了。 merge两个list，有重复，从小到大， 结果数组不能有重复。问两个stream怎么办。 第三题怎么都想不起来了，应该写下来的，但是关于queue的。如果我想起来细节了来补充。 总结亚麻的面试代码题都是medium就好，每一轮都有bq project问得很细。

上周面的，都快一周了没消息，不知道咋样。随缘，也怕亚麻的pip感觉很可怕。

补充内容 \(2021-05-06 05:47 +8:00\): 补充一下，刚 follow up了一下hr, offer来了， 但hr说要先info call with manager， team match的样子。 现在亚麻是这样的嘛？顺便问问platform team 有推荐的组么？ wlb怎么样？

补充内容 \(2021-05-06 13:32 +8:00\): 想起来第三题了， 给几个lists， 要求implement一个iterator 1，2，3，4 6，7 2， 9, 10 output: 1, 6, 2, 2,7,9,3,10,4

## 16.

{% embed url="https://www.1point3acres.com/bbs/thread-756988-1-1.html" %}

第一轮的面试官是个 欧洲人，上来就迟到了 5 分钟多， 开始面试的时候发现口音超重， 面behavior的时候 就感觉他有些不耐烦。之后面 coding 面的是 蠡口 私企，anagram分组， 但是对应的 字符可能是 任何的 Unicode， 所以不让我 把字符串转成tuple或者list，要求转成dictionary， 例如 act {'a': 1, 'c': 1, 't': 1}， 而且 要求 复杂度 是 n^2。

## 17

[https://www.1point3acres.com/bbs/thread-759699-1-1.html](https://www.1point3acres.com/bbs/thread-759699-1-1.html)

头两轮都是算法题，忘了题号了，但都是力扣里公司对应的高频里的 第三轮是system design，很规整的题，grokk里的原题，但是问了很多细节，我当时对message queue部分不太熟，没回答好 真正让我挂掉的应该是最后一轮，也是算法题，但恰好是在高频里但我一直懒得刷的题型，当时心存侥幸觉得没有技术含量就是繁琐，谁想到就考了 当时在力扣买了一个月的会员，感觉还挺值

## 18

{% embed url="https://www.1point3acres.com/bbs/thread-759546-1-1.html" %}

1. BQ - tight timeline
2. BQ -  out comfort zone
3. Testing Tools - unit test, cross browser test, selenium script 以下内容需要积分高于 100 您已经可以浏览
4. Aother methods improve the code and debug
5. 3 methods for improving web performance
6. 给了html和css 回答一些问题
7. coding: js form serialize function by form id

       submit

{ foo: { bar: "", baz: { fiz:"" } }, fix: "" }

## 19.

[https://www.1point3acres.com/bbs/thread-759329-1-1.html](https://www.1point3acres.com/bbs/thread-759329-1-1.html)



第一轮: BQ: 1. Code quality V.S good solution. 2. Something you could do better. 3. What is your contribution to production. 4. What do you learn from the production issue. 5. When you encounter a problem you do not know, how do you solve it, what do you learn. Coding: 实现一个类似linux的文件功能，可以找出某种格式的所有文件，又或者能计算所有文件的数量等等。应该是个OOD和这题很像linux file function

第二轮: BQ: 1. 介绍一下你的项目 2. 你有收到用户的反馈吗，对于这些反馈，你是怎么做的 Coding: 随便写一个你熟悉的cache。面试官任何cache都行，只要能实现。我写的LRU cache。蠡口 幺肆陆

第三轮: BQ: 1. What challenges did you face in your experience Coding: 题目第一次读起来吓了一跳，大概就是实现一个类似亚马逊产品推荐的功能，你查看一个商品比如tea，那么推荐列表里就会出现sugar。然后和面试官聊着聊着，问题就变成了找图里任意两点间的所有点，如果这两个点能连接上的话。 Input 大概是有3个参数，一个list of pair \[\[tea, sugar1\], \[tea, sugar2\], \[sugar1, bowl\], \[bowl, cup\]\], 一个商品比如tea，另一个商品比如cup。 输出就是Tea, suger1, bowl cup.

第四轮: BQ: 1. What do you do if you cannot deliver your story within timeline. System design: 设计一个covid-19 vaccine的tracking和allocation system。 You are responsible for developing a COVID-19 tracking and vaccine allocation system for Amazon.

* 40 Warehouses
* 50 States
* 500 Covid-19 Vaccination Clinics
* 500 vaccine per shipment
* Critical Infection Rate - 50 per day

  Objective: Identify where the patient concentration is increasing and dispatch resources accordingly.

## 20.

[https://www.1point3acres.com/bbs/thread-759205-1-1.html](https://www.1point3acres.com/bbs/thread-759205-1-1.html)

第一个是HM白人大叔 LP半小时 然后设计油管 第二个是白人大哥 LP半小时 然后一道代码题 就是个字符串找重复 没啥好说的 完了后写了几个unit test 第三个白人小哥和shadow LP20分钟 然后亚马逊locker 一开始搞错了 以为是设计 后来才知道就是实现存货和取货俩方法 第四个白人小姐姐 LP20分钟 然后是个找连续timestamp的题 没啥好讲的。。就是实现题

面完后俩礼拜 中间一次HR告诉我说别急还在讨论 然后今天告诉我面挂了 问feedback LP和一轮code不大行 尤其是LP 需要有深度 都是和蠡口不相干的题 感觉已经不能再放水了 然而还是挂了

## 21

{% embed url="https://www.1point3acres.com/bbs/thread-757382-1-1.html" %}

Round 1：阿三小哥，白哥shadow \(BR\)：一题BQ，一题类似刷题网 旧玲舅，没给input要自己定义，问最少步数，follow-up是问要print出最短路径来怎麽做，我的解法是先BFS建立一个最小步数的map之后再DFS找所有路径，类似邀俄遛的做法，没写完，解释一下对方表示满意 Round 2：HM，国人大哥，人挺友善，SD轮，问一题BQ，SD先叫我解释我履历上的project之后问整体的佳构是什麽，怎麽优化，我答的巨烂，只勉勉强强挤出一点回应 Round 3：三哥，採渐进式模式，么么两/么么三/赐伞漆/馏熘遛，问一堆DFS观念，逻辑要很清晰才能跟得上节奏，这轮秒。 Round 4：三姊，一题BQ，问了两题舞两巴 伞赐漆，都秒。 整体而言BQ follow-up钜细靡遗，一定要能够讲出一个好故事，lz有工作经验，沟通能力跟英文能力都没问题，所以BQ算是强项，刷题也花了挺多时间的，就是SD跟履历差了点，但大厂对转码真的是友善，拚一下都有机会。 兩天後打來說SDE II 沒過，SD面的太差，downgrade 到L4, 完全可以接受

## 22.

{% embed url="https://www.1point3acres.com/bbs/thread-758239-1-1.html" %}



1. OO design linux find command. 题目要求和讨论在[https://leetcode.com/discuss/int](https://leetcode.com/discuss/int) ... -Linux-Find-Command。建议把所有的讨论都看一遍，里面有follow up questions。
2. 实现rate limiter.
3. system design. user can upload videos and watch videos. 需要考虑CDN, scalibilty, durability, load balance, cache.
4. leetcod 漆散尔。但是被包装成发电用电。

## 23.

[https://www.1point3acres.com/bbs/thread-758892-1-1.html](https://www.1point3acres.com/bbs/thread-758892-1-1.html)

首先，面试本身并没什么太难的： 一轮：大意是客户可能访问各种网站，找出在所有客户的所有访问序列中，某一个连续三个网站出现次数最多的一种组合，比如 \[abcde, bcdfg\] 这里面 出现最多的三字组合就是bcd 二轮：设计亚麻取件的locker station, 就是一个面向对象，要注意各种功能的完整 三轮：search service for Prime video. 系统设计题， 楼主没有相关工作经验，就靠着recruiter给的材料死记硬背了一堆 比如数据库， load balance， cache的选择及各种选择的好坏 四轮：大概就是 leetcode 夷儿溜，但大哥上来给的例子就不是最优解，我指出这点后大哥明显龙颜不悦，加上之前BQ的梁子，臣只能诚惶诚恐，如履薄冰

然后，我得提一下BQ，我认为这是亚麻面试中的一个弊端，亚麻的BQ太强调故事的完整性，时间地点人物， 起承转合都要交待清楚，因为各个面试官面前似乎有一张大表要去填，如果你的故事不完整，他们就会不停地追问细节，直到榨干你最后一滴血。后来我意识到，亚麻的面试就是教条主义，过分强调STAR的运用，就表明了其当代八股文的不二地位。

最后，我得说一下最后这位大哥，他的每一道BQ在榨干我最后一滴血的之后，他会追问 “why is it important?” 而且语气是我做过的东西似乎完全不重要的感觉。于是我也向他承认是的，我的工作明显不如你们AWS-connect 重要，然后他就这样轻舟已过万重山般扒光了我最后一层皮，让我只能露宿街头。还有，最后那道题，我提出构建 一个 形如 \*bc -&gt; \[abc, bbc, dbc\]这样的库的构想后，他却说这完全不会对整个程序有任何帮助时，我真的彻底快hold不住，于是最后的十几分钟在不愉快地争吵中度过，我虽然是因为之前做过这个题有一定经验主义的问题没有说服他，但他的蛮横无理也是让我压不住心中之火。

## 24.

[https://www.1point3acres.com/bbs/thread-758036-1-1.html](https://www.1point3acres.com/bbs/thread-758036-1-1.html)

Coding: LC陆玖贰 Coding：LC壹肆贰玖 OOP：酒店预约系统 SDI：类似Ins一样的服务，重点讨论生成feed

LP问题问的很细，result方面能提供量化的结果最好

## 25.

{% embed url="https://www.1point3acres.com/bbs/thread-757999-1-1.html" %}

Round 1. system design,设计一个monitor/alert系统，比较常见的题目了，follow up聊了聊metric pull/push，alert escalation,，，，

Round 2. implement a range lock,

lock \[100, 200\] TRUE lock \[300, 400\] TRUE lock \[150, 250\] FALSE unlock \[100, 200\] TRUE lock \[150, 250\] TRUE 一开始range作为一个整体,要求lock是LOG\(N\)，followup如果可以拆分range

Round 3 Given a binary tree, return the min sum change to make the sum of any path equals, only increase, not decrease value

```text
       1
 /        \
```

2 3 /  \

3 4 5 the return is \[3\], which has the updated tree as 1 /  \[4\] 3 /   \[4\] 4 5

Round 4.

Round 5. HM继续聊BQ

## 26.

{% embed url="https://www.1point3acres.com/bbs/thread-757837-1-1.html" %}

第一轮 三姐manager 蠡口要司令 我用dfs loop string面试官不太满意 她比较想loop Wordlist 虽然我觉得没什么本质区别。。。 第二轮 两个白人 设计一个class来判断board game是否胜利 follow up是如果要随时增减获胜条件怎么办 第三轮 白人manager 设计个amazon locker 实现存取快递 比较坑的地方是最好先写个locker class 然后不同的locker extend这个class 我一开始给了locker一个size 后面也没时间改了 第四轮 印度manager 人特好上来说了一堆放轻松把前三轮忘掉blabla 蠡口贰酒屋 follow up是有timestamp怎么办 没时间写了

bq： 对teammate不满意 Step outside your responsibility Overcome unexpected obstacles mistake you made 讲一下你需要学新技术并在工作中应用

大概差不多这些，2个hard 2个OOD，BQ基本上每轮都有点重复，第一轮印度大姐还不停的打断我说这个例子不太行你能换一个吗。。。跪的话八成跪在第一轮了

## 27.

[https://www.1point3acres.com/bbs/thread-757817-1-1.html](https://www.1point3acres.com/bbs/thread-757817-1-1.html)

1. 刷题网 丝丝旧
2. 尔要吾变种
3. 1\) 六爸灵，2\) input是2d array , e.g. arr \[\[45, 16\] \[80, 30\] \[10, 25\], ...\], arr\[i\]\[0\] 是video length, arr\[i\]\[1\]是profit，假设user can only play 120s 视频，问最大可以得到的profit
4. 设计 类似他家的s3 cloud object storage系统

## 28.

[https://www.1point3acres.com/bbs/thread-757671-1-1.html](https://www.1point3acres.com/bbs/thread-757671-1-1.html)

1. 就把额 , 和mgr意见不同
2. 物流 变形 但基本一样, 最难的项目
3. 设计 自动照明系统, 对的你没看错, 场景是热带雨林campus, 进一个会议灯会自动亮
4. mgr: past experience

## 29.

[https://www.1point3acres.com/bbs/thread-757658-1-1.html](https://www.1point3acres.com/bbs/thread-757658-1-1.html)

店面

原题巴巴儿

onsite

1. 二三事, 歧视, 最难的项目
2. hm
3. 设计youtube, 处理冲突
4. 一而淋儿, 而散,  delivery result

## 30.

{% embed url="https://www.1point3acres.com/bbs/thread-758027-1-1.html" %}

之前，与team manager电话以及第一轮电话面试的经历已经写了（\[面试经验\] 2021.04 Amazon电面 ） 在这里，特别感谢srigter的干货贴，里面指导了作者是如何准备Amazon Behavior Questions：（\[面试经验\] 【干货贴】我是如何准备系统设计的）

虽然，已经有很多人强调了Amazon Principle Questions的重要性，我还是得再重申一下。我觉得这个再怎么强调也不会过分的。我被考到的是：

* Customer Obsession
* Ownership
* Dive Deep
* Have Backbone; Disagree and Commit
* Deliver Results

  有些principle甚至被2个的interviewers问到（加粗）。所以这些重要的，得准备两个例子。而且有些例子可以被用在不同的问题，只要你调整一下说法。我个人总共准备了10个例子。

  还有一个typical behavior question：Tell me when you failed. 这个问题是我的bar raiser问的。很多Youtube Videos（Amazon Interview: how to prepare the failure stories \(12 examples\)）谈到了Bar Raiser喜欢问这个问题，很重要，好好准备。

我的电面和VO之间隔了大概一个月，我可以有时间刷system design， Object-Oriented Design，和 multi-threading。

说了一大堆BQ，现在说下我视频面试的流程吧。因为我在leetcode没找到原题，我只能给出题目大概难度，类型。我面的是Amazon Aurora，有四轮，分两天： 第一天， 第一轮，和我面试的是我在上个帖子提到的中国大叔，他是组里的大manager。两道BQ和一个leetcode medium的slide window -- max product of subarray of size K \(注意，corner case 0\)。 第二轮，一个印度大叔面试，他是组里的小manager，一个白人大叔shadow，组里的senior。没有太多刁难，两道BQ和一个multi-threading的问题。这是一道典型的producer/consumer的multi-threading，做出来了，而且感觉设计得还行，但没时间检查和跑test。如果跪了，应该就是在这里了。教训是：回答BQ的时候稍微简洁一些，不要超时，要不之后技术面试时间会不够。 第二天， 第三轮，一个白人大叔面，Amazon Pharmacy的senior manager（唯一一个Aurora之外的面试官，所以我猜是bar raiser），一个印度大叔shadow。 两道BQ和一个easy的array。这个又超时了。。。后面一个面试官来晚了，而且白人大叔愿意在超时后，让我优化，跑测试，提问。 第四轮，一个韩国大叔面，因为我们面试开始得晚（晚了8min），所以他很好心地只问了一道BQ，给我留了足够的时间做system design。让设计一个类似 database metric publisher/receiver system。

总结一下： 1。Behavior Question真的很重要 -- 每轮面试你都在用一半的时间回答BQ。准备它们，你只需要10小时左右，你再找不到性价比更高的准备了。 2。和谷歌爸爸比，amazon算法面真的不难，毕竟你只有20-25分钟去解题，run through code。我第二天的同时电面谷歌，45min，直接一道hard，让我跪得明明白白，会在另一个帖子详述。 3。好好和面试官交流。这次VO，我并没有碰到刁难的面试官。当他们觉得想和你工作，他们会给你提示，给你easy question，或者起码给你一个好脸色。比如，我的第三轮，已经是easy的题了，最后优化的时候，白人大叔还是不断给hints。如果跪了，真的有点愧对了。 4。System design对大多数人来说都很陌生。比如我工作时，主要设计low-level driver和一些kernel的东西，从来没有设计过distributed system. 第一个，当然是经典的system design课程（Grokking the System Design Interview，注：我没收到educative.io的一分钱赞助），这个课程，我刷了3遍，虽然还是很多东西记不住，但很多概念以及设计的流程模板，你都能熟悉。 第二个，youtube上很多system design mock interviews，你有了足够的知识之后，一边follow别人的设计，一边自己想设计，帮助真的很大。贴一个例子（Youtube: Google Systems Design Interview With An Ex-Googler） 第三个，大多数时候，你都碰不上原题，这时候，别慌，顺着设计流程模板。比如我面system design的时候，刚开始就一脸懵B，不知道面试官到底想要什么。这时候，问你的面试官问题：functional and non-functional的要求，你的assumption是不是对的，具体focus在哪个部分，这个系统的scale是多少。等你这些问题问得差不多的时候，你心里大概就知道该怎么设计了。 5。掌握好时间。当你答题时，语速不要太快，面试官得typing你的回答，但你要把握好你自己的时间。

题外话一下： 当你已经和team manager聊过之后，主要准备他让你准备的东西。如果之后，时间还够，再准备其他的。我和中国大叔开始的时候就聊过，他让我准备：

* 算法
* multi-threading
* system design
* Principle

  全考了，multi-threading，我没花很多时间，所以拉跨了点。我自己在网上找到的：

* OO design \(花了好多时间T.T\)

  没有考。

好了，立帖赞人品，求亚麻妈妈的offer。

## 31.

Danny

第一轮，天竺老哥，Linux find。

第二轮，欧洲白人小哥，一个天竺妹子shadow，感觉这一轮是bar raiser。题目是设计一个data structure，判断两个人是否有血缘关系。Clarify了很久，最后没时间写代码，大致讲了讲思路和复杂度。 可以参考这个：[https://www.careercup.com/question?id=4812957531766784](https://www.careercup.com/question?id=4812957531766784)

第三轮，天竺老哥，两道coding，蠡口尔伞罢，另一道感觉是因为时间还有富裕，面试官随意出了一道题，给了一个字符串，求字母的permutation。

第四轮，天竺老哥，系统设计，设计一个热带雨林prime video，他没开摄像头，互动很迟钝，经常我抛出一个问题，slient很久他才回答。

每日一轮都有 25 - 30 mins BQ，除了第二轮，基本没有follow up

## 32.

jialiu

heap, top k

slide window

design file system

## 33.

[https://www.1point3acres.com/bbs/thread-764718-1-1.html](https://www.1point3acres.com/bbs/thread-764718-1-1.html)

上来对方先做了自我介绍，是EMR方向的，说自己已经换了3-4个部门，来这里有2年多了。然后我简单做了自我介绍。

前面的30分钟先问了一堆Behavior的问题，有 1）成功帮助peer解决问题的经历 2）有没有经历是组里其他人意见和我的都不一样，然后是怎么处理的 3）有没有一次提出了创新的想法，然后改进了一个系统或者一个process

感觉非常刻板的按照STAR路线走，一个都不能落下，像最后一个我回答了一个改进process的例子，就追问那改进后有啥效果，具体怎么衡量等等。可是不是啥都能量化的啊，估计是照着一个面试模板在往里填，并不是很关心我具体回答了些啥， 也没有有意义的互动。

后面30分钟问了个system design，没有料到店面会问这个。直接说，来设计个S3我看看。我心想说凭啥认为所有人要都知道啥是S3啊，直接问设计object store不好吗。

面馆给了个link在里面画图，一堆技术问题，例如他那里看不到更新，等等，所以很慢

中间我提到了可以用partition来split traffic，已经说得很明确了，可以按照某些参数例如UUID来partition，但是面馆一个劲的问，为啥要partition啊，是要用user ID来hash吗？我一再强调user ID也是一个choice，但是要根据具体情况来挑，也可以是根据一组input来同时partition，然后过了五分钟又来问我，你确定要用user id吗。。。

后来总算拉回到一个partition里面的replica（已经假设了只考虑一个data center，所以没有跨center的replica问题），也是经常打岔，突然问，要是object很大有1GB，那要怎么建立replica，但是这个涉及到了网络分发/存储优化的问题，根本没时间深入，只能简单提一句可以利用CDN如果replica数很多，或者在网络层用p2p来加速。

中间还提到了用Zookeeper来保存partition mapping/config，面馆坚持认为zookeeper只能用来选leader，那我说好吧，那就当我没提zookeeper，这就只是一个partition configuration service吧。

看样子估计是要挂了，整个过程的体验也很不好

## 34.

[https://www.1point3acres.com/bbs/thread-764561-1-1.html](https://www.1point3acres.com/bbs/thread-764561-1-1.html)

第一题，pow，follow up：仅使用O（1）空间，把recursion改成iteration就好了 第二题，一组有向线段，删去哪些可以让他变成树，忘了leetcode哪题了

BQ：说一次没有达到customer期望的一段经历，有点刁钻，揪着问了几个follow up

## 35.

[https://www.1point3acres.com/bbs/thread-764274-1-1.html](https://www.1point3acres.com/bbs/thread-764274-1-1.html)

第一轮 implement pow\(x, y\) 第二轮 OOD + 2 sum: implement an API which takes input PlayList \(consist of songs\) and a targetDuration, and return all song pairs in the playlist that has sum duration equals to the targetDuration. Need to define the PlayList class and Song class 第三轮 OOD + BFS: implement a function to fetch the shortest path between two LinkedIn Users \(if A & B are friends, then path between A & B will be 1\) 第四轮 RandomizedSet LC380

## 36.

{% embed url="https://www.1point3acres.com/bbs/thread-764499-1-1.html" %}

第一轮，ＢＱ问了２０分钟，听完一个故事不做评价也不问问题，只想再听我讲新的例子，因为我想把最impactful 的故事留给经理，就重复答了相同故事里的其他方面，然后对面翻了白眼，我好无奈。。。算法部分，刷题网，罢，过了很多corner case, 也做了相应的很多修改。最后问我遇到的 input 是二进制怎么办，我有点懵，请她clarify也非常费劲，基本照着问题描述在读给我听。没办法我只能答了根据 prefix , 比如"0x" 来分情况讨论。但隐约感觉不是面试官想要的答案。。。希望楼下遇到类似题的各位提供思路

第二轮面得很顺畅很开心，ＢＱ也问了将近１５分钟。刷题网，斯。拿到这一题我心里咯噔了一下，因为这道题二分解法我有点忘记怎么写了，于是影响了状态，开始语无轮次，但面试官非常nice，提示说先不要考虑最优解。我才反应过来，用双指针打擂台的方法去构建答案。最后他也没要求我写出二分法的最优解，我只是写了大概的框架，边界没有锱铢必较，只是让我说了一下思路，过了几个test case

第三轮，hiring manager, 系统设计。没有具体的题，就说是一个购物网站，最开始没有什么流量，后来流量 spike ，问我怎么处理、怎么找出是哪里出了问题，我基本上没有用准备好的系统设计模板答案，而是根据我自己的工作经历来聊的。期间讲了 circuit breaker 的原理是什么，聊了一下要怎么 partition ，怎样做 data roll up 如果有太多数据的话。总体来说比较正常，但最后他无意间说了句，get this over with... 让我觉得很奇怪，后来给了offer才觉得他只是累了，据猎头说，那天早上同时面3个人，并不是针对我。

第四轮，bar raiser, 先问ＢＱ问了好久，将近半个小时，其中问怎样保证 ＭＱ 不重复不丢失，kafka 的offset 怎么用等等, 我解释了很久，最后他把我画的例子收录进他的report 才算结束。然后进入考题，有点ＯＯＰ而不是系统设计，让我设计 locker delivery system 的各种类名，然后各种设计api, 我讲到了很多code maintainability方面的问题，比如这个以后可以怎么refactor等等。总体来说比较顺，但就是对方没有太多feedback, 一直是我不停地在说。

总体来说算法题，感觉过于简单，有种暗中标好价格的感觉，让我不是很放心。因为之前朋友，面试也是和我差不多的，有点过于简单，过于机械化的过程，期间对面也有些工程师态度奇怪的经历；结果他在AWS某组任劳任怨，却１年多就被pip, 连sign on 都要退还。让我感觉非常不好，怕自己也是同样的命运，best case 也是sign on 拿到但 vest 不到４０％的股票。于是决定不去了。去了另一家包裹没有那么大，但面试过程比较愉悦的公司



