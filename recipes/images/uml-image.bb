DESCRIPTION = "A rootfs for User-Mode-Linux"

OPIE_LIBS = "qte qpf-bitstream-vera libqpe-opie libopie2"
OPIE_BASE = "opie-qcop opie-quicklauncher opie-taskbar"

DEPENDS = "${MACHINE_TASK_PROVIDER}"
IMAGE_INSTALL = "${DEPENDS}"

inherit image

