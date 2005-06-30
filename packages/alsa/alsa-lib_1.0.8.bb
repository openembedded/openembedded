DESCRIPTION = "Alsa sound library"
MAINTAINER = "Lorn Potter <lpotter@trolltech.com>"
SECTION = "libs/multimedia"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "ftp://ftp.alsa-project.org/pub/lib/alsa-lib-${PV}.tar.bz2"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-cards=pdaudiocf --with-oss=yes"

do_stage () {
	oe_libinstall -so -C src libasound ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/alsa/sound
	install -m 0644 include/*.h ${STAGING_INCDIR}/alsa/
	install -m 0644 include/sound/ainstr*.h ${STAGING_INCDIR}/alsa/sound/
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 utils/alsa.m4 ${STAGING_DATADIR}/aclocal/
}

PACKAGES = "libasound alsa-server alsa-conf alsa-doc alsa-dev"
FILES_libasound = "${libdir}/libasound.so*"
FILES_alsa-server = "${bindir}"
FILES_alsa-conf = "${datadir}"
FILES_alsa-dev = "${libdir}/pkgconfig/ ${incdir}"

