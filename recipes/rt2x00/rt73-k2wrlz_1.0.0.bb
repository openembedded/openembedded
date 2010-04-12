DESCRIPTION = "Enhanced Driver for Ralink rt73 USB 802.11g WiFi sticks"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r2"

SRC_URI= "http://homepages.tu-darmstadt.de/~p_larbig/wlan/rt73-k2wrlz-1.0.0.tar.bz2"
inherit module
 
S = "${WORKDIR}/${PN}-${PV}/Module/"
 
EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"
 
do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
        install -m 0644 rt73${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

SRC_URI[md5sum] = "be1820ec548283ccaf5eea7094193351"
SRC_URI[sha256sum] = "6b9dfcfe509f3c659e2450610ad3bf0a9eef613481085b1b1bfed6647f21782d"
