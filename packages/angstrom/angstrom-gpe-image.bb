#Angstrom GPE image
LICENSE = MIT
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
PR = "r1"

ANGSTROM_EXTRA_INSTALL ?= ""
XSERVER ?= "xserver-kdrive-fbdev"

export IMAGE_BASENAME = "gpe-image"

DEPENDS = "task-angstrom"
RDEPENDS = "\
    ${XSERVER} \
    angstrom-base-depends \
    angstrom-x11-base-depends \
    angsgrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-gpe-task-pim \
    ${ANGSTROM_EXTRA_INSTALL}"


export IPKG_INSTALL = "${RDEPENDS}"

#ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk
