#include<stdio.h>
#include<stdlib.h>
void insertAtB(int x);
void insertAtE(int x);
void insertAtSP(int p,int x);
void deleteAtB();
void deleteAtSP(int p);
void deleteAtE();
void showAll();
void reverseList();
int searchNode();

struct Node *start=NULL;

int main()
{
	int ch,a,b,c,s,e,f,g;
	printf("menu\n");
	printf("1.insertAtbegining\n");
	printf("2.insertAtEnding\n");
	printf("3.insertAtSpecific position\n");
	printf("4.DeleteAtSpecific position\n");
	printf("5.DeleteAtbegining\n");
	printf("6.DeleteAtEnding\n");
	printf("7.showAll\n");
	printf("8.Reverselist\n");
	printf("9.searchNode\n");
	
	printf("Enter any element\n");
	printf("%d",&e);
	
	insertAtB(e);
	
	printf("Enter your choice\n");
	scanf("%d",ch);
	switch(ch)
	{
		case 1:
		printf("Enter any no.");
		
		scanf("%d",&a);
		insertAtB(a);
		
		printf("insert no.");
		showAll();
		break;
		
		case 2:
		printf("Enter any no.");
		
		scanf("%d",&a);
		insertAtE(a);
		
		printf("insert no.\n");
		showAll();
		break;
		
		case 3:
		printf("Enter positon and no.\n");
		
		scanf("%d,%d",&a,&b);
		insertAtSP(a,b);
		
		printf("insert no:",a);
		showAll();
		break;
		
		case 4:
		printf("Enter position to delete\n");
		
		scanf("%d",&a);
		deletetAtSP(a);
		
		printf("List after deletion");
		showAll();
		break;
		
		case 5:
		showAll();
		
		
		deletetAtB();
		
		printf("List after deletion.");
		showAll();
		break;
		
		case 6:
		showAll();
		deleteAtE();
		
		
		printf("List after atend.");
		showAll();
		break;
		
		case 7:
		
		showAll();
		break;
		case 8:
		
		showAll();
		
		reverseList();
		printf("List after reverse");
		showAll();
		break;
		
		case 9:
		printf("Enter any no. for search");
		
		scanf("%d",&s);
		searchNode(s);
	
		break;
		default:
		printf("invalid choise\n")
		
	}
	
	return 0;
}
void insertAtB(int x)
{
	struct Node *temp= malloc(sizeof(struct Node));
	
	if(temp==NULL)
	{
		printf("No space\n");
		return ;
	}	
	temp->data=x;
	temp->next= start;
	start=temp;
	
   }
	void deleteAtB()
	{
		if(start==NULL)
		{
			printf("List is empty\n");
		return ;
		}	
	struct Node *temp=start;
	start = start->next;
	free(temp);
		
	}
	void insertAtE(int x)
	{
		if(start==NULL)
		{
			insertAtB(x);
			return;
		}		
		temp->data=x;
		temp->next =NULL;
		temp1->next=temp;
		
	}
	
	void deleteAtE()
	{
		if(start==NULL)
		{
			printf("List is empty\n");
		return ;	
		}
		if(start->next == NULL)
		{
			free(start);
			start=NULL;
			return;
			
		}
		struct Node *temp1=start;
		while(temp1->next->next!=NULL)
		{
			temp1= temp1->next;
		}
		free(temp1->next);
		temp1->next = NULL;
	}
	
	void insertAtSP(int p,int x)
	{
		int i;
		if(p<=1)
		{
			insertAtB(x);
			return;
		}	
		temp->data=x;
		struct Node *temp1= start;
		for( i=1;i<p-1;i++)
		{
			temp1=temp1->next;
		}
		temp->next= temp1->next;
		temp1->next= temp;
	}
	void deleteAtSP
	{
		if(p<=1)
		{
			deleteAtB();
			return;
		}
		if(p > countNode())
		{
			printf("Position out of bond\n");
			return;
		}
		struct Node *temp1=start;
		while(temp!=NULL)
		{
			printf("%d",temp->data);
			temp=temp->next;
		}
		printf("\n");
	}
	void reverseList()
	{
		struct Node *prev= NULL;
		struct Node *current= start;
		struct Node *next= NULL;
		
		while(current!=NULL)
		{
			next = current->next;
			prev=current;
			current =next;
		}	
		start=prev;
	}
	int searchNode(int s)
	{
		int index= -1;
		struct Node *temp=start;
		while(temp!=NULL)
		{
			index++;
			if(temp->data == s)
			{
				printf("Data found %d\n",index);
			}
			temp= temp->next;
		}
		return -1;
	}
	int countNode()
	{
		int c=0;
		struct Node *temp= start;
		while(temp!=NULL)
		{
			c++;
			temp = temp->next;
			
		}
		return c;
	}