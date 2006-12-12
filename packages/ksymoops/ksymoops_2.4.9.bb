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
