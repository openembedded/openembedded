DESCRIPTION = "Driver for HD Wireless Wi-Fi device"
HOMEPAGE = "http://www.hd-wireless.se"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r1"
RDEPENDS = "wireless-tools \
	 wpa-supplicant \
	 "

SRC_URI = "http://www.hd-wireless.se/images/stories/public_pdf/owl-linux-arm-${PV}.tar.gz \
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
