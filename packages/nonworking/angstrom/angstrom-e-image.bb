#Angstrom e image

PREFERRED_PROVIDER_virtual/evas   ?= "evas-x11"
PREFERRED_PROVIDER_virtual/ecore  ?= "ecore-x11"
PREFERRED_PROVIDER_virtual/imlib2 ?= "imlib2-x11"
PREFERRED_PROVIDER_virtual/libx11 ?= "libx11"

PREFERRED_PROVIDER_libgpewidget 	?= "libgpewidget"
PREFERRED_PROVIDER_tslib 		    ?= "tslib"
PREFERRED_PROVIDER_virtual/libsdl 	?= "libsdl-x11"
PREFERRED_PROVIDER_virtual/libxine 	?= "libxine-x11"

ANGSTROM_EXTRA_INSTALL ?= ""
XSERVER ?= "xserver-kdrive-fbdev"

export IMAGE_BASENAME = "e-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-e-base-depends \
    angstrom-e-depends \
    angstrom-gpe-task-settings \
    ${ANGSTROM_EXTRA_INSTALL}"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
