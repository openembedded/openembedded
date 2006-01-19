DEPENDS = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native python-pyxml \
	libfribidi"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-pyxml"
DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PN = "enigma2"
PR = "r0"
CVSDATE = "20060117"
PV = "1.0cvs${CVSDATE}"

SRC_URI = "cvs://anonymous@dreamboxupdate.com/cvs;module=enigma2;method=pserver \
           file://enigma2.sh"

S = "${WORKDIR}/enigma2"

FILES_${PN} += "${datadir}/fonts"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--enable-maintainer-mode --with-target=native --with-libsdl=no"

do_install_append() {
	install -m 0755 ${WORKDIR}/enigma2.sh ${D}/usr/bin/
}
