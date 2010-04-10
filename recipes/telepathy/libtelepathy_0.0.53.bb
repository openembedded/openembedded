HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://telepathy.freedesktop.org/releases/libtelepathy/libtelepathy-${PV}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

do_stage() {
    autotools_stage_all
}

SRC_URI[md5sum] = "015611ff5cbd3b3718fcb49adc47bd13"
SRC_URI[sha256sum] = "dfc90b2c92bc313c67d80611945823799581b5b4eb5758d6d77846d4e22666de"
