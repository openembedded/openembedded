DESCRIPTION = "A rootfs for User-Mode-Linux"

export IMAGE_BASENAME = "uml-image"

OPIE_LIBS = "qte qpf-bitstream-vera libqpe-opie libopie2"
OPIE_BASE = "opie-qcop opie-quicklauncher opie-taskbar"

DEPENDS = "${MACHINE_TASK_PROVIDER}"
export PACKAGE_INSTALL = "${DEPENDS}"

inherit image
LICENSE = "MIT"
