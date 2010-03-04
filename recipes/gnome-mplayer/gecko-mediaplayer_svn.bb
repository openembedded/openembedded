DESCRIPTION = "Gecko plugin for gnome-mplayer"
HOMEPAGE = "http://dekorte.homeip.net/download/gecko-mediaplayer/"
LICENSE = "GPL"
DEPENDS = "firefox gtk+ gconf dbus-glib"
RDEPENDS = "firefox gnome-mplayer"

PV = "0.9.9.2+${SRCPV}"
SRCREV = "385"

inherit autotools

SRC_URI = "svn://gecko-mediaplayer.googlecode.com/svn/;module=trunk;proto=http \
           file://extensions \
"

S = "${WORKDIR}/trunk"

# XUL changed API badly, so we need to choose between pre 3.6 and post 3.6 firefox :(
EXTRA_OECONF = " --enable-new-libxul=yes "
TARGET_CC_ARCH += " -DHAVE_NEW_XULRUNNER=1 "

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

