DESCRIPTION = "Enchant Spell checker API Library"
MAINTAINER  = "AbiWord Team"
PRIORITY    = "optional"
SECTION     = "libs"

DEPENDS     = "aspell"
RDEPENDS    = "aspell"

inherit autotools pkgconfig

PR = "r0"

S = "${WORKDIR}/enchant-${PV}"

SRC_URI = "http://www.abisource.com/downloads/enchant/${PV}/enchant-${PV}.tar.gz \
           file://configure.patch;patch=1"

EXTRA_OECONF = "--with-aspell-prefix=${STAGING_DIR}/${HOST_SYS} --enable-aspell"

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR}/share/man
}
