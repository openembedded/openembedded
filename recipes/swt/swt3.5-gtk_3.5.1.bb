require swt-gtk.inc

PR = "r0"

SRC_URI = "http://mirror.switch.ch/eclipse/eclipse/downloads/drops/R-3.5.1-200909170800/swt-3.5.1-gtk-linux-x86.zip;name=swt \
           file://Makefile"

SRC_URI[swt.md5sum] = "ceaa95d484d7ab95c663401b5a9bd1f5"
SRC_URI[swt.sha1sum] = "654744a3a2bc7eadfd807d2f1238580ac31571ee"

# A number which is used by SWT to mark the shared libraries.
SWT_API_VERSION = "3.5"

PROVIDES = "swt3.5-gtk"

RCONFLICTS = "libswt3.4-gtk-java"
