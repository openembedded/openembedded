SECTION = "base"
LICENSE = "BSD"
require fontconfig_${PV}.bb
inherit native
DEPENDS = "freetype-native expat-native zlib-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/fontconfig-${PV}"

EXTRA_OECONF = "${@[' --disable-docs',' --disable-docs --with-freetype-config=%s/freetype-config' % bb.data.getVar('STAGING_BINDIR', d, 1)][os.path.isfile('%s/freetype-config' % bb.data.getVar('STAGING_BINDIR', d, 1))]}"

do_install_append () {
	install -d ${D}${bindir}
	install fc-lang/fc-lang ${D}${bindir}
	install fc-glyphname/fc-glyphname ${D}${bindir}
}

NATIVE_INSTALL_WORKS = "1"

SRC_URI[md5sum] = "ab54ec1d4ddd836313fdbc0cd5299d6d"
SRC_URI[sha256sum] = "a9a639eaa0e5666606a4657cc1494eb6df820fac7e5a2aa0c3f7e703b7c8d8a5"
