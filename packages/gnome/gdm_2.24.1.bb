DESCRIPTION = "Graphical login manager"
LICENSE = "GPL"

DEPENDS = "libpam gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl"

inherit gnome

SRC_URI += "file://%gconf-tree.xml"

do_install_prepend() {
	mkdir -p ${D}/var/lib/gdm/.gconf.mandatory
	cp ${WORKDIR}/%gconf-tree.xml ${D}/var/lib/gdm/.gconf.mandatory/ 
}

FILES_${PN} += "${datadir}/icon* \
		${datadir}/xsession*"





