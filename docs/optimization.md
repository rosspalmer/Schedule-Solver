
# Optimization Theory

TODO

**Stages**

1. Placement of order quantities on lines of production
2. Ordering on lines
3. Sizing of orders

## Initial Placement

Mixed linear program (MIP) problem with objective to minimize time.

### Constraints

```
Total for each product = Sum of line times * line + product rates
"Is on line" variable is integer from 0 to 1
Total time available on line = Sum line times for line + Sum of change times for line
```

### Objective

Minimize total time

```
Total time = Sum of line times + sum of change times
```