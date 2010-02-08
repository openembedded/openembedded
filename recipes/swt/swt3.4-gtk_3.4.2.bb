require swt-gtk.inc

PR = "r1"

SRC_URI = "http://ftp.wh2.tu-dresden.de/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.4.2-200902111700/swt-3.4.2-gtk-linux-x86.zip \
           file://Makefile"

# A number which is used by SWT to mark the shared libraries.
SWTVERSION = "3452"
SWT_API_VERSION = "3.4"

PROVIDES = "swt3.4-gtk"

RCONFLICTS = "libswt3.3-gtk-java"
