DESCRIPTION = "Sanitized set of 2.6 kernel headers for the C library's use."
SECTION = "devel"
LICENSE = "GPL"

RDEPENDS_${PN}-dev = ""
RRECOMMENDS_${PN}-dbg = "${PN}-dev (= ${DEBPV})"

do_install_append() {
	rm -rf ${D}${includedir}/scsi
}
