package com.colors;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Colors {
    /**
     * Default color for char when color key is not found in Map
     */
    String defaultCharColor = "F0F0F0";

    /**
     * Get colors for each char
     * @return Map<String, String> This is a Map of colors for each char.
     */
    public Map getCharsColors() {
        Map<String, String> colorsMap = new HashMap<String, String>();

        colorsMap.put("a", "A81717");
        colorsMap.put("b", "A43349");
        colorsMap.put("c", "48DFBC");
        colorsMap.put("d", "D4F5B3");
        colorsMap.put("e", "86C349");
        colorsMap.put("f", "175CA1");
        colorsMap.put("g", "537C72");
        colorsMap.put("h", "7A9CBF");
        colorsMap.put("i", "A15D21");
        colorsMap.put("j", "EB8E3D");
        colorsMap.put("k", "62574C");
        colorsMap.put("l", "C3EC51");
        colorsMap.put("m", "E7FD20");
        colorsMap.put("n", "E1FD30");
        colorsMap.put("o", "4D73B5");
        colorsMap.put("p", "1CB29E");
        colorsMap.put("r", "973EDB");
        colorsMap.put("s", "785691");
        colorsMap.put("t", "186F84");
        colorsMap.put("u", "3C0505");
        colorsMap.put("w", "B31B90");
        colorsMap.put("x", "F4FC20");
        colorsMap.put("y", "2A8A23");
        colorsMap.put("z", "155C0F");
        return colorsMap;
    }

    public String getDefaultCharColor() {
        return defaultCharColor;
    }

    /**
     * Create Color object from Hex code.
     * @param hexValue Color as Hex Code (e.g #3C0505)
     * @return Color Return Color object.
     */
    public Color createColor(String hexValue)
    {
        Color col = new Color(
                Integer.valueOf( hexValue.substring( 1, 3 ), 16 ),
                Integer.valueOf( hexValue.substring( 3, 5 ), 16 ),
                Integer.valueOf( hexValue.substring( 5, 7 ), 16 ));
        return col;
    }

    /**
     * Create rgb color from Color object
     * @param color This a color object - we create by his data rgb color.
     * @return Rgb color
     */
    public int createRGBFromColor(Color color)
    {
        int a = color.getAlpha();
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return (a<<24) | (r<<16) | (g<<8) | b;
    }
}
