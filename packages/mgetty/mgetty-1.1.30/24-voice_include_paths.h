--- mgetty-1.1.27.orig/voice/include/paths.h
+++ mgetty-1.1.27/voice/include/paths.h
@@ -19,10 +19,10 @@
  * the device name.
  */
 
-#define VGETTY_LOG_PATH "/var/log/vgetty.%s"
+#define VGETTY_LOG_PATH "/var/log/mgetty/vg_%s.log"
 
 /*
  * Filename of the logfile for vm.
  */
 
-#define VM_LOG_PATH "/var/log/vm.log"
+#define VM_LOG_PATH "/var/log/mgetty/vm.log"
