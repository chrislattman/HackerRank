// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

struct node* insert( struct node* root, int data ) {
        
    if(root == NULL) {
    
        struct node* node = (struct node*)malloc(sizeof(struct node));

        node->data = data;

        node->left = NULL;
        node->right = NULL;
        return node;
      
    } else {
      
        struct node* cur;
        
        if(data <= root->data) {
            cur = insert(root->left, data);
            root->left = cur;
        } else {
            cur = insert(root->right, data);
            root->right = cur;
        }
    
        return root;
    }
}

int max(int left, int right) {
    if (left >= right) {
        return left;
    }
    else {
        return right;
    }
}

/* you only have to complete the function given below.  
node is defined as  

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

*/
int getHeight(struct node* root) {
    if (root->left != NULL && root->right != NULL) {
        return 1 + max(getHeight(root->left), getHeight(root->right));
    }
    else if (root->left != NULL) {
        return 1 + getHeight(root->left);
    }
    else if (root->right != NULL) {
        return 1 + getHeight(root->right);
    }
    else {
        return 0;
    }
}

int main() {
  
    struct node* root = NULL;
    
    int t;
    int data;

    scanf("%d", &t);

    while(t-- > 0) {
        scanf("%d", &data);
        root = insert(root, data);
    }
  
    printf("%d",getHeight(root));
    return 0;
}
