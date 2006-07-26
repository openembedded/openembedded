DESCRIPTION = "Graphical login manager"
LICENSE = "GPL"

DEPENDS = "gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl" 

inherit gnome

SRC_URI += "file://gdm-nodocs.patch;patch=1"

FILES_${PN} += "${datadir}/icon* \
		${datadir}/xsession*"





