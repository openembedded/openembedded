DESCRIPTION = "Latest wireless drivers for kernels <= 2.6.26"
HOMEPAGE = "http://wireless.kernel.org/en/users/Download"
SECTION = "kernel/modules"
LICENSE = "GPL"
RDEPENDS = "wireless-tools"
DEPENDS = "virtual/kernel"
PR = "r0"
PV = "5.2.0+gitr${SRCPV}"

SRC_URI = " \
 git://git.kernel.org/pub/scm/linux/kernel/git/mcgrof/compat-wireless-2.6-old.git;protocol=git;branch=master \
 file://fix-makefile.patch \
"
S = "${WORKDIR}/git"

SRCREV = "9972065b4339af63d0d0eeb09b8aa224b8a3cada"

inherit module

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"
