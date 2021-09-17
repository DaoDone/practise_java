package com.adjiang.practise.arithmetic.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * 原理介绍：
 * BloomFilter通常采用bit array实现，假设其bit总数为m，初始化时m个bit都被置成0。
 * BloomFilter中插入一个元素，会使用k个hash函数，来计算出k个在bit array中的位置，然后，将bit array中这些位置的bit都置为1。
 * BloomFilter中查找一个元素，会使用和插入过程中相同的k个hash函数，取模后，取出每个bit对应的值，如果所有bit都为1，则返回元素可能存在，否则，返回元素不存在
 * BloomFilter中不允许有删除操作，因为删除后，可能会造成原来存在的元素返回不存在，这个是不允许的
 * 参数如何取值:
 * 在实际使用BloomFilter时，一般会关注false positive probability，因为这和额外开销相关。
 * 实际的使用中，期望能给定一个false positive probability和将要插入的元素数量，能计算出分配多少的存储空间较合适。
 * 假设BloomFilter中元素总bit数量为m，插入的元素个数为n，hash函数的个数为k，false positive probability记做p，它们之间有如下关系（具体推导过程请参考维基百科）：
 * 如果需要最小化false positive probability，则k的取值如下
 * k = m * ln2 / n;  公式一
 * {@linkplain com.google.common.hash.BloomFilter#optimalNumOfBits}
 * 而p的取值，和m，n又有如下关系
 * {@linkplain com.google.common.hash.BloomFilter#optimalNumOfHashFunctions}
 * m = - n * lnp / (ln2) ^ 2 公式二
 * 把公式一代入公式二，得出给定n和p，k的取值应该为
 * k = -lnp / ln2
 * 自己总结：
 *  hash次数取决于 给定的元素个数（预计），和给定的错误率
 *  hash 函数应该怎么写？
 *
 * @author jianad001
 * @date 2021/9/17
 */
public class BloomFilterUtil {

    //100
    private static int total = 100;


    //初始化一个boolFilter
    static  BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), total, 0.01);




}
