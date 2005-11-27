SECTION = "network/misc"
DESCRIPTION = "IMCP query generator"
MAINTAINER = "Bob Davies (tyggerbob@gmail.com)"
SRC_URI = "file://icmpquery.c \
	   file://Makefile"
PV = "1.03"

DEFAULT_PREFERENCE="-1"


S = "${WORKDIR}"
LICENSE = "GPL"
do_compile() {
	oe_runmake icmpquery
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 icmpquery ${D}${bindir}/
}
