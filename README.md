## Animal, Vegetable or Mineral?

Given a word or term, respond either ‘animalʼ, ‘vegetableʼ or ‘mineralʼ depending on what best fits the input.

For example: 

```
Input: spaniel, output: animal
Input: broccoli, output: vegetable
Input: table, output: mineral
```


If you use external APIs:
- Please read the terms and conditions of use carefully
- Please be mindful of the volume of queries you make
- Be aware that for APIs that limit accesses by IP, weʼll likely have only one outbound IP for the whole office.

### Guidelines

- Donʼt assume that the inputs will always be in lower case
- Anything inanimate is considered to be a mineral
- Weʼll ignore any grey areas like bacteria, assume you wonʼt receive them as input
- Fungi are classed as ‘vegetableʼ for the purposes of this challenge

### Competition

On the day, a list of 20 things will be provided. The winner is the solution that gets the most right answers.

### Solution Usages

```
./gradlew word --args="dog"

./gradlew word --args="book worm"
```
