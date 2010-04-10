DESCRIPTION = "Gnome application programming libraries"
LICENSE = "GPL"
SECTION = "x11/gnome/libs"

inherit gnome lib_package

DEPENDS = "gconf-native gnome-vfs libbonobo esound"

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/bonobo/servers ${libdir}/bonobo/monikers/*.so \
                ${datadir}/gnome-background-properties ${datadir}/pixmaps"
FILES_${PN}-dev += "${libdir}/bonobo/monikers/*a"
FILES_${PN}-dbg += "${libdir}/bonobo/monikers/.debug"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
	echo "EXTRA_DIST = version.xml" > gtk-doc.make
}

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "5c7efe21dc28c137aa766a77a84c0c29"
SRC_URI[archive.sha256sum] = "9b5b05085b814406f75abfaa1a85395bcf92c8f933248219e1bd738d500d0c0e"
