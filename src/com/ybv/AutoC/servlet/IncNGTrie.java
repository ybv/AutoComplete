package com.ybv.AutoC.servlet;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncNGTrie 
{
	int num =1;
	final HashMap<Integer,LinkedHashMap<String, LinkedHashMap>> count;
	int[] L = new int[10];
	HashSet<String> set;
	Trie t ;
	public IncNGTrie(){
		t= new Trie();
		HashMap<String, Integer> delVariants = DelVariants("fast");
		Iterator it = delVariants.entrySet().iterator();
		t.add("fast");
		t.add("fact");
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			t.add(pairs.getKey().toString());
			it.remove(); 
		}
		delVariants = DelVariants("fact");
		it = delVariants.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			t.add(pairs.getKey().toString());
			it.remove(); 
		}
		LinkedHashMap<String, LinkedHashMap> res = t.getRoot();
		count = new HashMap<Integer,LinkedHashMap<String, LinkedHashMap>>();
		printrecur(res);
	}

/*	public static void main(String[] args)
	{
		
		
		printrecur(res);
		//---------------------------------------------------------------------------------------------
		
		// INCREMENTAL SEARCH FUNCTION
		
		
	} // END OF MAIN FUNCTION*/
	
	public HashSet<String> sreenivas(String s){
		HashSet<String> ds = new HashSet<String>();
		ArrayList<Triplet> newactive = new ArrayList<Triplet>();
		ArrayList<Triplet> active1 = ExpandActive(1,1, 0, 1);
		System.out.println("FFFFFFFFFFF");
		/*
		for (Triplet t9: active1){
			System.out.print("((");
			System.out.print(t9.anode+",");
			System.out.print(t9.cursor+",");
			System.out.print(t9.inco);
			System.out.print("))");
			System.out.println("");
			
		}
		*/
		//Set<Triplet> newactive = new HashSet<Triplet>();
		
		//active1.addAll(newactive);
		int newChild=0;
		String str = s;
		if(str.length() > 0)
		{
			char[] input = str.toCharArray();
			for(int i = 0;i<input.length;i++)
			{
				for(Triplet t2: active1)
				{
					if(t2.cursor>i+1)
					{
						newactive.add(t2);
					}
					
				
					newChild = childLabel(t2.anode,Character.toString(input[i]));
					if(newChild!=0)
					{
						ArrayList<Triplet> a = ExpandActive(newChild, t2.cursor+1, t2.inco,1);
						for (Triplet s2: a)
						{
								newactive.add(s2);
						
						}
					}	
				}
				active1.clear();
				active1.addAll(newactive);
			}
		}
		else
		{
				for(Triplet w: active1)
				{
					newactive.add(w);
				}
			}
			
		
			// Displaying the active nodes
			for (Triplet t9: newactive){
				System.out.print("((");
				System.out.print(t9.anode+",");
				System.out.print(t9.cursor+",");
				System.out.print(t9.inco);
				System.out.print("))");
				System.out.println("");
				
			}
		
		
		// Displaying the leaf strings
			set = new HashSet<String>();
		for(Triplet t9: newactive){
			
			if(t9.cursor==str.length()+1){
				
				 ds = getLeafnode(t9.anode);
				
			}
		
			
		}
		System.out.println("ds "+ds.toString());
		return ds;
		//ArrayList<String> B = CreateRearrangedStringIDArray(I);
		//System.out.println("YOOOHOO" + B);
	}
	
	public HashSet<String> getLeafnode(int anode) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, LinkedHashMap> nodeNo = count.get(anode);
		System.out.println("anode num "+anode);
		//set.clear();
		for (String s: nodeNo.keySet())
		{
			
		
			LinkedHashMap<String,LinkedHashMap> values = nodeNo.get(s);
			String str = values.toString();
			
			//System.out.println("getleaf set "+str);
			//set.add(s);
		
			Pattern linkPattern = Pattern.compile("\\{([a-z#])+\\=\\{\\}",Pattern.MULTILINE);
			
			Matcher cmatcher = linkPattern.matcher(str);
			while(cmatcher.find()) {
				String gr = cmatcher.group();
				int i = gr.indexOf('=');
				gr = gr.substring(1,i);
				set.add(gr);
				
			} 
		//	System.out.println("nodenum keyset"+str);
		}
		System.out.println(set.toString());
		return set;
		

	}


	public void printrecur(LinkedHashMap<String,LinkedHashMap> node)
	{
		Collection<LinkedHashMap> values = node.values();
		Object[] arr = values.toArray();
		int poss=0;
		for (Object i:arr)
		{
			poss++;
		}
		if(values.size()>0)
		count.put(num++,node);
		//System.out.println(num);
		//System.out.println(count.get(num));
		//System.out.println("poss"+poss);
		if(values.size()==0){
			return;
		}
		else{
			for (Entry<String, LinkedHashMap> me2 : node.entrySet()) {
			
				//System.out.println("number"+num);
				String str = me2.getKey();
				//System.out.println(str);
				printrecur(node.get(str));
				
			}
			
		}
	
	}

	
	public LinkedHashMap<String, Integer> DelVariants(String s){
		LinkedHashMap<String, Integer> variants = new LinkedHashMap<String,Integer>();
		for (int i=0; i<s.length();i++){
			StringBuilder variant = new StringBuilder(s);
			variant.setCharAt(i, '#');
			variants.put(variant.toString(), i);
		}
		return variants;
	}

	
	//EXPANDACTIVE FUNCTION
	public ArrayList<Triplet> ExpandActive(int nodeno, int cur, int incor, int tres)
	{
		int newValue = 0;
		//ArrayList<Triplet> A = new ArrayList<Triplet>();
		ArrayList<Triplet> A = new ArrayList<Triplet>();
		for(int del=0; del<=tres-incor ; del++)
		{
			Triplet t = new Triplet(nodeno, cur+del , incor+del);			
			A.add(t);
		}
		int dds =1;
		
		newValue = childLabel(nodeno,"#");
		while(dds+incor <= tres)
		{
			if(newValue!=0)
			{
				for(int del=0; del<=tres-incor ; del++)
				{
					int ddash = Math.max(del, dds);
					Triplet t = new Triplet(newValue, cur+del , incor+ddash);			
					A.add(t);
				}
				nodeno = newValue;
				dds++;
			}
		}
		/*
		for (Triplet t: A){
			System.out.print("((");
			System.out.print(t.anode+",");
			System.out.print(t.cursor+",");
			System.out.print(t.inco);
			System.out.print("))");
			System.out.println("");
			
		}*/
		return A;
	}
	
	//CREATE REARRANGED STRING ID ARRAY FUNCTION
	public ArrayList<String> CreateRearrangedStringIDArray(Trie T)
	{
		int j = 0;
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<String> B2 = new ArrayList<String>();
		CreateStringIDArray(1,B,0);
		B.add(0,null);
		String[] B3 = new String[B.size()];
		B3 = B.toArray(B3);
		for(int i=1; i<B3.length; i++)
		{
			if(!B2.contains(B3[i]))
			{
				j = i;
				B2.add(B3[j]);
				while(L[j] != -1)
				{
					j = L[j];
					B2.add(B3[j]);
				}
			} 
		}
		return B2;
	}
	
	// CREATE STRING ID ARRAY FUNCTION
	public int CreateStringIDArray(int n, ArrayList<String> B, int prev)
	{
		//int pLocal = prev;
		int childValue = 0;
		int labelValue = 0;
		String stringID = null;
		stringID = checkLeafNode(n);
		if(stringID != null)
		{
			B.add(stringID);
			L[prev] = B.size();
			L[B.size()] = -1;
			return B.size();
			
		}
		else
		{
			LinkedHashMap<String, LinkedHashMap> nchild = count.get(n);
			for (String temp: nchild.keySet())
			{
				LinkedHashMap values = nchild.get(temp);
				for (Entry<Integer, LinkedHashMap<String, LinkedHashMap>> me2 : count.entrySet()) 
				{
					if (me2.getValue().toString().equals(values.toString())) 
					{
							childValue = me2.getKey();
							//System.out.println("Value is" + childValue);
							labelValue = childLabel(n,"#");
							if(labelValue == childValue)
							{
								CreateStringIDArray(childValue,B,0);
							}
							else
							{
								prev = CreateStringIDArray(childValue,B,prev);
							}
					}
				}
			}
			return prev;
		}
	}
	
	// Function to return a child with a given label of a particular node
	public int childLabel(int parentNode, String label)
	{
		int retValue=0;
		LinkedHashMap<String, LinkedHashMap> nodehere = count.get(parentNode);
		//System.out.println("childlabel "+ nodehere + parentNode);
		for (String s: nodehere.keySet())
		{
			if(s.equals(label))
			{
				LinkedHashMap values = nodehere.get(s);
				for (Entry<Integer, LinkedHashMap<String, LinkedHashMap>> me2 : count.entrySet()) 
				{
					if (me2.getValue().toString().equals(values.toString())) 
					{
						retValue = me2.getKey();
					}
				}
			}
		}
		return retValue;
	}
	
	public String checkLeafNode(int Node)
	{
		LinkedHashMap<String, LinkedHashMap> nodeNo = count.get(Node);
		for (String s: nodeNo.keySet())
		{
			if(s.length() == 4)
				return s;
			else
				return null;
		}
		return null;
	}
}

