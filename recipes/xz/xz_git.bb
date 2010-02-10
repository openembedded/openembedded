# XZ_BASE should be the latest released version of xz.
# It can be set in the distro file.
#XZ_BASE ?= "4.999.9"
#SRCREV = "HEAD"
#PV = "${XZ_BASE}+gitr${SRCREV}"
S = "${WORKDIR}/git"
PV = "git"
PR = "${INC_PR}.0"
SRC_URI = "git://ctrl.tukaani.org/xz.git;branch=master;protocol=git"
EXTRA_OECONF = "--enable-shared --disable-nls"
DEFAULT_PREFERENCE = "-1"
require xz.inc
inherit gettext
EXTRA_AUTORECONF = "--install"
# XXX: Not sure what i managed to break, but this should not be needed!
# | configure.ac:460: required file `build-aux/config.rpath' not found
do_configure () {
	install -D -m0755 ${STAGING_DATADIR}/gettext/config.rpath \
		 ${S}/build-aux/config.rpath
	autotools_do_configure
}
# just disabled nls for now
