DESCRIPTION = "IP Address List Generator"
SECTION = "utils"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "file://genlist.c \
	   file://Makefile"

DEFAULT_PREFERENCE="-1"

S = "${WORKDIR}"

do_compile() {
	oe_runmake all
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 genlist ${D}${bindir}/
}
