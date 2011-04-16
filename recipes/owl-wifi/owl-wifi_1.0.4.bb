DESCRIPTION = "Driver for HD Wireless Wi-Fi device"
HOMEPAGE = "http://www.hd-wireless.se"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r2"
RDEPENDS = "wireless-tools \
	 wpa-supplicant \
	 "

SRC_URI = "http://www.hd-wireless.se/images/stories/public_pdf/owl-linux-arm-${PV}.tar.gz \
	file://0001-owl-wifi-include-linux-semaphore.h.patch;apply=yes \
	file://0002-owl-wifi-Add-include-file-for-kmalloc-kfree.patch;apply=yes \
	file://0003-owl-wifi-include-sched.h.patch;apply=yes \
	"

S = "${WORKDIR}/owl-linux-arm-${PV}"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake 'MODPATH=${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net' \
                   'KERNELDIR=${STAGING_KERNEL_DIR}' \
                   'KDIR=${STAGING_KERNEL_DIR}' \
                   'KERNEL_VERSION=${KERNEL_VERSION}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
        install -m 0644 ${S}/owl*${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
}

SRC_URI[md5sum] = "e8df44b8c766436fdd798fa5cd6d1a02"
SRC_URI[sha256sum] = "c2b47ecb6375e7a5904fefd6ec7b715ca4a6ac347fb68324fea7ade152244e6e"

