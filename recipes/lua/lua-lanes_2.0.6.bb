DESCRIPTION = "Lua Lanes is a Lua extension library providing the possibility to run multiple Lua states in parallel."
LICENSE = "MIT"
HOMEPAGE = "http://kotisivu.dnainternet.net/askok/bin/lanes/index.html"

DEPENDS += "lua5.1-native"
RDEPENDS_${PN} += "lua5.1"

PR = "r1"
S = "${WORKDIR}/lanes-${PV}"

SRC_URI = "http://luaforge.net/frs/download.php/4652/lanes-2.0.6.tgz \
           file://makefile.patch \
           file://0001-fix-LanesTimer-inifinite-thread-GC.patch \
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

SRC_URI[md5sum] = "1716bdf138fcc65b7069aaad864da677"
SRC_URI[sha256sum] = "7b07fa1c21749981ec0addcf8e9e85acfca91efe8d3f64982a6ac0bc6a615e70"
