package com.examples.challenges.webscraper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinderTest {

    private Finder finder = new Finder();

    @Test
    public void should_return_animal_for_spaniel() {
        String[] searchText = {"spaniel"};
        assertEquals("\nInput: spaniel, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_vegetable_for_broccoli() {
        String[] searchText = {"broccoli"};
        assertEquals("\nInput: broccoli, output: vegetable", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_table() {
        String[] searchText = {"table"};
        assertEquals("\nInput: table, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_book_worm() {
        String[] searchText = {"book", "worm"};
        assertEquals("\nInput: book worm, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_priest() {
        String[] searchText = {"priest"};
        assertEquals("\nInput: priest, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_radio_journalist() {
        String[] searchText = {"Radio", "Journalist"};
        assertEquals("\nInput: Radio Journalist, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_tv() {
        String[] searchText = {"tv"};
        assertEquals("\nInput: tv, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_ruby() {
        String[] searchText = {"ruby"};
        assertEquals("\nInput: ruby, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_daisy() {
        String[] searchText = {"daisy"};
        assertEquals("\nInput: daisy, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_shirley() {
        String[] searchText = {"Shirley"};
        assertEquals("\nInput: Shirley, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_john() {
        String[] searchText = {"John"};
        assertEquals("\nInput: John, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_rob() {
        String[] searchText = {"rob"};
        assertEquals("\nInput: rob, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_kevin_bacon() {
        String[] searchText = {"kevin", "bacon"};
        assertEquals("\nInput: kevin bacon, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_oliver_stone() {
        String[] searchText = {"oliver", "stone"};
        assertEquals("\nInput: oliver stone, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_sharon_stone() {
        String[] searchText = {"sharon", "stone"};
        assertEquals("\nInput: sharon stone, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_catherine_bell() {
        String[] searchText = {"catherine", "bell"};
        assertEquals("\nInput: catherine bell, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_buddy_holly() {
        String[] searchText = {"buddy", "holly"};
        assertEquals("\nInput: buddy holly, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_vegetable_for_elephant_garlic() {
        String[] searchText = {"elephant", "garlic"};
        assertEquals("\nInput: elephant garlic, output: vegetable", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_animal_for_elephant() {
        String[] searchText = {"elephant"};
        assertEquals("\nInput: elephant, output: animal", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_toy_soldier() {
        String[] searchText = {"toy", "soldier"};
        assertEquals("\nInput: toy soldier, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_plastic_banana() {
        String[] searchText = {"plastic", "banana"};
        assertEquals("\nInput: plastic banana, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_silver_dolphin() {
        String[] searchText = {"silver", "dolphin"};
        assertEquals("\nInput: silver dolphin, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_gold() {
        String[] searchText = {"gold"};
        assertEquals("\nInput: gold, output: mineral", finder.returnInputOutputType(searchText));
    }

    @Test
    public void should_return_mineral_for_sand() {
        String[] searchText = {"sand"};
        assertEquals("\nInput: sand, output: mineral", finder.returnInputOutputType(searchText));
    }
}