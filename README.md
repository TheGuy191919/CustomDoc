
# CustomDoc
----
## Introduction
This is an eclipse plugin to generate class and method templates requried for CS2510 Fundimentals 2 at NEU. Examples are located at the bottom.  

----
## Requirement
* Eclipse Neon or above

----
## Install
1. Download the compiled plugin that has already been packaged into an update site from [here](https://github.com/TheGuy191919/CustomDoc/raw/master/CustomDoc.zip).
2. Open eclipse and go to Help -> Install new Software...
3. In the install window, click the "Add" button.
4. In the Add Respoitory window, click the "Archive" button and locate the zip file downloaded from step 1.
5. Click ok and install all the items shows on the screen.
6. Wait for the installation to complete, Accept the license and eclipse will ask you to restart when it is all done.

----
## Usage
Go to the file in the editor and go to Template -> Generate to generate templates for that file.

----
## Samples
Class Template

    /*Class Template for class Field
	 * Field
	 *   this.name - String
	 *   this.type - String
	 *   this.generics - ArrayList<String>
	 * Method
	 *   this.toString() - String
	 *   this.toString() - String
	 *   this.getType() - String
	 *   this.getMethodOfField() - ArrayList<String>
	 *   this.getType() - String
	 *   this.getName() - String
	 * Method on field
	 *   this.name.charAt(int) - char
	 *   this.name.checkBounds(byte[], int, int) - void
	 *   this.name.codePointAt(int) - int
	 *   this.name.codePointBefore(int) - int
	 *   this.name.codePointCount(int, int) - int
	 *   this.name.compareTo(String) - int
	 *   this.name.compareToIgnoreCase(String) - int
	 *   this.name.concat(String) - String
	 *   this.name.contains(CharSequence) - boolean
	 *   this.name.contentEquals(StringBuffer) - boolean
	 *   this.name.contentEquals(CharSequence) - boolean
	 *   this.name.copyValueOf(char[]) - String
	 *   this.name.copyValueOf(char[], int, int) - String
	 *   this.name.endsWith(String) - boolean
	 *   this.name.equals(Object) - boolean
	 *   this.name.equalsIgnoreCase(String) - boolean
	 *   this.name.format(String, Object[]) - String
	 *   this.name.format(Locale, String, Object[]) - String
	 *   this.name.getBytes() - byte[]
	 *   this.name.getBytes(String) - byte[]
	 *   this.name.getBytes(Charset) - byte[]
	 *   this.name.getBytes(int, int, byte[], int) - void
	 *   this.name.getChars(char[], int) - void
	 *   this.name.getChars(int, int, char[], int) - void
	 *   this.name.hashCode() - int
	 *   this.name.indexOf(int) - int
	 *   this.name.indexOf(String) - int
	 *   this.name.indexOf(int, int) - int
	 *   this.name.indexOf(String, int) - int
	 *   this.name.indexOf(char[], int, int, String, int) - int
	 *   this.name.indexOf(char[], int, int, char[], int, int, int) - int
	 *   this.name.indexOfSupplementary(int, int) - int
	 *   this.name.intern() - String
	 *   this.name.isEmpty() - boolean
	 *   this.name.join(CharSequence, CharSequence[]) - String
	 *   this.name.join(CharSequence, Iterable<? extends CharSequence>) - String
	 *   this.name.lastIndexOf(int) - int
	 *   this.name.lastIndexOf(String) - int
	 *   this.name.lastIndexOf(int, int) - int
	 *   this.name.lastIndexOf(String, int) - int
	 *   this.name.lastIndexOf(char[], int, int, String, int) - int
	 *   this.name.lastIndexOf(char[], int, int, char[], int, int, int) - int
	 *   this.name.lastIndexOfSupplementary(int, int) - int
	 *   this.name.length() - int
	 *   this.name.matches(String) - boolean
	 *   this.name.nonSyncContentEquals(AbstractStringBuilder) - boolean
	 *   this.name.offsetByCodePoints(int, int) - int
	 *   this.name.regionMatches(int, String, int, int) - boolean
	 *   this.name.regionMatches(boolean, int, String, int, int) - boolean
	 *   this.name.replace(char, char) - String
	 *   this.name.replace(CharSequence, CharSequence) - String
	 *   this.name.replaceAll(String, String) - String
	 *   this.name.replaceFirst(String, String) - String
	 *   this.name.split(String) - String[]
	 *   this.name.split(String, int) - String[]
	 *   this.name.startsWith(String) - boolean
	 *   this.name.startsWith(String, int) - boolean
	 *   this.name.subSequence(int, int) - CharSequence
	 *   this.name.substring(int) - String
	 *   this.name.substring(int, int) - String
	 *   this.name.toCharArray() - char[]
	 *   this.name.toLowerCase() - String
	 *   this.name.toLowerCase(Locale) - String
	 *   this.name.toString() - String
	 *   this.name.toUpperCase() - String
	 *   this.name.toUpperCase(Locale) - String
	 *   this.name.trim() - String
	 *   this.name.valueOf(Object) - String
	 *   this.name.valueOf(char[]) - String
	 *   this.name.valueOf(boolean) - String
	 *   this.name.valueOf(char) - String
	 *   this.name.valueOf(int) - String
	 *   this.name.valueOf(long) - String
	 *   this.name.valueOf(float) - String
	 *   this.name.valueOf(double) - String
	 *   this.name.valueOf(char[], int, int) - String
	 *   this.type.charAt(int) - char
	 *   this.type.checkBounds(byte[], int, int) - void
	 *   this.type.codePointAt(int) - int
	 *   this.type.codePointBefore(int) - int
	 *   this.type.codePointCount(int, int) - int
	 *   this.type.compareTo(String) - int
	 *   this.type.compareToIgnoreCase(String) - int
	 *   this.type.concat(String) - String
	 *   this.type.contains(CharSequence) - boolean
	 *   this.type.contentEquals(StringBuffer) - boolean
	 *   this.type.contentEquals(CharSequence) - boolean
	 *   this.type.copyValueOf(char[]) - String
	 *   this.type.copyValueOf(char[], int, int) - String
	 *   this.type.endsWith(String) - boolean
	 *   this.type.equals(Object) - boolean
	 *   this.type.equalsIgnoreCase(String) - boolean
	 *   this.type.format(String, Object[]) - String
	 *   this.type.format(Locale, String, Object[]) - String
	 *   this.type.getBytes() - byte[]
	 *   this.type.getBytes(String) - byte[]
	 *   this.type.getBytes(Charset) - byte[]
	 *   this.type.getBytes(int, int, byte[], int) - void
	 *   this.type.getChars(char[], int) - void
	 *   this.type.getChars(int, int, char[], int) - void
	 *   this.type.hashCode() - int
	 *   this.type.indexOf(int) - int
	 *   this.type.indexOf(String) - int
	 *   this.type.indexOf(int, int) - int
	 *   this.type.indexOf(String, int) - int
	 *   this.type.indexOf(char[], int, int, String, int) - int
	 *   this.type.indexOf(char[], int, int, char[], int, int, int) - int
	 *   this.type.indexOfSupplementary(int, int) - int
	 *   this.type.intern() - String
	 *   this.type.isEmpty() - boolean
	 *   this.type.join(CharSequence, CharSequence[]) - String
	 *   this.type.join(CharSequence, Iterable<? extends CharSequence>) - String
	 *   this.type.lastIndexOf(int) - int
	 *   this.type.lastIndexOf(String) - int
	 *   this.type.lastIndexOf(int, int) - int
	 *   this.type.lastIndexOf(String, int) - int
	 *   this.type.lastIndexOf(char[], int, int, String, int) - int
	 *   this.type.lastIndexOf(char[], int, int, char[], int, int, int) - int
	 *   this.type.lastIndexOfSupplementary(int, int) - int
	 *   this.type.length() - int
	 *   this.type.matches(String) - boolean
	 *   this.type.nonSyncContentEquals(AbstractStringBuilder) - boolean
	 *   this.type.offsetByCodePoints(int, int) - int
	 *   this.type.regionMatches(int, String, int, int) - boolean
	 *   this.type.regionMatches(boolean, int, String, int, int) - boolean
	 *   this.type.replace(char, char) - String
	 *   this.type.replace(CharSequence, CharSequence) - String
	 *   this.type.replaceAll(String, String) - String
	 *   this.type.replaceFirst(String, String) - String
	 *   this.type.split(String) - String[]
	 *   this.type.split(String, int) - String[]
	 *   this.type.startsWith(String) - boolean
	 *   this.type.startsWith(String, int) - boolean
	 *   this.type.subSequence(int, int) - CharSequence
	 *   this.type.substring(int) - String
	 *   this.type.substring(int, int) - String
	 *   this.type.toCharArray() - char[]
	 *   this.type.toLowerCase() - String
	 *   this.type.toLowerCase(Locale) - String
	 *   this.type.toString() - String
	 *   this.type.toUpperCase() - String
	 *   this.type.toUpperCase(Locale) - String
	 *   this.type.trim() - String
	 *   this.type.valueOf(Object) - String
	 *   this.type.valueOf(char[]) - String
	 *   this.type.valueOf(boolean) - String
	 *   this.type.valueOf(char) - String
	 *   this.type.valueOf(int) - String
	 *   this.type.valueOf(long) - String
	 *   this.type.valueOf(float) - String
	 *   this.type.valueOf(double) - String
	 *   this.type.valueOf(char[], int, int) - String
	 *   this.generics.add(String) - boolean
	 *   this.generics.add(int, String) - void
	 *   this.generics.addAll(Collection<? extends String>) - boolean
	 *   this.generics.addAll(int, Collection<? extends String>) - boolean
	 *   this.generics.batchRemove(Collection<?>, boolean) - boolean
	 *   this.generics.clear() - void
	 *   this.generics.clone() - Object
	 *   this.generics.contains(Object) - boolean
	 *   this.generics.elementData(int) - String
	 *   this.generics.ensureCapacity(int) - void
	 *   this.generics.ensureCapacityInternal(int) - void
	 *   this.generics.ensureExplicitCapacity(int) - void
	 *   this.generics.fastRemove(int) - void
	 *   this.generics.forEach(Consumer<? super String>) - void
	 *   this.generics.get(int) - String
	 *   this.generics.grow(int) - void
	 *   this.generics.hugeCapacity(int) - int
	 *   this.generics.indexOf(Object) - int
	 *   this.generics.isEmpty() - boolean
	 *   this.generics.iterator() - Iterator<String>
	 *   this.generics.lastIndexOf(Object) - int
	 *   this.generics.listIterator() - ListIterator<String>
	 *   this.generics.listIterator(int) - ListIterator<String>
	 *   this.generics.outOfBoundsMsg(int) - String
	 *   this.generics.rangeCheck(int) - void
	 *   this.generics.rangeCheckForAdd(int) - void
	 *   this.generics.readObject(ObjectInputStream) - void
	 *   this.generics.remove(int) - String
	 *   this.generics.remove(Object) - boolean
	 *   this.generics.removeAll(Collection<?>) - boolean
	 *   this.generics.removeIf(Predicate<? super String>) - boolean
	 *   this.generics.removeRange(int, int) - void
	 *   this.generics.replaceAll(UnaryOperator<String>) - void
	 *   this.generics.retainAll(Collection<?>) - boolean
	 *   this.generics.set(int, String) - String
	 *   this.generics.size() - int
	 *   this.generics.sort(Comparator<? super String>) - void
	 *   this.generics.spliterator() - Spliterator<String>
	 *   this.generics.subList(int, int) - List<String>
	 *   this.generics.subListRangeCheck(int, int, int) - void
	 *   this.generics.toArray() - Object[]
	 *   this.generics.toArray(T[]) - T[]
	 *   this.generics.trimToSize() - void
	 *   this.generics.writeObject(ObjectOutputStream) - void
	 * 
	 */

Method Template #1

    /*Everything in the class template plus:
	 * Params
	 *   Nothing
	 * Method on Params
	 *   Nothing
	 * 
	 */

Method Template #2

    /*Everything in the class template plus:
	 * Params
	 *   replacement - HashMap<String,String>
	 * Method on Params
	 *   replacement.afterNodeAccess(Node<String,String>) - void
	 *   replacement.afterNodeInsertion(boolean) - void
	 *   replacement.afterNodeRemoval(Node<String,String>) - void
	 *   replacement.capacity() - int
	 *   replacement.clear() - void
	 *   replacement.clone() - Object
	 *   replacement.comparableClassFor(Object) - Class<?>
	 *   replacement.compareComparables(Class<?>, Object, Object) - int
	 *   replacement.compute(String, BiFunction<? super String,? super String,? extends String>) - String
	 *   replacement.computeIfAbsent(String, Function<? super String,? extends String>) - String
	 *   replacement.computeIfPresent(String, BiFunction<? super String,? super String,? extends String>) - String
	 *   replacement.containsKey(Object) - boolean
	 *   replacement.containsValue(Object) - boolean
	 *   replacement.entrySet() - Set<Entry<String,String>>
	 *   replacement.forEach(BiConsumer<? super String,? super String>) - void
	 *   replacement.get(Object) - String
	 *   replacement.getNode(int, Object) - Node<String,String>
	 *   replacement.getOrDefault(Object, String) - String
	 *   replacement.hash(Object) - int
	 *   replacement.internalWriteEntries(ObjectOutputStream) - void
	 *   replacement.isEmpty() - boolean
	 *   replacement.keySet() - Set<String>
	 *   replacement.loadFactor() - float
	 *   replacement.merge(String, String, BiFunction<? super String,? super String,? extends String>) - String
	 *   replacement.newNode(int, String, String, Node<String,String>) - Node<String,String>
	 *   replacement.newTreeNode(int, String, String, Node<String,String>) - TreeNode<String,String>
	 *   replacement.put(String, String) - String
	 *   replacement.putAll(Map<? extends String,? extends String>) - void
	 *   replacement.putIfAbsent(String, String) - String
	 *   replacement.putMapEntries(Map<? extends String,? extends String>, boolean) - void
	 *   replacement.putVal(int, String, String, boolean, boolean) - String
	 *   replacement.readObject(ObjectInputStream) - void
	 *   replacement.reinitialize() - void
	 *   replacement.remove(Object) - String
	 *   replacement.remove(Object, Object) - boolean
	 *   replacement.removeNode(int, Object, Object, boolean, boolean) - Node<String,String>
	 *   replacement.replace(String, String) - String
	 *   replacement.replace(String, String, String) - boolean
	 *   replacement.replaceAll(BiFunction<? super String,? super String,? extends String>) - void
	 *   replacement.replacementNode(Node<String,String>, Node<String,String>) - Node<String,String>
	 *   replacement.replacementTreeNode(Node<String,String>, Node<String,String>) - TreeNode<String,String>
	 *   replacement.resize() - Node<String,String>[]
	 *   replacement.size() - int
	 *   replacement.tableSizeFor(int) - int
	 *   replacement.treeifyBin(Node<String,String>[], int) - void
	 *   replacement.values() - Collection<String>
	 *   replacement.writeObject(ObjectOutputStream) - void
	 * 
	 */
----
## Warning
* This program is provided as is and I bear no responsabality from the usage of the program.
* I cannot guarantee the correctness of the program, always double check the output personally. 
