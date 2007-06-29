DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "openssl"
PV = "0.9.99+svn${SRCDATE}"
PR = "r0"
SRC_URI = "svn://trac.aircrack-ng.org/svn/branch;module=1.0-dev;proto=http \
           file://makefile-ldflags.patch;patch=1;maxdate=20070629 "
 
S="${WORKDIR}/1.0-dev"
 
DEFAULT_PREFERENCE = "-1"

export TOOL_PREFIX = "${HOST_SYS}-"

do_install() {
        install -d ${D}/${sbindir}
        install -d ${D}/${bindir}
        install -m 0755 src/airodump-ng       ${D}/${sbindir}
        install -m 0755 src/aircrack-ng       ${D}/${bindir}
        install -m 0755 src/aireplay-ng       ${D}/${sbindir}
        install -m 0755 src/airserv-ng        ${D}/${sbindir}
        install -m 0755 src/wesside-ng        ${D}/${sbindir}
        install -m 0755 src/airdecap-ng       ${D}/${bindir}
        install -m 0755 src/packetforge-ng    ${D}/${bindir}
        install -m 0755 airmon-ng             ${D}/${sbindir}
        install -m 0755 src/ivstools          ${D}/${bindir}
        install -m 0755 src/kstats            ${D}/${bindir}
        install -m 0755 src/airtun-ng         ${D}/${sbindir}
        install -m 0755 test/makeivs          ${D}/${bindir}
}

