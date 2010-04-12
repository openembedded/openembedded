LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "e93f0c9747a66ce229702418b49e128f"
SRC_URI[sha256sum] = "97c2dec953e21bfa2633077d084fc0b9aff0c79030f96680ebdef9f97e294cc7"
