DESCRIPTION = "File manager for the Xfce Desktop Environment"
DEPENDS = "libxfcegui4 exo dbus-glib libexif xfce4-panel libice libsm"

inherit xfce pkgconfig

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.2/src/Thunar-${PV}.tar.bz2"
PR = 'r1'

S = "${WORKDIR}/Thunar-${PV}/"

FILES_${PN} += "${libdir}/thunarx-1/*.so \
                ${datadir}/dbus-1 \
                ${datadir}/thumbnailers \
                ${datadir}/Thunar \
                ${datadir}/xfce4"
FILES_${PN}-dbg += "${libdir}/thunarx-1/.debug/ ${libexecdir}/xfce4/panel-plugins/.debug/"

do_stage () {
	autotools_stage_all
}
