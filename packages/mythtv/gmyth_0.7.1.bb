DESCRIPTION = "GMyth is a library to access MythTV backend services."
LICENSE = "LGPLv2""
HOMEPAGE = "http://gmyth.sourceforge.net/wiki/index.php/Main_Page"
DEPENDS = "mythtv curl libxml2 glib-2.0"

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gmyth/${PN}-${PV}.tar.gz"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gmyth.pc
}

do_stage() {
	autotools_stage_all
}	

