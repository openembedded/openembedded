DESCRIPTION = "Linux Userland File Systems"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/lufs/lufs-${PV}.tar.gz"
S = "${WORKDIR}/lufs-${PV}"

inherit autotools module

KERNEL_SOURCE = "${STAGING_KERNEL_DIR}"
KERNEL_PATH = "${STAGING_KERNEL_DIR}"

EXTRA_OECONF = " --with-kernel=${KERNEL_VERSION} --with-kheaders=${STAGING_KERNEL_DIR}/include"

