SECTION = "kernel"
DESCRIPTION = "User Mode Linux Kernel"
LICENSE = "GPL"
UMLR = "2"
PR = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${PV}.tar.bz2;name=kernel \
           ${SOURCEFORGE_MIRROR}/user-mode-linux/uml-patch-${PV}-${UMLR}.bz2;patch=1;name=patch \
           file://defconfig \
           file://aio_abi.h"
S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = 'i.86.*-linux'
COMPATIBLE_MACHINE = "x86-uml"

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

SRC_URI[kernel.md5sum] = "88d7aefa03c92739cb70298a0b486e2c"
SRC_URI[kernel.sha256sum] = "dab39fb4431c1c6852b4197300b729c5d674906e71ebfada6fe9541fd452ec81"
SRC_URI[patch.md5sum] = "e2d02412e5ea7e65f665cf19bc5c267c"
SRC_URI[patch.sha256sum] = "5a557294b7d4aea69bb910c987c07af8889b9368927444437a65d47f6b3785c1"
