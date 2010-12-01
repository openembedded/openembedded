DESCRIPTION = "This package contains a set of programs for loading, inserting, and \
removing kernel modules for Linux (versions 2.5.48 and above). It serves \
the same function that the modutils package serves for Linux 2.4."
LICENSE = "GPLv2"
SECTION = "base"
PR = "r6"

PACKAGES =+ "${PN}-insmod-static ${PN}-depmod"
RDEPENDS_${PN} += "${PN}-depmod"

FILES_${PN}-depmod = "${sbindir}/depmod.26"
FILES_${PN}-insmod-static = "${sbindir}/insmod.static"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/module-init-tools/module-init-tools-${PV}.tar.bz2 \
	   file://ignore_arch_directory;apply=yes \
	   file://modutils_extension;apply=yes \
	   file://no_man_rebuild;apply=yes \
	   file://manpagesopt;apply=yes \
           file://module-init-tools-remove-index.patch "
S = "${WORKDIR}/module-init-tools-${PV}"

EXTRA_OECONF = "--disable-manpages"

inherit autotools
