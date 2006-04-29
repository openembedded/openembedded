DESCRIPTION = "Linux driver for 802.11a/b/g universal NIC cards using Atheros chip sets"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"
PR="r0"

SRC_URI = "http://snapshots.madwifi.org/${PN}/${PN}-${PV}.tar.gz \
	   file://10-xscale-be-elf-copts.patch;patch=1 \
	   file://10-xscale-le-elf-copts.patch;patch=1"

S = "${WORKDIR}/${PN}-${PV}"

inherit module-base

EXTRA_OEMAKE = "LDFLAGS= KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX}"

EXTRA_OEMAKE_prepend_slugos = "TARGET=xscale-${ARCH_BYTE_SEX}-elf "

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
	oe_runmake DESTDIR=${D} BINDIR=${sbindir} install
}

pkg_postinst() {
if test "x$D" != "x"; then
       exit 1
else
	depmod -ae
fi
}

PACKAGES = "${PN}-modules ${PN}-tools"
FILES_${PN}-modules = "/lib/modules/"
FILES_${PN}-tools = "/usr/"
