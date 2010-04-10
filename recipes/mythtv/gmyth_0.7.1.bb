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


SRC_URI[md5sum] = "ab6b7525fd9c71cf5203f9e61abec0c3"
SRC_URI[sha256sum] = "ce7cbf087b377f027516d90525bbea6130f70b42f176b2d17386b7247b290fdb"
