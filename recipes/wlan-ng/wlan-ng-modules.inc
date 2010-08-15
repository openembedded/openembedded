# FIXME, consider using kernel staging directory instead of KERNEL_SOURCE which is
# located in the work directory. see module.bbclass

DESCRIPTION = "linux-wlan-ng (prism2.x, prism3, pcmcia, pci, usb) driver for 11Mbps wireless lan cards"
HOMEPAGE = "http://www.linux-wlan.org"
SECTION = "kernel/modules"
DEPENDS = "virtual/kernel"
LICENSE = "GPL"

SRC_URI = "file://no-compat.patch \
	file://msleep-vs-mdelay.patch \
	file://might-sleep.patch \
	file://only-the-modules.patch \
	file://scripts-makefile-hostcc.patch \
	file://pcmciasrc.patch \
	file://config.in"

inherit module

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "CC="${KERNEL_CC}" LD=${KERNEL_LD} PARALLEL_MAKE=''"

do_configure() {
	install -m 0655 ${WORKDIR}/config.in ${S}/config.in
	oe_runmake LINUX_SRC=${KERNEL_SOURCE} auto_config

#        if grep CONFIG_PCMCIA=[ym] ${STAGING_KERNEL_DIR}/kernel-config; then
#                echo "PRISM2_PCMCIA=y"          >> config.mk
#                echo "WLAN_KERN_PCMCIA=y"       >> config.mk
#        fi
        echo "TARGET_ROOT_ON_HOST=${D}/"         >> config.mk
        echo "TARGET_MODDIR=${D}/lib/modules/${KERNEL_VERSION}/wlan-ng" >> config.mk
	echo "CC=${KERNEL_CC}"			>> config.mk
	echo "LD=${KERNEL_LD}"			>> config.mk
	echo "LDFLAGS="				>> config.mk

	# Listen closely... sssshhh... can you hear the wlan-ng build system suck?
	rm -f ${KERNEL_SOURCE}/../config.mk
	rm -f ${KERNEL_SOURCE}/../../config.mk
	ln -sf ${S}/config.mk	${KERNEL_SOURCE}/..
	ln -sf ${S}/config.mk	${KERNEL_SOURCE}/../..
	install -m 0655 config.mk src/prism2/config.mk
	install -d src/prism2/driver/include
	ln -sf ${S}/src/include/wlan 		src/prism2/driver/include/wlan
	ln -sf ${S}/src/prism2/include/prism2	src/prism2/driver/include/prism2
}

do_compile() {
	oe_runmake -C src all
}

do_install() {
	oe_runmake install DESTDIR=${D}

        # Listen closely... sssshhh... can you hear the wlan-ng build system suck?
        rm -f ${KERNEL_SOURCE}/../config.mk
        rm -f ${KERNEL_SOURCE}/../../config.mk	

	# man page and configure scripts are shipped by wlan-ng-utils
	rm -rf ${D}/usr/local/man
	rm -rf ${D}/etc
}

PACKAGES =+ "${PN}-p80211 ${PN}-usb ${PN}-cs ${PN}-pci"
ALLOW_EMPTY_${PN} = "1"
FILES_${PN}-p80211 = "/lib/modules/${KERNEL_VERSION}/wlan-ng/p80211${KERNEL_OBJECT_SUFFIX}"
FILES_${PN}-usb = "/lib/modules/${KERNEL_VERSION}/wlan-ng/prism2_usb${KERNEL_OBJECT_SUFFIX}"
FILES_${PN}-cs  = "/lib/modules/${KERNEL_VERSION}/wlan-ng/prism2_cs${KERNEL_OBJECT_SUFFIX}"
FILES_${PN}-pci = "/lib/modules/${KERNEL_VERSION}/wlan-ng/prism2_pci${KERNEL_OBJECT_SUFFIX} \
			     /lib/modules/${KERNEL_VERSION}/wlan-ng/prism2_plx${KERNEL_OBJECT_SUFFIX}"

RDEPENDS_${PN}-p80211 = "wlan-ng-utils"
RDEPENDS_${PN}     = "${PN}-p80211"
RDEPENDS_${PN}-usb = "${PN}-p80211"
RDEPENDS_${PN}-cs  = "${PN}-p80211"
RDEPENDS_${PN}-pci = "${PN}-p80211"
