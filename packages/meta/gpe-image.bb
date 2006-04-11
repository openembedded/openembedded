FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11"

PR = "r20"

export IMAGE_BASENAME = "gpe-image"

GPE_EXTRA_THEMES = "gpe-theme-industrial"

GPE_EXTRA_INSTALL_none = ""
GPE_EXTRA_INSTALL_bigscreen = "gpe-task-games ${GPE_EXTRA_THEMES}"
GPE_EXTRA_INSTALL_smallscreen = "gpe-task-games ${GPE_EXTRA_THEMES}"

GUI_MACHINE_CLASS ?= "none"
GPE_EXTRA_INSTALL += "${GPE_EXTRA_INSTALL_${GUI_MACHINE_CLASS}}"

#ship more stuff with devices with >16MB of flash
GPE_BIGFLASH_INSTALL := '${@base_conditional("ROOT_FLASH_SIZE", "16", "", "\
    gpe-task-connectivity \
    gpe-theme-clearlooks \
    figment \		
",d)}'

GPE_EXTRA_INSTALL += ${GPE_BIGFLASH_INSTALL}

XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "task-bootstrap task-gpe"
RDEPENDS = "${IPKG_INSTALL}"

export IPKG_INSTALL = "\
    task-bootstrap \
    gpe-task-base \
    gpe-task-pim \
    gpe-task-settings \
    gpe-task-apps \
    ${XSERVER} \
    ${GPE_EXTRA_INSTALL}"

#ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk
LICENSE = MIT
