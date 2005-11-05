SECTION = "console/network"
DESCRIPTION="Network performance benchmark including tests for TCP, UDP, sockets, ATM and more."
HOMEPAGE="http://www.netperf.org/"
LICENSE="netperf"

SRC_URI="${DEBIAN_MIRROR}/non-free/n/netperf/netperf_${PV}.orig.tar.gz \
	file://init"

inherit update-rc.d

S = "${WORKDIR}/netperf-${PV}.orig"

CFLAGS_append = " -DDO_UNIX -DDO_IPV6"

do_compile() {	 
	oe_runmake
        sed -i 's:^\(NETHOME=\).*:${bindir}:' *_script
}

do_install() {
	install -d ${D}${sbindir} ${D}${bindir} ${D}${sysconfdir}/init.d
        install -m 4755 netperf ${D}${bindir}
	install -m 4755 netserver ${D}${sbindir}
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/netperf
    
	# man
	install -d ${D}${mandir}/man1/
    	install -m 0644 netserver.man ${D}${mandir}/man1/netserver.1
	install -m 0644 netperf.man ${D}${mandir}/man1/netperf.1

	# move scripts to examples directory
	install -d ${D}${docdir}/netperf/examples
	install -m 0644 tcp_range_script ${D}${docdir}/netperf/examples/
	install -m 0644 tcp_stream_script ${D}${docdir}/netperf/examples/
	install -m 0644 tcp_rr_script ${D}${docdir}/netperf/examples/
	install -m 0644 udp_stream_script ${D}${docdir}/netperf/examples/
	install -m 0644 udp_rr_script ${D}${docdir}/netperf/examples/
	install -m 0644 snapshot_script ${D}${docdir}/netperf/examples/
	
	# docs ..
	install -m 0644 ACKNWLDGMNTS ${D}${docdir}/netperf
	install -m 0644 COPYRIGHT ${D}${docdir}/netperf
	install -m 0644 Release_Notes ${D}${docdir}/netperf
	install -m 0644 README ${D}${docdir}/netperf
	install -m 0644 netperf.ps ${D}${docdir}/netperf
}

INITSCRIPT_NAME="netperf"
INITSCRIPT_PARAMS="defaults"
