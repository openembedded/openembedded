DESCRIPTION = "The portable SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://pupnp.sourceforge.net/"
LICENSE = "BSD"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/pupnp/${P}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
