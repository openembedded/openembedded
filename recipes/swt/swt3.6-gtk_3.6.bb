require swt-gtk.inc

PR = "r0"

SRC_URI = "http://mirrors.ibiblio.org/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.6-201006080911/swt-${PV}-gtk-linux-x86.zip;name=swt \
           file://Makefile"

SRC_URI[swt.md5sum] = "514206a4b9e27ac66cb7876157c3e74f"
SRC_URI[swt.sha256sum] = "9497be8de7e1190680cf984a0d53c3023812540a10df759ac28c7140198077ff"

# A number which is used by SWT to mark the shared libraries.
SWT_API_VERSION = "3.6"

PROVIDES = "swt3.6-gtk"

RCONFLICTS_${PN} = "libswt3.4-gtk-java libswt3.5-gtk-java"
