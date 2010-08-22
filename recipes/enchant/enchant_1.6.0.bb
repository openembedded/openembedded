DESCRIPTION = "Enchant Spell checker API Library"
PRIORITY    = "optional"
SECTION     = "libs"
LICENSE     = "LGPL"
DEPENDS     = "aspell glib-2.0"
RDEPENDS_${PN}    = "aspell"

inherit autotools pkgconfig

PR = "r2"

S = "${WORKDIR}/enchant-${PV}"

SRC_URI = "http://www.abisource.com/downloads/enchant/${PV}/enchant-${PV}.tar.gz"

EXTRA_OECONF = "--with-aspell-prefix=${STAGING_DIR_HOST}${layout_prefix} --enable-aspell --disable-binreloc"

FILES_${PN} = "${bindir} ${libdir}/*${SOLIBS} ${datadir}/${PN} ${libdir}/${PN}/*.so"
FILES_${PN}-dev += "${libdir}/${PN}/*{SOLIBSDEV} ${libdir}/${PN}/*.la ${libdir}/${PN}/*.a"

export CXXFLAGS += " -L${STAGING_LIBDIR} -lstdc++ "

SRC_URI[md5sum] = "de11011aff801dc61042828041fb59c7"
SRC_URI[sha256sum] = "2fac9e7be7e9424b2c5570d8affe568db39f7572c10ed48d4e13cddf03f7097f"

