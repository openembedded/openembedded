DESCRIPTION = "MRXVT is a lightweight and powerful X terminal emulator based on aterm and rxvt"
HOMEPAGE = "http://materm.sourceforge.net"
AUTHOR = "Jimmy Zhou <jimmyzhou@users.sf.net>"
LICENSE = "GPL"
SECTION = "x11/apps"
DEPENDS = "libx11 libxext libxpm jpeg libpng"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/materm/mrxvt-${PV}.tar.gz \
           file://fix-compile.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-everything --disable-debug"
