HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "telepathy-glib glib-2.0 dbus"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "http://telepathy.freedesktop.org/releases/libtelepathy/libtelepathy-${PV}.tar.gz \
           file://duplicate-header.patch;patch=1 \
          "

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

do_stage() {
    autotools_stage_all
}
