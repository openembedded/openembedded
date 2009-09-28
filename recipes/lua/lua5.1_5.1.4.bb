DESCRIPTION = "Lua is a powerful light-weight programming language designed \
for extending applications."
LICENSE = "MIT"
HOMEPAGE = "http://www.lua.org/"

DEPENDS += "readline"
PR = "r4"
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

do_stage () {
	oe_libinstall -C src liblua ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/
	install -m 0644 src/lua.h src/luaconf.h src/lualib.h src/lauxlib.h ${STAGING_INCDIR}/
	# the .so ones are broken
	rm ${STAGING_LIBDIR}/*.so*
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

