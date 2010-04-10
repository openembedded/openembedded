DESCRIPTION = "NTP (RFC-1305) client for unix-alike computers"
HOMEPAGE = "http://doolittle.icarus.com/ntpclient"
AUTHOR = "Larry Doolittle <larry@doolittle.boa.org>"
RDEPENDS = "busybox"
SECTION = "admin"
LICENSE = "GPLv2"
PR = "r1"
# The ntpclient package uses version numbers that include an underscore :(
PV = "2003_194"
# ntpclient unpacks into a directory that doesn't include version info :(
S = "${WORKDIR}/${PN}"

SRC_URI = "http://doolittle.icarus.com/ntpclient/ntpclient_${PV}.tar.gz \
           file://init"

INITSCRIPT_NAME = "ntpclient"
INITSCRIPT_PARAMS = "defaults 65"
inherit update-rc.d

do_compile() {
    oe_runmake ntpclient
    oe_runmake adjtimex
}

do_install () {
    # Install the binary and tools
    install -D -m 0755 ${S}/ntpclient ${D}${base_sbindir}/ntpclient
    install -D -m 0755 ${S}/adjtimex ${D}${base_sbindir}/adjtimex
    install -D -m 0755 ${S}/rate.awk ${D}${sbindir}/ntpclient-drift-rate.awk
    install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ntpclient
}


SRC_URI[md5sum] = "94e84d5c6023c5e1f3890b28d0a08c92"
SRC_URI[sha256sum] = "3f515a043bcd3b778d33938da224214e727faa528256d4a1a213bc8617ac2d0b"
