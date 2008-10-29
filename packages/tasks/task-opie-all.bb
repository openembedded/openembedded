DESCRIPTION = "Tasks for OPIE stuff"
SECTION = "opie/base"
LICENSE = "MIT"
PR = "r3"

inherit task

PACKAGES = "task-opie-applets task-opie-inputmethods task-opie-styles \
            task-opie-decorations task-opie-multimedia task-opie-wlan \
            task-opie-settings task-opie-pim task-opie-datebookplugins \
            task-opie-todayplugins"

#
# all OPIE stuff
#
RDEPENDS_task-opie-applets = "opie-aboutapplet opie-autorotateapplet opie-batteryapplet \
                     opie-bluetoothapplet opie-brightnessapplet \ 
                     opie-clipboardapplet opie-clockapplet opie-homeapplet \
                     opie-irdaapplet opie-lockapplet opie-logoutapplet \
                     opie-mailapplet opie-memoryapplet opie-multikeyapplet \
                     opie-networkapplet opie-notesapplet opie-cardapplet \
                     opie-pyquicklaunchapplet opie-restartapplet \
                     opie-restartapplet2 opie-rotateapplet \
                     opie-screenshotapplet opie-suspendapplet opie-vmemo \
                     opie-volumeapplet opie-vtapplet opie-zkbapplet \
                     "
RDEPENDS_task-opie-inputmethods = "opie-dvorak opie-handwriting \
                          opie-handwriting-classicset opie-jumpx opie-keyboard \
                          opie-keyview opie-kjumpx opie-multikey opie-unikeyboard"

RDEPENDS_task-opie-styles = "opie-style-flat opie-style-fresh opie-style-liquid opie-style-metal \
                    opie-style-web opie-style-phase opie-theme"

RDEPENDS_task-opie-decorations = "opie-deco-flat opie-deco-liquid opie-deco-polished"

RDEPENDS_task-opie-multimedia = "opie-mediaplayer1 \
                        ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'opie-mediaplayer1-libmadplugin', d)} \
                        opie-mediaplayer1-libmodplugin \
                        opie-mediaplayer1-libtremorplugin \
                        opie-mediaplayer1-libwavplugin \
                        opie-mediaplayer2 \
                        opie-mediaplayer2-skin-default \
                        opie-mediaplayer2-skin-default-landscape \
                        opie-mediaplayer2-skin-pod \
                        opie-mediaplayer2-skin-techno \
                        opie-powerchord opie-recorder opie-tonleiter"

RDEPENDS_task-opie-settings = "opie-appearance opie-aqpkg opie-backup opie-button-settings \
                      opie-citytime opie-confeditor opie-doctab \
                      opie-formatter opie-language opie-launcher-settings \
                      opie-light-and-power opie-mediummount opie-networksettings \
                      opie-packagemanager opie-security opie-sshkeys opie-sysinfo \
                      opie-systemtime opie-icon-reload opie-vmemo-settings"

RDEPENDS_task-opie-pim = "task-opie-base-pim task-opie-todayplugins task-opie-datebookplugins \
                 opie-mail opie-pimconverter"

RDEPENDS_task-opie-datebookplugins = "opie-datebook-birthdayplugin \
                            opie-datebook-chrisholidayplugin \
                            opie-datebook-nationalholidayplugin"

RDEPENDS_task-opie-todayplugins = "opie-today-addressbookplugin opie-today-datebookplugin \
                          opie-today-fortuneplugin opie-today-mailplugin \
                          opie-today-stocktickerplugin opie-today-todolistplugin \
                          opie-today-weatherplugin"

RDEPENDS_task-opie-wlan = "wireless-tools opie-wellenreiter opie-networksettings-wlanplugin"

