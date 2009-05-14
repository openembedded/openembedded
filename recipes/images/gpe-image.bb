LICENSE = "MIT"

# Set some defaults

MACHINE_TASK_PROVIDER = "task-base-extended"
GUI_MACHINE_CLASS ?= "none"
XSERVER ?= "xserver-kdrive-fbdev"
GPE_EXTRA_THEMES = "gpe-theme-industrial"

# Select bootsplash 
SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-angstrom", "",d)}'

# Select some useful things depending on the device capabilities

GPE_EXTRA_INSTALL_none = ""
GPE_EXTRA_INSTALL_bigscreen = "task-gpe-games ${GPE_EXTRA_THEMES}"
GPE_EXTRA_INSTALL_smallscreen = "task-gpe-games ${GPE_EXTRA_THEMES}"

GPE_EXTRA_INSTALL += "${GPE_EXTRA_INSTALL_${GUI_MACHINE_CLASS}}"

#ship more stuff with devices with >16MB of flash
GPE_BIGFLASH_INSTALL := '${@base_conditional("ROOT_FLASH_SIZE", "16", "", "\
    task-gpe-connectivity \
    gpe-theme-clearlooks \
    figment \
",d)}'

GPE_EXTRA_INSTALL += "${GPE_BIGFLASH_INSTALL}"


DEPENDS = "${MACHINE_TASK_PROVIDER} \
	   ${SPLASH} \
	   task-gpe-base \
           task-gpe-apps \
           task-gpe-pim \
           task-gpe-settings \
           task-gpe-games \
           virtual/xserver"

IMAGE_INSTALL = "\
    ${MACHINE_TASK_PROVIDER} \
    task-gpe-base \
    task-gpe-pim \
    task-gpe-settings \
    task-gpe-apps \
    ${XSERVER} \
    ${SPLASH} \
    ${GPE_EXTRA_INSTALL}"

ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "demo", "set_image_autologin; ", "",d)}'

inherit image
