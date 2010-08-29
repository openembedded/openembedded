SECTION = "console/utils"
DESCRIPTION = "Kernel oops and error message decoder."
LICENSE = "GPLv2"
DEPENDS = "binutils"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/ksymoops/v2.4/ksymoops-${PV}.tar.bz2 \
	   file://flags.patch"
S = "${WORKDIR}/ksymoops-${PV}"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ksymoops ${D}${bindir}/ksymoops
	install -d ${D}${mandir}/man8
	install -m 0755 ksymoops.8 ${D}${mandir}/man8/ksymoops.8
}

SRC_URI[md5sum] = "4a8249e182a5dbc75e566d162e9f3314"
SRC_URI[sha256sum] = "52d3546062681e91460013acba6150ece9139b7c2787c2f3213ad0770b72a6b4"
