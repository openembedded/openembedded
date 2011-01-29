DESCRIPTION = "Linux driver for 802.11a/b/g universal NIC cards using Atheros chip sets"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "kernel-${KERNEL_VERSION}"
DEPENDS = "virtual/kernel"
INC_PR = "r7"

WACKELF_SRC_URI = ""
WACKELF_SRC_URI_ixp4xx = " file://20-xscale-VFP-wackelf.patch"
WACKELF_SRC_URI_compulab-pxa270 = " file://20-xscale-VFP-wackelf.patch"

SRCNAME = "${PN}"
SRC_URI = "http://snapshots.madwifi-project.org/madwifi-trunk/${SRCNAME}-${PV}.tar.gz \
           file://10-xscale-be-elf-copts.patch \
           file://10-xscale-le-elf-copts.patch \
           file://10-sh4-le-elf-copts.patch \
	   file://powerpc-fix.patch \
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
	oe_runmake tools
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake modules
}

do_install() {
	oe_runmake DESTDIR=${D} BINDIR=${sbindir} MANDIR=${mandir} install-tools
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake DESTDIR=${D} BINDIR=${sbindir} MANDIR=${mandir} install-modules
	install -d ${D}${includedir}/${PN}/include
	install -m 644 include/compat.h ${D}${includedir}/${PN}/include
	install -d ${D}${includedir}/${PN}/net80211
	install -m 644 net80211/*.h ${D}${includedir}/${PN}/net80211
}

pkg_postinst() {
if test "x$D" != "x"; then
       exit 1
else
	depmod -ae
fi
}

PACKAGES =+ "${PN}-modules ${PN}-tools"
FILES_${PN}-modules = "/lib/modules/"
FILES_${PN}-tools = "${sbindir}/*"

