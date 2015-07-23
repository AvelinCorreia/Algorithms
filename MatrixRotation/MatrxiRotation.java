import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatrixRotation {
	
	
	/* PsuedoCode
	1. Read the matrix
	2. find the number of layers
	3. for each layer , do the following,
	    a. read the layer into a linear array.
		b. rotate the linear array anticlockwise with the given number of rotation.
		c. Store the linear array as a layer into output matrix (which represents the rotated form of original matrix)
	4. Display the rotated matrix.
	*/
	
	
	
	public static void rotate (int [][]arr, int [][] arrDup, int layer, int rotation)
	{
		int row = arr.length;
		int col = arr[0].length;
		int rot=0; int nrow=0; int ncol=0;
		
		
		for (int l=0; l<layer; l++)
		{
			
		   int [] temp = new int[2*(row+col-2-4*l)]; 
				int index=0;
				
				
			for (int i=l, j=l; j< col-1-l; j++)
			{	
			   temp[index++] =  arr[i][j];
			   }
			
			for (int i=l, j=col-1-l; i<row-l-1; i++)
			{		
			   temp[index++] =  arr[i][j];
			}
			
			for (int i=row-l-1, j=col-l-1; j>l; j--)
			{		
			   temp[index++] =  arr[i][j];
			}
			
			for (int i=row-l-1, j=l; i>l; i--)
			{		
			   temp[index++] =  arr[i][j];
			}
			
			rot = rotation% temp.length;
			
            int pos;
            int[] tempDup = new int [temp.length];
			
			for (int i=0;i<temp.length; i++)
			{
			   pos = i-rot;
			   if (pos <0)
			   {
				  pos = temp.length- rot+i;
			   }
			   tempDup[pos]= temp[i];
			 }
			
			
			index =0;
			for (int i=l, j=l; j< col-1-l; j++)
			{	
				  arrDup[i][j] = tempDup[index++] ;
			   }
			
			for (int i=l, j=col-1-l; i<row-l-1; i++)
			{		
				  arrDup[i][j] = tempDup[index++] ;
			}
			
			for (int i=row-l-1, j=col-l-1; j>l; j--)
			{		
				  arrDup[i][j] = tempDup[index++] ;
			}
			
			for (int i=row-l-1, j=l; i>l; i--)
			{		
				  arrDup[i][j] = tempDup[index++] ;
			}
			
		}
		 matPrint(arrDup);
				
	}
	
	public static int abs(int val)
	{
		if (val<0)
			return (val*(-1));
		return val;
	}
	
	public static int min(int a, int b)
	{
		if(a<b)
			return a;
		return b;
	}
	public static int max(int a, int b)
	{
		if(a>b)
			return a;
		return b;
	}
	
	public static void matPrint(int [][]arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int row = sc.nextInt();
	int column = sc.nextInt();
	int rotation = sc.nextInt();
	int layer = min(row,column)/2;
	
	int matOrg [][] = new int[row][column];
	int matRot [][]= new int[row][column];
	
	
	for (int i=0; i<row; i++)
		for(int j=0; j<column; j++)
		{
			matOrg[i][j]= sc.nextInt();
			matRot[i][j]=0;
		}
	
//	matPrint(matOrg);
	
	rotate(matOrg, matRot,layer,rotation);
	
	//System.out.println(layer);
	
}
		
	
}
