Index: linux-2.6.21-rc1/arch/ppc/platforms/sandpoint.c
===================================================================
--- linux-2.6.21-rc1.orig/arch/ppc/platforms/sandpoint.c	2007-02-21 05:32:30.000000000 +0100
+++ linux-2.6.21-rc1/arch/ppc/platforms/sandpoint.c	2007-02-27 21:57:46.000000000 +0100
@@ -91,7 +91,7 @@
 #include <asm/vga.h>
 #include <asm/open_pic.h>
 #include <asm/i8259.h>
-#include <asm/todc.h>
+//#include <asm/todc.h>
 #include <asm/bootinfo.h>
 #include <asm/mpc10x.h>
 #include <asm/pci-bridge.h>
@@ -99,6 +99,8 @@
 #include <asm/ppc_sys.h>
 
 #include "sandpoint.h"
+#include "qnap_pic.h"
+#include "qnap_pic_user.h"
 
 /* Set non-zero if an X2 Sandpoint detected. */
 static int sandpoint_is_x2;
@@ -106,8 +108,7 @@
 unsigned char __res[sizeof(bd_t)];
 
 static void sandpoint_halt(void);
-static void sandpoint_probe_type(void);
-
+//static void sandpoint_probe_type(void);
 /*
  * Define all of the IRQ senses and polarities.  Taken from the
  * Sandpoint X3 User's manual.
@@ -121,7 +122,6 @@
 	(IRQ_SENSE_LEVEL | IRQ_POLARITY_NEGATIVE),	/* 8: IDE (INT C) */
 	(IRQ_SENSE_LEVEL | IRQ_POLARITY_NEGATIVE)	/* 9: IDE (INT D) */
 };
-
 /*
  * Motorola SPS Sandpoint interrupt routing.
  */
@@ -145,7 +145,7 @@
 	const long min_idsel = 11, max_idsel = 16, irqs_per_slot = 4;
 	return PCI_IRQ_TABLE_LOOKUP;
 }
-
+#if 0
 static inline int
 x2_map_irq(struct pci_dev *dev, unsigned char idsel, unsigned char pin)
 {
@@ -166,7 +166,37 @@
 	const long min_idsel = 11, max_idsel = 16, irqs_per_slot = 4;
 	return PCI_IRQ_TABLE_LOOKUP;
 }
+#else
+static inline int
+x2_map_irq(struct pci_dev *dev, unsigned char idsel, unsigned char pin)
+{
+	static char pci_irq_table[][4] =
+	/*
+	 *	PCI IDSEL/INTPIN->INTLINE
+	 * 	   A   B   C   D
+	 */
+	{
+		{  0,  0,  0,  0 },	/* IDSEL 11 - unused */
+		{  0,  0,  0,  0 },	/* IDSEL 12 - unused */
+		{ 16, 16, 16, 16 },	/* IDSEL 13 - PCI slot 1 */ // Sil3512 chip
+		{ 17, 17, 17, 17 },	/* IDSEL 14 - PCI slot 2 */ // NEC USB chip
+		{ 18, 18, 18, 18 },	/* IDSEL 15 - PCI slot 3 */ // Intel 82540 chip
+		{ 19, 19, 19, 19 },	/* IDSEL 16 - PCI slot 4 */
+		{  0,  0,  0,  0 },
+		{  0,  0,  0,  0 },
+		{  0,  0,  0,  0 },
+		{  0,  0,  0,  0 },
+		{  0,  0,  0,  0 },
+		{  0,  0,  0,  0 },
+		{  0,  0,  0,  0 },
+		{  20,  20,  20,  20 }, /* IDSEL 24 - mini PCI */
+	};
 
+	const long min_idsel = 11, max_idsel = 24, irqs_per_slot = 4;
+	return PCI_IRQ_TABLE_LOOKUP;
+}
+#endif
+#if 0
 static void __init
 sandpoint_setup_winbond_83553(struct pci_controller *hose)
 {
@@ -226,7 +256,7 @@
 				0x00ff0011);
 	return;
 }
-
+#endif
 /* On the sandpoint X2, we must avoid sending configuration cycles to
  * device #12 (IDSEL addr = AD12).
  */
@@ -258,7 +288,7 @@
 			       MPC10X_MAPB_EUMB_BASE) == 0) {
 
 		/* Do early winbond init, then scan PCI bus */
-		sandpoint_setup_winbond_83553(hose);
+		//sandpoint_setup_winbond_83553(hose);
 		hose->last_busno = pciauto_bus_scan(hose, hose->first_busno);
 
 		ppc_md.pcibios_fixup = NULL;
@@ -280,10 +310,21 @@
 }
 
 static void __init
+sandpoint_init2(void)
+{
+	char pic_command[2] = {QNAP_PIC_STATUS_GREEN_BLINK, QNAP_PIC_BUZZER_SHORT};
+
+	/* Setup serial port access */
+	qnap_pic_init();
+	qnap_pic_send_command(pic_command, 2);
+}
+
+static void __init
 sandpoint_setup_arch(void)
 {
 	/* Probe for Sandpoint model */
-	sandpoint_probe_type();
+	//sandpoint_probe_type();
+	sandpoint_is_x2 = 1;
 	if (sandpoint_is_x2)
 		epic_serial_mode = 0;
 
@@ -348,8 +389,9 @@
 		_set_L3CR(0x8f032000);
 	}
 #endif
+	sandpoint_init2();
 }
-
+#if 0
 #define	SANDPOINT_87308_CFG_ADDR		0x15c
 #define	SANDPOINT_87308_CFG_DATA		0x15d
 
@@ -456,7 +498,7 @@
 }
 
 arch_initcall(sandpoint_setup_natl_87308);
-
+#endif
 static int __init
 sandpoint_request_io(void)
 {
@@ -481,20 +523,20 @@
 static void __init
 sandpoint_init_IRQ(void)
 {
-	int i;
+//	int i;
 
-	OpenPIC_InitSenses = sandpoint_openpic_initsenses;
-	OpenPIC_NumInitSenses = sizeof(sandpoint_openpic_initsenses);
+//	OpenPIC_InitSenses = sandpoint_openpic_initsenses;
+//	OpenPIC_NumInitSenses = sizeof(sandpoint_openpic_initsenses);
 
 	mpc10x_set_openpic();
-	openpic_hookup_cascade(sandpoint_is_x2 ? 17 : NUM_8259_INTERRUPTS, "82c59 cascade",
-			i8259_irq);
+//	openpic_hookup_cascade(sandpoint_is_x2 ? 17 : NUM_8259_INTERRUPTS, "82c59 cascade",
+//			i8259_irq);
 
 	/*
 	 * The EPIC allows for a read in the range of 0xFEF00000 ->
 	 * 0xFEFFFFFF to generate a PCI interrupt-acknowledge transaction.
 	 */
-	i8259_init(0xfef00000, 0);
+//	i8259_init(0xfef00000, 0);
 }
 
 static unsigned long __init
@@ -518,36 +560,60 @@
 static void __init
 sandpoint_map_io(void)
 {
-	io_block_mapping(0xfe000000, 0xfe000000, 0x02000000, _PAGE_IO);
+	// 2005.08.02, JohnsonCheng
+	//io_block_mapping(0xfe000000, 0xfe000000, 0x02000000, _PAGE_IO);
+	io_block_mapping(0xfc000000, 0xfc000000, 0x04000000, _PAGE_IO);
 }
 
-static void
-sandpoint_restart(char *cmd)
+// mode: 0 - reboot, 1 - poweroff & shutdown
+void sandpoint_real_reset(int mode)
 {
-	local_irq_disable();
+	char pic_command = 0x0;
 
-	/* Set exception prefix high - to the firmware */
-	_nmask_and_or_msr(0, MSR_IP);
+	local_irq_disable();
+	/* disable and invalidate the L2 cache */
+    _set_L2CR(0);
+    _set_L2CR(0x200000);
+    /* flush and disable L1 I/D cache */
+    __asm__ __volatile__
+       	("\n\
+       	mfspr   3,1008 \n\
+       	ori     5,5,0xcc00 \n\
+       	ori     4,3,0xc00 \n\
+       	andc    5,3,5 \n\
+       	sync	\n\
+       	mtspr   1008,4	\n\
+       	isync	\n\
+       	sync	\n\
+       	mtspr   1008,5	\n\
+       	isync	\n\
+       	sync	\n\
+       	");
+	if (mode == 0)
+		pic_command = QNAP_PIC_SOFTWARE_REBOOT;
+	else
+		pic_command = QNAP_PIC_SOFTWARE_SHUTDOWN;
+//	qnap_pic_send_command(&pic_command, 1);
+	while (1)
+		qnap_pic_send_command(&pic_command, 1);
+}
 
-	/* Reset system via Port 92 */
-	outb(0x00, 0x92);
-	outb(0x01, 0x92);
-	for(;;);	/* Spin until reset happens */
+static void
+sandpoint_restart(char *cmd)
+{
+	sandpoint_real_reset(0);
 }
 
 static void
 sandpoint_power_off(void)
 {
-	local_irq_disable();
-	for(;;);	/* No way to shut power off with software */
-	/* NOTREACHED */
+	sandpoint_real_reset(1);
 }
 
 static void
 sandpoint_halt(void)
 {
-	sandpoint_power_off();
-	/* NOTREACHED */
+	sandpoint_real_reset(1);
 }
 
 static int
@@ -665,7 +731,18 @@
 			: "=r" (bat3u), "=r" (bat3l));
 }
 
-TODC_ALLOC();
+static void __init
+sandpoint_calibrate_decr(void)
+{
+	ulong freq = 33000000;
+
+	//printk("time_init: decrementer frequency = %lu.%.6lu MHz\n", freq/1000000, freq%1000000);
+	tb_ticks_per_jiffy = freq / HZ;
+	tb_to_us = mulhwu_scale_factor(freq, 1000000);
+	return;
+}
+
+//TODC_ALLOC();
 
 void __init
 platform_init(unsigned long r3, unsigned long r4, unsigned long r5,
@@ -721,14 +798,14 @@
 	ppc_md.find_end_of_memory = sandpoint_find_end_of_memory;
 	ppc_md.setup_io_mappings = sandpoint_map_io;
 
-	TODC_INIT(TODC_TYPE_PC97307, 0x70, 0x00, 0x71, 8);
-	ppc_md.time_init = todc_time_init;
-	ppc_md.set_rtc_time = todc_set_rtc_time;
-	ppc_md.get_rtc_time = todc_get_rtc_time;
-	ppc_md.calibrate_decr = todc_calibrate_decr;
+	//TODC_INIT(TODC_TYPE_PC97307, 0x70, 0x00, 0x71, 8);
+	//ppc_md.time_init = todc_time_init;
+	//ppc_md.set_rtc_time = todc_set_rtc_time;
+	//ppc_md.get_rtc_time = todc_get_rtc_time;
+	ppc_md.calibrate_decr = sandpoint_calibrate_decr;
 
-	ppc_md.nvram_read_val = todc_mc146818_read_val;
-	ppc_md.nvram_write_val = todc_mc146818_write_val;
+	//ppc_md.nvram_read_val = todc_mc146818_read_val;
+	//ppc_md.nvram_write_val = todc_mc146818_write_val;
 
 #ifdef CONFIG_KGDB
 	ppc_md.kgdb_map_scc = gen550_kgdb_map_scc;
