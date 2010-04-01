DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "openssl zlib sqlite3"
PV = "0.9.99+svnr${SRCPV}"
PR = "r1"
SRCREV = "802"

SRC_URI = "svn://trac.aircrack-ng.org/svn/branch;module=1.0-dev;proto=http"
 
S="${WORKDIR}/1.0-dev"
 
DEFAULT_PREFERENCE = "-1"

export TOOL_PREFIX = "${HOST_SYS}-"

do_compile() {
	oe_runmake SQLITE=true
}

do_install() {
        install -d ${D}/${sbindir}
        install -d ${D}/${bindir}
        install -m 0755 src/airodump-ng       ${D}/${sbindir}
        install -m 0755 src/aircrack-ng       ${D}/${bindir}
        install -m 0755 src/aireplay-ng       ${D}/${sbindir}
        install -m 0755 src/airserv-ng        ${D}/${sbindir}
        install -m 0755 src/wesside-ng        ${D}/${sbindir}
        install -m 0755 src/easside-ng        ${D}/${sbindir}
        install -m 0755 src/airdecap-ng       ${D}/${bindir}
        install -m 0755 src/packetforge-ng    ${D}/${bindir}
        install -m 0755 airmon-ng             ${D}/${sbindir}
        install -m 0755 src/ivstools          ${D}/${bindir}
        install -m 0755 src/kstats            ${D}/${bindir}
        install -m 0755 src/airtun-ng         ${D}/${sbindir}
        install -m 0755 src/makeivs-ng        ${D}/${bindir}
        install -m 0755 src/buddy-ng          ${D}/${bindir}
# I'm not including airdriver-ng as it is for building drivers and most people
# cannot use it on their handheld anyway.
}

