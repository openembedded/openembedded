DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"

DEPENDS = "openssl"

SRC_URI = " \
  http://nodejs.org/dist/node-v${PV}.tar.gz \
  file://libev-cross-cc_${PV}.patch \
"

SRC_URI[md5sum] = "9e9e791e125f6a601ebc663dc99c72a8"
SRC_URI[sha256sum] = "09b1100ca6828eedbe52418fbeb3352d71c0b1ff3344c44a5af3efb80c5b908c"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

do_configure () {
  sed -i -e 's:/usr/lib:${STAGING_LIBDIR}:g' wscript
  sed -i -e 's:/usr/local/lib:${STAGING_LIBDIR}:g' wscript
  ./configure --prefix=${prefix} --without-snapshot
}

do_compile () {
  make
}

do_install () {
  DESTDIR=${D} oe_runmake install
}

BBCLASSEXTEND = "native"
