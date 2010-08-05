require libpcap.inc

PR = "r1"
SRC_URI = "http://www.tcpdump.org/release/libpcap-${PV}.tar.gz"
SRC_URI += "file://ieee80215-arphrd.patch"

BINCONFIG_GLOB = "pcap-config"

inherit binconfig

do_configure_prepend() {
	cat ${S}/aclocal.m4 >>${S}/acinclude.m4
}

do_compile () {
    oe_runmake
    rm -f *.o
    oe_runmake shared
}

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${bindir}
    oe_runmake install DESTDIR=${D}
    oe_runmake install-shared DESTDIR=${D}
    oe_libinstall -a -so libpcap ${D}${libdir}

    install -d ${D}${includedir}/pcap
    install -m 0644 pcap/pcap.h ${D}${includedir}/pcap/pcap.h
    install -m 0644 pcap/namedb.h ${D}${includedir}/pcap/namedb.h
    install -m 0644 pcap/bpf.h ${D}${includedir}/pcap/bpf.h

    install -m 0755 ${S}/pcap-config ${D}${bindir}
}

FILES_${PN}-dev += "${bindir}/pcap-config"

SRC_URI[md5sum] = "1bca27d206970badae248cfa471bbb47"
SRC_URI[sha256sum] = "508cca15547e55d1318498b838456a21770c450beb2dc7d7d4a96d90816e5a85"

