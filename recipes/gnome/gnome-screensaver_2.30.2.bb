DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-menus gnome-desktop gnome-common shadow glib-2.0 gtk+ gconf"

PR = "r1"

inherit gnome

SRC_URI[archive.md5sum] = "0fbe6e610e6847ac1e69d49b1e1f0582"
SRC_URI[archive.sha256sum] = "dd52ef278b23ec5abe5974548c2d576eeaeb5294c85e9f2efd6231ecc9ca09fa"

EXTRA_OECONF = " \
                --with-shadow=${STAGING_INCDIR}/.. \
               "
do_configure () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
	sed -i -e 's:$CPPFLAGS -I$includedir:$CPPFLAGS:g' configure.ac
	autotools_do_configure
}

#disable the screensaver by default
do_install_append_angstrom() {
	sed -i -e 's:<default>TRUE:<default>FALSE:g' ${D}${sysconfdir}/gconf/schemas/gnome-screensaver.schemas
}

FILES_${PN} += "${datadir}/*background* ${datadir}/desktop-directories"

FILES_${PN}-dbg += "${libexecdir}/gnome-screensaver/.debug "


