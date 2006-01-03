LICENSE = "GPL"
DESCRIPTION = "The Openobex project aims to make an \
open source implementation of the Object Exchange \
(OBEX) protocol."
SECTION = "libs"
PR = "r3"

# put openobex-config into -dev package
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/openobex-${PV}.tar.gz \
	  file://syms.patch;patch=1"

inherit autotools binconfig

do_stage () {
	autotools_stage_all
}
