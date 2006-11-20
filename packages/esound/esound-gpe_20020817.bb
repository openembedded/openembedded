DESCRIPTION = "Enlightened Sound Daemon - GPE version"
SECTION = "gpe/base"
LICENSE = "GPL"
DEPENDS = "audiofile"
PR = "r5"
PROVIDES += "esound"
RPROVIDES += "esound"

SRCDATE = "${PV}"
SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base/;module=esound;date=20061119 \
	   file://audiofile-please.patch;patch=1 \
	   file://configure.patch;patch=1"

S = "${WORKDIR}/esound"

inherit autotools binconfig pkgconfig

EXTRA_OECONF = "--disable-alsa"

SOV = "0.2.28"

do_stage () {
	install -m 0644 esd.h ${STAGING_INCDIR}/esd.h
	oe_soinstall .libs/libesd.so.${SOV} ${STAGING_LIBDIR}
	install -m 0644 .libs/libesd.lai ${STAGING_LIBDIR}/libesd.la
	install -m 0644 esd.m4 ${STAGING_DATADIR}/aclocal
}

PACKAGES =+ "esddsp esd esd-utils"

FILES_esddsp = "${bindir}/esddsp ${libdir}/libesddsp.so.*"
FILES_esd = "${bindir}/esd"
FILES_esd-utils = "${bindir}/*"
