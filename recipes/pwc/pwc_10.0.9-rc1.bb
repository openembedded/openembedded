DESCRIPTION = "Philips USB Webcam driver for Linux that supports VGA resolution"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.saillard.org/linux/pwc/files/pwc-${PV}.tar.bz2 \
	   file://Makefile"

S = "${WORKDIR}/pwc-${PV}"

inherit module

do_compile_prepend() {
	cp -f ${WORKDIR}/Makefile ${S}/
}

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake 'KDIR=${STAGING_KERNEL_DIR}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
}

SRC_URI[md5sum] = "d12d62f4f80589802dc10f2a4ede58c7"
SRC_URI[sha256sum] = "49b7021dae3e927a058a10e9bac737a28d0e4f35fd0b2c6a420cc26e6f8c55e6"
