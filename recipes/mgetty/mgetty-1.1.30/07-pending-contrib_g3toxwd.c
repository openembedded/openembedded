--- mgetty-1.1.27.orig/contrib/g3toxwd.c
+++ mgetty-1.1.27/contrib/g3toxwd.c
@@ -26,6 +26,8 @@
 #include <sys/types.h>
 #include <ctype.h>
 #include <stdio.h>
+#include <stdlib.h>
+#include <string.h>
 
 typedef unsigned char bit;
 
@@ -331,6 +333,8 @@
 
 #endif	/* _G3_H_ */
 
+void skiptoeol (void);
+
 FILE *
   pm_openr (name)
      char *name;
@@ -604,7 +608,7 @@
     return (0);
 }
 
-skiptoeol ()
+void skiptoeol ()
 {
     while (rawzeros < 11)
 	(void) rawgetbit ();
@@ -732,7 +736,7 @@
 	putchar (byte);
 };
 
-void main (argc, argv)
+int main (argc, argv)
      int argc;
      char *argv[];
 {
@@ -883,5 +887,6 @@
 	xwd_writerow (stdout, writerow, wcols);
 	wrow++;
     }
-    exit (0);
+
+    return 0;
 }
