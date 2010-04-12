SECTION = "base"
LICENSE = "BSD"
require fontconfig_${PV}.bb
inherit native
DEPENDS = "freetype-native expat-native zlib-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/fontconfig-${PV}"

EXTRA_OEMAKE = ""
EXTRA_OECONF = "${@[' --disable-docs',' --disable-docs --with-freetype-config=%s/freetype-config' % bb.data.getVar('STAGING_BINDIR', d, 1)][os.path.isfile('%s/freetype-config' % bb.data.getVar('STAGING_BINDIR', d, 1))]}"

do_stage () {
	oe_runmake install
	install fc-lang/fc-lang ${STAGING_BINDIR}
	install fc-glyphname/fc-glyphname ${STAGING_BINDIR}
}

SRC_URI[md5sum] = "098a36ec53ec893f6511712ec4010d38"
SRC_URI[sha256sum] = "a906c3193de44e5a8d93174bb86e91f39e415f92ad9319b318fd3a46a2ad9b35"
