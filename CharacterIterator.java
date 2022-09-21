import structure5.*;

/**
* An iterator that yields the consecutive characters of a String, in order
*/
public class CharacterIterator extends AbstractIterator<Character> {
	String Str;
	Character Char;
	int index;

	public CharacterIterator(String str) {
		// what "state" do you need to iterate over the characters in a String?
		Str = str;
		Char = Str.charAt(0);
		index = 0;
	}

	public Character next() {
		// given your current location in the iteration, yield the "next"
    // character and then advance the state of the iteration
		Assert.pre(hasNext() == true, "hasNext evaluates to true");
		Char = Str.charAt(index++);
			return Char;
	}

	public boolean hasNext() {
		// are there still characters left to yield?
	if ((index + 1) < Str.length()) {
			return true;
		}
		return false;
	}

	public void reset() {
		// this is part of the AbstractIterator class's requirements;
    // reset is not part of the standerd Iterable interface, but
    // it is incredibly useful!
		index = 0;
	}

	public Character get() {
		// given your current location in the iteration, yield the "next"
		// character, but DO NOT advance the state of the iteration
		// Repeated calls to get should yield the same character.
		return Str.charAt(index);
	}

	public static void main(String[] args) {
		CharacterIterator ci = new CharacterIterator("Hello world!");
		for (char c : ci) {
			System.out.println(c);
		}
	}

}
