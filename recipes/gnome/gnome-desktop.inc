DESCRIPTION = "GNOME library for reading .desktop files"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common libgnomeui"

PR = "r1"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

do_install_append() {
	sed  -i 's:#!.*/usr/bin/python:#!/usr/bin/python:' ${D}${bindir}/gnome-about
}

FILES_${PN} += "${datadir}/gnome-about ${datadir}/libgnome-desktop"
