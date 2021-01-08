package ch14;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Ex14_11 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true , 1,1,300),
                new Student2("김지미", false, 1,1,250),
                new Student2("김자바", true , 1,1,200),
                new Student2("이지미", false, 1,2,150),
                new Student2("남자바", true , 1,2,100),
                new Student2("안지미", false, 1,2, 50),
                new Student2("황지미", false, 1,3,100),
                new Student2("강지미", false, 1,3,150),
                new Student2("이자바", true , 1,3,200),
                new Student2("나자바", true , 2,1,300),
                new Student2("김지미", false, 2,1,250),
                new Student2("김자바", true , 2,1,200),
                new Student2("이지미", false, 2,2,150),
                new Student2("남자바", true , 2,2,100),
                new Student2("안지미", false, 2,2, 50),
                new Student2("황지미", false, 2,3,100),
                new Student2("강지미", false, 2,3,150),
                new Student2("이자바", true , 2,3,200),
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student2::getBan));
        for(List<Student2> ban: stuByBan.values()) {
            for (Student2 s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<Student2.Level, List<Student2>> stuByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                         if (s.getScore() >= 200) return Student2.Level.HIGH;
                    else if (s.getScore() >= 100) return Student2.Level.MID;
                    else                          return Student2.Level.LOW;
                }));

        TreeSet<Student2.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(Student2.Level key : keySet) {
            System.out.println("["+key+"]");
            for(Student2 s: stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계 (성적별 학생수)%n");

        Map<Student2.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s-> {
                         if (s.getScore() >= 200) return Student2.Level.HIGH;
                    else if (s.getScore() >= 100) return Student2.Level.MID;
                    else                          return Student2.Level.LOW;
                }, Collectors.counting()));

        for(Student2.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));

        System.out.printf("%n4. 다중그룹화 (학년별, 반별)%n");

        Map<Integer, Map<Integer, List<Student2>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student2::getHak,
                        Collectors.groupingBy(Student2::getBan)));

        for(Map<Integer, List<Student2>> hak : stuByHakAndBan.values()) {
            for(List<Student2> ban : hak.values()) {
                System.out.println();
                for(Student2 s : ban) {
                    System.out.println(s);
                }
            }
        }
        System.out.printf("%n5. 다중그룹화 +통계 (학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student2>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student2::getHak,
                        Collectors.groupingBy(Student2::getBan,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student2::getScore)), Optional::get
                                ))));

        for(Map<Integer, Student2> ban : topStuByHakAndBan.values())
            for(Student2 s : ban.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화 +통계 (학년별, 반별 성적 그룹)%n");
        Map<String, Set<Student2.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s->s.getHak()+"-"+s.getBan(),
                        Collectors.mapping(s-> {
                            if(s.getScore() >= 200)      return Student2.Level.HIGH;
                            else if(s.getScore() >= 100) return Student2.Level.MID;
                            else                         return Student2.Level.LOW;
                        },Collectors.toSet())));
        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("["+key+"]"+stuByScoreGroup.get(key));
        }

    }
}
