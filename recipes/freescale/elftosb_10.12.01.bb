LICENSE = "FREESCALE"
PR = "r0"

SRC_URI = "http://foss.doredevelopment.dk/mirrors/imx/elftosb-${PV}.tar.gz \
           file://uclibc_and_eglibc_have_no_powf.patch"

SRC_URI[md5sum] = "e8005d606c1e0bb3507c82f6eceb3056"
SRC_URI[sha256sum] = "77bb6981620f7575b87d136d94c7daa88dd09195959cc75fc18b138369ecd42b"

BBCLASSEXTEND = "native"

do_install() {
        install -d ${D}${bindir}
        install ${S}/bld/linux/elftosb ${D}${bindir}/
        install ${S}/bld/linux/keygen ${D}${bindir}/
        install ${S}/bld/linux/sbtool ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"

