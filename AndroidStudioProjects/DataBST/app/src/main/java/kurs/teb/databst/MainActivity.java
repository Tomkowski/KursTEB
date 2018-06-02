package kurs.teb.databst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    TextView printTree;

    Button collectData;
    BST<String> stringBST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringBST = new BST<>(new String ("test"));

        textView = findViewById(R.id.dataText);
        printTree = findViewById(R.id.printTreeView);
    }

    public void collectDataOnClick(View view) {

        String [] words = textView.getText().toString().split(" ");
        //możliwość wpisywania wielu słów

        for(String s : words) stringBST.insert(s);

    }

    public void printOnClick(View view) {
        printTree.setText(stringBST.toString());
    }

    class BST<T extends Comparable<T>>{

        Node root;

        public BST(T value){
            root = new Node(value);
        }


        public void insert(T value){
            Node current = root;
            Node previous = null;

            while(current != null){

                previous = current;

                if(current.value.compareTo(value) < 0) current = current.rightChild;
                else current = current.leftChild;

            }

            if(previous.value.compareTo(value) < 0 ) previous.rightChild = new Node(value);
            else previous.leftChild = new Node(value);

        }

        @Override
        public String toString(){
              return collectStrings(root);
        }

        private String collectStrings(Node root){
             if(root == null) return "";
             else return collectStrings(root.leftChild)+" "+root.value+" "
             + collectStrings(root.rightChild);
        }


        public class Node{
            T value;
            Node leftChild;
            Node rightChild;

            public Node(T value){
                this.value = value;
            }
        }
    }
}
