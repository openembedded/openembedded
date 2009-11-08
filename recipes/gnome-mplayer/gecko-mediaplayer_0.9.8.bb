DESCRIPTION = "Gecko plugin for gnome-mplayer"
HOMEPAGE = "http://dekorte.homeip.net/download/gecko-mediaplayer/"
LICENSE = "GPL"
DEPENDS = "firefox gtk+ gconf dbus-glib"
RDEPENDS = "firefox gnome-mplayer"

PR = "r5"

inherit autotools

SRC_URI = "http://gecko-mediaplayer.googlecode.com/files/${P}.tar.gz \
           file://gecko-mplayer-svn.diff;patch=1;pnum=0 \
           file://extensions \
"

# Yes, this needs to match the firefox version you are building *exactly*
MOZILLA_HOME = "firefox-3.5.5"

do_install_append() {
	install -d ${D}${libdir}/${MOZILLA_HOME}/extensions/
	cp -dpR ${WORKDIR}/extens* ${D}${libdir}/mozilla/
	ln -sf ${libdir}/mozilla/extensions/flash@alwaysinnovating.com ${D}${libdir}/${MOZILLA_HOME}/extensions/
}

PACKAGES =+ "${PN}-firefox-hack"
RDEPENDS_${PN}-firefox-hack = "${PN}"
FILES_${PN}-firefox-hack = "${libdir}/mozilla/extensions ${libdir}/${MOZILLA_HOME}"

FILES_${PN} += "${sysconfdir}/* \
                ${libdir}/mozilla/* ${libdir}/${MOZILLA_HOME}"
FILES_${PN}-dbg += "${libdir}/mozilla*/plugins/.debug/*"


