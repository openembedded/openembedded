DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"
DEPENDS = "openssl"
SRC_URI = " \
  http://nodejs.org/dist/node-v${PV}.tar.gz \
  file://libev-cross-cc.patch \
  file://node-cross-cc.patch \
"
SRC_URI[md5sum] = "c6051dd216817bf0f95bea80c42cf262"
SRC_URI[sha256sum] = "5bb7d084b2138ce43fcb34739ed894379c450a1dd569a1c710405bc39d2861c2"
S = "${WORKDIR}/node-v${PV}"
do_configure () {
  ./configure --without-snapshot
}
do_compile () {
  make
}
do_install () {
  #oe_runmake install # doesn't install to correct location

  # This works
  install -d ${D}${bindir}/
  install -m 0755 ${S}/build/default/node ${D}${bindir}/
  install -m 0755 ${S}/bin/node-waf ${D}${bindir}/
  install -m 0755 ${S}/bin/node-repl ${D}${bindir}/
}
FILES_${PN} = "${bindir}/node ${bindir}/node-repl ${bindir}/node-waf"
