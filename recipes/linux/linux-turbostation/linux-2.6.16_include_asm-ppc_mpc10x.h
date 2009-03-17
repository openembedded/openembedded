Index: linux-2.6.20.1/include/asm-ppc/mpc10x.h
===================================================================
--- linux-2.6.20.1.orig/include/asm-ppc/mpc10x.h	2007-02-20 07:34:32.000000000 +0100
+++ linux-2.6.20.1/include/asm-ppc/mpc10x.h	2007-02-26 02:28:21.000000000 +0100
@@ -155,7 +155,8 @@
  */
 extern unsigned long			ioremap_base;
 #define	MPC10X_MAPA_EUMB_BASE		(ioremap_base - MPC10X_EUMB_SIZE)
-#define	MPC10X_MAPB_EUMB_BASE		MPC10X_MAPA_EUMB_BASE
+//#define	MPC10X_MAPB_EUMB_BASE		MPC10X_MAPA_EUMB_BASE
+#define	MPC10X_MAPB_EUMB_BASE		0xfdf00000	// 2005.08.02, JohnsonCheng
 
 enum ppc_sys_devices {
 	MPC10X_IIC1,
