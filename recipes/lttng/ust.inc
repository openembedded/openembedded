DESCRIPTION = "LTTng Userspace Tracer (UST)"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPLv2 and LGPLv2.1"
DEPENDS = "liburcu"

PR = "r4"

inherit update-rc.d

INITSCRIPT_NAME = "ustd"
INITSCRIPT_PARAMS = "defaults 99 0"

UST_BASEDIR = "/tmp/ust"

SRC_URI = "http://lttng.org/files/ust/releases/ust-${PV}.tar.gz \
	file://ustd.init"

S = "${WORKDIR}/ust-${PV}"

inherit autotools

do_compile_append () {
	sed -e 's|^#!/bin/bash$|#!/bin/sh|' \
	    -e 's/^function \(.*() *{\)$/\1/' \
	    -e 's|^\(BASE_TRACE_DIR\)=.*|\1="${UST_BASEDIR}"|' \
	    -e 's/\(.*\)="$(<\(.*\))"/\1=`cat \2`/' \
	    -e 's/^\(DATESTRING\)=.*/\1="$(date +%Y%m%d%H%M%S)"/' \
	    -i ${S}/usttrace
	sed -e 's|^\(TRACEDIR\)=.*|\1="${UST_BASEDIR}"|' \
	    -i ${WORKDIR}/ustd.init
}

do_install_append () {
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/ustd.init ${D}${sysconfdir}/init.d/ustd
}

# We need to have -dev get parsed first.  Need the .so symlinks for preload to
# work
PACKAGES = "${PN}-dev ${PN}-dbg ${PN} ${PN}-static ${PN}-doc"
FILES_${PN}-dev = "${includedir} ${libdir}/*.la ${libdir}/*.o ${libdir}/libust.so"
FILES_${PN} += "${libdir}/lib*${SOLIBS} ${libdir}/lib*${SOLIBSDEV}"
INSANE_SKIP_${PN} = "1"
