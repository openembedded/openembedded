DESCRIPTION = "Driver for Ralink rt73 USB 802.11b/g WiFi sticks"
HOMEPAGE = "http://www.ralinktech.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL"

PR = "r3"

SRC_URI = "http://www.ralinktech.com.tw/data/drivers/2008_0506_RT73_Linux_STA_Drv1.1.0.1.tar.bz2 \
           file://make.patch;patch=1 \
           file://changeiface.patch;patch=1"
RDEPEND = "wireless-tools"

inherit module

FILES_${PN} += " /lib/firmware/rt73.bin"

S = "${WORKDIR}/2008_0506_RT73_Linux_STA_Drv1.1.0.1/Module/"
EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake 'MODPATH={D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net' \
                   'KERNEL_SOURCE=${STAGING_KERNEL_DIR}' \
                   'LINUX_SRC=${STAGING_KERNEL_DIR}' \
                   'KDIR=${STAGING_KERNEL_DIR}' \
                   'KERNDIR=${STAGING_KERNEL_DIR}' \
                   'KERNEL_VERSION=${KERNEL_VERSION}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
        install -m 0644 rt73${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
        install -d ${D}/lib/firmware
        install -m 0644 rt73.bin ${D}/lib/firmware/
}

