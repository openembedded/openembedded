DESCRIPTION = "USB Webcam driver for spca5xx chipset family supporting \
over 100 models of camera"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"

SRC_URI = "http://mxhaard.free.fr/spca50x/Download/gspcav1-${PV}.tar.gz \
           file://Makefile-fix-cc-quoting.diff;patch=1 \
          "

S = "${WORKDIR}/gspcav1-${PV}"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake 'KERNELDIR=${STAGING_KERNEL_DIR}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
}

SRC_URI[md5sum] = "14853ba1f4edc1e685039fca56e5ebf2"
SRC_URI[sha256sum] = "2151063706709bd79b40d892d1d0f21c9b02e3e1260fa6bf88bdd0ac252fbb35"
