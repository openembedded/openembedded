SECTION = "network/misc"
DESCRIPTION = "DCE Service enumerator for MS Windows systems"
MAINTAINER = "Bob Davies (tyggerbob@gmail.com)"
PV = "1.2"

SRC_URI = "http://packetstormsecurity.org/UNIX/scanners/dcetest-2.0.tar.gz"

DEFAULT_PREFERENCE="-1"


S = "${WORKDIR}/dcetest"
LICENSE = "GPL"
do_compile() {
	oe_runmake dcetest
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/dcetest ${D}${bindir}
}
