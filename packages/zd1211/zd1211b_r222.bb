DESCRIPTION = "Driver for zd1211b family of wireless USB Dongles"
HOMEPAGE = "http://zd1211.ath.cx/"
SECTION = "kernel/modules"
PRIORITY = "optional"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
LICENSE = "GPL"
RDEPENDS = "wireless-tools"
PR = "r0"

SRC_URI = "http://www.reactivated.net/software/zd1211-vendor/releases/ZD1211LnxDrv_2_22_0_0.tar.gz \
           file://ZD1211LnxDrv_2_22_0_0.patch;patch=1 \
           file://zdiface.patch;patch=1"
           
S = "${WORKDIR}/ZD1211LnxDrv_2_22_0_0"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake 'MODPATH={D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net' \
                   'KERNEL_SOURCE=${STAGING_KERNEL_DIR}' \
                   'KDIR=${STAGING_KERNEL_DIR}' \
                   'KERNEL_VERSION=${KERNEL_VERSION}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
        install -m 0644 ${S}/zd1211*${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
}
