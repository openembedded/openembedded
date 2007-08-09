DESCRIPTION = "File manager for the Xfce Desktop Environment"
DEPENDS = "libxfcegui4 exo dbus-glib libexif xfce4-panel libice libsm"

inherit xfce

SRC_URI = "http://thunar.xfce.org/download/sources/Thunar/0.8.0/Thunar-0.8.0.tar.bz2"

S = "${WORKDIR}/Thunar-${PV}/"

FILES_${PN} += "${libdir}/thunarx-1/*.so \
                ${datadir}/dbus-1 \
                ${datadir}/thumbnailers \
                ${datadir}/Thunar \
                ${datadir}/xfce4"
FILES_${PN}-dbg += "${libdir}/thunarx-1/.debug/"
