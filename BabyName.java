package com.assignment.babyname;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BabyName implements Comparable<BabyName>{
    static ArrayList<BabyName> totalBabyNamesList = new ArrayList<>();
    static final int YEAR_2012 = 2012;
    static final int YEAR_2013 = 2013;
    static final int YEAR_2014 = 2014;
    boolean rankSet = false;
    ArrayList<BabyName> boys12 = new ArrayList<>();
    ArrayList<BabyName> girls12 = new ArrayList<>();
    ArrayList<BabyName> boys13 = new ArrayList<>();
    ArrayList<BabyName> girls13 = new ArrayList<>();
    ArrayList<BabyName> boys14 = new ArrayList<>();
    ArrayList<BabyName> girls14 = new ArrayList<>();

    String name;
    String gender;
    int numBabies;
    int year;
    int rank;

    public BabyName(String name, String gender, int numBabies, int year) {
        this.name = name;
        this.gender = gender;
        this.numBabies = numBabies;
        this.year = year;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumBabies() {
        return numBabies;
    }

    public void setNumBabies(int numBabies) {
        this.numBabies = numBabies;
    }

    public int getYear() {
        return year;
    }

    public BabyName() {
    }
    public BabyName getBabyNames(){
        return this;
    }
    public void printBabyNames(){
        System.out.print(this.name+"\t"+this.gender+"\t"+this.numBabies+"\t"+this.year+"\t"+this.rank+"\n");
    }

    //    Write method totalBirths to print the number of unique girls names , the number of
//    unique boys names and the total names in the file.
    public void totalBirths(){
        TreeSet<String> uniqueBoyNames = new TreeSet<>();
        TreeSet<String> uniqueGirlNames = new TreeSet<>();
        for(BabyName bn:totalBabyNamesList){
//            System.out.println(bn.getName());
            if(bn.getGender().equals("F"))
                uniqueGirlNames.add(bn.getName());
            if(bn.getGender().equals("M"))
                uniqueBoyNames.add(bn.getName());
        }
        System.out.println("Number of unique boy names: "+uniqueBoyNames.size());
        System.out.println("Number of unique girl names: "+uniqueGirlNames.size());
        System.out.println("Total(boy and girl) names in the file: "+totalBabyNamesList.size());

    }
    //    Write the method named getRank that has three parameters: an integer named year , a
//    string named name , and a string named gender (F for female and M for male). This
//    method returns the rank of the name in the file for the given gender, where rank 1 is the
//    name with the largest number of births. If the name is not in the file, then 1
//    is returned. For
//    example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the
//    gender ‘M’, the number returned is 2, as Mason is the boys name with the second highest
//    number of births. Given the name Mason, the year 2012 and the gender ‘F’, the number
//    returned is 1
//    as Mason does not appear with an F in that file.
    public void settingRankInObj(){
        //looping through the entire baby names and separating them by their year and
//        gender into separate arraylists.
        for(BabyName bn : totalBabyNamesList) {
            if (bn.getYear() == YEAR_2012) {
                if (bn.getGender().equals("M"))
                    boys12.add(bn);
                else //If female.
                    girls12.add(bn);
            }
            if (bn.getYear() == YEAR_2013) {
                if (bn.getGender().equals("M"))
                    boys13.add(bn);
                else  //Female
                    girls13.add(bn);
            }
            if (bn.getYear() == YEAR_2014) {
                if (bn.getGender().equals("M"))
                    boys14.add(bn);
                else  //Female
                    girls14.add(bn);
            }
        }
//        System.out.println("Boys 12 List:");
//        boys12.stream().forEach(e-> e.printBabyNames());
        Collections.sort(boys12);
//        System.out.println("Sorted Boys 12 List:");
//        boys12.stream().forEach(e-> e.printBabyNames());
        Collections.sort(girls12);
        Collections.sort(boys13);
        Collections.sort(girls13);
        Collections.sort(boys14);
        Collections.sort(girls14);

        //sorting over. Now, setting the rank starting at 1 because each of
//        the above lists are sorted in descending order
        int rank = 1;
        for(BabyName b:boys12){
            b.setRank(rank);
            rank++;
        }
        rank = 1;
        for(BabyName b:girls12){
            b.setRank(rank);
            rank++;
        }
        rank = 1;
        for(BabyName b:boys13){
            b.setRank(rank);
            rank++;
        }
        rank = 1;
        for(BabyName b:girls13){
            b.setRank(rank);
            rank++;
        }
        rank = 1;
        for(BabyName b:boys14){
            b.setRank(rank);
            rank++;
        }
        rank = 1;
        for(BabyName b:girls14){
            b.setRank(rank);
            rank++;
        }
        rankSet = true;
    }
//    Write the method named getRank that has three parameters: an integer named year , a
//    string named name , and a string named gender (F for female and M for male). This
//    method returns the rank of the name in the file for the given gender, where rank 1 is the
//    name with the largest number of births. If the name is not in the file, then 1
//    is returned.
    public int getRank(int year, String name, String gender){
        int result = -1;
        if(!rankSet) settingRankInObj();
        for (BabyName bn:totalBabyNamesList){
            //getting the rank for the name, year, and gender passed as input parameters
            if((bn.getName().equals(name)) && (bn.getYear()==year) && (bn.getGender().equals(gender)) )
                result = bn.getRank();
        }
        //System.out.println("The rank for "+name+", "+gender+", born in "+year+" is: "+result);
        return result;
    }
    //    Write the method named getName that has three parameters: an integer named year , an
//    integer named rank , and a string named gender (F for female and M for male). This
//    method returns the name of the person in the file at this rank, for the given gender, where
//    rank 1 is the name with the largest number of births. If the rank does not exist in the file,
//    then “NO NAME” is returned.
    public String getName(Integer year, Integer rank, String gender){
        String result = "NO NAME";
        if(!rankSet) settingRankInObj();
        for (BabyName bn: totalBabyNamesList){
            if((bn.getYear() == year) && (bn.getRank() == rank) && (bn.getGender().equals(gender)) )
                result = bn.getName();
        }
        return result;
    }
    //    What would your name be if you were born in a different year? Write the void method
//    named whatIsNameInYear that has four parameters: a string name , an integer named
//    year representing the year that name was born, an integer named newYear and a string
//    named gender (F for female and M for male). This method determines what name would
//    have been named if they were born in a different year, based on the same popularity. That
//    is, you should determine the rank of name in the year they were born, and then print the
//    name born in newYear that is at the same rank and same gender
    public void whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
        int currentRank;
        String g = (gender.equals("M"))?" he ":" she ";
        currentRank = getRank(year,name,gender);
        String nameInYear = getName(newYear,currentRank,gender);
        System.out.println(name+" born in "+year+" would be "+nameInYear+" if"+g+"was born in "+newYear);
    }
    //    Write the method yearOfHighestRank that has two parameters: a string name , and a
//    string named gender (F for female and M for male). This method selects a range of files to
//    process and returns an integer, the year with the highest rank for the name and gender. If
//    the name and gender are not in any of the selected files, it should return 1.
    public TreeSet<Integer> yearOfHighestRank(String name, String gender){
        TreeSet<Integer> result = new TreeSet<>();
        //duplicateYear is assigned the year which is duplicate rank entry into result TreeSet
        ArrayList<Integer> duplicateYear = new ArrayList<>();
        //TreeMap of Rank as key and year as value
        TreeMap<Integer, Integer> allRanks_Years = new TreeMap<>();
        if (!rankSet) settingRankInObj();
        for(BabyName bn: totalBabyNamesList){
            //Iterating thought the entire baby names to find all those that match
            //the input name and gender parameters and add them into allRanks_Years map
            //If there are duplicate entries, taking those into duplicate_Year arrayList.
            if((bn.getName().equals(name) && (bn.getGender().equals(gender))))
                duplicateYear.add(allRanks_Years.put(bn.getRank(),bn.getYear()));
        }
        //The first entry in the map is the highest 'coz it is sorted by ranks in asc order
        if(!allRanks_Years.isEmpty())
            result.add(allRanks_Years.firstEntry().getValue());

//        System.out.println("TreeMap of Ranks and years: ");
//        for(Map.Entry<Integer, Integer> rankYear: allRanks_Years.entrySet()) {
//            System.out.println(rankYear.getKey()+" "+rankYear.getValue());
//        }
        for(Integer y:duplicateYear) {
            if (y!=null) {
                //Checking to find if the year has the same rank as the rank in the first element of TreeSet
                //if true, then that is also one of the highest year.
                if(getRank(y,name,gender) == allRanks_Years.firstEntry().getKey())
                    result.add(y);
            }
        }
        if (result.isEmpty()) result.add(-1);
        System.out.println("The year of highest rank for the name "+name+" "+gender+" is "+result);
        return result;
    }
//    Write the method getAverageRank that has two parameters: a string name , and a string
//    named gender (F for female and M for male). This method selects a range of files to
//    process and returns a double representing the average rank of the name and gender over
//    the selected files. It should return 1.0 if the name is not ranked in any of the selected files.
    public double getAverageRank(String name, String gender){
        int rank12;
        int rank13;
        int rank14;
        double avgRank = -1.0;
        rank12 = getRank(YEAR_2012, name, gender);
        rank13 = getRank(YEAR_2013, name, gender);
        rank14 = getRank(YEAR_2014, name, gender);

        //Using if conditions to check if any of the rank variables are = -1
        if((rank12 != -1) && (rank13 != -1) && (rank14 != -1))
            avgRank = (double)(rank12 + rank13 + rank14)/3;
        if((rank12 != -1) && (rank13 == -1) && (rank14 == -1))
            avgRank = (double)(rank12);
        if((rank12 == -1) && (rank13 == -1) && (rank14 != -1))
            avgRank = (double)(rank14);
        if((rank12 == -1) && (rank13 != -1) && (rank14 == -1))
            avgRank = (double)(rank13);
        if((rank12 != -1) && (rank13 != -1) && (rank14 == -1))
            avgRank = (double)(rank12 + rank13)/2;
        if((rank12 == -1) && (rank13 != -1) && (rank14 != -1))
            avgRank = (double)(rank14 + rank13)/2;
        if((rank12 != -1) && (rank13 == -1) && (rank14 != -1))
            avgRank = (double)(rank12 + rank14)/2;
        avgRank = Math.round(avgRank * 100.0)/100.0;
        System.out.println("The average rank for "+name+" "+gender+" is "+avgRank);
        return avgRank;
    }
//    Write the method getTotalBirthsRankedHigher that has three parameters: an integer
//    named year , a string named name , and a string named gender (F for female and M for
//            male). This method returns an integer, the total number of births of those names with the
//    same gender and same year who are ranked higher than name . For example, if
//    getTotalBirthsRankedHigher accesses the "yob2012short.csv" file with name set to
//“Ethan”, gender set to “M”, and year set to 2012, then this method should return 15, since
//    Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than
//    Ethan.
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int result = 0;
        int index=0;
        if(!rankSet) settingRankInObj();
//checking to figure which collection needs to be used
        if((year==YEAR_2012) && (gender.equals("M")) ) {
            for(int i =0;i<boys12.size();i++){
                if (name.equals(boys12.get(i).getName()))
                   index = i;
            }
            for(int i=0;i<index;i++) {
                result+=boys12.get(i).getNumBabies();
            }
        }
        if((year==YEAR_2012) && (gender.equals("F")) ) {
            for(int i =0;i<girls12.size();i++){
                if (name.equals(girls12.get(i).getName()))
                    index = i;
            }
            for(int i=0;i<index;i++) {
                result+=girls12.get(i).getNumBabies();
            }
        }
        if((year==YEAR_2013) && (gender.equals("M")) ) {
            for(int i =0;i<boys13.size();i++){
                if (name.equals(boys13.get(i).getName()))
                    index = i;
            }
            for(int i=0;i<index;i++) {
                result+=boys13.get(i).getNumBabies();
            }
        }
        if((year==YEAR_2013) && (gender.equals("F")) ) {
            for(int i =0;i<girls13.size();i++){
                if (name.equals(girls13.get(i).getName()))
                    index = i;
            }
            for(int i=0;i<index;i++) {
                result+=girls13.get(i).getNumBabies();
            }
        }
        if((year==YEAR_2014) && (gender.equals("M")) ) {
            for(int i =0;i<boys14.size();i++){
                if (name.equals(boys14.get(i).getName()))
                    index = i;
            }
            for(int i=0;i<index;i++) {
                result+=boys14.get(i).getNumBabies();
            }
        }
        if((year==YEAR_2014) && (gender.equals("F")) ) {
            for(int i =0;i<girls14.size();i++){
                if (name.equals(girls14.get(i).getName()))
                    index = i;
            }
            for(int i=0;i<index;i++) {
                result+=girls14.get(i).getNumBabies();
            }
        }

        System.out.println("The total births ranked higher than "+name+" in the year "+year+" is: "+result);
        return result;
    }
    public void addIntoList(String line, int year){
        //splitting the values by comma
        String[] values = line.split(",");
        //creating an object with the values
        BabyName babyNamesAddintoArray = new BabyName(values[0],values[1],Integer.parseInt(values[2]),year);
        //Adding the object into an ArrayList
        totalBabyNamesList.add(babyNamesAddintoArray);
    }

    public static void main(String[] args) {
        BabyName babyNamesObj = new BabyName();
        try {
            //Opening the files for reading
            BufferedReader br2012 = new BufferedReader(new FileReader("E:\\Java_Course\\testing\\yob2012short.csv"));
            BufferedReader br2013 = new BufferedReader(new FileReader("E:\\Java_Course\\testing\\yob2013short.csv"));
            BufferedReader br2014 = new BufferedReader(new FileReader("E:\\Java_Course\\testing\\yob2014short.csv"));
            String line;
            //adding the data from 2012 file into the BabyNames ArrayList
            while ((line = br2012.readLine()) != null) {
                babyNamesObj.addIntoList(line, YEAR_2012);
            }
            br2012.close();
            //adding the data from 2013 file into the BabyNames ArrayList
            while ((line = br2013.readLine()) != null) {
                babyNamesObj.addIntoList(line, YEAR_2013);
            }
            br2013.close();
            //adding the data from 2014 file into the BabyNames ArrayList
            while ((line = br2014.readLine()) != null) {
                babyNamesObj.addIntoList(line, YEAR_2014);
            }
            br2014.close();

    //calling total births method to print unique names and total names
            babyNamesObj.totalBirths();
   //Calling getRank method to get the rank for the parameters below
            Integer yearParam = 2014;
            String nameParam = "Olivia";
            String genderParam = "F";
            int rank = babyNamesObj.getRank(yearParam,nameParam,genderParam);
            System.out.println("The rank for "+nameParam+" "+genderParam+" "+yearParam+" is: "+rank);
    //Calling getName for the parameters below.
            yearParam = 2012;
            Integer rankParam = 2;
            genderParam = "M";
            String name = babyNamesObj.getName(yearParam,rankParam,genderParam);
            System.out.println("The name for "+yearParam+" with rank "+rank+", gender "+genderParam+" is: "+ name);
    //Calling whatIsNameInYear to find the name if born in a different year.
            babyNamesObj.whatIsNameInYear("Jacob",2013,2014, "M");
//calling highestYearRank to find in which year the name & gender was highest ranked
            TreeSet<Integer> highestYearRank = babyNamesObj.yearOfHighestRank("Ava","F");
//calling averageRank to calculate the avg rank
            double averageRank = babyNamesObj.getAverageRank("William","M");
//calling totalBirthsRankedHigher to calculate total number of babies born with higher rank
            int totalBirthsRankedHigher = babyNamesObj.getTotalBirthsRankedHigher(2014,"Isabella","F");
            //printing all the objects in the ArrayList
            //totalBabyNamesList.forEach(BabyName::printBabyNames);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

//Sorting in descending order
    @Override
    public int compareTo(BabyName o) {
        return (o.numBabies - this.numBabies);
    }
}