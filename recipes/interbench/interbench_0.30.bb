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

SRC_URI[md5sum] = "d197c4077ce15460a1c411f88f6a8053"
SRC_URI[sha256sum] = "a77d4a82573b07a9f6c6d256b399accea1f6cd433f3f1e6d038272cf0d320365"
