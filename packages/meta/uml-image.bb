DESCRIPTION = "A rootfs for User-Mode-Linux"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

export IMAGE_BASENAME = "uml-image"

OPIE_LIBS = "qte qpf-bitstream-vera libqpe-opie libopie2"
OPIE_BASE = "opie-qcop opie-quicklauncher opie-taskbar"

DEPENDS = "task-bootstrap"
export IPKG_INSTALL = "${DEPENDS}"

inherit image_ipk
LICENSE = MIT
