DESCRIPTION = "A library to build launchers"
LICENSE = "GPLv3"

DEPENDS = "glib-2.0 dbus-glib libwnck libgtop gtk+ gnome-menus"

SRC_URI = "http://launchpad.net/wncksync/0.2/${PV}/+download/wncksync-${PV}.tar.gz;name=wncksync"

SRC_URI[wncksync.md5sum] = "eb936c9340bbad18856a2797d57a015d"
SRC_URI[wncksync.sha256sum] = "f14d1f033821210e943ad2ca748340e10c4554680891754ee1018dd282e5abe2"

inherit autotools

FILES_${PN} += "${datadir}/dbus-1 ${libdir}/gio/modules/*.so"
FILES_${PN}-dev += "${libdir}/gio/modules/"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug"


