PV = "1.0.3+cvs${FIXEDSRCDATE}"
FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"

LICENSE= "BSD-X"
SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DESCRIPTION = "various extension headers."

SRC_URI = "${FREEDESKTOP_CVS}/xlibs;module=XExtensions;date=${FIXEDSRCDATE}"
S = "${WORKDIR}/XExtensions"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
