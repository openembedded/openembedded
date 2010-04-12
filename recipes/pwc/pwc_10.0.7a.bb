DESCRIPTION = "Philips USB Webcam driver for Linux that supports VGA resolution"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r0"

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


SRC_URI[md5sum] = "8f6f61f49e84690a955a059f39577935"
SRC_URI[sha256sum] = "3853eccb72c25bf122b26acb2b15bd7d43951e06d24c2674729d271cbf9c7771"
