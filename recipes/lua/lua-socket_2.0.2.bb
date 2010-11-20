DESCRIPTION = "LuaSocket is the most comprehensive networking support library for the Lua language."
LICENSE = "MIT"
HOMEPAGE = "http://luaforge.net/projects/luasocket"

RDEPENDS_${PN} += "lua5.1"

PR = "r0"
S = "${WORKDIR}/luasocket-${PV}"

SRC_URI = "http://luaforge.net/frs/download.php/2664/luasocket-${PV}.tar.gz \
           file://lua-socket_${PV}-make.patch"

LUA_LIB_DIR =  "${libdir}/lua/5.1"
LUA_SHARE_DIR = "${datadir}/lua/5.1"

FILES_${PN}-dbg = "${LUA_LIB_DIR}/mime/.debug/core.so \
                   ${LUA_LIB_DIR}/socket/.debug/core.so"

FILES_${PN} = "${LUA_LIB_DIR}/mime/core.so \
               ${LUA_LIB_DIR}/socket/core.so \
               ${LUA_SHARE_DIR}/*.lua \
               ${LUA_SHARE_DIR}/socket/*.lua"

EXTRA_OEMAKE = "MYFLAGS='${CFLAGS} ${LDFLAGS}'"

do_install() {
        oe_runmake install INSTALL_TOP_SHARE=${D}${LUA_SHARE_DIR} INSTALL_TOP_LIB=${D}${LUA_LIB_DIR}
        install -d ${D}/${docdir}/${PN}-${PV}
        install -m 0644 doc/*.html ${D}/${docdir}/${PN}-${PV}
}

SRC_URI[md5sum] = "41445b138deb7bcfe97bff957503da8e"
SRC_URI[sha256sum] = "4fd9c775cfd98841299851e29b30176caf289370fea1ff1e00bb67c2d6842ca6"
