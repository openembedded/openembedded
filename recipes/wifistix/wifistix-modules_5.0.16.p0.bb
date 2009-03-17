DESCRIPTION = "Linux Driver for Marvel 88W8385 802.11b/g Wifi Module used in Gumstix daughtercards"
SECTION = "base"
PRIORITY = "optional"
HOMEPAGE = "http://www.gumstix.com"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"
PR = "r0"

SRC_URI = "http://files.gumstix.com/cf8385-5.0.16.p0-26306.tbz \
			file://wifistix.conf \
			file://mcf25 \
			file://marvell-devicename.patch;patch=1 \
			file://marvell-devicetable.patch;patch=1 \
			file://marvell-gumstix.patch;patch=1 \
			file://sbi-no-inline.patch;patch=1 \
			file://2.6.17-new-pcmcia-layer.patch;patch=1 \
			file://bad-cast.patch;patch=1 \
			file://sk_buff.patch;patch=1 \
			file://struct-changes.patch;patch=1 \
			file://no-more-config-h.patch;patch=1 \
			file://realtime-kernel.patch;patch=1 \
			file://install-properly.patch;patch=1 \
			file://fix-essid-truncation.patch;patch=1"

S = "${WORKDIR}/src_cf8385"

inherit module-base

EXTRA_OEMAKE = 'CONFIG_GUMSTIX=y CONFIG_DEBUG=n KVER=2.6 \
                KERNELDIR="${KERNEL_SOURCE}" ARCH="${TARGET_ARCH}" \
                CC="${KERNEL_CC}" EXTRA_CFLAGS="${CFLAGS}" \
                INSTALL_MOD_PATH="${D}"'

do_compile() {	
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake
}

do_install() {	
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake install

	install -m 0755 -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 ${WORKDIR}/wifistix.conf ${D}${sysconfdir}/modprobe.d/wifistix.conf
 	install -m 0755 -d ${D}${sysconfdir}/modutils
 	install -m 0644 ${WORKDIR}/mcf25 ${D}${sysconfdir}/modutils/mcf25
}

FILES_${PN} = "${base_libdir}/modules/"
FILES_${PN} += "${sysconfdir}/modprobe.d/"
FILES_${PN} += "${sysconfdir}/modutils/"
CONFFILES_${PN} = "${sysconfdir}/modprobe.d/wifistix.conf"
CONFFILES_${PN} += "${sysconfdir}/modutils/mcf25"

