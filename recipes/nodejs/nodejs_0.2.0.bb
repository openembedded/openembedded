DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"

DEPENDS = "openssl"

SRC_URI = " \
  http://nodejs.org/dist/node-v${PV}.tar.gz \
  file://node-cross-cc.patch \
  file://libev-cross-cc.patch \
  file://node-dont-include-hosts-usr-include.patch \
"
SRC_URI[md5sum] = "99a6dacc44b3f9c6ec376ccb446dd0b8"
SRC_URI[sha256sum] = "3d3eff9287c9917af4044f3cef99ae5b17946710a71e83039de4fcb4b0a26631"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

do_configure () {
  ./configure --prefix=${prefix} --without-snapshot
}

do_compile () {
  make
}

do_install () {
  DESTDIR=${D} oe_runmake install
}

