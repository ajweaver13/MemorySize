/*
Create a function that takes the memory size (ms is a string type) as an argument and returns the
actual memory size.

Examples
actualMemorySize("32GB") --> "29.76GB"

actualMemorySize("2GB") --> "1.86GB"

actualMemorySize("512MB") --> "476MB"

Notes
-The actual storage loss on a USB device is 7% of the overall memory size!
-If the actual memory size was greater than 1 GB, round your result to two decimal places.
-If the memory size after adjustment is smaller than 1 GB, return the result in MB.
 */

public class MemorySize {
    public String actualMemorySize(String input) {
        String type = input.substring(input.length() - 2);
        String number = input.substring(0, input.length() - 2);

        Double reduce = Integer.parseInt(number) * 0.93;

        if ((reduce%10 < 1) && type.equals("GB")) {
            type = "MB";
            reduce = reduce * 1000;
        }
        if (type.equals("GB")) {
            number = String.format("%.2f",reduce);
        } else {
            number = String.format("%.0f", reduce);
        }
        return number+type;
    }
}
