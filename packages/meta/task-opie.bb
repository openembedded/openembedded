DESCRIPTION = "Tasks for OPIE stuff"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
SECTION = "opie/base"
ALLOW_EMPTY = 1
PACKAGE_ARCH = "all"
LICENSE = "MIT"

PR = "r1"

PACKAGES = "task-opie-applets task-opie-apps task-opie-base \
            task-opie-base-applets task-opie-base-apps \
            task-opie-base-decorations task-opie-base-inputmethods \
            task-opie-base-pim task-opie-base-settings \
            task-opie-base-styles task-opie-bluetooth \
            task-opie-base-todayplugins \
            task-opie-datebookplugins task-opie-decorations \
            task-opie-extra-apps task-opie-extra-settings \
            task-opie-extra-styles task-opie-extra-games \
            task-opie-games task-opie-inputmethods task-opie-irda \
            task-opie-multimedia task-opie-pim task-opie-settings \
            task-opie-styles task-opie-todayplugins task-opie-wlan"

#
# Dependencies to get the launcher up and running
#
RDEPENDS_task-opie-base = "opie-alarm opie-qcop opie-quicklauncher opie-taskbar \
                           opie-pics opie-sounds opie-freetype ttf-dejavu-sans \
			   ttf-dejavu-sans-mono-lite"

#
# things for reasonable bootstrap image
#
RDEPENDS_task-opie-base-applets = "opie-aboutapplet opie-clockapplet opie-suspendapplet \
                          opie-homeapplet opie-rotateapplet \
                          opie-irdaapplet opie-brightnessapplet opie-batteryapplet \
                          opie-pcmciaapplet opie-volumeapplet \
                          opie-screenshotapplet"

#
# keyboard models can benefit from the vt and logout applets
#
RDEPENDS_task-opie-base-applets_append_openzaurus = " opie-vtapplet opie-logoutapplet"
RDEPENDS_task-opie-base-applets_append_mnci       = " opie-vtapplet opie-logoutapplet"

#
# clamshell models can benefit from the autorotate applet
#
RDEPENDS_task-opie-base-applets_append_c7x0   = " opie-autorotateapplet"
RDEPENDS_task-opie-base-applets_append_spitz  = " opie-autorotateapplet"
RDEPENDS_task-opie-base-applets_append_akita  = " opie-autorotateapplet"
RDEPENDS_task-opie-base-applets_append_borzoi = " opie-autorotateapplet"

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
                            opie-networksettings-wlanplugin opie-networksettings-pppplugin"

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

#
# all OPIE stuff
#
RDEPENDS_task-opie-applets = "opie-aboutapplet opie-autorotateapplet opie-batteryapplet \
                     opie-bluetoothapplet opie-brightnessapplet opie-cardmon \
                     opie-clipboardapplet opie-clockapplet opie-homeapplet \
                     opie-irdaapplet opie-lockapplet opie-logoutapplet \
                     opie-mailapplet opie-memoryapplet opie-multikeyapplet \
                     opie-networkapplet opie-notesapplet opie-pcmciaapplet \
                     opie-pyquicklaunchapplet opie-restartapplet \
                     opie-restartapplet2 opie-rotateapplet \
                     opie-screenshotapplet opie-suspendapplet opie-vmemo \
                     opie-volumeapplet opie-vtapplet opie-zkbapplet \
                     "
RDEPENDS_task-opie-apps = "opie-advancedfm opie-bartender opie-calculator \
                  opie-checkbook opie-clock \
                  opie-console opie-dagger opie-embeddedkonsole \
                  opie-euroconv opie-eye opie-ftp opie-gutenbrowser \
                  opie-helpbrowser opie-irc opie-keypebble opie-odict \
                  opie-oxygen opie-rdesktop opie-reader opie-remote \
                  opie-sheet opie-tableviewer opie-tinykate \
                  opie-wellenreiter opie-write opie-zsafe"

RDEPENDS_task-opie-decorations = "opie-deco-flat opie-deco-liquid opie-deco-polished"

RDEPENDS_task-opie-games = "opie-backgammon opie-bounce opie-buzzword opie-fifteen \
                   opie-go opie-kbill opie-kcheckers opie-kpacman opie-mindbreaker \
                   opie-minesweep opie-oyatzee opie-parashoot opie-qasteroids \
                   opie-sfcave opie-snake opie-solitaire opie-tetrix opie-tictac \
                   opie-wordgame opie-zlines opie-zsame"

RDEPENDS_task-opie-inputmethods = "opie-dasher opie-dvorak opie-handwriting \
                          opie-handwriting-classicset opie-jumpx opie-keyboard \
                          opie-keyview opie-kjumpx opie-multikey opie-unikeyboard"

RDEPENDS_task-opie-multimedia = "opie-mediaplayer1 \
                        opie-mediaplayer1-libmadplugin \
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
                      opie-calibrate opie-citytime opie-confeditor opie-doctab \
                      opie-formatter opie-language opie-launcher-settings \
                      opie-light-and-power opie-mediummount opie-networksettings \
                      opie-packagemanager opie-security opie-sshkeys opie-sysinfo \
                      opie-systemtime opie-usermanager opie-icon-reload \
                      opie-vmemo-settings"

RDEPENDS_task-opie-styles = "opie-style-flat opie-style-fresh opie-style-liquid opie-style-metal \
                    opie-style-web opie-style-phase opie-theme"

RDEPENDS_task-opie-datebookplugins= "opie-datebook-birthdayplugin \
                            opie-datebook-chrisholidayplugin \
                            opie-datebook-nationalholidayplugin"

RDEPENDS_task-opie-todayplugins = "opie-today-addressbookplugin opie-today-datebookplugin \
                          opie-today-fortuneplugin opie-today-mailplugin \
                          opie-today-stocktickerplugin opie-today-todolistplugin \
                          opie-today-weatherplugin"

RDEPENDS_task-opie-pim = "task-opie-base-pim task-opie-todayplugins task-opie-datebookplugins \
                 opie-mail opie-pimconverter"

RDEPENDS_task-opie-bluetooth = "bluez-utils-nodbus obexftp obexpush libopieobex0 \
                       opie-bluepin opie-bluetoothmanager opie-bluetoothapplet"

RDEPENDS_task-opie-wlan = "wireless-tools opie-wellenreiter opie-networksettings-wlanplugin"

RDEPENDS_task-opie-irda = "irda-utils libopieobex0 obexftp obexpush"

#
# additional things for a >= 24mb distribution
#

RDEPENDS_task-opie-extra-apps = "opie-calculator opie-checkbook opie-mail opie-eye \
                        opie-rdesktop opie-wellenreiter opie-irc \
                        opie-mediaplayer2 \
                        konqueror-embedded qpdf2"

RDEPENDS_task-opie-extra-games = "opie-parashoot opie-mindbreaker opie-fifteen opie-tictac \
                         opie-tetrix"

