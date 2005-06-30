inherit autotools gpe

DESCRIPTION = "GReader"
DEPENDS = "libgpewidget zlib"
SECTION = "gpe/applications"
#RDEPENDS = "gpe-icons"

SRC_URI = "http://handhelds.org/~gberenfield/${PN}_${PV}_src.tgz \
           file://greader.patch;patch=1;pnum=1"
S = "${WORKDIR}/greader/" 
