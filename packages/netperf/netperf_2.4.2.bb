DESCRIPTION="Network performance benchmark including tests for TCP, UDP, sockets, ATM and more."
SECTION = "console/network"
HOMEPAGE = "http://www.netperf.org/"
LICENSE = "netperf"

SRC_URI="${DEBIAN_MIRROR}/non-free/n/netperf/netperf_${PV}.orig.tar.gz \
         file://init"

inherit update-rc.d autotools

S = "${WORKDIR}/netperf-${PV}"

CFLAGS_append = " -DDO_UNIX -DDO_IPV6"

do_configure_prepend() {
        install -m 0644 ${S}/m4/m4/m4/*.m4 ${S}/m4/
        install -m 0644 ${S}/src/missing/m4/*.m4 ${S}/m4/
}

do_install() {
        install -d ${D}${sbindir} ${D}${bindir} ${D}${sysconfdir}/init.d
        install -m 4755 src/netperf ${D}${bindir}
        install -m 4755 src/netserver ${D}${sbindir}
        install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/netperf

        # man
        install -d ${D}${mandir}/man1/
        install -m 0644 doc/netserver.man ${D}${mandir}/man1/netserver.1
        install -m 0644 doc/netperf.man ${D}${mandir}/man1/netperf.1

        # move scripts to examples directory
        install -d ${D}${docdir}/netperf/examples
        install -m 0644 doc/examples/*_script ${D}${docdir}/netperf/examples/

        # docs ..
        install -m 0644 COPYING ${D}${docdir}/netperf
        install -m 0644 Release_Notes ${D}${docdir}/netperf
        install -m 0644 README ${D}${docdir}/netperf
        install -m 0644 doc/netperf_old.ps ${D}${docdir}/netperf
}

INITSCRIPT_NAME="netperf"
INITSCRIPT_PARAMS="defaults"
