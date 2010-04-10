HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "http://telepathy.freedesktop.org/releases/libtelepathy/libtelepathy-${PV}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

do_stage() {
    autotools_stage_all
}

SRC_URI[md5sum] = "a2083338ed480fd507925e00a93fd96b"
SRC_URI[sha256sum] = "c33ef2820ea954aa2aa6d048f4540aa75f09cfc4c7915558d736dcedc1b8fa07"
