DESCRIPTION = "ipaq h5400 fingerprint identification driver and client library for Linux"
SRC_URI = "http://heim.ifi.uio.no/~jorgenam/h5400/fsi-client-${PV}.tar.gz"
SECTION = "libs"
LICENSE = "GPL"

CFLAGS += "-std=c99"

S = "${WORKDIR}/client"

FILES_${PN} += "${libdir}/libfsiclient.so"

do_compile() {
	oe_runmake all examples CC="${CC} ${LDFLAGS}"
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install libfsiclient.so ${D}${libdir}
	install fsidumpraw fsidumppgm ${D}${bindir}
}

SRC_URI[md5sum] = "99adcf3275943c109d27a781addf7d63"
SRC_URI[sha256sum] = "b0474b223a130e9412bb88f464138f40921e84f63b6024bf2ce5b32bd78d4bd8"
