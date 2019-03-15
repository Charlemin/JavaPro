package com;

import java.util.*;

public class CompareTest {

    public static void main(String[] args) {
        Domain d1 = new Domain("c");
        Domain d2 = new Domain("a");
        Domain d3 = new Domain("f");
        Domain d4 = new Domain("d");
//        System.out.println(d1.compareTo(d2));
//        System.out.println(d1.compareTo(d3));
//        System.out.println(d1.compareTo(d4));
        Domain[] domains = new Domain[]{d1,d2,d3,d4};
        Arrays.sort(domains);
        for (Domain domain : domains)
            System.out.println(domain.str);
        DomainComparator dc = new DomainComparator();
        List<Domain> domainList = new ArrayList<>();
        domainList.add(d1);
        domainList.add(d2);
        domainList.add(d3);
        domainList.add(d4);
        Collections.sort(domainList);
        for (Domain domain : domainList)
            System.out.println(domain.str);
    }

    public static class Domain implements Comparable<Domain>
    {
        private String str;

        public Domain(String str)
        {
            this.str = str;
        }

        public int compareTo(Domain domain)
        {
            if (this.str.compareTo(domain.str) > 0)
                return -1;
            else if (this.str.compareTo(domain.str) == 0)
                return 0;
            else
                return 1;
        }

        public String getStr()
        {
            return str;
        }
    }

    public static class DomainComparator implements Comparator<Domain>
    {
        public int compare(Domain domain1, Domain domain2)
        {
            if (domain1.getStr().compareTo(domain2.getStr()) > 0)
                return 1;
            else if (domain1.getStr().compareTo(domain2.getStr()) == 0)
                return 0;
            else
                return -1;
        }
    }

}
