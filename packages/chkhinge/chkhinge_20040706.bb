SECTION = "base"
SRC_URI = "${HANDHELDS_CVS};module=apps/chkhinge;date=${PV}"
LICENSE = "MIT"
S = "${WORKDIR}/chkhinge"
PR = "r1"

FILES_${PN} = "/bin"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${base_bindir}
	install -m 4755 chkhinge ${D}${base_bindir}/
}

