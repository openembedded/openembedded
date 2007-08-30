#Angstrom X11 image, with apps and kernel modules included
LICENSE = "MIT"
PR = "r0"

PREFERRED_PROVIDER_libgpewidget 	?= "libgpewidget"
PREFERRED_PROVIDER_tslib 		?= "tslib"
PREFERRED_PROVIDER_virtual/libsdl 	?= "libsdl-x11"
PREFERRED_PROVIDER_virtual/libxine 	?= "libxine-x11"
PREFERRED_PROVIDER_virtual/libx11       ?= "diet-x11"

ANGSTROM_EXTRA_INSTALL += " \
                           ${@base_contains("MACHINE_FEATURES", "phone", "openmoko-dialer2", "",d)} \
			  " 
XSERVER ?= "xserver-kdrive-fbdev"

export IMAGE_BASENAME = "x11-pimlico-image"

DEPENDS = "task-base"
RDEPENDS = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    kernel-modules \
    hal \
    angstrom-ohand-task-pim \
    ${ANGSTROM_EXTRA_INSTALL}"


export PACKAGE_INSTALL = "${RDEPENDS}"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
