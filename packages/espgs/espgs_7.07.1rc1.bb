SECTION = "unknown"
DEPENDS = "jpeg zlib libpng espgs-native"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/espgs/espgs-${PV}-source.tar.bz2"
S = "${WORKDIR}/espgs-${PV}"

inherit autotools

EXTRA_OECONF = "--with-drivers= \
		--without-ijs \
		--without-gimp-print \
		--without-omni \
		--without-x \
		--disable-cups"
EXTRA_OEMAKE = "'BUILD_TIME_GS=${STAGING_BINDIR}/gs' \
		'ECHOGS_XE=${STAGING_BINDIR}/echogs' \
		'GENARCH_XE=${STAGING_BINDIR}/genarch' \
		'GENCONF_XE=${STAGING_BINDIR}/genconf'"

do_install () {
	oe_runmake 'prefix=${D}${prefix}' \
		   'bindir=${D}${bindir}' \
		   'datadir=${D}${datadir}' \
		   'mandir=${D}${mandir}' install
}
