DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-menus gnome-desktop gnome-common shadow glib-2.0 gtk+ gconf"

inherit gnome

SRC_URI[archive.md5sum] = "e6fb9b206f3470c04e21474ee6d69687"
SRC_URI[archive.sha256sum] = "f2ffec4f637883c7db15fb94c3f85a7d59ade3cf1f0107ecebc01df13f0ad5c3"

EXTRA_OECONF = " \
                --with-shadow=${STAGING_INCDIR}/.. \
               "
# requires a too recent, non-default autoconf
do_configure () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
	sed -i -e 's:$CPPFLAGS -I$includedir:$CPPFLAGS:g' configure.ac
	sed -i -e 's:$CPPFLAGS -I$includedir:$CPPFLAGS:g' configure

	gnu-configize
	oe_runconf
}

FILES_${PN} += "${datadir}/*background* ${datadir}/desktop-directories"

FILES_${PN}-dbg += "${libexecdir}/gnome-screensaver/.debug "


