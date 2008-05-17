DESCRIPTION = "Tasks for small OPIE image"
SECTION = "opie/base"
LICENSE = "MIT"
PR = "r3"

inherit task

PACKAGES = "task-opie-16mb-base \
            task-opie-16mb-applets \
            task-opie-16mb-inputmethods \
            task-opie-16mb-settings \
            task-opie-16mb-apps \
            task-opie-16mb-pim \
           "

#
# Dependencies to get the launcher up and running
#
RDEPENDS_task-opie-16mb-base = "opie-init opie-alarm opie-qcop opie-qss opie-quicklauncher \
                           opie-taskbar opie-pics opie-sounds opie-freetype opie-taskbar-images-320x240 \
                           ttf-dejavu-sans ttf-dejavu-sans-mono"

#
# things for reasonable bootstrap image
#
RDEPENDS_task-opie-16mb-applets = "opie-aboutapplet opie-clockapplet opie-suspendapplet \
                                   opie-homeapplet opie-rotateapplet \
		                   opie-brightnessapplet opie-volumeapplet \
                                   opie-screenshotapplet \
    ${@base_contains("COMBINED_FEATURES", "irda", "opie-irdaapplet", "",d)} \
    ${@base_contains("MACHINE_FEATURES", "apm", "opie-batteryapplet", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "pcmcia", "opie-cardapplet", "",d)} \
    ${@base_contains("MACHINE_FEATURES", "keyboard", "opie-vtapplet opie-logoutapplet", "",d)}"

PACKAGE_ARCH_task-opie-16mb-applets = "${MACHINE_ARCH}"

#
# clamshell models can benefit from the autorotate applet
#
RDEPENDS_task-opie-16mb-applets_append_c7x0   = " opie-autorotateapplet"
RDEPENDS_task-opie-16mb-applets_append_spitz  = " opie-autorotateapplet"
RDEPENDS_task-opie-16mb-applets_append_akita  = " opie-autorotateapplet"

RDEPENDS_task-opie-16mb-inputmethods = "opie-multikey"

RDEPENDS_task-opie-16mb-settings = "opie-packagemanager opie-light-and-power opie-appearance \
                           opie-systemtime opie-networksettings opie-button-settings \
                           opie-icon-reload opie-launcher-settings opie-security \
                           opie-securityplugin-pin"

RDEPENDS_task-opie-16mb-apps = "opie-console opie-clock opie-backup opie-sysinfo \
                       opie-advancedfm"

RDEPENDS_task-opie-16mb-pim = "opie-addressbook opie-datebook opie-drawpad \
                      opie-search opie-textedit opie-today opie-todo"
