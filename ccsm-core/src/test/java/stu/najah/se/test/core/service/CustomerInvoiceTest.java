package stu.najah.se.test.core.service;

import org.junit.jupiter.api.Test;
import stu.najah.se.core.service.CustomerInvoice;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerInvoiceTest {

    @Test
    public void testPrintInvoice() {
        String input = "Sara\n123 Main St\n456 Second St\nshirt\ndress\npants\ndone\n50.00";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CustomerInvoice.main(new String[0]);

        String output = systemOut().getHistory();

        String expectedOutput = "=================================\n" +
                "CUSTOMER INFORMATION\n" +
                "=================================\n" +
                "Customer Name: Sara\n" +
                "Customer Address: 123 Main St\n" +
                "Delivery Address: 456 Second St\n" +
                "=================================\n" +
                "ITEMS TO CLEAN\n" +
                "=================================\n" +
                "- shirt\n" +
                "- dress\n" +
                "- pants\n" +
                "=================================\n" +
                "TOTAL PRICE\n" +
                "=================================\n" +
                "$50.0\n" +
                "=================================\n";

        assertEquals(expectedOutput, output);
    }

    private static TestHelper.SystemOut systemOut() {
        return new TestHelper.SystemOut();
    }

    static class TestHelper {
        static class SystemOut {
            private final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            private final java.io.PrintStream originalOut = System.out;

            void setAsSystemOut() {
                System.setOut(new java.io.PrintStream(outContent));
            }

            void restoreOriginal() {
                System.setOut(originalOut);
            }

            String getHistory() {
                return outContent.toString();
            }
        }
    }
}