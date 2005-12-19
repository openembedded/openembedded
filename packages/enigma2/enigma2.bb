DEPENDS = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native python-pyxml"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-pyxml"
DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PN = "enigma2"
PR = "r0"
CVSDATE = "20051201"
PV = "1.0cvs${CVSDATE}"

SRC_URI = "cvs://dreamboxupdate.com/cvs;module=enigma2;method=ext \
           file://enigma2.sh"

S = "${WORKDIR}/enigma2"

FILES_${PN} += " ${datadir}/tuxbox ${datadir}/fonts ${libdir}/tuxbox"
FILES_${PN} += "/home/root/userbouquet.favourites.tv /home/root/bouquets.tv"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--enable-maintainer-mode --with-target=native --with-libsdl=no"

do_install_append() {
	install -d ${D}/usr/share/fonts
#	install -m 0755 ${WORKDIR}/font.ttf ${D}/usr/share/fonts/
	install -m 0755 ${WORKDIR}/enigma2.sh ${D}/usr/bin/
	install -d ${D}/etc/enigma2
	install -d ${D}/home/root

	# TODO: move them to /etc/enigma2
	install -m 0755 ${S}/userbouquet.favourites.tv ${D}/home/root/
	install -m 0755 ${S}/bouquets.tv ${D}/home/root/
}
