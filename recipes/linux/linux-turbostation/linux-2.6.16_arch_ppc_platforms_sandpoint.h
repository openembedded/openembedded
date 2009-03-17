Index: linux-2.6.20.1/arch/ppc/platforms/sandpoint.h
===================================================================
--- linux-2.6.20.1.orig/arch/ppc/platforms/sandpoint.h	2007-02-20 07:34:32.000000000 +0100
+++ linux-2.6.20.1/arch/ppc/platforms/sandpoint.h	2007-02-26 03:15:15.000000000 +0100
@@ -49,29 +49,37 @@
 /*
  * Serial defines.
  */
-#define SANDPOINT_SERIAL_0		0xfe0003f8
-#define SANDPOINT_SERIAL_1		0xfe0002f8
+#define SANDPOINT_SERIAL_0		0xfdf04500
+#define SANDPOINT_SERIAL_1		0xfdf04600
 
-#define RS_TABLE_SIZE  2
+#define RS_TABLE_SIZE  1
 
 /* Rate for the 1.8432 Mhz clock for the onboard serial chip */
-#define BASE_BAUD			( 1843200 / 16 )
-#define UART_CLK			1843200
+#define BASE_BAUD			( 133000000 / 16 )
+#define UART_CLK			133000000
 
 #ifdef CONFIG_SERIAL_DETECT_IRQ
-#define STD_COM_FLAGS (ASYNC_BOOT_AUTOCONF|ASYNC_AUTO_IRQ)
+#define STD_COM_FLAGS (ASYNC_BOOT_AUTOCONF|ASYNC_AUTO_IRQ|ASYNC_SKIP_TEST)
 #else
-#define STD_COM_FLAGS (ASYNC_BOOT_AUTOCONF)
+#define STD_COM_FLAGS (ASYNC_BOOT_AUTOCONF|ASYNC_SKIP_TEST)
 #endif
 
+#define SANDPOINT_SERIAL_0_INT	25 // 4 + EPIC_IRQ_BASE + NUM_8259_INTERRUPTS
+#define SANDPOINT_SERIAL_1_INT	24 // 3 + EPIC_IRQ_BASE + NUM_8259_INTERRUPTS
+#if 0
 #define STD_SERIAL_PORT_DFNS \
-        { 0, BASE_BAUD, SANDPOINT_SERIAL_0, 4, STD_COM_FLAGS, /* ttyS0 */ \
+        { 0, BASE_BAUD, SANDPOINT_SERIAL_0, SANDPOINT_SERIAL_0_INT, STD_COM_FLAGS, /* ttyS0 */ \
 		iomem_base: (u8 *)SANDPOINT_SERIAL_0,			  \
 		io_type: SERIAL_IO_MEM },				  \
-        { 0, BASE_BAUD, SANDPOINT_SERIAL_1, 3, STD_COM_FLAGS, /* ttyS1 */ \
+        { 0, BASE_BAUD, SANDPOINT_SERIAL_1, SANDPOINT_SERIAL_1_INT, STD_COM_FLAGS, /* ttyS1 */ \
 		iomem_base: (u8 *)SANDPOINT_SERIAL_1,			  \
 		io_type: SERIAL_IO_MEM },
-
+#else
+#define STD_SERIAL_PORT_DFNS \
+        { 0, BASE_BAUD, SANDPOINT_SERIAL_0, SANDPOINT_SERIAL_0_INT, STD_COM_FLAGS, /* ttyS0 */ \
+		iomem_base: (u8 *)SANDPOINT_SERIAL_0,			  \
+		io_type: SERIAL_IO_MEM },
+#endif
 #define SERIAL_PORT_DFNS \
         STD_SERIAL_PORT_DFNS
 
