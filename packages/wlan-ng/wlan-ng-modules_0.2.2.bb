DESCRIPTION = "linux-wlan-ng (prism2.x, prism3, pcmcia, pci, usb) driver for 11Mbps wireless lan cards"
HOMEPAGE = "http://www.linux-wlan.org"
SECTION = "kernel/modules"
DEPENDS = "virtual/kernel"
RRECOMMENDS = "wlan-ng-utils"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
	file://no-compat.patch;patch=1 \
	file://msleep-vs-mdelay.patch;patch=1 \
	file://might-sleep.patch;patch=1 \
	file://only-the-modules.patch;patch=1 \
	file://module_param_array.patch;patch=1 \
	file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://config.in"
S = "${WORKDIR}/linux-wlan-ng-${PV}"

inherit module

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "CC="${KERNEL_CC}" LD=${KERNEL_LD} PARALLEL_MAKE=''"

do_configure() {
	install -m 0655 ${WORKDIR}/config.in ${S}/config.in
	oe_runmake LINUX_SRC=${KERNEL_SOURCE} auto_config

        if grep CONFIG_PCMCIA=[ym] ${STAGING_KERNEL_DIR}/kernel-config; then
                echo "PRISM2_PCMCIA=y"          >> config.mk
                echo "WLAN_KERN_PCMCIA=y"       >> config.mk
        fi
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
}

FILES_${PN} = "/lib"
