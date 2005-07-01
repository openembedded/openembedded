DEFAULT_PREFERENCE = "-1"
PR = "r0"
SECTION = "libs"
LICENSE = "LGPL GPL"
DESCRIPTION = "The Audio File Library provides a uniform and elegant \
API for accessing a variety of audio file formats, such as AIFF/AIFF-C, \
WAVE, NeXT/Sun .snd/.au, Berkeley/IRCAM/CARL Sound File, Audio Visual \
Research, Amiga IFF/8SVX, and NIST SPHERE." 

PACKAGES += "${PN}-bin"
FILES_${PN} = "${libdir}/libaudiofile*.so.*"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-bin += "${bindir}"
RPROVIDES_${PN} += "audiofile"

SRC_URI = "http://stage.maemo.org/pool/maemo/ossw/source/a/${PN}/${PN}_${PV}.tar.gz"

S = ${WORKDIR}/${PN}-0.2.6

inherit autotools pkgconfig binconfig

do_stage () {
	install -m 0644 libaudiofile/audiofile.h libaudiofile/aupvlist.h libaudiofile/af_vfs.h ${STAGING_INCDIR}/
	oe_libinstall -C libaudiofile libaudiofile ${STAGING_LIBDIR}
	install -m 0644 audiofile.m4 ${STAGING_DATADIR}/aclocal/
}
