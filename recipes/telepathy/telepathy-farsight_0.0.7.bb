DESCRIPTION = "Telepathy fasrsight"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus telepathy-glib farsight2"
LICENSE = "LGPLv2"

SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-farsight/${P}.tar.gz \
"

inherit autotools_stage

EXTRA_OECONF = "--disable-python"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

SRC_URI[md5sum] = "882c9630ab28706d34d7d6d1060d43f0"
SRC_URI[sha256sum] = "877760e794fb050448b6e591616afaba061d40c319e86b145053edf22df5570d"
