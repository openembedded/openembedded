DESCRIPTION = "ClamSMTP is an SMTP filter that allows you to check for \
viruses using the ClamAV anti-virus software. It accepts SMTP connections \
and forwards the SMTP commands and responses to another SMTP server. The \
'DATA' email body is intercepted and scanned before forwarding. ClamSMTP \
has an optional transparent proxy mode."
HOMEPAGE = "http://memberwebs.com/nielsen/software/clamsmtp/"
SECTION = "network"
LICENSE = "BSD"
DEPENDS = "clamav"
RDEPENDS_${PN} = "clamav-daemon"
PR = "r2"

SRC_URI = "http://memberwebs.com/nielsen/software/clamsmtp/clamsmtp-${PV}.tar.gz \
           file://update-config.patch;patch=1 \
           file://clamsmtp.init \
           file://doc.configure.txt"

inherit autotools update-rc.d

do_configure () {
        # no autoreconf please
        aclocal
        autoconf
        libtoolize --force
        oe_runconf
}
do_install_append () {
        install -m 0755 -d ${D}${sysconfdir}/init.d \
                           ${D}${docdir}/clamsmtp
        install -m 755 ${WORKDIR}/clamsmtp.init ${D}${sysconfdir}/init.d/clamsmtpd
        install -m 644 doc/clamsmtpd.conf ${D}${sysconfdir}/clamsmtpd.conf
        install -m 644 README ${D}${docdir}/clamsmtp
        install -m 644 ${WORKDIR}/doc.configure.txt ${D}${docdir}/clamsmtp/configure.txt
        install -m 644 scripts/virus_action.sh ${D}${docdir}/clamsmtp
}

CONFFILES_${PN} = "${sysconfdir}/clamsmtpd.conf"

INITSCRIPT_NAME = "clamsmtpd"
INITSCRIPT_PARAMS = "defaults 65 35"
