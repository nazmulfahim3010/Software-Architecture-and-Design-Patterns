public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepo namerepo = new NameRepo();
        for (Iterator iter = namerepo.getIterator(); iter.hasNext();) {
            String name = (String) iter.Next();
            System.out.println("Name : " + name);
        }

    }
}

interface Container {
    public Iterator getIterator();

}

interface Iterator {
    public boolean hasNext();

    public Object Next();
}

class NameRepo implements Container {
    public String names[] = { "Fahim", "Nazmul", "Hasan", "Famm" };

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object Next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }

    }

}