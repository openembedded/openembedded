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


SRC_URI[md5sum] = "23f58fe232254a65df6eb4736a81d524"
SRC_URI[sha256sum] = "2d91457906ee2ff1e26de82987019fe2efe22d9c3b6c7741b7ed8fffbae51411"
