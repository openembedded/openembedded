DESCRIPTION = "The Portable Coroutine Library (PCL) implements the low level \
functionality for coroutines."
HOMEPAGE = "http://www.xmailserver.org/libpcl.html"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "libs"

SRC_URI = "http://www.xmailserver.org/libpcl-${PV}.tar.gz"
S = "${WORKDIR}/libpcl-${PV}"

inherit autotools

do_stage () {
	autotools_stage_includes
	oe_libinstall -so -a -C pcl libpcl ${STAGING_LIBDIR}/
}
