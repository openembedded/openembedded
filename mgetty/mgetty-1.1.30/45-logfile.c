--- mgetty-1.1.30.orig/logfile.c	2002-11-25 08:08:26.000000000 -0500
+++ mgetty-1.1.30/logfile.c	2003-04-28 00:08:35.000000000 -0400
@@ -56,10 +56,14 @@
 /* Most systems have these variables but do not declare them. On many
    of those systems that _do_ declare them, it won't hurt */
 
-extern int sys_nerr;
-#if !defined(__NetBSD__) && !defined( __FreeBSD__ ) && !defined(__OpenBSD__) && !defined(__GLIBC__) && !defined(__MACH__)
-extern char *sys_errlist[];
-#endif
+/* commented in by was@debian.org on Wed, 27 Nov 2002 01:15:11 -0500
+   because sys_nerr and sys_errlist are deprecated. strerror() is used
+   instead below.*/
+
+/* extern int sys_nerr; */
+/* #if !defined(__NetBSD__) && !defined( __FreeBSD__ ) && !defined(__OpenBSD__) && !defined(__GLIBC__) && !defined(__MACH__) */
+/* extern char *sys_errlist[]; */
+/* #endif */
 
 /* Interactive Unix is a little bit braindead - does not have atexit(),
  */
@@ -209,6 +213,7 @@
 va_list pvar;
 int     errnr;
 char * p;
+char *error_string;
 static int first_open = TRUE;
 
     if ( level > log_level )	/* log level high enough? */
@@ -325,12 +330,20 @@
     }
     else		/* ERROR or FATAL */
     {
+        error_string = strerror (errnr);
+	if ( error_string == NULL )
+	{
+            if ( errno == EINVAL )
+	        error_string = "<error not in list>";
+	    else
+	        error_string = "<error calling strerror()>";
+	}
+
 	fprintf(log_fp, "\n%02d/%02d %02d:%02d:%02d %s %s: %s",
 		             tm->tm_mon+1,  tm->tm_mday,
 			     tm->tm_hour, tm->tm_min, tm->tm_sec,
 		             log_infix, ws,
-			     ( errnr <= sys_nerr ) ? sys_errlist[errnr]:
-			     "<error not in list>" );
+			     strerror (errnr));
 #ifdef SYSLOG
 	syslog( level == L_FATAL? LOG_ALERT: LOG_ERR, "%s: %m", ws );
 #endif
