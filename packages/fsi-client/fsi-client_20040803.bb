DESCRIPTION = "ipaq h5400 fingerprint identification driver and client library for Linux"
SRC_URI = "http://heim.ifi.uio.no/~jorgenam/h5400/fsi-client-${PV}.tar.gz"
SECTION = "libs"
LICENSE = "GPL"

CFLAGS += "-std=c99"

S = "${WORKDIR}/client"

FILES_${PN} += "${libdir}/libfsiclient.so"

do_compile() {
	oe_runmake all examples
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install libfsiclient.so ${D}${libdir}
	install fsidumpraw fsidumppgm ${D}${bindir}
}

