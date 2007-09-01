GPE_EXTRA_THEMES = ""

GPE_EXTRA_INSTALL_none = ""
GPE_EXTRA_INSTALL_x86 = "grub"
GPE_EXTRA_INSTALL_bigscreen = "${GPE_EXTRA_THEMES}"
GPE_EXTRA_INSTALL_smallscreen = "${GPE_EXTRA_THEMES}"

GUI_MACHINE_CLASS ?= "none"
GPE_EXTRA_INSTALL += "${GPE_EXTRA_INSTALL_${GUI_MACHINE_CLASS}}"

#ship more stuff with devices with >16MB of flash
GPE_BIGFLASH_INSTALL := '${@base_conditional("ROOT_FLASH_SIZE", "16", "", "\
",d)}'

GPE_EXTRA_INSTALL += "${GPE_BIGFLASH_INSTALL}"

XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "${MACHINE_TASK_PROVIDER} task-gpephone virtual/xserver"

IMAGE_INSTALL = "\
    ${MACHINE_TASK_PROVIDER} \
    gpephone-task-base \
    gpephone-task-pim \
    gpephone-task-settings \
    gpephone-task-development \
    gpephone-task-apps \
    gpephone-task-connectivity \
    ${XSERVER} \
    ${GPE_EXTRA_INSTALL}"


inherit image

ROOTFS_POSTPROCESS_COMMAND += "set_image_autologin; "

LICENSE = "MIT"
