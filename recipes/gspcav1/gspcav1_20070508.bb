DESCRIPTION = "USB Webcam driver for spca5xx chipset family supporting \
over 100 models of camera"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"

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

SRC_URI[md5sum] = "e18a21b80e1728c6b51b799d1e671f8c"
SRC_URI[sha256sum] = "1185165125b890ea9a4312440c32bae9214947596b0b3ec31febec0d3c18b008"
