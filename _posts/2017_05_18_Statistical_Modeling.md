**From experimental results to a prediction**  
```r
# Baseline run
test_scores(school = "public", acad_motivation = 0, relig_motivation = 0)

# Change school input, leaving others at baseline
test_scores(school = "private", acad_motivation = 0, relig_motivation = 0)

# Change acad_motivation input, leaving others at baseline
test_scores(school = "public", acad_motivation = 1, relig_motivation = 0)

# Change relig_motivation input, leaving others at baseline
test_scores(school = "public", acad_motivation = 0, relig_motivation = 1)

# Use results above to estimate output for new inputs
my_prediction <- 100 - 5 + 2 * 15 + 2 * 0
my_prediction

# Check prediction by using test_scores() directly
test_scores(school = "private", acad_motivation = 2, relig_motivation = 2)
```

**Model Definitions**
A model is a representation for a purpose.  
A mathematical model is built from mathematical stuff.  
A statistical model is trained on data, built on objects.  
