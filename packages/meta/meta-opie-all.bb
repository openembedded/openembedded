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

RDEPENDS_task-qpe-applets = "\
    subapplet \
    tasklistapplet"

RDEPENDS_task-qpe-applications = "\
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
    zshopi"

RDEPENDS_task-opie-decorations = "\
    opie-deco-flat \
    opie-deco-liquid \
    opie-deco-polished"

RDEPENDS_task-qpe-games = "\
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
    ztappy"

RDEPENDS_task-qpe-inputmethods = "\
    custominput \
    flexis-zaurus \
    irk \
    irk-belkin"

RDEPENDS_task-qpe-multimedia = "\
    mplayer \
    sidplayer \
    xmms-embedded"

RDEPENDS_task-kdepim = "\
    kopi \
    kapi \
    kopi-applet"

DEPENDS += " kdepimpi"

RDEPENDS_task-qpe-emulators = "\
    scummvm \
    snes9x-sdl-qpe"


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
    terminus"
#FIXME Does this really want just a DEPENDS here?
DEPENDS += " ${task-qpe-fonts}"

RDEPENDS_task-qpe-settings += "\
    qclockchange"

