SECTION = "devel"
DESCRIPTION = "The Linux trace toolkit is a suite of tools designed to \
extract program execution details from the Linux operating system and  \
interpret them."
LICENSE = "GPL"

SRC_URI = "http://lttng.org/files/lttng/ltt-control-${PV}-01022010.tar.gz"

S = "${WORKDIR}/ltt-control-${PV}-01022010"

inherit autotools

export KERNELDIR="${STAGING_KERNEL_DIR}"

FILES_${PN} += "${datadir}/ltt-control/facilities/*"

SRC_URI[md5sum] = "5846298f930f27454fc8f3b6cc0b6002"
SRC_URI[sha256sum] = "f6ae22f65ffca55b456ab6dc46d601f82956503b53698c9565dc41ef499e3bb5"
