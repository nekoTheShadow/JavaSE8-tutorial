package chapter2.question8;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Question8 {
	public static void main(String[] args) {
		var lst1 = List.of("A", "B", "C");
		var lst2 = List.of("1", "2");
		zip(lst1.stream(), lst2.stream()).forEach(System.out::println);
		// A
		// 1
		// B
		// 2
		// C
	}
	
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		var iterator = new ZipIterator<>(first, second);
		var spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
		return StreamSupport.stream(spliterator, false);
	}
	
	private static class ZipIterator<E> implements Iterator<E> {
		
		private List<Iterator<E>> iters;
		private int i;
		
		private ZipIterator(Stream<E> first, Stream<E> second) {
			this.iters = List.of(first.iterator(), second.iterator());
			this.i = 0;
		}
		
		@Override
		public boolean hasNext() {
			return iters.get(i).hasNext();
		}

		@Override
		public E next() {
			var e = iters.get(i).next();
			i = (i + 1) % iters.size();
			return e;
		}
	}
}
