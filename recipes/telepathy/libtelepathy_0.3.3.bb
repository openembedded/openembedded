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

SRC_URI[md5sum] = "490ca1a0c614d4466394b72d43bf7370"
SRC_URI[sha256sum] = "e0d230be855125163579743418203c6f6be2f10f98c4f065735c1dc9ed115878"
