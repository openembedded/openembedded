require swt-gtk.inc

PR = "r2"

SRC_URI = "http://ftp.wh2.tu-dresden.de/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.4.2-200902111700/swt-3.4.2-gtk-linux-x86.zip \
           file://Makefile"

# A number which is used by SWT to mark the shared libraries.
SWT_API_VERSION = "3.4"

PROVIDES = "swt3.4-gtk"

RCONFLICTS = "libswt3.5-gtk-java"

SRC_URI[md5sum] = "2b97f05f86bd7138491d9a8c5934e840"
SRC_URI[sha256sum] = "30c8c545faabae331420a6c37194470a4f74f508eab4e0463c65953d09cde6eb"
