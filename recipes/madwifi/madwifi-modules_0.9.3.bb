DESCRIPTION = "Linux driver for 802.11a/b/g universal NIC cards using Atheros chip sets"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION}) wireless-tools (>=27)"
DEPENDS = "virtual/kernel"
CONFLICTS = "hostap-daemon (<0.4.8)"
SRCDATE = "20050803"
PV = "0.9.3"

SRC_URI = "${SOURCEFORGE_MIRROR}/madwifi/madwifi-${PV}.tar.bz2 \
	   file://madwifi-devname.patch;patch=1 \
	   file://madwifi-skbpanic.patch;patch=1"
S = "${WORKDIR}/madwifi-${PV}"

inherit module-base

# Hack Alert :D
ARCH_mipsel = "mips"
EXTRA_OEMAKE_mtx-1 = "TARGET=mips-le-elf KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX} \
COPTS='-G 0 -mno-abicalls -fno-pic -Wa,--trap -fno-strict-aliasing -fno-common -fomit-frame-pointer -mlong-calls -DATH_PCI'"
EXTRA_OEMAKE_mtx-2 = "TARGET=mips-le-elf KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX} \
COPTS='-G 0 -mno-abicalls -fno-pic -Wa,--trap -fno-strict-aliasing -fno-common -fomit-frame-pointer -mlong-calls -DATH_PCI'"

do_compile() {
	oe_runmake
	cd tools; oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
	install -d ${D}/${sbindir}
	cd tools; 
	oe_runmake DESTDIR=${D} BINDIR=${sbindir} install
	install -m 755 athchans athctrl athkey ${D}/${sbindir}
}

do_stage() {
	# hostapd and wpa_supplicant need these files
	install -d ${STAGING_INCDIR}/madwifi/net80211/ ${STAGING_INCDIR}/madwifi/include
	install -m 0644 net80211/*.h ${STAGING_INCDIR}/madwifi/net80211/
	install -m 0644 include/compat.h ${STAGING_INCDIR}/madwifi/include/
	cd ${STAGING_INCDIR}/madwifi/net80211/
	rm -f compat.h; ln -s ../include/compat.h .
}

pkg_postinst() {
if test "x$D" != "x"; then
       exit 1
else
	depmod -ae
fi
}

PACKAGES = "${PN}-dbg madwifi-tools ${PN}"
FILES_${PN} = "/lib/modules/"
FILES_madwifi-tools = "/usr/sbin/"

SRC_URI[md5sum] = "26c31e8e1528fd098e3aaa11c0d34d99"
SRC_URI[sha256sum] = "847596646417abbdce9cfd0e1dca2cced29c6a8b814d1bd28d0c7301e9e4e9d8"
