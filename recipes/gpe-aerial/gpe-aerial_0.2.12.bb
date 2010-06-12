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

SRC_URI[md5sum] = "dcf115e16bcc393b2b45fe34ef06fdbc"
SRC_URI[sha256sum] = "6280881516f851edb075882d8114bd9bee6906b924a9923645793e937e4d6e68"
