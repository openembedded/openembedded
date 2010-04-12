DESCRIPTION = "iCal and scheduling (RFC 2445, 2446, 2447) library"
HOMEPAGE = "http://www.softwarestudio.org/softwarestudio/app.php/libical"
SECTION = "libs"
LICENSE = "LGPL / MPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/freeassociation/${P}.tar.gz \
           file://pthread-link.patch;patch=1"


inherit autotools

do_stage () {
    autotools_stage_all
}

SRC_URI[md5sum] = "87d48321bff08de08794132d60b55d94"
SRC_URI[sha256sum] = "7f1fa404e5540c880cc747c4a680a89d88b87b10a1c77655f512780fcb0ca5d0"
