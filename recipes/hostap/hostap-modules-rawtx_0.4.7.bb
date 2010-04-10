require hostap-modules.inc

DESCRIPTION = "A driver for wireless LAN cards based on Intersil's Prism2/2.5/3 chipset with rawtx patch included"
RDEPENDS_hostap-modules-cs-rawtx = "hostap-modules-rawtx"
RDEPENDS_hostap-modules-pci-rawtx = "hostap-modules-rawtx"

SRC_URI += "file://kernel_updates.patch;patch=1 \
	   file://hostap-driver-0.4.7.patch;patch=1;pnum=1 \
           file://hostap_cs.conf "
SRC_URI_append_mtx-1 = " file://mtx_compat.diff;patch=1;pnum=0 \
	file://mtx_hostap_deferred_irq.diff;patch=1;pnum=0"

S = "${WORKDIR}/hostap-driver-${PV}"

inherit module

PACKAGES = "{PN}-dbg hostap-modules-cs-rawtx hostap-modules-pci-rawtx hostap-modules-rawtx"
FILES_hostap-modules-cs-rawtx = "/lib/modules/${KERNEL_VERSION}/pcmcia/ /${sysconfdir}/pcmcia/"
FILES_hostap-modules-pci-rawtx = "/lib/modules/${KERNEL_VERSION}/net/hostap_pci${KERNEL_OBJECT_SUFFIX}"
FILES_hostap-modules-rawtx = "/lib/modules/"

SRC_URI[md5sum] = "ee495686cf27011b4e401963c2c7f62a"
SRC_URI[sha256sum] = "e9a3e035a1483b371269936c6fde46bfbae71dc38fa04685c1338ca8ffe900a5"
