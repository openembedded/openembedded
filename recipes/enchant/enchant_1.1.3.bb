DESCRIPTION = "Enchant Spell checker API Library"
PRIORITY    = "optional"
SECTION = "libs"

DEPENDS     = "aspell"
RDEPENDS    = "aspell"

inherit autotools pkgconfig

PR = "r0"

S = "${WORKDIR}/enchant-${PV}"

SRC_URI = "http://download.sourceforge.net/abiword/enchant-1.1.3.tar.gz"

do_stage() {
	oe_runmake install prefix=${STAGING_DIR_HOST}${layout_prefix} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR_HOST}${layout_mandir}
}

SRC_URI[md5sum] = "c95186755fe46b27a78d9a85fef2175c"
SRC_URI[sha256sum] = "6a8bce57437c514f2578e7ff09f8a48ff3b20e7ed746c3113372d2c75d382c83"
