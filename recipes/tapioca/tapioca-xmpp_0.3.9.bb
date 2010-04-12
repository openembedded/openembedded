HOMEPAGE = "http://tapioca-voip.sourceforge.net/wiki/index.php/Tapioca"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 dbus libjingle openssl tapioca"
inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/${P}.tar.gz"

FILES_${PN} += "${datadir}/dbus* ${datadir}/tapioca* "

do_stage () {
        autotools_stage_all
}

SRC_URI[md5sum] = "8d810351eb5b30e70b202e067da450c1"
SRC_URI[sha256sum] = "51dd2ecda515e5872971cf80216915492686f5a5c9745e12ba1b3c5aec826fce"
