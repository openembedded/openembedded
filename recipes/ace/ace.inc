DESCRIPTION = "C++ network programming framework"
SECTION = "net"
LICENSE = "http://www.cs.wustl.edu/~schmidt/ACE-copying.html"

DEPENDS += "openssl gperf-native"

SRC_URI = "ftp://download.dre.vanderbilt.edu/previous_versions/ACE-${PV}.tar.bz2"
S = "${WORKDIR}/ACE_wrappers"
B = "${WORKDIR}/build.${TARGET_SYS}"

EXTRA_OECONF += "--disable-ace-tests --disable-gperf"
LEAD_SONAME = "libACE-[0-9.]*.so"

inherit autotools

do_configure_prepend() {
	export ace_cv_linux_event_poll=yes
}
