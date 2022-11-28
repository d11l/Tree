package tree;
/**
 * @Abdulrahman
 */
public class Binary_Search_Tree {

Node root;
// rootExplore  => rootEX
//  Add 
public void add(int value){
    Node temp = new Node(value);
    root = add_helper(root , temp);
    
}

private Node add_helper(Node rootEX , Node node){
    
   
    
    if(rootEX == null){
    rootEX = node;
    }
    else if( node.value >= rootEX.value){
         
       rootEX.Right = add_helper(rootEX.Right,node);
}
    else{
     
         rootEX.Left = add_helper(rootEX.Left,node);
    }
    
    return rootEX;
}


public void display(){

display_helper(root);
    
}
private void display_helper(Node rootEX){

      if(rootEX != null){
      display_helper(rootEX.Left);
      System.out.print(rootEX.value+" ");      
      display_helper(rootEX.Right);  
 }
      
}


public boolean Search(int value){
    
  return Search_helper(root,value);
  
}

private boolean Search_helper(Node rootEX ,int value){

    if(rootEX == null){//base case
    return false;
    }
    else if(rootEX.value == value){
    
        return true ; 
 
    }
    else if (value < rootEX.value){
    return Search_helper(rootEX.Left, value);
    }
    else
        return Search_helper(rootEX.Right, value);



}

public boolean Search2(int v){
Node rootEX = root;
    
while(rootEX!=null){

 if(rootEX.value == v){
     return true;
 }
  else if(rootEX.value > v){
     rootEX = rootEX.Left;
  }
 else
      rootEX = rootEX.Right;
}
return false;
}


public void remove(int value){

    if(Search(value)){
    remove_helper(root,value);
    }
    else{
        System.out.println("Not Found");
    }
}
private Node remove_helper(Node rootEX,int value){
    
    if(rootEX==null){
   return rootEX;
    }
    else if(rootEX.value > value ){
    rootEX.Left = remove_helper(rootEX.Left , value);
    }
    else if(rootEX.value < value ){
    rootEX.Right = remove_helper(rootEX.Right , value);
    }
    else{ // found it 
    
        if(rootEX.Left == null && rootEX.Right == null){// do not have childs
        
            rootEX = null;  
        
        }else if(rootEX.Right != null){
        rootEX.value = Successor(root);
        rootEX.Right = remove_helper(rootEX.Right , rootEX.value);
        
        }
        else {
        
        rootEX.value = predecessor(rootEX);
        rootEX.Left = remove_helper(rootEX.Left , rootEX.value);
        
        }
    
    }
    
    return rootEX;
    
    
 }

public int Successor(Node rootEX){ 
    
     rootEX = rootEX.Right;
    while(rootEX.Left != null){
     rootEX = rootEX.Left;
    }
    
    return rootEX.value;
}

private int predecessor(Node rootEX){
  
     rootEX = rootEX.Left;
   while(rootEX.Right != null){
    rootEX =rootEX.Right;
    }
    
    return rootEX.value;

}



public int Max(){

return Max_helper(root);
}

private int Max_helper(Node rootEX) {
if (rootEX.Right == null) 
return rootEX.value ;
return Max_helper(rootEX.Right);
}

public int Min(){

return Min_helper(root);
}

private int Min_helper(Node rootEX) {
if (rootEX.Left == null) 
return rootEX.value ;
return Max_helper(rootEX.Left);
}


} 
