#Angstrom X11 image
LICENSE = "MIT"
PR = "r5"

PREFERRED_PROVIDER_libgpewidget 	?= "libgpewidget"
PREFERRED_PROVIDER_tslib 		?= "tslib"
PREFERRED_PROVIDER_virtual/libsdl 	?= "libsdl-x11"
PREFERRED_PROVIDER_virtual/libxine 	?= "libxine-x11"
PREFERRED_PROVIDER_virtual/libx11       ?= "diet-x11"

ANGSTROM_EXTRA_INSTALL ?= ""
XSERVER ?= "xserver-kdrive-fbdev"

export IMAGE_BASENAME = "x11-image"

DEPENDS = "task-base"
RDEPENDS = "\
    ${XSERVER} \
    task-base-core-default \
    task-base \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    ${ANGSTROM_EXTRA_INSTALL}"


export PACKAGE_INSTALL = "${RDEPENDS}"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
