package FluentAPI.employee;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class DataPipeline {
    private List<Employee> data;
    private Function<Employee, String> mapper = Employee::getName;

    private DataPipeline(List<Employee> data) {
        this.data = new ArrayList<>(data);
    }

    public static DataPipeline from(List<Employee> employees) {
        return new DataPipeline(employees);
    }

    public DataPipeline filter(Predicate<Employee> predicate) {
        data = data.stream().filter(predicate).collect(Collectors.toList());
        return this;
    }

    public DataPipeline sortBy(Comparator<Employee> comparator) {
        data.sort(comparator);
        return this;
    }

    public DataPipeline limit(int n) {
        data = data.stream().limit(n).collect(Collectors.toList());
        return this;
    }

    public DataPipeline map(Function<Employee, String> mapper) {
        this.mapper = mapper;
        return this;
    }

    public List<String> toList() {
        return data.stream().map(mapper).collect(Collectors.toList());
    }
}
