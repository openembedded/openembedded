SECTION = "x11/data"

SRC_URI = "git://git.shr-project.org/repo/illume-keyboards.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

PV = "0.0+gitr${SRCREV}"
PE = "1"
PR = "r2"


PACKAGES = "\
illume-keyboard-arabic \
illume-keyboard-browse \
illume-keyboard-danish \
illume-keyboard-default-alt \
illume-keyboard-dutch \
illume-keyboard-dvorak \
illume-keyboard-french \
illume-keyboard-german \
illume-keyboard-hebrew \
illume-keyboard-numeric-alt \
illume-keyboard-russian \
illume-keyboard-russian-terminal \
illume-keyboard-persian \
"

PACKAGE_ARCH = "all"

AUTHOR_illume-keyboard-arabic = "Mohammad Fahmi / Tom Hacohen"
DESCRIPTION_illume-keyboard-arabic = "Illume keyboard with arabic layout"
FILES_illume-keyboard-arabic = "${libdir}/enlightenment/modules/illume/keyboards/arabic"

AUTHOR_illume-keyboard-browse = "Pander"
DESCRIPTION_illume-keyboard-browse = "Illume keyboard with a layout optimized for browsing"
FILES_illume-keyboard-browse = "${libdir}/enlightenment/modules/illume/keyboards/browse"

AUTHOR_illume-keyboard-danish = "Esben Damgaard"
DESCRIPTION_illume-keyboard-danish = "Illume keyboard with danish layout"
FILES_illume-keyboard-danish = "${libdir}/enlightenment/modules/illume/keyboards/danish"

AUTHOR_illume-keyboard-default-alt = "Pander"
DESCRIPTION_illume-keyboard-default-alt = "Illume keyboard with an alternative default layout"
FILES_illume-keyboard-default-alt = "${libdir}/enlightenment/modules/illume/keyboards/default-alt"

AUTHOR_illume-keyboard-dutch = "Pander"
DESCRIPTION_illume-keyboard-dutch = "Illume keyboard with dutch layout"
FILES_illume-keyboard-dutch = "${libdir}/enlightenment/modules/illume/keyboards/dutch"

AUTHOR_illume-keyboard-dvorak = "Gabor Adam TOTH"
DESCRIPTION_illume-keyboard-dvorak = "Illume keyboard with dvorak layout"
FILES_illume-keyboard-dvorak = "${libdir}/enlightenment/modules/illume/keyboards/dvorak"

DESCRIPTION_illume-keyboard-french = "Illume keyboard with french layout"
FILES_illume-keyboard-french = "${libdir}/enlightenment/modules/illume/keyboards/french"

AUTHOR_illume-keyboard-german = "Florian Hackenberger"
DESCRIPTION_illume-keyboard-german = "Illume keyboard with german layout"
FILES_illume-keyboard-german = "${libdir}/enlightenment/modules/illume/keyboards/german"

AUTHOR_illume-keyboard-hebrew = "Tom Hacohen"
DESCRIPTION_illume-keyboard-hebrew = "Illume keyboard with hebrew layout"
FILES_illume-keyboard-hebrew = "${libdir}/enlightenment/modules/illume/keyboards/hebrew"

AUTHOR_illume-keyboard-numeric-alt = "Pander"
DESCRIPTION_illume-keyboard-numeric-alt = "Illume keyboard with an alternative numeric layout"
FILES_illume-keyboard-numeric-alt = "${libdir}/enlightenment/modules/illume/keyboards/numeric-alt"

AUTHOR_illume-keyboard-russian = "lucky"
DESCRIPTION_illume-keyboard-russian = "Illume keyboard with russian layout"
FILES_illume-keyboard-russian = "${libdir}/enlightenment/modules/illume/keyboards/russian"

AUTHOR_illume-keyboard-russian-terminal = "lucky"
DESCRIPTION_illume-keyboard-russian-terminal = "Illume keyboard with russian layout for the Terminal"
FILES_illume-keyboard-russian-terminal = "${libdir}/enlightenment/modules/illume/keyboards/russian-terminal"

AUTHOR_illume-keyboard-persian = "slave"
DESCRIPTION_illume-keyboard-persian = "Illume keyboard with persian layout"
FILES_illume-keyboard-persian = "${libdir}/enlightenment/modules/illume/keyboards/persian"

do_install() {
	make DESTDIR=${D} install
}

