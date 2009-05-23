# Boost.Signals2 library: http://www.comedi.org/projects/signals2/
DESCRIPTION = "Boost.Signals2 - Thread-safe implementation of signals and slots."
LICENSE = "Boost Software License"
DEPENDS = "boost-1.38.0"
PV = "0.0.0+svnr${SRCREV}"
#PR = "r0" # 0 is default

# This provides a ${PN}-dev only. Override default ${PN}-dev dependency on ${PN}
RDEPENDS_${PN}-dev = ""

SRC_URI = "svn://svn.boost.org/svn/boost/sandbox/thread_safe_signals;proto=http;module=trunk"
S = "${WORKDIR}/trunk"

do_install() {
        mkdir -p ${D}${includedir}
	svn export "${S}/boost" "${D}/${includedir}/boost"
}

# Only the -dev package makes sense here (it's a header-only library).
PACKAGES = "${PN}-dev"
FILES_${PN}-dev = "${includedir}/boost"
