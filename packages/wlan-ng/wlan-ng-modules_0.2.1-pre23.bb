DESCRIPTION = "linux-wlan-ng (prism2.x, prism3, pcmcia, pci, usb) driver for 11Mbps wireless lan cards"
HOMEPAGE = "http://www.linux-wlan.org"
SECTION = "kernel/modules"
DEPENDS = "virtual/kernel"
RRECOMMENDS = "wlan-ng-utils"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
	file://no-compat.patch;patch=1 \
	file://Ambit_usb.patch;patch=1 \
	file://scripts-makefile-hostcc.diff;patch=1;pnum=0 \
	file://pass-kernel-cross.patch;patch=1;pnum=0 \
	file://OZ-Configure.patch;patch=1 \
	file://wlan-ng.modutils \
	file://wlan.agent \
	file://config.in \
	file://usbctl \
	file://resume \
	file://pre-up \
	file://post-down"
S = "${WORKDIR}/linux-wlan-ng-0.2.1pre23"

inherit module

MAKE_TARGETS = "all"

do_configure() {
	cp ${WORKDIR}/config.in ${S}
	if grep CONFIG_PCMCIA=[ym] ${STAGING_KERNEL_DIR}/kernel-config; then
		export PRISM2_PCMCIA=y
		export WLAN_KERN_PCMCIA=y
	fi
	export PRISM2_PCI=y
	export PRISM2_PLX=n
	export PRISM2_USB=y
	export TARGET_ROOT_ON_HOST=${D}
	export RC_DIR=${sysconfdir}
	oe_runmake LINUX_SRC=${KERNEL_SOURCE} auto_config
}

# override module_do_install in module.oeclass - dont want to set CC and
# LD unless actually compiling the kernel modules - there are other user
# level programs to be compiled. Note we need to use same compiler
# that was used to build the kernel
do_compile() {
       unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
       oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
                  KERNEL_SRC=${STAGING_KERNEL_DIR}    \
                  KERNEL_VERSION=${KERNEL_VERSION}    \
                  KERNEL_CC="${KERNEL_CC}" KERNEL_LD="${KERNEL_LD}" \
                  ${MAKE_TARGETS}
}

do_install() {
	oe_runmake install DESTDIR=${D} TARGET_MODDIR=
	echo "YYYYYYYYYYYYYYYYY"
	mkdir -p ${D}${sysconfdir}/modutils/
	mkdir -p ${D}${sysconfdir}/hotplug/
	mkdir -p ${D}${base_sbindir}/
	install -m 0644 ${WORKDIR}/wlan-ng.modutils ${D}${sysconfdir}/modutils/wlan-ng.conf
	install -m 0755 ${WORKDIR}/wlan.agent ${D}${sysconfdir}/hotplug/wlan.agent
	install -d ${D}${sysconfdir}/network/if-pre-up.d
	install -m 0755 ${WORKDIR}/pre-up ${D}${sysconfdir}/network/if-pre-up.d/wlan-ng
	install -d ${D}${sysconfdir}/network/if-post-down.d
	install -m 0755 ${WORKDIR}/post-down ${D}${sysconfdir}/network/if-post-down.d/wlan-ng
	install -d ${D}${sysconfdir}/apm/resume.d
	install -m 0755 ${WORKDIR}/resume ${D}${sysconfdir}/apm/resume.d/wlan-ng
	install -m 0755 ${WORKDIR}/usbctl ${D}${base_sbindir}/usbctl
	install -d ${D}${mandir}
	mv ${D}/usr/local/man/* ${D}${mandir}
	rm -r ${D}/usr/local/man
	rm -rf ${D}/${sysconfdir}/init.d
}

PACKAGES_prepend = "wlan-ng-utils "
FILES_wlan-ng-utils = "${sysconfdir} /sbin"
FILES_${PN} = "/lib"
