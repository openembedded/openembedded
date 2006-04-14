DESCRIPTION = "Linux driver for 802.11a/b/g universal NIC cards using Atheros chip sets"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"
PV = "r1527-20060425"

SRC_URI = "http://snapshots.madwifi.org/madwifi-ng/madwifi-ng-${PV}.tar.gz \
	   file://10-xscale-be-elf-copts.patch;patch=1 \
	   file://10-xscale-le-elf-copts.patch;patch=1"

S = "${WORKDIR}/madwifi-ng-${PV}"

inherit module-base

EXTRA_OEMAKE = "LDFLAGS= KERNELPATH=${STAGING_KERNEL_DIR} KERNELRELEASE=${KERNEL_VERSION} TOOLPREFIX=${TARGET_PREFIX}"

EXTRA_OEMAKE_prepend_slugos = "TARGET=xscale-${ARCH_BYTE_SEX}-elf "

do_compile() {
	oe_runmake all
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

PACKAGES = "madwifi-ng-tools ${PN}"
FILES_${PN} = "/lib/modules/"
FILES_madwifi-ng-tools = "/usr/"
