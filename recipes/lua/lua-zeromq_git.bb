DESCRIPTION = "Lua bindings to zeromq2."
HOMEPAGE = "http://github.com/iamaleksey/lua-zmq"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://zmq.c;beginline=1;endline=21;md5=e1bbb5e9ca8c6fb7215f886d9d0d5cd3"

DEPENDS += "lua5.1 zeromq"

PR = "r0"
PV = "0.10+gitr${SRCREV}"
S = "${WORKDIR}/git/"
SRCREV = "5578612efe296faa36203c7b80507e38fa7714e0"

SRC_URI = "git://github.com/iamaleksey/lua-zmq.git;protocol=git \
           file://makefile.patch \
          "

LUA_LIB_DIR = "${libdir}/lua/5.1"

PACKAGES = "${PN} ${PN}-dbg"
FILES_${PN}-dbg = "${LUA_LIB_DIR}/.debug/zmq.so"
FILES_${PN} = "${LUA_LIB_DIR}/zmq.so"

EXTRA_OEMAKE = "MYFLAGS='${CFLAGS} ${LDFLAGS} -shared'"

do_install() {
        oe_runmake install PREFIX=${D}${LUA_LIB_DIR}
}
