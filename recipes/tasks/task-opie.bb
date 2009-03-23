DESCRIPTION = "Tasks for OPIE stuff"
SECTION = "opie/base"
LICENSE = "MIT"

PR = "r12"

inherit task

PROVIDES = "task-opie-everything"

PACKAGES = "task-opie-base \
            task-opie-base-applets task-opie-base-apps \
            task-opie-base-decorations task-opie-base-inputmethods \
            task-opie-base-pim task-opie-base-settings \
            task-opie-base-styles task-opie-bluetooth \
            task-opie-base-todayplugins \
            task-opie-extra-settings \
            task-opie-extra-styles \
            task-opie-irda \
           "

RDEPENDS_task-opie-everything := "${PACKAGES}"

PACKAGES += "task-opie-everything"

#
# Dependencies to get the launcher up and running
#
RDEPENDS_task-opie-base = "opie-init opie-alarm opie-qcop opie-qss opie-quicklauncher \
                           opie-taskbar opie-pics opie-sounds opie-freetype \
                           ttf-dejavu-sans ttf-dejavu-sans-mono"
# Recommend both landscape and portrait backgrounds
RRECOMMENDS_task-opie-base = "opie-taskbar-images-${MACHINE_DISPLAY_WIDTH_PIXELS}x${MACHINE_DISPLAY_HEIGHT_PIXELS} \
                              opie-taskbar-images-${MACHINE_DISPLAY_HEIGHT_PIXELS}x${MACHINE_DISPLAY_WIDTH_PIXELS}"

PACKAGE_ARCH_task-opie-base = "${MACHINE_ARCH}"

#
# things for reasonable bootstrap image
#
RDEPENDS_task-opie-base-applets = "opie-aboutapplet opie-clockapplet opie-suspendapplet \
                                   opie-homeapplet opie-rotateapplet \
		                   opie-brightnessapplet opie-volumeapplet \
                                   opie-screenshotapplet \
    ${@base_contains("COMBINED_FEATURES", "irda", "opie-irdaapplet", "",d)} \
    ${@base_contains("MACHINE_FEATURES", "apm", "opie-batteryapplet", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "pcmcia", "opie-cardapplet", "",d)} \
    ${@base_contains("MACHINE_FEATURES", "keyboard", "opie-vtapplet opie-logoutapplet", "",d)}"

PACKAGE_ARCH_task-opie-base-applets = "${MACHINE_ARCH}"

#
# clamshell models can benefit from the autorotate applet
#
RDEPENDS_task-opie-base-applets_append_c7x0   = " opie-autorotateapplet"
RDEPENDS_task-opie-base-applets_append_spitz  = " opie-autorotateapplet"
RDEPENDS_task-opie-base-applets_append_akita  = " opie-autorotateapplet"

RDEPENDS_task-opie-base-inputmethods = "opie-multikey opie-handwriting opie-handwriting-classicset"

RDEPENDS_task-opie-base-apps = "opie-console opie-clock opie-citytime opie-backup opie-sysinfo \
                       opie-advancedfm"

RDEPENDS_task-opie-base-settings = "opie-packagemanager opie-light-and-power opie-appearance \
                           opie-systemtime opie-networksettings opie-button-settings \
                           opie-icon-reload opie-launcher-settings opie-security \
                           opie-securityplugin-pin"

#
# That settings can be removed and device will be still usable
#
RDEPENDS_task-opie-extra-settings = "opie-language opie-doctab opie-mediummount \
    ${@base_contains("DISTRO_FEATURES", "wifi", "opie-networksettings-wlanplugin", "",d)} \
    ${@base_contains("DISTRO_FEATURES", "ppp", "opie-networksettings-pppplugin", "",d)} \
			    "

PACKAGE_ARCH_task-opie-extra-settings = "${MACHINE_ARCH}"

RDEPENDS_task-opie-base-decorations = "opie-deco-flat opie-deco-liquid opie-deco-polished"

RDEPENDS_task-opie-base-styles = "opie-style-flat opie-style-fresh opie-style-web opie-style-phase"

#
# Those styles are big and does not look good on QVGA screen
#
RDEPENDS_task-opie-extra-styles = "opie-style-liquid opie-style-metal"

RDEPENDS_task-opie-base-todayplugins = "opie-today-addressbookplugin opie-today-datebookplugin \
                               opie-today-todolistplugin"

RDEPENDS_task-opie-base-pim = "opie-addressbook opie-datebook opie-drawpad \
                      opie-search opie-textedit opie-today opie-todo \
                      task-opie-base-todayplugins \
                      opie-datebook-birthdayplugin"

RDEPENDS_task-opie-bluetooth = "bluez-utils obexftp obexpush libopieobex0 \
                       opie-bluepin opie-bluetoothmanager opie-bluetoothapplet"

RDEPENDS_task-opie-irda = "irda-utils libopieobex0 obexftp obexpush"
