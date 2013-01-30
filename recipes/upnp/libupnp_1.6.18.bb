DESCRIPTION = "The portable SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://pupnp.sourceforge.net/"
LICENSE = "BSD"

PR = "r0"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/pupnp/${P}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "11c6484fd2e2927bf3b8d8108407ca56"
SRC_URI[sha256sum] = "b21bc676365622d3ace1b25292dab8d4d23f6e6a80ddc8f029b765d39797e934"
