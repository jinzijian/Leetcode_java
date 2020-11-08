

# Flow Based Model 学习笔记

## 生成模型的种类

- GAN----MiniMax Game

- VAE----最大化ELBO

- Flow-based generative models: 一系列可逆转的变换组成；直接解出P(X) ;损失函数就是negative log-likelihood

  ![image-20200701130610944](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701130610944.png)

## 线性代数基础回顾

### 雅克比矩阵和行列式

#### 雅克比矩阵

![image-20200701134310002](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701134310002.png)

![image-20200701134404932](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701134404932.png)

![image-20200701134448388](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701134448388.png)

![image-20200701211218176](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701211218176.png)

#### 行列式的计算

![image-20200701140754768](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701140754768.png)

### 变量的转化

给定一个随机变量Z ，概率密度函数为z ~π(z);

new 1-1 map 随机变量 x = f(z); f 可逆

z = f-1(x);

求P（X）

![image-20200701213239601](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701213239601.png)

可以推导出

![image-20200701223919980](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701223919980.png)

![image-20200701224010049](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701224010049.png)

## Normalizing Flows

![image-20200701225902933](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701225902933.png)

推导目标函数

![image-20200701231000431](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701231000431.png)

推导到连续 链式情况

![image-20200701231416283](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701231416283.png)

F可逆

雅克比不等式容易计算

## Models with Normalizing Flows

### Loss Function 

<img src="/Users/alexkim/Library/Application Support/typora-user-images/image-20200701232922496.png" alt="image-20200701232922496" style="zoom:67%;" />

### RealNVP

函数f被设计成耦合层

 input dimensions are split into two parts:





![image-20200701234315448](/Users/alexkim/Library/Application Support/typora-user-images/image-20200701234315448.png)

S和T是 scaleTransformer 函数

![image-20200702003721069](/Users/alexkim/Library/Application Support/typora-user-images/image-20200702003721069.png)

![image-20200702004430401](/Users/alexkim/Library/Application Support/typora-user-images/image-20200702004430401.png)

In one affine coupling layer, some dimensions (channels) remain unchanged. To make sure all the inputs have a chance to be altered, the model reverses the ordering in each layer so that different components are left unchanged. Following such an alternating pattern, the set of units which remain identical in one transformation layer are always modified in the next. Batch normalization is found to help training models with a very deep stack of coupling layers.

Furthermore, RealNVP can work in a multi-scale architecture to build a more efficient model for large inputs. The multi-scale architecture applies several “sampling” operations to normal affine layers, including spatial checkerboard pattern masking, squeezing operation, and channel-wise masking. Read the [paper](https://arxiv.org/abs/1605.08803) for more details on the multi-scale architecture.

### NICE

没有scale变换

![image-20200702135746198](/Users/alexkim/Library/Application Support/typora-user-images/image-20200702135746198.png)

### Glow

<img src="/Users/alexkim/Library/Application Support/typora-user-images/image-20200702142440501.png" alt="image-20200702142440501" style="zoom:50%;" />

1. **Activation normalization** 
2. **Invertible 1x1 conv**
3. **Affine coupling layer**

![image-20200702142710474](/Users/alexkim/Library/Application Support/typora-user-images/image-20200702142710474.png)

## Models with Autoregressive Flows

Xi依靠X1——Xi-1；

序列模型

![image-20200703113001059](/Users/alexkim/Library/Application Support/typora-user-images/image-20200703113001059.png)

If a flow transformation in a normalizing flow is framed as an autoregressive model — each dimension in a vector variable is conditioned on the previous dimensions — this is an **autoregressive flow**.

### MADE

![image-20200703125102420](/Users/alexkim/Library/Application Support/typora-user-images/image-20200703125102420.png)

简单来说就是每一层随机断链接

实话实说这个公式我没太看懂

![image-20200703130554310](/Users/alexkim/Library/Application Support/typora-user-images/image-20200703130554310.png)

### MAF / IAF

![image-20200703195423633](/Users/alexkim/Library/Application Support/typora-user-images/image-20200703195423633.png)

![image-20200703195507582](/Users/alexkim/Library/Application Support/typora-user-images/image-20200703195507582.png)

