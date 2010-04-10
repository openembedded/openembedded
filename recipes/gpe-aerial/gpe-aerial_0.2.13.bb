inherit gpe pkgconfig

PR = "r1"


DESCRIPTION = "GPE wireless LAN communication applet"
DEPENDS = "gtk+ libgpewidget prismstumbler"
RDEPENDS = "prismstumbler"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://iconlist.patch;patch=1;pnum=0 \
	    file://fix_makefile.patch;patch=1"

SRC_URI[md5sum] = "528f95a23999a248f4425436d67585a7"
SRC_URI[sha256sum] = "0cd7a9229a0c583dc9dc74ef3a2c542ee5f64f8e6c641d50cadc11c664c0c109"
