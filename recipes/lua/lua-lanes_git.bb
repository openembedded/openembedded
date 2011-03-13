DESCRIPTION = "Lua Lanes is a Lua extension library providing the possibility to run multiple Lua states in parallel."
HOMEPAGE = "https://github.com/LuaLanes/lanes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=8cd4045dac80d5036b8a09fed113236e"

DEPENDS += "lua5.1-native"
RDEPENDS_${PN} += "lua5.1"

PR = "r0"
PV = "2.1.0+gitr${SRCREV}"

S = "${WORKDIR}/git/"
SRCREV = "507e02b20f4ce2c57c18992fe68430b0ffb3eee9"

SRC_URI = "git://github.com/LuaLanes/lanes.git;protocol=git \
           file://makefile.patch \
          "

UCLIBC_PATCHES = "file://uclibc.patch"
SRC_URI_append_libc-uclibc = "${UCLIBC_PATCHES}"

LUA_LIB_DIR =  "${libdir}/lua/5.1"
LUA_SHARE_DIR = "${datadir}/lua/5.1"

PACKAGES = "${PN} ${PN}-dbg"
FILES_${PN} = "${LUA_LIB_DIR}/lua51-lanes.so ${LUA_SHARE_DIR}/lanes.lua"
FILES_${PN}-dbg = "${LUA_LIB_DIR}/.debug/lua51-lanes.so"

EXTRA_OEMAKE = "MYFLAGS='${CFLAGS} ${LDFLAGS}'"

do_install() {
	oe_runmake install DESTDIR='${D}/usr'
}
