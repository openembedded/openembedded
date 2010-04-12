DESCRIPTION = "Graphical login manager"
LICENSE = "GPL"

DEPENDS = "gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl"

inherit gnome

SRC_URI += "file://gdm-nodocs.patch;patch=1"

FILES_${PN} += "${datadir}/icon* \
		${datadir}/xsession*"






SRC_URI[archive.md5sum] = "7e46bc3b0a5b08e79f1f2f1b869caf40"
SRC_URI[archive.sha256sum] = "0483dac71c88ca0da5ee85729c0c1dd6793d928109ac79ad56583aa1a5ff43d2"
