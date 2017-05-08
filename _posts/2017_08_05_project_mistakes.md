1.NullPointerException in planMap.put(plannedId, leg);  
planMap is a hashMap, which I defined before:  
private HashMap<Integer, Leg> planMap.  
-> I forgot to initialize, so its default value is null, which can't add any elements inside it
