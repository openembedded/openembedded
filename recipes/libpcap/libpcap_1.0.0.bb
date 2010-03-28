require libpcap.inc

PR = "r6"
SRC_URI = "http://www.tcpdump.org/release/libpcap-${PV}.tar.gz"
SRC_URI += "file://aclocal.patch;patch=1"
SRC_URI += "file://ieee80215-arphrd.patch;patch=1"
SRC_URI += "file://ldflags.patch;patch=1"
SRC_URI += "file://0001-Fix-some-problems-that-show-up-in-autoconf-2.64-and-.patch;patch=1"

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
}


