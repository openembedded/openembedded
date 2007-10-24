DESCRIPTION = "A media player for OpenMoko"
SECTION = "openmoko/tools"
DEPENDS = "libmokoui2 expat gstreamer libspiff curl"
RDEPENDS = "gst-meta-audio"
PV = "0.1.0+svnr${SRCREV}"
PR = "r3"

inherit openmoko2

FILES_${PN} += "${datadir}/openmoko-mediaplayer"

do_install_append() {
	install -d ${D}${sysconfdir}/gconf/schemas
	install -m 0644 ${S}/openmoko-mediaplayer.schemas ${D}${sysconfdir}/gconf/schemas/openmoko-mediaplayer.schemas
}

pkg_postinst_openmoko-mediaplayer2 () {
#!/bin/sh -e
if [ "x$D" != "x" ]; then
    exit 1
fi

gconftool-2 --makefile-install-rule ${D}${sysconfdir}/gconf/schemas/openmoko-mediaplayer.schemas > /dev/null
}
