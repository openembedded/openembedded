inherit gpe pkgconfig

PR = "r2"

DESCRIPTION = "GPE wireless LAN communication applet"
DEPENDS = "gtk+ libgpewidget prismstumbler"
RDEPENDS_${PN} = "prismstumbler"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://iconlist.patch;striplevel=0 \
	    file://fix_makefile.patch"

SRC_URI[md5sum] = "4b06838f0ad963f8c01640e8311130cb"
SRC_URI[sha256sum] = "30be2c450915938957bcb077bc5cf17b84eb9163ebe043e7324c359fb965c721"
