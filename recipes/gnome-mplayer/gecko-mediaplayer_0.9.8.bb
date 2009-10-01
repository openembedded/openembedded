DESCRIPTION = "Gecko plugin for gnome-mplayer"
HOMEPAGE = "http://dekorte.homeip.net/download/gecko-mediaplayer/"
LICENSE = "GPL"
DEPENDS = "firefox gtk+ gconf dbus-glib"
RDEPENDS = "firefox gnome-mplayer"

inherit autotools

SRC_URI = "http://gecko-mediaplayer.googlecode.com/files/${P}.tar.gz \
           file://extensions \
"

# Yes, this needs to match the firefox version you are building *exactly*
MOZILLA_HOME = firefox-3.5.2

do_install_append() {
	install -d  ${D}${libdir}/${MOZILLA_HOME}
	mv ${D}${libdir}/mozilla/plugins ${D}${libdir}/${MOZILLA_HOME}
	cp -dpR ${WORKDIR}/extens* ${D}${libdir}/${MOZILLA_HOME}/
}


#EXTRA_OEMAKE = "-I${STAGING_INCDIR}/${MOZILLA_HOME} -I${STAGING_INCDIR}/linux"

PACKAGES =+ "${PN}-firefox-hack"
RDEPENDS_${PN}-firefox-hack = "${PN}"
FILES_${PN}-firefox-hack = "${D}${libdir}/${MOZILLA_HOME}/extensions"

FILES_${PN} += "${sysconfdir}/* \
                ${libdir}/${MOZILLA_HOME}/*"
FILES_${PN}-dbg += "${libdir}/${MOZILLA_HOME}/plugins/.debug/*"


