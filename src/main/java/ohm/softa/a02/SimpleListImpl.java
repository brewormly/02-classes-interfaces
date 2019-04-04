package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private Element head;
    private int size;

    public SimpleListImpl() {
        this.head = null;
        this.size = 0;
        new Testi().new Inner();
    }

    private static class Element {
        private Object item;
        private Element next;

        public Element(Object item) {
            this.item = item;
            this.next = null;
        }

        public Object getItem() {
            return item;
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public Element getNext() {
            return this.next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private class SimpleIteratorImpl implements Iterator {
        private Element current = head;

        @Override
        public boolean hasNext() {
            if (current != null)
                return true;
            return false;
        }

        /**
         * Immer wenn next geht er auch eins weiter
         * @return
         */
        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }


    @Override
    public void add(Object o) {
        if (head == null) {
            head = new Element(o);
        } else {
            Element current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Element(o));
        }
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl tmp = new SimpleListImpl();

        Element current = this.head;
        while (current.getNext() != null) {
            if(filter.include(current.getItem())){
                tmp.add(current.getItem());
            }
            current = current.getNext();
        }
        /*
        kann man sich mal merken, gerade das this ist ja der knaller
        SimpleList result = new SimpleListImpl();
        for(Object o : this){
            if(filter.include(o)){
                result.add(o);
            }
        }
        return result;

         */

        return tmp;
    }


    @Override
    public Iterator<Object> iterator() {
        return new SimpleIteratorImpl();
    }


}
