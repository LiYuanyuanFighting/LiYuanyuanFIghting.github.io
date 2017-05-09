1.NullPointerException in planMap.put(plannedId, leg);  
planMap is a hashMap, which I defined before:  
private HashMap<Integer, Leg> planMap.  
-> I forgot to initialize, so its default value is null, which can't add any elements inside it

for update, the right format is:
    update tableName
    set columnName1 = name1, columnName2=name2
    where condition  

pay attention that should use comma to set multiple values instead of using AND
