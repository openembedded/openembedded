DESCRIPTION = "Configuration files for SoftAP with udhcpd"
SECTION = "console/network"
HOMEPAGE = "http://udhcp.busybox.net/"
LICENSE = "GPLv2+"

PR = "r0"

S = ${WORKDIR}

# Default configuration file is from the base udhcp package
SRC_URI = "file://udhcpd.conf"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0755 ${S}/udhcpd.conf ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir}/udhcpd.conf"
CONFFILES_${PN} += "${sysconfdir}/udhcpd.conf"
