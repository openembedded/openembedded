DESCRIPTION = "GMyth is a library to access MythTV backend services."
LICENSE = "LGPLv2""
HOMEPAGE = "http://gmyth.sourceforge.net/wiki/index.php/Main_Page"
DEPENDS = "curl libxml2 glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gmyth/${PN}-${PV}.tar.gz"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	sed -i -e s:${STAGING_DIR}::g gmyth.pc
	autotools_stage_all
}	

