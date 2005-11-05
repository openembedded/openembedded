SECTION = "unknown"
SRC_URI = "${HANDHELDS_CVS};module=apps/kbdd;date=${PV}"
DEFAULT_PREFERENCE="-1"


S = "${WORKDIR}/kbdd"
LICENSE = "GPL"
do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${docdir}/kbdd/
	install -m 0755 kbdd ${D}${bindir}/
	install -m 0644 README ${D}${docdir}/kbdd/
}
