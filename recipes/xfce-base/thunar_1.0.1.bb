DESCRIPTION = "File manager for the Xfce Desktop Environment"
HOMEPAGE="http://thunar.xfce.org"
DEPENDS = "exo dbus-glib libexif xfce4-panel libice libsm gamin"
RDEPENDS = "libxfcegui4 exo dbus-glib libexif xfce4-panel libice libsm gamin"
RRECOMMENDS = "shared-mime-info"
SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://www.us.xfce.org/archive/xfce-${XFCE_VERSION}/src/Thunar-${PV}.tar.bz2"

S = "${WORKDIR}/Thunar-${PV}/"

EXTRA_OECONF += "--disable-dependency-tracking --enable-dbus"

FILES_${PN} += "${libdir}/thunarx-1/*.so \
		${libdir}/thunarx-1/*.la \
                ${datadir}/dbus-1 \
                ${datadir}/thumbnailers \
                ${datadir}/Thunar \
                ${datadir}/xfce4"
FILES_${PN}-dbg += "${libdir}/thunarx-1/.debug/ ${libexecdir}/xfce4/panel-plugins/.debug/"

do_stage () {
 	autotools_stage_all
}
