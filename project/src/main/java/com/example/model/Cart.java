package com.example.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	public Map<Integer, CartItem> items = new HashMap();
	
	public Cart() {

	}




	public void addItem(CartItem item) {
		int itemId=item.getId();
		if(items.containsKey(itemId)) {
			CartItem existingItem=items.get(itemId);
			int newQuantity = item.getQuantity();
			int oldquantity = existingItem.getQuantity();
			int totalQuanty=oldquantity+newQuantity;
			existingItem.setQuantity(totalQuanty);
		}
		else {
			
			items.put(itemId, item);
		}
//		Set<Entry<Integer,CartItem>> entries = items.entrySet();
//		for( Entry<Integer,CartItem> x:entries)
//		{
//			System.out.println(x.getKey()+" "+x.getValue());
//		}
	}

	public void updateItem(int itemId,int quantity) {

		if(items.containsKey(itemId))
		{
			if(quantity <= 0)
			{
				deleteItem(itemId);			}
			else
			{
				//items.get(itemId) it will return an existingCartItem
				items.get(itemId).setQuantity(quantity);
//				System.out.println(items.get(itemId).getQuantity());
			}
		}
	}


	public void deleteItem(int itemId) {
	if(items.size()>1)
	{
		items.remove(itemId);	
	}
	else
	{
		clearAllItems();
	}
	}

	public void clearAllItems()
	{
		items.clear();
	}
	
	public Map<Integer, CartItem> getItems()
	{
		return items;
	}


}
