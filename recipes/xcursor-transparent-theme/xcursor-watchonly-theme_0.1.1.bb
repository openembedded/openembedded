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

SRC_URI[md5sum] = "7b0c623049d4aab20600d6473f8aab23"
SRC_URI[sha256sum] = "b26adf2d503d01299718390ae39dab4691a67220de09423be0364e9a060bf7e4"
