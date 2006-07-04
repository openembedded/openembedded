#Angstrom GPE image
LICENSE = MIT
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
PR = "r0"

export IMAGE_BASENAME = "gpe-image"

DEPENDS = "task-angstrom"
RDEPENDS = "\
    angstrom-base-depends \
    angstrom-x11-base-depends \
    angsgrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-gpe-task-pim \
    ${ANGSTROM_EXTRA_INSTALL}"


export IPKG_INSTALL = "${RDEPENDS}"

#ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk
