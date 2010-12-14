LICENSE = "GPLv2"

PV = "1.00"
PR = "${MACHINE_KERNEL_PR}"
PR_append = "-24.11a+gitr${SRCREV}"

# 24.11 tag
SRCREV = "d74be6020e970228f6bd25112fde12ecb4322f65"
SRC_URI = "git://git.omapzoom.org/platform/hardware/ti/tiler.git;protocol=git"

inherit autotools

export ARCH = "${TARGET_ARCH}"
export CROSS_COMPILE = "${TARGET_PREFIX}"

EXTRA_OECONF = "--enable-tilermgr"

S = "${WORKDIR}/git/memmgr"

do_configure_prepend() {
	sed -i -e 's:-Werror::g' configure.ac
}
