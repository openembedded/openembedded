
PR = "r0"

DEPENDS = "xextensions"
SECTION = "x11"
LICENSE = "X-MIT"
DESCRIPTION = "missing header"

SRC_URI = "file://scrnsaver.h"

do_stage() { 
	install -m 0644 ${WORKDIR}/scrnsaver.h ${STAGING_INCDIR}/X11/extensions/ 
}
