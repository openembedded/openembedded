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

