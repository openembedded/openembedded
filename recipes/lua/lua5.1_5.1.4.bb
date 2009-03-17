DESCRIPTION = "Lua is a powerful light-weight programming language designed \
for extending applications."
LICENSE = "MIT"
HOMEPAGE = "http://www.lua.org/"

DEPENDS += "readline"
PR = "r0"
SRC_URI = "http://www.lua.org/ftp/lua-${PV}.tar.gz \
           file://makefile.patch;patch=1 \
           file://lua5.1.pc"
S = "${WORKDIR}/lua-${PV}"

inherit binconfig

EXTRA_OEMAKE = "'CC=${CC}' 'MYCFLAGS=${CFLAGS}' 'MYLDFLAGS=${LDFLAGS}'"

do_compile () {
	oe_runmake linux
}

do_stage () {
	oe_libinstall -C src liblua5.1 ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/lua5.1
	install -m 0644 src/lua.h src/luaconf.h src/lualib.h src/lauxlib.h ${STAGING_INCDIR}/lua5.1
	install -m 0644 ${WORKDIR}/lua5.1.pc ${STAGING_LIBDIR}/pkgconfig/
}

do_install () {
	oe_runmake \
		'INSTALL_TOP=${D}${prefix}' \
		'INSTALL_BIN=${D}${bindir}' \
		'INSTALL_INC=${D}${includedir}/lua5.1' \
		'INSTALL_MAN=${D}${mandir}/man1' \
		'INSTALL_SHARE=${D}${datadir}/lua' \
		install
}

