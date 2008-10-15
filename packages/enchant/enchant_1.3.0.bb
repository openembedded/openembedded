DESCRIPTION = "Enchant Spell checker API Library"
PRIORITY    = "optional"
SECTION     = "libs"
LICENSE     = "LGPL"
DEPENDS     = "aspell"
RDEPENDS    = "aspell"

inherit autotools pkgconfig

PR = "r0"

S = "${WORKDIR}/enchant-${PV}"

SRC_URI = "http://www.abisource.com/downloads/enchant/${PV}/enchant-${PV}.tar.gz"

EXTRA_OECONF = "--with-aspell-prefix=${STAGING_DIR_HOST}${layout_prefix} --enable-aspell --disable-binreloc"

export CXXFLAGS += " -L${STAGING_LIBDIR} -lstdc++ "

FILES_${PN} = "/usr/bin/* /usr/lib/enchant/*.so /usr/share/enchant /usr/lib/libenchant*.so.*"

do_stage() {
	autotools_stage_all
}
