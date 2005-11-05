DESCRIPTION = "A library for replaying C64 SID music"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.geocities.com/SiliconValley/Lakes/5147/sidplay/packages/libsidplay-${PV}.tgz"

inherit autotools 

do_stage() {
	oe_libinstall -so -C src libsidplay ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/sidplay
	for f in src/compconf.h src/emucfg.h src/fformat.h src/fixpoint.h src/libcfg.h src/myendian.h src/mytypes.h src/player.h src/sidtune.h src/version.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/sidplay/
	done
}

