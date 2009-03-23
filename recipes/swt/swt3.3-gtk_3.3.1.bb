require swt-gtk.inc

PR = "r1"

SRC_URI = "http://ftp-stud.fht-esslingen.de/pub/Mirrors/eclipse/eclipse/downloads/drops/R-${PV}-200710231652/swt-${PV}-gtk-linux-x86.zip \
           file://Makefile"

# A number which is used by SWT to mark the shared libraries.
SWTVERSION = "3347"
SWT_API_VERSION = "3.3"

RCONFLICTS = "libswt3.4-gtk-java"
