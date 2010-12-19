SECTION = "base"
LICENSE = "BSD"
require fontconfig_${PV}.bb
inherit native
DEPENDS = "freetype-native expat-native zlib-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/fontconfig-${PV}"

EXTRA_OEMAKE = ""
EXTRA_OECONF = "${@[' --disable-docs',' --disable-docs --with-freetype-config=%s/freetype-config' % bb.data.getVar('STAGING_BINDIR', d, 1)][os.path.isfile('%s/freetype-config' % bb.data.getVar('STAGING_BINDIR', d, 1))]}"

do_install_append () {
	install -d ${D}${bindir}
	install fc-lang/fc-lang ${D}${bindir}
	install fc-glyphname/fc-glyphname ${D}${bindir}
}

NATIVE_INSTALL_WORKS = "1"
