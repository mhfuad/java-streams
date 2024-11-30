import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*

        forEach(Consumer)
        filter(Predicate)
        collect(Collector)
        map(Function)
        distinct()
        flatMap(Function)
        sorted(Comparator both ASC and DESC)
        min() & max()
        GroupBy
        findFirst()
        findAny()
        anyMatch(Predicate)
        allMatch(Predicate)
        noneMatch(Predicate)
        limit(long maxSize)
        skip(long n)

        var numbers = IntStream
                .range(0, 100_000_000)
                .boxed()
                .toList();
        var start = Instant.now();
        var result = numbers
                .stream()
                        .filter(n -> n % 2 != 0)
                                .toList();
        var duration = Duration
                .between(start, Instant.now());
        System.out.printf("stream %d in %dms%n", result.size(), duration.toMillis());

        start = Instant.now();
        var lResult = new ArrayList<>();
        for (var number : numbers){
            if (number % 2 != 0){
                lResult.add(number);
            }
        }

        duration = Duration
                .between(start, Instant.now());
        System.out.printf("for %d in %dms%n", lResult.size(), duration.toMillis());
        */
        List<Employee> employees = EmployeeDatabase.getEmployees();
        /*
        //forEach
        employees.forEach( employee -> System.out.println(employee.getName()+" : "+ employee.getSalary()));
        employees.stream().forEach(System.out::println);

        //filter
        //.collect
        Map<Integer, String> devEmploye = employees.stream()
                .filter( e -> e.getDept().equals("Development") && e.getSalary() > 60000)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println( devEmploye);
        //map
        Set<String> depertment = employees.stream()
                .map(Employee::getDept)
                .collect(Collectors.toSet());
        List<String> depertment = employees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(depertment);

        //flatMap
        List<Stream<String>> projects = employees.stream()
                .map(e-> e.getProjects()
                        .stream().map(project -> project.getName())
                ).collect(Collectors.toList());
        //flatMap
        List<String> projects = employees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .map(Project::getName)
                .distinct()
                .toList();
        System.out.println(projects);

        //sorted
        //asc
        List<Employee> ascSortedEmp = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
        //desc
        List<Employee> descSortedEmp = employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .toList();

        //min & max
        Optional<Employee> maxPaidSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(maxPaidSalary);Optional<Employee> minPaidSalary = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(minPaidSalary);

        //groupingBy
        Map<String, List<Employee>> employeeGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(employeeGroup);
        //Gender -> [names]
        Map<String, List<String>> employeeGorupName = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(employeeGorupName);

        //Gender -> [count]
        Map<String, Long> employeeGroupCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(employeeGroupCountMap);

        //findFirst
        Optional<Employee> findFirstElement = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst();

        if(findFirstElement.isPresent()){
            System.out.println(findFirstElement.get());
        }

        findFirstElement.ifPresent(employee -> System.out.println(employee.getName()));

        Employee findFirstElement2 = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee Not found"));

        System.out.println(findFirstElement2);

        //findAny
        Employee findAnyElement = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee Not found"));

        System.out.println(findAnyElement);

        //anyMatch, allMatch, nonMatch
        boolean developmentEmpAnyMatch = employees.stream()
                .anyMatch(e -> e.getDept().equals("xyx"));
        System.out.println("is there any employee match from devlopment dept "+developmentEmpAnyMatch);

        boolean developmentEmpAllMatch = employees.stream()
                .allMatch(employee -> employee.getSalary() > 5000);
        System.out.println(developmentEmpAllMatch);

        boolean isNoneMatch = employees.stream()
                .noneMatch(employee -> employee.getDept().equals("bal"));
        System.out.println(developmentEmpAllMatch);


        // limit(long)
        List<Employee> topPaidEmploy = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        topPaidEmploy.forEach(employee -> System.out.println(employee.getName() + employee.getSalary()));
        */

        //skip(long)
        List<Employee> skipEmployee = employees.stream().skip(9)
                .collect(Collectors.toList());
        skipEmployee.forEach(employee -> System.out.println(employee.getName()));
    }
}