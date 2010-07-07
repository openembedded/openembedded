DESCRIPTION = "Enhanced Driver for Ralink rt2570 USB 802.11g WiFi sticks"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan"
SECTION = "kernel/modules"
LICENSE = "GPL"

PR = "r0"

SRC_URI = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/${PN}-${PV}.tar.bz2"

inherit module

S = "${WORKDIR}/${PN}-${PV}/Module/"

do_compile_prepend_arm () {
  MAKE_TARGETS="arm"
}

do_compile() { 
  export KERNDIR=${STAGING_KERNEL_DIR} 
  module_do_compile
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
	install -m 0644 rt2570${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

SRC_URI[md5sum] = "21f6e873ad7ee34843dbcd1204f9eda3"
SRC_URI[sha256sum] = "5b2d382504d0aee14cf24f0eb3c483a79c712f8aa1ca027a7d4425891f1bb2ec"
