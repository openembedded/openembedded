DESCRIPTION="AiO screen grabber for dreambox stbs"
LICENSE = "GPL"
DEPENDS = "jpeg, libpng12-0, libz1, libgcc1, libc6"

PR = "r0"
PV = "0.8cvs${SRCDATE}"
SRCDATE = "20081204"
SRC_URI="cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/aio-grab;module=aio-grab;method=pserver"

S = "${WORKDIR}/aio-grab"

inherit autotools pkgconfig

#do_stage_append() {
#	oe_runmake install prefix=${STAGING_DIR} \
#		bindir=${STAGING_BINDIR} \
#		includedir=${STAGING_INCDIR} \
#		libdir=${STAGING_LIBDIR} \
#		datadir=${STAGING_DATADIR}
#}
