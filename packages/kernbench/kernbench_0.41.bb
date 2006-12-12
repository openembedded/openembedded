DESCRIPTION = "cpu throughput benchmark"
HOMEPAGE = "http://kernbench.kolivas.org/"
LICENSE = "GPL"
RDEPENDS = "time"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/people/ck/apps/kernbench/kernbench-${PV}.tar.bz2"

inherit autotools

do_install() {
    install -d ${D}${bindir} ${D}${datadir}/doc/${PN}/
    install -m 0755 kernbench ${D}${bindir}
    install -m 0644 README ${D}${datadir}/doc/${PN}/
}
