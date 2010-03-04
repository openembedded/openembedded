diff -Nur snort-2.8.5.3.vanilla/configure.in snort-2.8.5.3/configure.in
--- snort-2.8.5.3.vanilla/configure.in	2010-02-12 17:36:25.000000000 +0100
+++ snort-2.8.5.3/configure.in	2010-03-02 11:23:03.000000000 +0100
@@ -74,7 +74,6 @@
     # libpcap doesn't even LOOK at the timeout you give it under Linux
     AC_DEFINE([PCAP_TIMEOUT_IGNORED],[1],[Define if pcap timeout is ignored])
     AC_SUBST(extra_incl)
-    extra_incl="-I/usr/include/pcap"
     ;;
   *-hpux10*|*-hpux11*)
     AC_DEFINE([HPUX],[1],[Define if HP-UX 10 or 11])
@@ -229,25 +228,7 @@
 AC_CHECK_TYPES([int8_t,int16_t,int32_t,int64_t])
 
 # In case INADDR_NONE is not defined (like on Solaris)
-have_inaddr_none="no"
-AC_MSG_CHECKING([for INADDR_NONE])
-AC_RUN_IFELSE(
-[AC_LANG_PROGRAM(
-[[
-#include <sys/types.h>
-#include <netinet/in.h>
-#include <arpa/inet.h>
-]],
-[[
-	if (inet_addr("10,5,2") == INADDR_NONE);
-    return 0;
-]])],
-[have_inaddr_none="yes"],
-[have_inaddr_none="no"])
-AC_MSG_RESULT($have_inaddr_none)
-if test "x$have_inaddr_none" = "xno"; then
-	AC_DEFINE([INADDR_NONE],[-1],[For INADDR_NONE definition])
-fi
+have_inaddr_none="yes"
 
 AC_COMPILE_IFELSE([AC_LANG_PROGRAM([[
 #include <stdio.h>
@@ -350,62 +331,8 @@
 # This is Linux only.  The check is done after pcre because the code below uses pcre.
 # It seems Phil Wood's pcap does not accumulate - 0.9x
 pcap_version_check="yes"
-if test "x$linux" = "xyes"; then
-    if test "x$pcap_version_check" = "xyes"; then
-        AC_MSG_CHECKING([for libpcap version >= 0.9])
-        AC_RUN_IFELSE(
-        [AC_LANG_PROGRAM(
-        [[
-        #include <pcap.h>
-        #include <string.h>
-        extern char pcap_version[];
-        ]],
-        [[
-           if (strcmp(pcap_version, "0.9x") == 0)
-               return 1;
-
-           if (strcmp(pcap_version, "0.9.0") < 0)
-               return 1;
-        ]])],
-        [libpcap_version_09="yes"],
-        [libpcap_version_09="no"])
-        AC_MSG_RESULT($libpcap_version_09)
-        if test "x$libpcap_version_09" = "xyes"; then
-            AC_DEFINE([LIBPCAP_ACCUMULATES],[1],[For libpcap versions that accumulate stats])
-        fi
-    else
-        libpcap_version_09="no"
-        AC_DEFINE([LIBPCAP_ACCUMULATES],[1],[For libpcap versions that accumulate stats])
-    fi
-
-    # there is a bug in the Linux code in 0.9.0 - 0.9.4 where the pcap
-    # stats are doubled.
-    if test "x$libpcap_version_09" = "xyes"; then
-        AC_MSG_CHECKING(for libpcap version 0.9.0 - 0.9.4)
-        AC_RUN_IFELSE(
-        [AC_LANG_PROGRAM(
-        [[
-        #include <pcap.h>
-        #include <string.h>
-        extern char pcap_version[];
-        ]],
-        [[
-           if (strcmp(pcap_version, "0.9.5") < 0)
-               return 1;
-        ]])],
-        [libpcap_version_09_bug="no"],
-        [libpcap_version_09_bug="yes"])
-        AC_MSG_RESULT($libpcap_version_09_bug)
-    else
-        libpcap_version_09_bug="no"
-    fi
-
-    if test "x$libpcap_version_09_bug" = "xyes"; then
-        AC_DEFINE([LINUX_LIBPCAP_DOUBLES_STATS],[1],[For Linux libpcap versions 0.9.0 to 0.9.4])
-    fi
-else
-    AC_DEFINE([LIBPCAP_ACCUMULATES],[1],[For libpcap versions that accumulate stats])
-fi
+libpcap_version_09="yes"
+libpcap_version_09_bug="no"
 
 AC_DEFUN([FAIL_MESSAGE],[
    echo
