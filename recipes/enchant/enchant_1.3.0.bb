DESCRIPTION = "Enchant Spell checker API Library"
PRIORITY    = "optional"
SECTION     = "libs"
LICENSE     = "LGPL"
DEPENDS     = "aspell"
RDEPENDS    = "aspell"

inherit autotools pkgconfig

PR = "r1"

S = "${WORKDIR}/enchant-${PV}"

SRC_URI = "http://www.abisource.com/downloads/enchant/${PV}/enchant-${PV}.tar.gz"

EXTRA_OECONF = "--with-aspell-prefix=${STAGING_DIR_HOST}${layout_prefix} --enable-aspell --disable-binreloc"

FILES_${PN} = "${bindir} ${libdir}/*${SOLIBS} ${datadir}/${PN} ${libdir}/${PN}/*.so"
FILES_${PN}-dev += "${libdir}/${PN}/*{SOLIBSDEV} ${libdir}/${PN}/*.la ${libdir}/${PN}/*.a" 

export CXXFLAGS += " -L${STAGING_LIBDIR} -lstdc++ "

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "f7edafae875616b83e7a17a7e5c2d585"
SRC_URI[sha256sum] = "e65015aa0e6ada88a001b07b092265f4cbaf377d99b4233972995cdb94e698ef"
