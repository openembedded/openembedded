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
