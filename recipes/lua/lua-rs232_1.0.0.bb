DESCRIPTION = "Lua bindings for librs232 - library for serial communications over RS-232 (serial port)"
HOMEPAGE = "http://github.com/ynezz/librs232"
LICENSE = "MIT"

PR = "r1"

DEPENDS += "lua5.1"
RDEPENDS_${PN} += "librs232"

SRC_URI = "git://github.com/ynezz/librs232.git;protocol=git"

SRCREV = "ecad1e03104bc9bf348e0c5e571660f270c86421"
S = "${WORKDIR}/git/"

inherit autotools

LUA_LIB_DIR = "${libdir}/lua/5.1"
LUA_LIB = "luars232.so"

PACKAGES = "${PN} ${PN}-dbg"
FILES_${PN} = "${LUA_LIB_DIR}/${LUA_LIB}"
FILES_${PN}-dbg = "${LUA_LIB_DIR}/.debug/${LUA_LIB}"

do_install_append() {
	install -d ${D}${LUA_LIB_DIR}/.debug
	install -m 0644 ${D}${libdir}/${LUA_LIB} ${D}${LUA_LIB_DIR}/${LUA_LIB}
	install -m 0644 ${D}${libdir}/${LUA_LIB} ${D}${LUA_LIB_DIR}/.debug/${LUA_LIB}
}
