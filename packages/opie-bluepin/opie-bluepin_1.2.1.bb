include ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opietooth/blue-pin \
	   file://bluepin"

FILES_${PN} += " /bin/bluepin"

do_install() {
	install -d ${D}/bin
	install -m 0755 ${WORKDIR}/bluepin ${D}/bin
}
