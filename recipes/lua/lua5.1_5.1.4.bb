DESCRIPTION = "Lua is a powerful light-weight programming language designed \
for extending applications."
LICENSE = "MIT"
HOMEPAGE = "http://www.lua.org/"

DEPENDS += "readline"
PR = "r5"
SRC_URI = "http://www.lua.org/ftp/lua-${PV}.tar.gz \
           file://lua5.1.pc"
S = "${WORKDIR}/lua-${PV}"

inherit pkgconfig binconfig

TARGET_CC_ARCH += " -fPIC ${LDFLAGS}"
EXTRA_OEMAKE = "'CC=${CC} -fPIC' 'MYCFLAGS=${CFLAGS} -DLUA_USE_LINUX -fPIC' MYLDFLAGS='${LDFLAGS}'"

do_compile () {
	cp ${WORKDIR}/lua5.1.pc ${S}/
	oe_runmake linux
}

do_install () {
	oe_runmake \
		'INSTALL_TOP=${D}${prefix}' \
		'INSTALL_BIN=${D}${bindir}' \
		'INSTALL_INC=${D}${includedir}/' \
		'INSTALL_MAN=${D}${mandir}/man1' \
		'INSTALL_SHARE=${D}${datadir}/lua' \
		install
}
NATIVE_INSTALL_WORKS = 1
BBCLASSEXTEND = "native"
