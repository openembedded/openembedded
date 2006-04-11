MAINTAINER = "Bob Davies  <tyggerbob@rogers.com>"
LICENSE = MIT
PR = "r6"

FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11"

export IMAGE_BASENAME = "sectest-gpe-image"

GPE_EXTRA_THEMES = "\
    gtk-theme-industrial \
    gtk-industrial-engine \
    matchbox-themes-extra-industrial"

GPE_EXTRA_INSTALL_none = ""
GPE_EXTRA_INSTALL_smallscreen = "${GPE_EXTRA_THEMES}"
GPE_EXTRA_INSTALL_bigscreen = "minimo gpe-task-games ${GPE_EXTRA_THEMES}"
#GPE_EXTRA_INSTALL_bigscreen = "firefox linphone"

GUI_MACHINE_CLASS ?= "none"
GPE_EXTRA_INSTALL += "${GPE_EXTRA_INSTALL_${GUI_MACHINE_CLASS}}"

XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "task-bootstrap task-gpe"
RDEPENDS = "${IPKG_INSTALL}"

export IPKG_INSTALL = "\
    task-bootstrap \
    gpe-task-base \
    gpe-task-pim \
    gpe-task-settings \
    gpe-task-sectest \
    ${XSERVER} \
    ${GPE_EXTRA_INSTALL}"

ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk

