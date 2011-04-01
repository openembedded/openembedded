DESCRIPTION = "Gecko plugin for gnome-mplayer"
HOMEPAGE = "http://dekorte.homeip.net/download/gecko-mediaplayer/"
LICENSE = "GPL"
DEPENDS = "firefox gtk+ gconf dbus-glib"
RDEPENDS_${PN} = "firefox gnome-mplayer"

inherit autotools

SRC_URI = "http://gecko-mediaplayer.googlecode.com/files/${P}.tar.gz \
           file://extensions \
"

EXTRA_OECONF = " --enable-new-libxul=yes "
TARGET_CC_ARCH += " -DHAVE_NEW_XULRUNNER=1 "

do_install_append() {
	cp -PpR ${WORKDIR}/extens* ${D}${libdir}/mozilla/
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

SRC_URI[md5sum] = "80ccb671aea90153be9f9e6dc41b7eae"
SRC_URI[sha256sum] = "d0e5d6516c943de2257661d4718c91aa878e243d3fa891a121e99c887929499e"

