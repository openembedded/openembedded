DESCRIPTION = "NTP (RFC-1305) client for unix-alike computers"
HOMEPAGE = "http://doolittle.icarus.com/ntpclient"
AUTHOR = "Larry Doolittle <larry@doolittle.boa.org>"
RDEPENDS = "busybox"
SECTION = "admin"
LICENSE = "GPLv2"
PR = "r2"
# The ntpclient package uses version numbers that include an underscore :(
PV = "2007_365"
# ntpclient unpacks into a directory that doesn't include version info :(
S = "${WORKDIR}/${PN}-2007"

SRC_URI = "http://doolittle.icarus.com/ntpclient/ntpclient_${PV}.tar.gz \
           file://init"

INITSCRIPT_NAME = "ntpclient"
INITSCRIPT_PARAMS = "defaults 65"
inherit update-rc.d

LDFLAGS += " -lrt "

do_compile() {
    oe_runmake ntpclient
    oe_runmake adjtimex
}

do_install () {
    # Install the binary and tools
    install -D -m 0755 ${S}/ntpclient ${D}${base_sbindir}/ntpclient
    install -D -m 0755 ${S}/adjtimex ${D}${base_sbindir}/adjtimex.${PN}
    install -D -m 0755 ${S}/rate.awk ${D}${sbindir}/ntpclient-drift-rate.awk
    install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ntpclient
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_sbindir}/adjtimex adjtimex adjtimex.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove adjtimex adjtimex.${PN}
}

SRC_URI[md5sum] = "cb98711f11769cdd22fc592844cef414"
SRC_URI[sha256sum] = "295ed5ecfab595901cbe2cd41998d1715913318d30c22349784733e79de0e8f8"
