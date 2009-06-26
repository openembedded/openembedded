DESCRIPTION = "Linux driver for 802.11a/b/g universal NIC cards using Atheros chip sets"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"
PR ="r6"

WACKELF_SRC_URI = ""
WACKELF_SRC_URI_ixp4xx = " file://20-xscale-VFP-wackelf.patch;patch=1"
WACKELF_SRC_URI_compulab-pxa270 = " file://20-xscale-VFP-wackelf.patch;patch=1"

SRCNAME = "${PN}"
SRC_URI = "http://snapshots.madwifi-project.org/madwifi-trunk/${SRCNAME}-${PV}.tar.gz \
           file://10-xscale-be-elf-copts.patch;patch=1 \
           file://10-xscale-le-elf-copts.patch;patch=1 \
           file://10-sh4-le-elf-copts.patch;patch=1 \
	   file://powerpc-fix.patch;patch=1 \
           ${WACKELF_SRC_URI}"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit module-base

ARCH_dht-walnut="ppc"
ARCH_efika="powerpc"
ARCH_magicbox="ppc"
ARCH_mpc8313e-rdb="powerpc"
ARCH_mpc8315e-rdb="powerpc"
ARCH_sequoia="ppc"

EXTRA_OEMAKE = "KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX}"

EXTRA_OEMAKE_prepend_ixp4xxle = "TARGET=xscale-le-elf "
EXTRA_OEMAKE_prepend_ixp4xxbe = "TARGET=xscale-be-elf "

do_compile() {
	oe_runmake all
}

do_stage() {
	install -d ${STAGING_INCDIR}/${PN}/include
	install -d ${STAGING_INCDIR}/${PN}/net80211
	cp --dereference include/compat.h ${STAGING_INCDIR}/${PN}/include/
	cp --dereference net80211/*.h ${STAGING_INCDIR}/${PN}/net80211/
}

do_install() {
	install -d ${D}${sbindir}
	unset LDFLAGS
	oe_runmake DESTDIR=${D} BINDIR=${sbindir} install
}

pkg_postinst() {
if test "x$D" != "x"; then
       exit 1
else
	depmod -ae
fi
}

PACKAGES += "${PN}-modules ${PN}-tools"
FILES_${PN}-modules = "/lib/modules/"
FILES_${PN}-tools = "/usr/"

