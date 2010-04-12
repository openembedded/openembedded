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

SRC_URI[md5sum] = "50dda4c865dba5c341422e2d848fb6be"
SRC_URI[sha256sum] = "6d5de792b0a3b119da3b584eb64076ed192d050516f7d44a36f95ecd8cf32362"
