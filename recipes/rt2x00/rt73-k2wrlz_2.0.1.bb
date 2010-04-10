DESCRIPTION = "Enhanced Driver for Ralink rt73 USB 802.11g WiFi sticks"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r2" 

SRC_URI="http://homepages.tu-darmstadt.de/~p_larbig/wlan/${PN}-${PV}.tar.bz2"

inherit module
 
S = "${WORKDIR}/${PN}-${PV}/Module/"
 
EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"
 
do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
        install -m 0644 rt73${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}


SRC_URI[md5sum] = "121e2ed57d01e04f82e942c502b1ca75"
SRC_URI[sha256sum] = "e04718f3989bc567bf185cacfb27e324218cce5f5c87fca65328e49a3b56e603"
