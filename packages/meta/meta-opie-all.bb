DESCRIPTION = "Meta-package for Opie and QPE"
SECTION = "opie/base"
ALLOW_EMPTY = 1
PACKAGE_ARCH = "all"
LICENSE = "MIT"
DEPENDS = "meta-opie"
PR = "r2"

PACKAGES = "task-qpe-applets task-qpe-games task-qpe-inputmethods \
	task-qpe-multimedia task-qpe-emulators task-qpe-applications \
	task-qpe-fonts task-qpe-settings"

task-qpe-applets = "\
subapplet \
tasklistapplet \
"
RDEPENDS_task-qpe-applets = "${task-qpe-applets}"
DEPENDS += " ${task-qpe-applets}"

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

task-opie-decorations = "\
opie-deco-flat \
opie-deco-liquid \
opie-deco-polished "
RDEPENDS_task-opie-decorations = "${task-opie-decorations}"
DEPENDS += " ${task-opie-decorations}"

task-qpe-games = "\
aliens \
aliens-qt \
atomic \
billiardz \
brickout \
checkers \
crossword \
fish \
froot \
gemdropx \
glider \
gnuz \
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
puzz-le \
qfish2 \
qpe-vexed \
qmatrix \
shisensho \
sokoban \
tickypip \
tickypip-levels \
tron \
vectoroids \
win4 \
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

task-qpe-inputmethods = "\
custominput \
flexis-zaurus \
irk \
irk-belkin \
"
RDEPENDS_task-qpe-inputmethods = "${task-qpe-inputmethods}"
DEPENDS += " ${task-qpe-inputmethods}"

task-qpe-multimedia = "\
mplayer \
sidplayer \
xmms-embedded "
RDEPENDS_task-qpe-multimedia = "${task-qpe-multimedia}"
DEPENDS += " ${task-qpe-multimedia}"

task-kdepim = "\
kopi \
kapi \
kopi-applet \
"
RDEPENDS_task-kdepim = "${task-kdepim}"
DEPENDS += " kdepimpi"

task-qpe-emulators = "\
scummvm \
snes9x-sdl-qpe \
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
