DESCRIPTION = "The Linux* SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://upnp.sourceforge.net/"
LICENSE = "BSD"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/upnp/${P}.tar.gz"
inherit autotools pkgconfig



do_stage() {
autotools_stage_all
}



SRC_URI[md5sum] = "6646be5e31e58188e8f47c6ce64faa4c"
SRC_URI[sha256sum] = "4d0d6a5302222757fb36ee21d8f8e1b3de849c2de658ab1105272f32ff78767d"
