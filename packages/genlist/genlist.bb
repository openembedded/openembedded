SECTION = "utility"
DESCRIPTION = "IP Address List Generator"
MAINTAINER = "Bob Davies (tyggerbob@gmail.com)"

SRC_URI = "file://genlist.c \
	   file://Makefile"

DEFAULT_PREFERENCE="-1"


S = "${WORKDIR}"
LICENSE = "GPL"
do_compile() {
	oe_runmake all
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 genlist ${D}${bindir}/
}
