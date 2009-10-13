DESCRIPTION = "Ralink 3070"
LICENSE = "GPLv2"

inherit module

SRC_URI = "http://www.ralinktech.com.tw/data/drivers/2009_0525_RT3070_Linux_STA_v${PV}.tar.bz2 \
           file://makefile.patch;patch=1 \
		   file://config.patch;patch=1 \
"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

S = "${WORKDIR}/2009_0525_RT3070_Linux_STA_v${PV}"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	cp ${S}/os/linux/rt3070sta.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
