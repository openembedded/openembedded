DESCRIPTION = "mpg123 is a fast and free console based real time MPEG \
Audio Player for Layer 1, 2 and 3."
LICENSE = "LGPL"
DESCRIPTION = "multimedia"
HOMEPAGE = "http://www.mpg123.de"
RCONFLICTS_${PN} = "mpg321"
RREPLACES_${PN} = "mpg321"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg123/mpg123-${PV}.tar.bz2"

EXTRA_OECONF="--with-cpu=generic_nofpu"

inherit autotools

SRC_URI[md5sum] = "01fa64533cade452c2b22a3ce14a2fcd"
SRC_URI[sha256sum] = "27008b972e37f35eb8a2a33af556adc29d8e10bf8f2c362f3e50254d682425c4"
