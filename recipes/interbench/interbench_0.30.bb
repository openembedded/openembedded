DESCRIPTION = "Linux interactivity benchmark"
HOMEPAGE = "http://members.optusnet.com.au/ckolivas/interbench/"
LICENSE = "GPL"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/people/ck/apps/interbench/interbench-0.30.tar.bz2"

inherit autotools

do_install() {
    install -d ${D}${bindir} ${D}${datadir}/doc/${PN}/ ${D}${mandir}/man8/
    install -m 0755 interbench ${D}${bindir}
    install -m 0644 readme* ${D}${datadir}/doc/${PN}/
    install -m 0644 interbench.8 ${D}${mandir}/man8/
}
