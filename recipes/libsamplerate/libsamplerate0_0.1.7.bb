DESCRIPTION = "An audio Sample Rate Conversion library"
SECTION = "libs"
LICENSE = "GPL libsamplerate"

SRC_URI = "http://www.mega-nerd.com/SRC/libsamplerate-${PV}.tar.gz"
S = "${WORKDIR}/libsamplerate-${PV}"

inherit autotools_stage pkgconfig

do_configure() {
	gnu-configize --force
	oe_runconf
}

