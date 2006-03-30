DESCRIPTION = "The Linux* SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://upnp.sourceforge.net/"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
LICENSE = "BSD"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/upnp/${P}.tar.gz"
inherit autotools pkgconfig



do_stage() {
autotools_stage_all
}


