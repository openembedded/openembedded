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


SRC_URI[md5sum] = "952af13db40a8aa723c859256c697a9c"
SRC_URI[sha256sum] = "91619748c4dba733c60eb8a40805c972f407b2463dc6de856ac40336d66bc16c"
