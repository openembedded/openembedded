DESCRIPTION = "Linux driver for 802.11a/b/g universal NIC cards using Atheros chip sets"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"
PV = "cvs${CVSDATE}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/madwifi;module=madwifi"

S = "${WORKDIR}/madwifi"

inherit module-base

# Hack Alert :D
ARCH_mipsel = "mips"
EXTRA_OEMAKE_mtx-1 = "TARGET=mips-le-elf KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX} \
COPTS='-G 0 -mno-abicalls -fno-pic -Wa,--trap -fno-strict-aliasing -fno-common -fomit-frame-pointer -mlong-calls -DATH_PCI'"

do_compile() {
	oe_runmake
	cd tools; oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
	install -d ${D}${sbindir}
	cd tools; 
	oe_runmake DESTDIR=${D} BINDIR=${sbindir} install
	install -m 755 athchans athctrl athkey ${D}${sbindir}
}

pkg_postinst() {
if test "x$D" != "x"; then
       exit 1
else
	depmod -ae
fi
}

PACKAGES = "madwifi-tools ${PN}"
FILES_${PN} = "/lib/modules/"
FILES_madwifi-tools = "/usr/"
