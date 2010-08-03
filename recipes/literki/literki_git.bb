DESCRIPTION = "Literki overlay keyboard"
SECTION = "x11"
LICENSE = "GPL"
HOMEPAGE = "http://www.opkg.org/package_232.html"

SRCREV = "master"
PR = "r0.1"

# TODO:
# steal from http://users.tkk.fi/~tajyrink/moko/literki_mods/

SRC_URI = "git://git.senfdax.de/git/literki;protocol=http"
SRC_URI += "file://makefile.patch"
SRC_URI += "file://noswitcher.patch"
SRC_URI += "file://sliderheight.patch"

PV = "${SRCPV}"

DEPENDS += " \
	freetype \
	libxtst \
	libxext \
	libxrandr \
	libpng \
	libfakekey \
"

S = "${WORKDIR}/git"
PACKAGES = "${PN}"

inherit base

do_install() {
	oe_runmake DESTDIR=${D} install
}
