DESCRIPTION = "Om application for playing media files."
SECTION = "openmoko/tools"
DEPENDS = "libmokoui2 expat gstreamer libspiff curl"
RDEPENDS = "gst-meta-audio gconf gst-plugin-alsa"
SRCREV = "4750"
PV = "0.1.0+svnr${SRCPV}"
PR = "r6"

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

export GCONF_CONFIG_SOURCE=`gconftool-2 --get-default-source`
gconftool-2 --makefile-install-rule ${sysconfdir}/gconf/schemas/openmoko-mediaplayer.schemas > /dev/null
}
