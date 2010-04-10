require mingw-w32api.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/w32api-${PV}-mingw32-src.tar.gz"

S = "${WORKDIR}/w32api-${PV}-mingw32"

SRC_URI[md5sum] = "8eae788a09a589414b83adc91bb0c069"
SRC_URI[sha256sum] = "02cec615f8cfc94786ea9c1f41645cf43cc2414ca36b92fdd041304723bf2fc4"
