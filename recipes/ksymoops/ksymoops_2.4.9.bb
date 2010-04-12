SECTION = "console/utils"
DESCRIPTION = "Kernel oops and error message decoder."
LICENSE = "GPLv2"
DEPENDS = "binutils"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/ksymoops/v2.4/ksymoops-${PV}.tar.bz2 \
	   file://flags.patch;patch=1"
S = "${WORKDIR}/ksymoops-${PV}"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ksymoops ${D}${bindir}/ksymoops
	install -d ${D}${mandir}/man8
	install -m 0755 ksymoops.8 ${D}${mandir}/man8/ksymoops.8
}

SRC_URI[md5sum] = "231b6ea3afbc318c129ec770d10f8ec8"
SRC_URI[sha256sum] = "125fcecc9f650dc2ec82db3194d17c0af40b48900204fedb0c695b5fcc5a99e3"
