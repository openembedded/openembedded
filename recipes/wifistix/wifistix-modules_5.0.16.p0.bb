# FIXME, consider using kernel staging directory instead of KERNEL_SOURCE which is
# located in the work directory. see module.bbclass

DESCRIPTION = "Linux Driver for Marvel 88W8385 802.11b/g Wifi Module used in Gumstix daughtercards"
SECTION = "base"
PRIORITY = "optional"
HOMEPAGE = "http://www.gumstix.com"
LICENSE = "GPL"
RDEPENDS_${PN} = "kernel-${KERNEL_VERSION}"
DEPENDS = "virtual/kernel"
PR = "r1"

SRC_URI = "http://files.gumstix.com/cf8385-5.0.16.p0-26306.tbz \
			file://wifistix.conf \
			file://mcf25 \
			file://marvell-devicename.patch \
			file://marvell-devicetable.patch \
			file://marvell-gumstix.patch \
			file://sbi-no-inline.patch \
			file://2.6.17-new-pcmcia-layer.patch \
			file://bad-cast.patch \
			file://sk_buff.patch \
			file://struct-changes.patch \
			file://no-more-config-h.patch \
			file://realtime-kernel.patch \
			file://install-properly.patch \
			file://fix-essid-truncation.patch"

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


SRC_URI[md5sum] = "348588c3e6224fc3fcbd6bc5fe2ec2c4"
SRC_URI[sha256sum] = "08a527d6b68ab4dda7da05d69159518924ea557d71b2c65c16f66e7e6c374e8b"
