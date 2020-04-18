package com.imooc.datastructs;

import java.util.Scanner;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/18 10:43
 */

class DATA2{
	String key;    //节点的关键字
	String name;
	int age;
}

class CLType{                //定义链表结构
	DATA2 nodeData= new DATA2();
	CLType nextNode;
	CLType CLAddEnd(CLType head,DATA2 nodeData){   //追加节点
         CLType node,htemp;
         if((node=new CLType())==null){
	         System.out.println("申请内存失败\n");
	         return null;
         }else{
         	 node.nodeData =nodeData; //保存数据
	         node.nextNode=null;//设置节点指针为空，即为表尾
	         if(head ==null){
	         	head=node;
	         	return head;
	         }
	         htemp =head;
	         while (htemp.nextNode!=null){ //查找链表的末尾
	         	htemp=htemp.nextNode;
	         }
	         htemp.nextNode=node;
	         return head;
         }

	}
	int CLLength(CLType head){ //计算链表长度
		CLType htemp;
		int len=0;
		htemp=head;
		while(htemp!=null){
			len++; //累加节点数量
			htemp=htemp.nextNode; //处理下一个节点
		}
		return len;

	}
	void CLAllNode(CLType head){
		CLType htemp;
		DATA2 nodeData;
		htemp=head;
		System.out.printf("当前链表共有%d 个节点，链表所有数据如下： \n",CLLength(head));
		while(htemp !=null){
			nodeData = htemp.nodeData; //获取节点数据
			System.out.printf("节点（%s,%s,%d）\n",nodeData.key,nodeData.name,nodeData.age);
			htemp=htemp.nextNode; //处理下一个节点

		}

	}
	CLType CLAddFirst(CLType head,DATA2 nodeData){
		CLType node;
		if((node=new CLType())==null){
			System.out.print("申请内存失败！\n");
			return null;
		}else{
	         node.nodeData=nodeData;
	         node.nextNode=head;
	         head=node;
	         return head;
		}

	}
	CLType CLFindNode(CLType head,String key){
		CLType htemp;
		htemp =head;
		while (htemp!=null){
			if(htemp.nodeData.key.compareTo(key)==0){
				return htemp;
			}
			htemp=htemp.nextNode;
		}
		return null;
	}
	CLType CLInsertNode(CLType head,String findkey,DATA2 nodeData){
		CLType node,nodetemp;
		if((node=new CLType())==null) 		//分配保存结点的内容
		{
			System.out.print("申请内存失败！\n");
			return null;  								//分配内存失败
		}
		node.nodeData=nodeData;
		nodetemp =CLFindNode(head,findkey);
		if(nodetemp !=null){
			node.nextNode=nodetemp.nextNode; //新插入节点指向关键节点的下一个节点
			nodetemp.nextNode=node; //设置关键节点执行新插入节点
		}else{
			System.out.println("未找到正确的插入位置");
		}
		return head;
	}
	int CLDeleteNode(CLType head,String key){
		CLType node,htemp; //node 保存删除节点的前一个节点
		htemp =head;
		node=head;
		while(htemp!=null){
			if(htemp.nodeData.key.compareTo(key)==0){ //找到关键字，执行删除操作
				node.nextNode=htemp.nextNode;  //使前一节点指向当前节点的下一个节点
				htemp=null;
				return 1;
			}else{
				node=htemp; //指向当前节点
				htemp =htemp.nextNode; //指向下一个节点
			}
		}
		return 0; // 未删除
	}
}
public class P2_2 {
	public static void main(String[] args) {
		CLType node, head=null;
		CLType CL=new CLType();
		String key,findkey;
		Scanner input=new Scanner(System.in);

		System.out.print("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄\n");
		do
		{
			DATA2 nodeData=new DATA2();
			nodeData.key=input.next();
			if(nodeData.key.equals("0"))
			{
				break; //若输入0，则退出
			}
			else
			{
				nodeData.name=input.next();
				nodeData.age=input.nextInt();
				head=CL.CLAddEnd(head,nodeData);//在链表尾部添加结点
			}
		}while(true);
		CL.CLAllNode(head); 							//显示所有结点

		System.out.printf("\n演示插入结点，输入插入位置的关键字：") ;
		findkey=input.next();  						//输入插入位置关键字
		System.out.print("输入插入结点的数据(关键字 姓名 年龄):");
		DATA2 nodeData=new DATA2();
		nodeData.key=input.next();
		nodeData.name=input.next();
		nodeData.age=input.nextInt();//输入插入结点数据
		head=CL.CLInsertNode(head,findkey,nodeData);		//调用插入函数
		CL.CLAllNode(head); 							//显示所有结点

		System.out.print("\n演示删除结点，输入要删除的关键字:");

		key=input.next();								//输入删除结点关键字
		CL.CLDeleteNode(head,key); 					//调用删除结点函数
		CL.CLAllNode(head); 							//显示所有结点

		System.out.printf("\n演示在链表中查找，输入查找关键字:");
		key=input.next();							//输入查找关键字
		node=CL.CLFindNode(head,key);					//调用查找函数，返回结点指针
		if(node!=null)									//若返回结点指针有效
		{
			nodeData=node.nodeData;				//获取结点的数据
			System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n" ,key,nodeData.key,nodeData.name,nodeData.age);
		}
		else										//若结点指针无效
		{
			System.out.printf("在链表中未找到关键字为%s的结点！\n",key);
		}

	}
}
