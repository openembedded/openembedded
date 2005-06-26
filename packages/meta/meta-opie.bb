DESCRIPTION = "Meta-package for Opie and QPE"
SECTION = "opie/base"
ALLOW_EMPTY = 1
PR = "r24"
PACKAGE_ARCH = "all"
LICENSE = "MIT"

PACKAGES = "task-opie-applets task-opie-applications task-opie-base \
	task-opie-decorations task-opie-games task-opie-inputmethods \
	task-opie-multimedia task-opie-pim task-opie-settings \
	task-opie-styles task-opie-todayplugins task-opie-bluetooth \
	task-opie-wlan task-opie-datebookplugins \
	task-qpe-applets task-qpe-games task-qpe-inputmethods \
	task-qpe-multimedia task-qpe-emulators task-qpe-applications \
	task-qpe-fonts task-qpe-settings"

DEPENDS = "\
libopieobex0 \
opie-examples-python \
opie-freetype \
opie-help-en \
opie-i18n \
opie-keytabs \
opie-libqrsync \
opie-login \
opie-securityplugin-blueping \
opie-securityplugin-dummy \
opie-securityplugin-notice \
opie-securityplugin-pin \
opie-sh \
opie-symlinker \
"

task-opie-applets = "\
opie-aboutapplet \
opie-autorotateapplet \
opie-batteryapplet \
opie-bluetoothapplet \
opie-brightnessapplet \
opie-cardmon \
opie-clipboardapplet \
opie-clockapplet \
opie-homeapplet \
opie-irdaapplet \
opie-lockapplet \
opie-logoutapplet \
opie-mailapplet \
opie-memoryapplet \
opie-multikeyapplet \
opie-networkapplet \
opie-notesapplet \
opie-pcmciaapplet \
opie-pyquicklaunchapplet \
opie-restartapplet \
opie-restartapplet2 \
opie-rotateapplet \
opie-screenshotapplet \
opie-suspendapplet \
opie-vmemo \
opie-volumeapplet \
opie-vtapplet \
opie-zkbapplet \
"
RDEPENDS_task-opie-applets = "${task-opie-applets}"
DEPENDS += " ${task-opie-applets}"

task-qpe-applets = "\
subapplet \
tasklistapplet \
"
RDEPENDS_task-qpe-applets = "${task-qpe-applets}"
DEPENDS += " ${task-qpe-applets}"

task-opie-applications = "\
opie-advancedfm \
opie-bartender \
opie-calculator \
opie-camera \
opie-checkbook \
opie-clock \
opie-console \
opie-dagger \
opie-embeddedkonsole \
opie-euroconv \
opie-eye \
opie-ftp \
opie-gutenbrowser \
opie-helpbrowser \
opie-irc \
opie-keypebble \
opie-odict \
opie-oxygen \
opie-rdesktop \
opie-reader \
opie-remote \
opie-sheet \
opie-tableviewer \
opie-tinykate \
opie-wellenreiter \
manufacturers \
opie-write \
opie-zsafe "
RDEPENDS_task-opie-applications = "${task-opie-applications}"
DEPENDS += " ${task-opie-applications}"

task-qpe-applications = "\
camera-assistant \
cumulus \
dviviewer \
inkwp \
iqnotes \
justreader \
keyring \
klimt \
kstars-embedded \
ktimetrackerpi \
mileage \
militaryalphabet \
notez \
petitepainture \
pocketcellar \
poqetpresenter \
portabase \
qpdf2 \
qpealarmclock \
qpe-gaim \
qpegps \
qpenmapfe \
qplot \
resistorui \
shopper \
timesleuth \
txdrug \
tximage \
ubahnnav \
visiscript \
zeecookbook \
zbedic \
zbench \
zgscore \
zipsc \
zlapspeed \
zroadmap \
zshopi \
"
RDEPENDS_task-qpe-applications = "${task-qpe-applications}"
DEPENDS += " ${task-qpe-applications}"

task-opie-base = "\
opie-alarm \
opie-pics \
opie-qcop \
opie-quicklauncher \
opie-sounds \
opie-taskbar "
RDEPENDS_task-opie-base = "${task-opie-base}"
DEPENDS += " ${task-opie-base}"

task-opie-decorations = "\
opie-deco-flat \
opie-deco-liquid \
opie-deco-polished "
RDEPENDS_task-opie-decorations = "${task-opie-decorations}"
DEPENDS += " ${task-opie-decorations}"

task-opie-games = "\
opie-backgammon \
opie-bounce \
opie-buzzword \
opie-fifteen \
opie-go \
opie-kbill \
opie-kcheckers \
opie-kpacman \
opie-mindbreaker \
opie-minesweep \
opie-oyatzee \
opie-parashoot \
opie-qasteroids \
opie-sfcave \
opie-snake \
opie-solitaire \
opie-tetrix \
opie-tictac \
opie-wordgame \
opie-zlines \
opie-zsame \
"
RDEPENDS_task-opie-games = "${task-opie-games}"
DEPENDS += " ${task-opie-games}"

task-qpe-games = "\
aliens \
aliens-qt \
atomic \
billiardz \
brickout \
checkers \
crossword \
fish \
freedroid \
froot \
gemdropx \
glider \
hexatrolic \
iaimaster \
icebloxx \
knights \
labyrinth \
mahjongg \
maki \
nmm \
pairs \
pdamaze \
pipeman \
powermanga \
prboom \
puzz-le \
qfish2 \
qpe-vexed \
qmatrix \
rott \
scummvm \
shisensho \
sokoban \
tickypip \
tickypip-levels \
tron \
vectoroids \
win4 \
xmame \
zauralign \
zddice \
ziq \
zmerlin \
zrally \
zrev7 \
zsubhunt \
ztappy "
RDEPENDS_task-qpe-games = "${task-qpe-games}"
DEPENDS += " ${task-qpe-games}"

task-opie-inputmethods = "\
opie-dasher \
opie-dvorak \
opie-handwriting \
opie-jumpx \
opie-keyboard \
opie-keyview \
opie-kjumpx \
opie-multikey \
opie-pickboard \
opie-unikeyboard "
RDEPENDS_task-opie-inputmethods = "${task-opie-inputmethods}"
DEPENDS += " ${task-opie-inputmethods}"

task-qpe-inputmethods = "\
custominput \
flexis-zaurus \
"
RDEPENDS_task-qpe-inputmethods = "${task-qpe-inputmethods}"
DEPENDS += " ${task-qpe-inputmethods}"

task-opie-multimedia = "\
opie-mediaplayer1 \
opie-mediaplayer1-libmadplugin \
opie-mediaplayer1-libmodplugin \
opie-mediaplayer1-libtremorplugin \
opie-mediaplayer1-libwavplugin \
opie-mediaplayer1-ogg-mp3 \
opie-mediaplayer2 \
opie-mediaplayer2-skin-default \
opie-mediaplayer2-skin-default-landscape \
opie-mediaplayer2-skin-pod \
opie-mediaplayer2-skin-techno \
opie-mediaplayer2-divx \
opie-powerchord \
opie-recorder \
opie-tonleiter \
"
RDEPENDS_task-opie-multimedia = "${task-opie-multimedia}"
DEPENDS += " ${task-opie-multimedia}"

task-qpe-multimedia = "\
mplayer \
sidplayer \
xmms-embedded "
RDEPENDS_task-qpe-multimedia = "${task-qpe-multimedia}"
DEPENDS += " ${task-qpe-multimedia}"

task-opie-pim = "\
opie-addressbook \
opie-datebook \
opie-drawpad \
opie-mail \
opie-pimconverter \
opie-search \
opie-textedit \
opie-today \
opie-todo "
RDEPENDS_task-opie-pim = "${task-opie-pim} task-opie-todayplugins task-opie-datebookplugins"
DEPENDS += " ${task-opie-pim}"

task-kdepim = "\
kopi \
kapi \
kopi-applet \
"
RDEPENDS_task-kdepim = "${task-kdepim}"
DEPENDS += " kdepimpi"

task-opie-settings = "\
opie-appearance \
opie-aqpkg \
opie-backup \
opie-button-settings \
opie-calibrate \
opie-citytime \
opie-confeditor \
opie-doctab \
opie-formatter \
opie-language \
opie-launcher-settings \
opie-light-and-power \
opie-mediummount \
opie-networksettings \
opie-packagemanager \
opie-security \
opie-sshkeys \
opie-sysinfo \
opie-systemtime \
opie-usermanager \
opie-icon-reload \
opie-vmemo-settings "
RDEPENDS_task-opie-settings = "${task-opie-settings}"
DEPENDS += " ${task-opie-settings}"

task-opie-styles = "\
opie-style-flat \
opie-style-fresh \
opie-style-liquid \
opie-style-metal \
opie-style-web \
opie-style-phase \
opie-theme "
RDEPENDS_task-opie-styles = "${task-opie-styles}"
DEPENDS += " ${task-opie-styles}"

task-opie-todayplugins = "\
opie-today-addressbookplugin \
opie-today-datebookplugin \
opie-today-fortuneplugin \
opie-today-mailplugin \
opie-today-stocktickerplugin \
opie-today-todolistplugin \
opie-today-weatherplugin "
RDEPENDS_task-opie-todayplugins = "${task-opie-todayplugins}"
DEPENDS += " ${task-opie-todayplugins}"

task-opie-datebookplugins= "\
opie-datebook-birthdayplugin \
opie-datebook-chrisholidayplugin \
opie-datebook-nationalholidayplugin "
RDEPENDS_task-opie-datebookplugins = "${task-opie-datebookplugins}"
DEPENDS += " ${task-opie-datebookplugins}"

task-opie-bluetooth = "\
opie-bluepin \
opie-bluetoothmanager \
opie-bluetoothapplet"
RDEPENDS_task-opie-bluetooth = "${task-opie-bluetooth}"
DEPENDS += " ${task-opie-bluetooth}"

task-opie-wlan = "\
opie-wellenreiter "
RDEPENDS_task-opie-wlan = "${task-opie-wlan}"
DEPENDS += " ${task-opie-wlan}"

task-qpe-emulators = "\
frodo \
snes9x-sdl-qpe \
e-uae \
"
RDEPENDS_task-qpe-emulators = "${task-qpe-emulators}"
DEPENDS += " ${task-qpe-emulators}"

task-qpe-fonts = "\
qpf-bitstream-vera \
qpf-bitstream-vera-sans-mono \
qpf-dejavusans \
qpf-dejavusanscondensed \
qpf-dejavusansmono \
qpf-dejavuserif \
qpf-dejavuserifcondensed \
qpf-freemono \
qpf-freeserif \
qpf-gentium \
qpf-gentiumalt \
qpf-hunkysans \
qpf-hunkyserif \
qpf-qte \
qpf-helvetica \
qpf-unifont \
qpf-utopia \
terminus \
"
DEPENDS += " ${task-qpe-fonts}"

task-qpe-settings = "\
qclockchange \
"
RDEPENDS_task-qpe-settings += "${task-qpe-settings}"
DEPENDS += " ${task-qpe-settings}"
