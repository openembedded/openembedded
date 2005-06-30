DESCRIPTION = "Qt wrapper for librsync"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

S = "${WORKDIR}/rsync"

inherit opie

do_stage() {
	oe_libinstall -a libqrsync ${STAGING_LIBDIR}/
	install -m 0644 qrsync.h ${STAGING_INCDIR}/
}
