require swt-gtk.inc

SRC_URI = "http://ftp.wh2.tu-dresden.de/pub/mirrors/eclipse/eclipse/downloads/drops/S-3.4M3-200711012000/swt-3.4M3-gtk-linux-x86.zip \
           file://Makefile \
	   file://make_linux-fix.patch;patch=1"

# A number which is used by SWT to mark the shared libraries.
SWTVERSION = "3416"
SWT_API_VERSION = "3.4"

PROVIDES = "swt3.4-gtk"

RCONFLICTS = "libswt3.3-gtk-java"
