SECTION = "kernel"
DESCRIPTION = "User Mode Linux Kernel"
LICENSE = "GPL"
UMLR = "2"
PR = "1"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.4/linux-${PV}.tar.bz2 \
           ${SOURCEFORGE_MIRROR}/user-mode-linux/uml-patch-${PV}-${UMLR}.bz2;patch=1 \
           file://defconfig \
           file://aio_abi.h"
S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = 'i.86.*-linux'

export OS = "Linux"
ARCH = "um"
SUBARCH = "${TARGET_ARCH}"
KERNEL_IMAGETYPE = "linux"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig .config
	oe_runmake oldconfig
	install -d arch/um/include/linux/
	#install -m 0644 ${WORKDIR}/aio_abi.h arch/um/include/linux/
}

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake dep
	oe_runmake HAVE_AIO_ABI= HAVE_AIO_LIBC= STAGING_LIBDIR=${STAGING_LIBDIR} ${KERNEL_IMAGETYPE}
	oe_runmake modules
}

do_install() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" modules_install
        install -d ${D}/boot
        install -m 0755 linux ${D}/boot/linux-${PV}
        install -m 0644 System.map ${D}/boot/System.map-${PV}
        install -m 0644 .config ${D}/boot/config-${PV}
}
