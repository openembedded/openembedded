LICENSE = "GPL"
DESCRIPTION = "Transparent xcursor theme for handheld systems with visible watch cursor"
SECTION = "x11/base"
RREPLACES = "xcursor-transparent-theme"
RPROVIDES = "xcursor-transparent-theme"
PR ="r4"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/utils/xcursor-transparent-theme-${PV}.tar.gz \
	   file://use-relative-symlinks.patch;patch=1 \
	   file://skip_watch_cursor.patch;patch=1 \
	   file://20xcursor-transparent"
S = "${WORKDIR}/xcursor-transparent-theme-${PV}"

FILES_${PN} += "${datadir}/icons/xcursor-transparent/cursors/*"

inherit autotools

do_install_append () {
        install -d ${D}${sysconfdir}/X11/Xsession.d
        install -m 0755 ${WORKDIR}/20xcursor-transparent ${D}${sysconfdir}/X11/Xsession.d
}

PACKAGE_ARCH = "all"
