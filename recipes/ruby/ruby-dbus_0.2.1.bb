DESCRIPTION = "${PN} bindings"
SECTION = "devel/ruby"
LICENSE = "LGPL"
RDEPENDS = "dbus ruby"

SRC_URI = "http://trac.luon.net/data/${PN}/releases/${PN}-0.2.1.tar.gz"

RUBY_DIR = "/usr/lib/ruby/1.8"

S = "${WORKDIR}/${PN}-${PV}"

FILES_${PN} += "${RUBY_DIR}"

do_install() {
	install -d ${D}${RUBY_DIR}
	cp -r lib/* ${D}${RUBY_DIR}
}


SRC_URI[md5sum] = "1f6398d8bbafa272c0b43878fec43276"
SRC_URI[sha256sum] = "cfcadc4ae860f2de3d6aa1a1230a410b1dedf783148a27a20205bb3b54e3c3ac"
