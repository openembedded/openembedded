inherit autotools gpe

DESCRIPTION = "GReader"
DEPENDS = "libgpewidget zlib"
SECTION = "gpe/applications"
#RDEPENDS = "gpe-icons"

SRC_URI = "http://handhelds.org/~gberenfield/${PN}_${PV}_src.tgz \
           file://greader.patch;patch=1;pnum=1"
S = "${WORKDIR}/greader/"

SRC_URI[md5sum] = "6a2c4167c79ccd768e770e693e5e69bd"
SRC_URI[sha256sum] = "81d2113eba8a9b2acf5cb7558ab2dcd369213eb82b1772b03b29cf2ae6cd7b5e"
