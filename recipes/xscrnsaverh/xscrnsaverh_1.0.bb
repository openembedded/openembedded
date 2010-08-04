
PR = "r1"

DEPENDS = "libxext"
SECTION = "x11"
LICENSE = "X-MIT"
DESCRIPTION = "missing header"

SRC_URI = "file://scrnsaver.h"

do_install() {
	install -d ${D}${includedir}/X11/extensions/
	install -m 0644 ${WORKDIR}/scrnsaver.h ${D}${includedir}/X11/extensions/
}
