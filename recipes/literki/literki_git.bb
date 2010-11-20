DESCRIPTION = "Literki overlay keyboard"
SECTION = "x11"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.opkg.org/package_232.html"

SRCREV = "1da40724369c8adc069288f1bfc6b2e167bbb87b"

SRC_URI = "git://git.senfdax.de/git/literki;protocol=http \
           file://makefile.patch \
           file://noswitcher.patch \
           file://sliderheight.patch \
"

PV = "0.0.2+gitr${SRCPV}"

DEPENDS += " \
	freetype \
	libxtst \
	libxext \
	libxrandr \
	libpng \
	libfakekey \
"

S = "${WORKDIR}/git"

inherit base

do_install() {
	oe_runmake DESTDIR=${D} install
}
