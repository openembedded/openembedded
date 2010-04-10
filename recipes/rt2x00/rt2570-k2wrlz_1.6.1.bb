DESCRIPTION = "Enhanced Driver for Ralink rt2570 USB 802.11g WiFi sticks"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan"
SECTION = "kernel/modules"
LICENSE = "GPL"

PR = "r1"

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


SRC_URI[md5sum] = "87947cf1868ac37d4d756f3585dbf1e6"
SRC_URI[sha256sum] = "11d2c4a1b69a4b2b49811128a41c33f25c71e590b019ace392761598ca3d419f"
