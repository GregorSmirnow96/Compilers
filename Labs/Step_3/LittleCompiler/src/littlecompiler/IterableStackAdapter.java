/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author im5no
 * @param <T>
 */
public class IterableStackAdapter<T> extends Stack<T>
{
    private final ArrayList<T> arrayList;
    
    public IterableStackAdapter(ArrayList<T> arrayList)
    {
        this.arrayList = arrayList;
    }
    
    @Override
    public T push(T element)
    {
        arrayList.add(element);
        return element;
    }
    
    @Override
    public T pop()
    {
        T poppedElement = this.arrayList.get(arrayList.size() - 1);
        this.arrayList.remove(poppedElement);
        return poppedElement;
    }
    
    @Override
    public T peek()
    {
        return this.arrayList.get(arrayList.size() - 1);
    }
    
    public Iterator<T> getIterator()
    {
        return this.arrayList.iterator();
    }
}