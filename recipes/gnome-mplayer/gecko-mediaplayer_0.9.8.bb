DESCRIPTION = "Gecko plugin for gnome-mplayer"
HOMEPAGE = "http://dekorte.homeip.net/download/gecko-mediaplayer/"
LICENSE = "GPL"
DEPENDS = "firefox gtk+ gconf dbus-glib"
RDEPENDS = "firefox gnome-mplayer"

PR = "r8"

inherit autotools

SRC_URI = "http://gecko-mediaplayer.googlecode.com/files/${P}.tar.gz \
           file://gecko-mplayer-svn.diff;patch=1;pnum=0 \
           file://extensions \
"

do_install_append() {
	cp -dpR ${WORKDIR}/extens* ${D}${libdir}/mozilla/
}

PACKAGES =+ "${PN}-firefox-hack"
RDEPENDS_${PN}-firefox-hack = "${PN}"
FILES_${PN}-firefox-hack = "${libdir}/mozilla/extensions"

FILES_${PN} += "${sysconfdir}/* \
                ${libdir}/mozilla/*"
FILES_${PN}-dbg += "${libdir}/mozilla*/plugins/.debug/*"

pkg_postinst_${PN}-firefox-hack() {
for firefoxdir in $D${libdir}/firefox-* ; do
	if [ -e $firefoxdir/extensions/ ] ; then 
		ln -sf ${libdir}/mozilla/extensions/flash@alwaysinnovating.com $firefoxdir/extensions/
	fi
done
}


SRC_URI[md5sum] = "4df009d21b1a95c35c9adfdb6fbc96fe"
SRC_URI[sha256sum] = "a51ebf00021b1d5d43837edebd0fb28d8f6d2626111c4c391e8b0f6515004aa1"
