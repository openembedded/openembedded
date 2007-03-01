Index: linux-2.6.20.1/arch/ppc/syslib/open_pic.c
===================================================================
--- linux-2.6.20.1.orig/arch/ppc/syslib/open_pic.c	2007-02-20 07:34:32.000000000 +0100
+++ linux-2.6.20.1/arch/ppc/syslib/open_pic.c	2007-02-26 02:26:56.000000000 +0100
@@ -318,7 +318,8 @@
 #ifdef CONFIG_EPIC_SERIAL_MODE
 	/* Have to start from ground zero.
 	*/
-	openpic_reset();
+	// 2005.09.06, JohnsonCheng Fixed USB device Oops bug
+	//openpic_reset();
 #endif
 
 	if (ppc_md.progress) ppc_md.progress("openpic: enter", 0x122);
