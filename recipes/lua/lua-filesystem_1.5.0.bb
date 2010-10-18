DESCRIPTION = "LuaFileSystem is a Lua library with set of functions related to file systems operations."
LICENSE = "MIT"
HOMEPAGE = "http://keplerproject.org/luafilesystem"

PR = "r1"

DEPENDS += "lua5.1"

SRC_URI = "git://github.com/keplerproject/luafilesystem.git;protocol=git \
           file://makefile.patch "

SRCREV = "ae5a05deec8a3737bd6972213b5495108b6566cc"
S = "${WORKDIR}/git/"

LUA_LIB_DIR =  "${libdir}/lua/5.1"

PACKAGES = "${PN} ${PN}-dbg"
FILES_${PN}-dbg = "${LUA_LIB_DIR}/.debug/lfs.so"
FILES_${PN} = "${LUA_LIB_DIR}/lfs.so"

EXTRA_OEMAKE = "PREFIX='${D}/${prefix}' MYFLAGS='${CFLAGS} ${LDFLAGS}'"

do_install() {
        oe_runmake install PREFIX=${D}/${prefix}
        install -d ${D}/${docdir}/${PN}-${PV}
        install -m 0644 doc/us/* ${D}/${docdir}/${PN}-${PV}
}
