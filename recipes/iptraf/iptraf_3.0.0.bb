DESCRIPTION = "Heavyweight console network bandwidth monitor"
LICENSE = "GPLv2"
DEPENDS = "ncurses"
PR = "r0"

SRC_URI = " \
    ${DEBIAN_MIRROR}/main/i/iptraf/iptraf_${PV}.orig.tar.gz;name=archive \
    ${DEBIAN_MIRROR}/main/i/iptraf/iptraf_3.0.0-6.diff.gz;patch=1;name=patch \
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

SRC_URI[archive.md5sum] = "377371c28ee3c21a76f7024920649ea8"
SRC_URI[archive.sha256sum] = "9ee433d95573d612539da4b452e6cdcbca6ab6674a88bfbf6eaf12d4902b5163"
SRC_URI[patch.md5sum] = "fe0e2944addbd5803b42e91f7e4ec5d7"
SRC_URI[patch.sha256sum] = "5803c3f3653887896b75567daf617a8f200cecdd28beb870219b3954d9931efa"
