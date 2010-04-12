DESCRIPTION = "USB Webcam driver for spca5xx chipset family supporting \
over 100 models of camera"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"

PR = "r2"

RRECOMMENDS = "kernel-module-videodev kernel-module-v4l1-compat kernel-module-v4l2-common"

SRC_URI = "http://mxhaard.free.fr/spca50x/Download/oldrelease/${PN}-${PV}.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://MS.patch;patch=1"

S = "${WORKDIR}/${PN}-${PV}"

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

SRC_URI[md5sum] = "1e3fa004490a07b7b76de03d70b3e8ea"
SRC_URI[sha256sum] = "f05d6793b943b7d1115e2b4b047ec1131c07c9ef0fd890d1616e5be0edd4a555"
