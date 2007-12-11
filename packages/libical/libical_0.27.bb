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
