DESCRIPTION = "The Audio File Library provides a uniform and elegant \
API for accessing a variety of audio file formats, such as AIFF/AIFF-C, \
WAVE, NeXT/Sun .snd/.au, Berkeley/IRCAM/CARL Sound File, Audio Visual \
Research, Amiga IFF/8SVX, and NIST SPHERE."
SECTION = "libs"
LICENSE = "LGPL GPL"
RPROVIDES_${PN} += "audiofile"
PR = "r6"

SRC_URI = "http://www.68k.org/~michael/audiofile/audiofile-${PV}.tar.gz"

inherit autotools pkgconfig binconfig

do_stage () {
	install -m 0644 libaudiofile/audiofile.h libaudiofile/aupvlist.h libaudiofile/af_vfs.h ${STAGING_INCDIR}/
	oe_libinstall -C libaudiofile libaudiofile ${STAGING_LIBDIR}
	install -m 0644 audiofile.m4 ${STAGING_DATADIR}/aclocal/
}

PACKAGES += "${PN}-bin"
FILES_${PN} = "${libdir}/libaudiofile*.so.*"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-bin += "${bindir}"
