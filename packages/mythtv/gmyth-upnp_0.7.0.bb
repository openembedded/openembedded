DESCRIPTION = "GMyth is a library to access MythTV backend services."
LICENSE = "LGPLv2""
HOMEPAGE = "http://gmyth.sourceforge.net/wiki/index.php/Main_Page"

DEPENDS = "glib-2.0 mysql gmyth libupnp

SRC_URI = "${SOURCEFORGE_MIRROR}/gmyth/${PN}_0.7-indt1.tar.gz"
S = "${WORKDIR}/${PN}"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}	

