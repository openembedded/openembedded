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

SRC_URI[md5sum] = "6e64304b91cfea887558154d465bb752"
SRC_URI[sha256sum] = "9d1eb5813a7d3e7907da4e6a69c93f4689c49a2ed8320c35ce4570f63448f2d0"
