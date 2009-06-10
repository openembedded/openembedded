DESCRIPTION = "Heavyweight console network bandwidth monitor"
LICENSE = "GPLv2"
DEPENDS = "ncurses"
PR = "r0"

SRC_URI = " \
    ${DEBIAN_MIRROR}/main/i/iptraf/iptraf_${PV}.orig.tar.gz \
    ${DEBIAN_MIRROR}/main/i/iptraf/iptraf_3.0.0-6.diff.gz;patch=1 \
    file://support-makefile.patch;patch=1 \
"

# iptraf will store user filters etc. in /var/run/iptraf, which is probably
# volatile.
EXTRA_OEMAKE_append = " \
    TARGET=${bindir} WORKDIR=${localstatedir}/run/iptraf DESTDIR=${D} \
    INCLUDEDIR=-I../support \
"

do_compile(){
    oe_runmake -C ${S}/src
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/src/iptraf ${D}${bindir}
    install -m 0755 ${S}/src/rvnamed ${D}${bindir}

    install -d ${D}${mandir}/man8
    install -m 0644 ${S}/Documentation/iptraf.8 ${D}${mandir}/man8
}

PACKAGES =+ "${PN}-dns"
DESCRIPTION_${PN}-dns = "Asynchronous reverse DNS lookup daemon for iptraf"
FILES_${PN}-dns = "${bindir}/rvnamed"
