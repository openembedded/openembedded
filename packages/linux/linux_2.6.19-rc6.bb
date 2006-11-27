DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"
PV = "2.6.18+2.6.19-rc6"
PR = "r1"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/patch-2.6.19-rc1.bz2;patch=1 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/incr/patch-2.6.19-rc1-rc2.bz2;patch=1 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/incr/patch-2.6.19-rc2-rc3.bz2;patch=1 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/incr/patch-2.6.19-rc3-rc4.bz2;patch=1 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/incr/patch-2.6.19-rc4-rc5.bz2;patch=1 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/incr/patch-2.6.19-rc5-rc6.bz2;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.18"

inherit kernel

KERNEL_IMAGETYPE = "bzImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

KERNEL_RELEASE = "2.6.19-rc6"
