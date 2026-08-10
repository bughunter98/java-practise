package org.example.Streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsPractise {
    public static void main(String[] args) {
        List<Integer> employeeList = Arrays.asList(3000,5000,2000,4000,1000);
        List<Employee> employeesList = Arrays.asList(new Employee(1,3000,"DEV","Hyderabad","teja"),
                new Employee(2,5000,"HR","Hyderabad","sai"),new Employee(3,2000,"QA","Chennai","john")
                ,new Employee(4,4000,"DevOps","Bangalore","venkat"),new Employee(5,1000,"AI","Pune","ajit")
        ,new Employee(6,1500,"QA","Banglore","daksh"));
        //1. sort list of employees by salary desc
        System.out.println(employeeList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(employeesList.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .collect(Collectors.toList())); // “Java implicitly calls toString() whenever an object is used where a String is expected,
        // such as printing, concatenation, logging, or inside collections’ toString() methods.
        // That’s why we see readable output only after overriding toString().”
        // “Java implicitly calls toString() whenever an object is used where a String is expected, such as printing,
        // concatenation, logging, or inside collections’ toString() methods. That’s why we see readable output only
        // after overriding toString().”
        // ************************************************************************************************************
        // 2 . Sort employees by department then salary
        System.out.println(employeesList.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getEmpSalary)).toList());
        // 3. grouping by example
        System.out.println(employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment)));
        // this will give the ascending order of depts that are grouped by length.
        System.out.println(employeesList.stream().map(Employee::getDepartment).collect(Collectors.groupingBy(String::length)));
        // for descending order
        System.out.println(employeesList.stream().map(Employee::getDepartment).collect(Collectors.groupingBy(String::length,
                ()->new TreeMap<>(Comparator.reverseOrder()),
                Collectors.toList())));
        // 4. Sum all salaries in department using groupingby
        System.out.println(employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingInt(Employee::getEmpSalary))));
        // 5. Sum all numbers using reduce()
        // if we use reduce(Integer::sum) this returns an optional
        System.out.println(employeesList.stream().map(Employee::getEmpSalary).
                reduce(Integer::sum).get());
        // wihtout optional
        // this is how reduce(0,Integaer::sum) works
        /*
        * start = 0
          0 + 3000 = 3000
          3000 + 5000 = 8000
          8000 + 2000 = 10000
          * */
        System.out.println(employeesList.stream().map(Employee::getEmpSalary).
                reduce(0,Integer::sum));

        // 6 . count occurances of each element in a list .
        List<String> alphabetList = Arrays.asList("a","b","a","c","a","b");
        // without stream we can loop and perform the logic
        // when ever number of elements come we need to use counting
        System.out.println(alphabetList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        List<List<Integer>> intList = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6));
        System.out.println(intList);
        System.out.println(intList.stream().flatMap(List::stream).toList());


        //7) sort employees by salary descending
        List<Employee> empList = Arrays.asList(new Employee(1,2000,"IT","Hyderabad","sai")
                ,new Employee(3,1000,"IT","Banglore","teja"),new Employee(2,3000,"IT","Chennai","naveen"),
                new Employee(1,2000,"NONIT","Allahabad","ajit"));
        System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).toList());

        //8) Convert List to Map safely handling duplicate keys
        Map<Integer,Employee> resultMap = empList.stream().collect(
                Collectors.toMap(Employee::getEmpId, Function.identity(), (e1, e2) -> e1));
        // this is same as above but slight diff . in output this will take the most recently updated value for that key unlike
        // above which takes the first value
        Map<Integer,Employee> resultMap1 = empList.stream().collect(
                Collectors.toMap(Employee::getEmpId, Function.identity(), (e1, e2) -> e2));
        System.out.println(resultMap);
        System.out.println(resultMap1);
        // group employees by dept
        Map<String, List<Employee>> grpByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(grpByDept);

        //9) find average salary per department .
       Map<String, Double> empAvgSalaryByDEpt = empList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.averagingInt(Employee::getEmpSalary)));
        System.out.println(empAvgSalaryByDEpt);

        //10) count employees per department
        Map<String,Long> empPerDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(empPerDept);

        //11) highest paid employee in each department
        /*Map<String, Optional<Employee>> highPaidEmp = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getEmpSalary))));*/
        // collectors.maxBy returns optional . so we need to extract that hence above is not useful so i am using below
        // above gives response this way
        // {NONIT=Optional[Employee{empId=1, empSalary=2000, department=NONIT}], IT=Optional[Employee{empId=2, empSalary=3000, department=IT}]}
        Map<String, Employee> highPaidEmp = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getEmpSalary)),
                        Optional::get // Extract the value before the Map is finished
                )));
        System.out.println(highPaidEmp);
        //Partition employees by salary > threshold
       Map<Boolean, List<Employee>> s = empList.stream().collect(Collectors.partitioningBy(emp -> emp.getEmpSalary() > 1500));
        System.out.println(s);

        // 12)find employees based on city and then sort them according to alphabet order.
        // prints Allahabad=[Employee{empId=1name=ajit, empSalary=2000, department=NONIT, City=Allahabad}], Banglore=[Employee{empId=3name=teja, empSalary=1000, department=IT, City=Banglore}]
        Map<String,List<Employee>> employeeGroupByCity = empList.stream().
                sorted(Comparator.comparing(Employee::getName)).
                collect(Collectors.groupingBy(Employee::getCity));

        System.out.println(employeeGroupByCity);

        // if we want an improvised version of it which gives output like  Allahabad=[Ajit]

        // first approach
         employeeGroupByCity.forEach((city,employees)->{
             List<String> names = employees.stream().map(Employee::getName).toList();
             System.out.println(city +" "+names);
         });

         // second approach  little tricky

      Map<String,List<String>> x = empList.stream().
                sorted(Comparator.comparing(Employee::getName)).
                collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(x);


      // 13) find the occurances of names of employees and their frequencies

      Map<String,Long> empFreq = employeesList.stream().collect(Collectors.groupingBy(
              Employee::getName,Collectors.counting()));


        System.out.println(empFreq);

        // 14) You have a Map<String, Integer> with employee names and their performance scores.
        // You need the top 3 performers in descending order of score. How will you achieve this? give me easy java code
        // 1. Create the sample map
        Map<String, Integer> employees = new HashMap<>();
        employees.put("Alice", 85);
        employees.put("Bob", 95);
        employees.put("Charlie", 70);
        employees.put("David", 98);
        employees.put("Eve", 92);

        // approach 1
        List<Map.Entry<String,Integer>> emp = employees.entrySet().stream().sorted(
                Map.Entry.<String,Integer>comparingByValue().reversed()).
                limit(3).toList();

        System.out.println(emp);

        // approach 2
        List<Map.Entry<String,Integer>> emp1 = new ArrayList<>(employees.entrySet());
        // to compare in descending order
        emp1.sort((a,b)->b.getValue().compareTo(a.getValue()));

        List<Map.Entry<String, Integer>> emp1output = emp1.stream().limit(3).toList();

        System.out.println(emp1output);


        // 15) . Write a program to print only numbers from an alphanumeric char array using stream API

        // first convert the char array to stream then check by using character.isDigit method and then print
        char[] charArray = {'1','A','2','B','3','C','4','D','5'};
        Character[] chaArray = {'1','A','2','B','3','C','4','D','5'};
        // approach 1
        // .chars() converts the String to Intstream
        // Stiring.lines coverts to Stream<String> where as .chars() coverts to IntStream thats key diff.
        new String(charArray).chars().filter(Character::isDigit).forEach(val-> System.out.print((char)val +" ,"));
        System.out.println();
        // approach 2
        // use Arrays
        Arrays.stream(chaArray).filter(Character::isDigit).forEach(System.out::println);

        //16) Write a program to find the sum of the entire array using Java 8 streams.

        int [] arr = {1,2,5,6,7,8,9};
        int arrSum = Arrays.stream(arr).sum();
        System.out.println(arrSum);

        // 17)  Write a program to find even numbers from a list and multiply them by 2 using streams.
        List<Integer> evenList  = Arrays.asList(1,2,4,6,5,3,7,9,4);
        evenList.stream().filter(n->n%2==0).map(n->n*2).forEach(n->System.out.print(n+","));

        // 18) . Write a program to find the occurrence of each word in a given string.
        // approach 1
        String word  = "saitejathota";
        Map<Character,Integer> wordOccurance = new HashMap<>();

         for(char c : word.toCharArray()){
             if (!wordOccurance.containsKey(c)){
                 wordOccurance.put(c,1);
             }
             else {
                 wordOccurance.put(c,wordOccurance.get(c)+1);
             }
         }
        System.out.println();
        wordOccurance.forEach((k,v)->{
            System.out.println("Alphabet : "+k+" "+"occurance : "+v);
        });

        // approach 2 (can check later)

        //19) Write a program to find common elements from three ArrayLists.

        List<Integer> list1 = Arrays.asList(1,5,10,20,40,80);
        List<Integer> list2 = Arrays.asList(6,7,20,80,100,5);
        List<Integer> list3 = Arrays.asList(3,4,20,15,30,70,80,5,10);


        // approach 1 using hashset ..
        // there is a method called retain all . that will keep only the common elements between two lists.

        Set<Integer> hashSet =  new HashSet<>(list1);

        hashSet.retainAll(list2);
        hashSet.retainAll(list3);
        System.out.println(hashSet);

        // approach 2 using hashmap .
        // clubbing all the lists into one
        List<List<Integer>> combinedList  = Arrays.asList(list1,list2,list3);
        Map<Integer,Integer> hashMap = new/* ConcurrentHashMap*/HashMap<>();
        // since i am removing in loop it throws concurrentModificationException
        // or simply use removeIF which doesn't need this iterator
        for (List<Integer> intList1 : combinedList){
            for (int num : intList1){
                hashMap.put(num,hashMap.getOrDefault(num,0)+1);
            }
        }

        hashMap.entrySet().removeIf(v->v.getValue()!=3);
        /*for (Map.Entry<Integer,Integer> m : hashMap.entrySet()){
            if (m.getValue()!=3){
                hashMap.remove(m.getKey());
            }
        }*/

        hashMap.forEach((k,v)-> System.out.println(k));

        //20. Write a program to convert a string to integer without using any API.

        String str  = "4567";

        int ans = 0;
        for(int i=0;i<str.length();i++){

            // Step 4: Grab the single character at the current position 'i'
            char c = str.charAt(i);

            // Step 5: Convert the character to its real numeric value.
            // In computer memory, characters have hidden number codes (ASCII).
            // The character '0' has a code of 48, and '1' has a code of 49.
            // By subtracting '0' (48), we get the actual math number.
            // Example: '1' (49) minus '0' (48) equals the integer 1.
            int singleDigit = c-'0';

            // Step 6: Build the final number step-by-step.
            // We multiply our current total by 10 to push it over by one decimal place.
            // Then we add the new digit to the end.
            // Example for "456":
            // Loop 1: (0 * 10) + 4 = 4
            // Loop 2: (4 * 10) + 5 = 45
            // Loop 3: (45 * 10) + 6 = 456
            ans  =  (ans*10)+singleDigit;
        }

        System.out.println( "String value after converting to int is :"+ans);

        //21. Write a program to find the first occurrence of a character in a string.

        String firstOccurance  = "abcaab";
        char ss = 'b';
        int index = 0;
        for(int i=0;i<firstOccurance.length();i++){
            if (ss == firstOccurance.charAt(i)){
                index=i;
                break;
            }
        }

        System.out.println("First occurance of string ' "+ss+ " ' is at index :"+index);


        //22. Write a program to find the missing number in an array.

        int[] array = new int[]{1,2,5,4,6};
        int n = array.length+1;
        int sum = n*(n+1)/2;
        int sum1 = 0;
        for (int val : array){
            sum1 = sum1+val;
        }

        int outp = sum-sum1;
        System.out.println("Missing number is :"+outp);
        // but if array starts with diff value then above wont work . use below

        int[] array1 = new int[]{31,32,34,35,36};
        int n1 = array1.length+1;
        int sum2 = n1*(array1[0]+array1[array1.length-1])/2;
        int sum3 = 0;
        for (int val:array1){
            sum3=sum3+val;
        }
        int outp1 = sum2-sum3;
        System.out.println("Missing number is : "+outp1);


        //23.  Write a program to find all possible combinations of the string "GOD"

        String god  = "GOD";
        // mostly this is probability .. where we used permutations and combinations .

        List<String> results = new ArrayList<>();

        generateCombination(god.toCharArray(),0,results);

        //24 Write a program to check for valid parentheses.



        String parenthesisValidator = "()[]{}";

        // Approach 1 : use  custom stack using a primitive array
        boolean isParenthesesValidApproach1 = parenthesesValidator(parenthesisValidator);
        // Approach 2 : use  Stack approach
        boolean isParenthesesValidApproach2 = parenthesesValidator1(parenthesisValidator);


        System.out.println( " is parenthesis valid ? "+isParenthesesValidApproach1);
        System.out.println( " is parenthesis valid ? "+isParenthesesValidApproach2);


        //25 . Write a program to find duplicates in an ArrayList.
        List<String> duplicates  =  new ArrayList<>(Arrays.asList("Apple","Banana","Apple","Orange","apple","grape","Banana"));

        // approach 1 // using hashset.
        findDuplicatesUsingHashset(duplicates);

        // approach 2 : using java streams

        findDuplicatesUsingJavaStreams(duplicates);

        // 26. Write a program for the Quick Sort algorithm.

        int[] quickSortArray = {10, 7, 8, 9, 1, 5};
        int arrLenght = quickSortArray.length;
        //quickSort(quickSortArray,0,arrLenght-1);

        // 27. Write a program to check the minimum number of occurrences of a character in a string.
        String testStr = "javaprogramming";
        getMinOccurrence(testStr);

        //28. Write a program where each index stores the product of all array elements except itself.

        int [] nums =new int[] {1, 2, 3, 4};
        // time complexity O(n2).
        productOfAllArrayElementsExceptItself(nums);
        productOfAllArrayElementsExceptItselfUsingStreams(nums);
        productOfAllArrayElementsExceptItselfEffieicentApproach(nums);
        //29. . How to count every character in a string using Java 8 streams?
        System.out.println();
        System.out.println("count every character in a string using Java 8 streams");
        String strr = "SaiTeja";

        Map<Character,Long> strr1 = strr.chars().mapToObj(val -> (char) val).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String,Long> strr2 = Arrays.stream(strr.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strr1);
        System.out.println(strr2);

        //30 . . Write a program to check if a string has all unique characters.
        // lets use above string only
        checkStringIfIthasUniqueCharacters(strr);

        //31 .  Write a program to find spikes in a stock price integer array.

        System.out.println("spikes in a stock price integer array");
        int [] stockPrices = {1,2,8,5,3,4};
        int k = 2;
        int spikesCountBruteForce  = findNoOfSpikesUsingBruteForce(stockPrices,k);
        int spikesCountEfficient  = findNoOfSpikesUsingEfficientApproach(stockPrices,k);
        System.out.println("no of spikes in stock array :"+spikesCountBruteForce);
        System.out.println("no of spikes in stock array :"+spikesCountEfficient);

        //32. Find the second highest salary of an employee using Java 8 streams.

        List<Employee> employeesSalaryList = new ArrayList<>();
        employeesSalaryList.add(new Employee("Sai",1000));
        employeesSalaryList.add(new Employee("Teja",2000));
        employeesSalaryList.add(new Employee("Naidu",500));
        employeesSalaryList.add(new Employee("Reddy",3000));
        employeesSalaryList.add(new Employee("Sunny",2500));
        employeesSalaryList.add(new Employee("Bunny",5000));

        findSecondHighestSalary(employeesSalaryList);
        findNthHighestSalary(employeesSalaryList);

        // 33. Difference between map(), flatMap(), and filter() with example
        // map() transforms each element individually,
        // flatMap() transforms and flattens nested collections,
        // filter() selects elements based on a condition
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        System.out.println("Input List" + names);
        System.out.println("Map Example :");
        System.out.println(names.stream().map(d->d.toUpperCase()).toList());

        System.out.println("FlatMap Example :");
        List<List<String>> nestedFruits = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date")
        );

        System.out.println(" Flatmap input : "+nestedFruits);
        System.out.println(" Flatmap output : "+   nestedFruits.stream().flatMap(List::stream).toList());
        System.out.println(" Flatmap output with capitals : "+   nestedFruits.stream().flatMap(d->d.stream().map(String::toUpperCase)).toList());

        // filter i need not add example we know many

        //34. Write a program to partition numbers into even and odd using streams
        System.out.println("program to partition numbers into even and odd using streams");
        List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9,10);
        //To partition numbers into even and odd using Java Streams, you should use the Collectors.partitioningBy()

        // Partitions elements into a single map containing two lists
        Map<Boolean,List<Integer>> partitiones = numberList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partitiones);
        // approach 2
        System.out.println("Even list  : "+numberList.stream().filter(num->num%2==0).toList());
        System.out.println("Odd list  : "+numberList.stream().filter(num->num%2!=0).toList());


        //35.  Find the longest string in a list using Java 8 streams.
        System.out.println("longest string in a list using Java 8 streams.");
        List<String> lengthString = List.of("sai","teja","thota","hema","venkata","sai","sheela");
        // we can actually sort and then get first element like below but time complexity will increase to O(NlogN)
        //lengthString.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst();
        // we can use 2 approches now
        //1
        System.out.println("Approach 1:"+lengthString.stream().max(Comparator.comparingInt(String::length)).orElse(null));
        System.out.println("Approach 2:"+lengthString.stream().max((str1,str2)->Integer.compare(str1.length(),str2.length())).orElse(null));

        // 36.Convert a List to Map using Java 8 streams (handle duplicate keys)
        //2. toMap(keyMapper, valueMapper, mergeFunction) --> merger function is to check duplicates and handle them .
        // if we use 2 args only like t2. toMap(keyMapper, valueMapper) then in case there is dupliacte key java throws illegal state exception
        System.out.println("Convert a List to Map using Java 8 streams (handle duplicate keys)");
        System.out.println( lengthString.stream().collect(Collectors.toMap(
                st->st.charAt(0), // key Mapper
                /*Function.identity()*/st->st,// value mapper we can use any .
                (existing,replacement)->existing // merger function to eliminate duplicates
        )));
        // but the above approach actually doesn't print second sai and sheela  because the merger function checks and eliminates suplicate keys right .
        // since sai and sheela have duplicate , we are telling merger function to keep existing and ignore replacement , even if we do vice versa then sheela will be there
        // and sai wont be there . so if we need all values then we need to use grouping by .

        //Map<Character, List<String>>
        System.out.println(lengthString.stream().collect(Collectors.groupingBy(st->st.charAt(0))));

        //37  Write a program to find the top 3 highest paid employees
        // this uses sorted which is O(nlogn)
        System.out.println(" Write a program to find the top 3 highest paid employees");
        System.out.println(employeesSalaryList.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).limit(3).toList());

        // group by dept
        System.out.println("java stream code to group employee by dept and have 3 highest paid employees per dept in resp");
        System.out.println(employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(
                Collectors.toList(),
                list->employeesList.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).limit(3).toList()
        ))));
    }

    private static void findNthHighestSalary(List<Employee> employeesSalaryList) {
    }

    private static void findSecondHighestSalary(List<Employee> employeesSalaryList) {
        // approach 1 --> using comparator
        // While using .sorted() and .skip() is clean and highly readable, it is not performance-optimal for massive datasets or large values of N:
        Optional<Integer> secondHighestSalApproach1 = employeesSalaryList.stream().
                distinct().sorted(Comparator.comparingInt(Employee::getEmpSalary).reversed()).
                map(Employee::getEmpSalary).skip(1).findFirst();
        if (secondHighestSalApproach1.isPresent())
            System.out.println("second highest salary using approch 1 is "+secondHighestSalApproach1.get());
        else
            System.out.println("second highest salary using approch 1 is "+null);

        // approach 2 -->
        Set<Integer> salarySet = new TreeSet<>(Comparator.reverseOrder());
        for(Employee e : employeesSalaryList){
            salarySet.add(e.getEmpSalary());
        }
        System.out.println("second highest salary using approch 2 is "+salarySet.stream().skip(1).findFirst().get());

    }

    private static int findNoOfSpikesUsingEfficientApproach(int[] stockPrices, int k) {
        // this is using a Prefix Suffix approach

        return 0;
    }

    private static int findNoOfSpikesUsingBruteForce(int[] stockPrices,int k) {
        int spikeCount = 0;
        for (int i = 0;i<stockPrices.length;i++){
            int leftCount  = 0;
            int rightCount  = 0;

            // 1. Manually check all elements to the left
            for (int j=0;j<i;j++){
                if (stockPrices[j]<stockPrices[i]){
                    leftCount++;
                }
            }

            // 2. Manually check all elements to the right
            for (int j=i+1;j<stockPrices.length;j++){
                if (stockPrices[j]<stockPrices[i]){
                    rightCount++;
                }
            }
            // 3. If it satisfies the K-spike rule, count it
            if (leftCount>=k && rightCount>=k){
                spikeCount++;
            }

        }
        return spikeCount;
    }

    private static void checkStringIfIthasUniqueCharacters(String strr) {
       char[] arr = strr.toCharArray();
       Set<Character> set = new HashSet<>();
       boolean isDuplicate = false;
       // using for loop
        for (char c : arr) {
            if (!set.add(c)) {
                isDuplicate = true;
                break;
            }
        }
        System.out.println("input string "+strr+" has duplicates : "+isDuplicate);

        // using streams
        boolean isUnique  = (strr.chars().distinct().count() == strr.length());
        System.out.println("input string "+strr+" has all unique characters : "+isUnique);
    }

    private static void productOfAllArrayElementsExceptItselfUsingStreams(int[] nums) {
        int [] answer = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            final int p = i;
            answer[i] = IntStream.range(0,nums.length).filter(k->k!=p)
                    .map(j->nums[j])
                    .reduce(1,(a,b)->a*b);

        }
        System.out.println("productOfAllArrayElementsExceptItselfUsingStreams");
        for (int num : answer){
            System.out.println(num);
        }

    }


    private static void productOfAllArrayElementsExceptItselfEffieicentApproach(int[] nums) {
        //array to store all left multiplication
        int [] left =  new int[nums.length];
        //array to store all rght multiplication
        int [] right =  new int[nums.length];
        int [] ans =  new int[nums.length];

        left[0]  = 1;
        for (int i = 1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }

        right[nums.length-1] = 1;
        // nums.length-2 because we need to ignore first position
        for (int i = nums.length-2;i>=0;i--){
            right[i] = right[i+1]* nums[i+1];
        }

        for (int i=0;i<nums.length;i++){
            ans[i] = left[i]*right[i];
        }

        System.out.println("productOfAllArrayElementsExceptItselfEffieicentApproach");
        for (int i : ans){
            System.out.print(i+" ");
        }


    }

    private static void productOfAllArrayElementsExceptItself(int[] nums) {
        int[] result  = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int product = 1;
            for (int j=0;j<nums.length;j++){
                int current  = nums[j];
                if (i!=j){
                    product = product*current;
                }
                result[i]=product;
            }
        }
        System.out.println("productOfAllArrayElementsExceptItself");

        for (int num : result){
            System.out.println(num);
        }

    }

    private static void getMinOccurrence(String str) {
        if (str==null|| str.isEmpty()){
            return;
        }
        Map<Character,Integer> frequencyMap = /*new HashMap<>();*/ /*using linked hashmap preserves the order*/ new LinkedHashMap<>();
        for (char ch : str.toCharArray()){
            if (ch != ' ') {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        int minValue  = Integer.MAX_VALUE;
        char minChar = ' ';
        for (char ch : frequencyMap.keySet()){
            int count = frequencyMap.get(ch);
            if (count<minValue){
                minValue = count;
                minChar = ch;
            }
        }
        System.out.println("Character: '" + minChar + "' appears " + minValue + " time(s).");
    }

    private static void quickSort(int[] quickSortArray, int low, int high) {
        // recursion condition should be there to break the loop
        if (low<high){
            // partition logic is the most crucial now...
            int partition  = partition(quickSortArray,low,high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(quickSortArray,low,partition-1);
            quickSort(quickSortArray,partition+1,high);
        }
    }

    private static int partition(int[] quickSortArray, int low, int high) {
        // last index is choosen as pivot .
        int pivot  = quickSortArray[high];
        return 1;
    }

    private static void findDuplicatesUsingJavaStreams(List<String> duplicates) {
        Set<String> seen = new HashSet<>();
        List<String> dup = duplicates.stream().filter(x -> !seen.add(x)).distinct().toList();
        System.out.println("Original List : "+duplicates);
        System.out.println("Duplicate Elemetns :"+dup);
    }

    private static void findDuplicatesUsingHashset(List<String> duplicates) {
        Set<String> uniqueElements = new HashSet<>();
        Set<String> duplicateElements = new HashSet<>();

        for (String s : duplicates){
            if (!uniqueElements.add(s)){
                duplicateElements.add(s);
            }
        }
        System.out.println("Original List : "+duplicates);
        System.out.println("Duplicate Elemetns :"+duplicateElements);
    }

    private static void generateCombination(char[] charArray, int currentIndex, List<String> results) {
        // now we need to iterate

        // BASE CASE: If we have reached the last character, a full combination is ready
        // hence recursion should break.
        if (currentIndex == charArray.length-1){
            // Convert the character array back to a String and save it
            results.add(new String(charArray));
        }
        //GOD
        for (int i=currentIndex;i<charArray.length;i++){
            // 1. SWAP: Put the character at index 'i' into our current active slot
            swap(charArray,currentIndex,i);
            // 2. RECURSE: Move to the next index slot (currentIndex + 1) and dig deeper
            generateCombination(charArray,currentIndex+1,results);

            swap(charArray,currentIndex,i);
        }
    }

    // A helper method to switch the places of two characters in the array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static boolean parenthesesValidator1(String s) {
        // If the string length is odd, it cannot be balanced
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        // Traverse each character in the string

        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[' ){
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                 if (stack.isEmpty()){
                     return false;
                 }
                 char top = stack.pop();
                 if ((ch==')' && top!='(')||
                         (ch=='}' && top!='{')||
                         (ch==']' && top!='[')){
                     return false;
                 }

            }
        }
        return stack.isEmpty();
    }

    private static boolean parenthesesValidator(String parenthesisValidator) {

        // first we can check the length ..
        // if its odd then straight away we can know that they can never be balanced.
        if (parenthesisValidator.length()%2!=0){
            return false;
        }
        char[] arr = new char[parenthesisValidator.length()];
        int top = -1;

        for (int i=0;i<arr.length;i++){
            char ch = parenthesisValidator.charAt(i);
            // Push opening brackets by incrementing the top pointer
            if (ch == '(' || ch == '{' || ch == '['){
                top++;
                arr[top]=ch;
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // If pointer is -1, stack is empty (no matching opening bracket)
                if (top == -1) {
                    return false;
                }
                // Fetch the top element and decrement the pointer (pop)
                char lastOpen = arr[top];
                top--;

                // Check for mismatches
                if ((ch == ')' && lastOpen != '(') ||
                        (ch == '}' && lastOpen != '{') ||
                        (ch == ']' && lastOpen != '[')) {
                    return false;
                }

            }
        }
        return top ==-1;
    }






}
