#
# A collection of dependencies for images including Opie or parts of it.
#

#
# Dependencies to get the launcher up and running
#

OPIE_LIBS_DEPENDS  = "qte libopie2 opie-ttf-support ttf-dejavu"
OPIE_LIBS_RDEPENDS = "opie-ttf-support ttf-dejavu-sans ttf-dejavu-sans-mono"
OPIE_BASE = "opie-qcop opie-qss opie-quicklauncher opie-taskbar opie-pics opie-sounds"

#
# Things for reasonable bootstrap image
#

OPIE_BASE_APPLETS = "opie-aboutapplet opie-clockapplet      opie-suspendapplet	\
                     opie-homeapplet  opie-multikeyapplet   opie-rotateapplet 	\
                     opie-irdaapplet  opie-brightnessapplet opie-batteryapplet  \
                     opie-pcmciaapplet "

OPIE_BASE_INPUTMETHODS = "opie-multikey opie-handwriting opie-pickboard"

OPIE_BASE_APPS = "opie-packagemanager opie-keytabs opie-console opie-clock \
                  opie-citytime opie-backup"

OPIE_BASE_SETTINGS = "opie-light-and-power opie-appearance opie-systemtime \
                      opie-sysinfo opie-networksettings opie-button-settings \
                      opie-icon-reload"

OPIE_BASE_DECOS = "opie-deco-flat opie-deco-liquid opie-deco-polished"

OPIE_BASE_STYLES = "opie-style-flat opie-style-liquid opie-style-fresh \
                    opie-style-metal opie-style-web opie-style-phase"

OPIE_BASE_DEPENDS = "ipkg timezones ntp bluez-utils-nodbus irda-utils \
                     openobex-apps libopieobex0 wireless-tools usbutils"
OPIE_BASE_RDEPENDS = "timezones ntpdate opie-handwriting-classicset \
                      bluez-utils-nodbus openobex-apps libopieobex0 wireless-tools "

#
# Clamshell models can benefit from the autorotate applet
#
OPIE_BASE_DEPENDS_append_c7x0 = " opie-autorotateapplet"
OPIE_BASE_DEPENDS_append_spitz = " opie-autorotateapplet"
OPIE_BASE_DEPENDS_append_akita = " opie-autorotateapplet"

# Keyboard models can benefit from the VT and logout applets
OPIE_BASE_APPLETS_append_openzaurus = " opie-vtapplet opie-logoutapplet"
OPIE_BASE_APPLETS_append_mnci       = " opie-vtapplet opie-logoutapplet"

#
# Additional things for a standard 16MB distribution
#

OPIE_PIM_BASE = "opie-alarm opie-drawpad opie-textedit"

OPIE_PIM_MAIL = "opie-mail"

OPIE_PIM = "${OPIE_PIM_BASE} opie-addressbook opie-datebook opie-todo opie-today \
            opie-today-addressbookplugin opie-today-datebookplugin opie-today-todolistplugin \
            opie-datebook-nationalholidayplugin opie-datebook-birthdayplugin "

KDE_PIM_DEPENDS = "${OPIE_PIM_BASE} kdepimpi"
KDE_PIM_RDEPENDS = "kopi kapi kopi-applet"

OPIE_EXTRA_APPLETS = "opie-clipboardapplet opie-volumeapplet opie-screenshotapplet"

OPIE_EXTRA_APPS = "opie-advancedfm"

OPIE_EXTRA_SETTINGS = "opie-language opie-launcher-settings opie-doctab opie-security \
            opie-mediummount opie-networksettings-wlanplugin opie-networksettings-pppplugin"

#
# Additional things for a >= 24MB distribution
#

OPIE_DEPENDS_24  = "konqueror-embedded opie-calculator opie-checkbook opie-mail opie-eye opie-rdesktop \
                    qpdf2 opie-wellenreiter opie-parashoot opie-mindbreaker opie-fifteen opie-tictac opie-tetrix   \
                    opie-irc "
OPIE_RDEPENDS_24 = "konqueror-embedded opie-calculator opie-checkbook opie-mail opie-eye opie-rdesktop \
                    qpdf2 opie-wellenreiter opie-parashoot opie-mindbreaker opie-fifteen opie-tictac opie-tetrix   \
                    opie-irc "

#
#
#

def opie_more_depends(d):
	import bb
	root_flash_size = int( bb.data.getVar( "ROOT_FLASH_SIZE", d, True ) or "16" )
	if root_flash_size >= 24: return bb.data.getVar( "OPIE_DEPENDS_24", d, True )
	else: return " "

def opie_more_rdepends(d):  
	import bb
	root_flash_size = int( bb.data.getVar( "ROOT_FLASH_SIZE", d, True ) or "16" )
	if root_flash_size >= 24: return bb.data.getVar( "OPIE_RDEPENDS_24", d, True )
	else: return " "

OPIE_MORE_DEPENDS := "${@opie_more_depends(d)}"
OPIE_MORE_RDEPENDS := "${@opie_more_rdepends(d)}"
