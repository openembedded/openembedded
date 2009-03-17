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

DEPENDS = "${MACHINE_TASK_PROVIDER} task-gpe"

IMAGE_INSTALL = "\
    ${MACHINE_TASK_PROVIDER} \
    gpe-task-base \
    gpe-task-pim \
    gpe-task-settings \
    gpe-task-sectest \
    ${XSERVER} \
    ${GPE_EXTRA_INSTALL}"

ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image

