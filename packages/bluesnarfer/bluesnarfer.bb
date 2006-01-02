SECTION = "net/misc"
DESCRIPTION = "Bluetooth cellphone information gatherer"
MAINTAINER = "Bob Davies (tyggerbob@gmail.com)"
PV = "0.1"
SRC_URI = "http://www.remote-exploit.org/images/a/a0/Bluesnarfer.tar.gz"

DEFAULT_PREFERENCE="-1"


CFLAGS_prepend = "-I${STAGING_INCDIR}/bluetooth "

LDFLAGS_prepend = "-lbluetooth -L${STAGING_LIBDIR} "

S = "${WORKDIR}/bluesnarfer"
LICENSE = "GPL"
do_compile() {
	oe_runmake bluesnarfer
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/bluesnarfer ${D}${bindir}
}

