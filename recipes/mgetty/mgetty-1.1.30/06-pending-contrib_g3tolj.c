--- mgetty-1.1.27.orig/contrib/g3tolj.c
+++ mgetty-1.1.27/contrib/g3tolj.c
@@ -57,6 +57,7 @@
 #include <sys/types.h>
 #include <ctype.h>
 #include <stdio.h>
+#include <stdlib.h>
 
 typedef unsigned char bit;
 
@@ -303,6 +304,8 @@
 
 #endif	/* _G3_H_ */
 
+void skiptoeol (void);
+
 FILE *
   pm_openr (name)
      char *name;
@@ -552,7 +555,7 @@
     return (0);
 }
 
-skiptoeol ()
+void skiptoeol ()
 {
     while (rawzeros < 11)
 	(void) rawgetbit ();
@@ -707,9 +710,9 @@
 	newpage (fd);
 };
 
-void main (argc, argv)
-     int argc;
-     char *argv[];
+int main (argc, argv)
+    int argc;
+    char *argv[];
 {
     int argn, rows, wrows, cols, wcols, row, wrow, col, wcol, i;
     int vval, hval;
@@ -864,5 +867,6 @@
 	    break;
     }
     putrest ();
-    exit (0);
+
+    return 0;
 }
