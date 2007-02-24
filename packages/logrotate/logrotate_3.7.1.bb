DESCRIPTION = "Rotates, compresses, removes and mails system log files"
HOMEPAGE = "http://packages.debian.org/unstable/admin/logrotate"
RCONFLICTS = "logrotate-script"
RRECOMMENDS = "gzip"
DEPENDS = "popt"
RDEPENDS = "cron"
SECTION = "admin"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://ftp.debian.org/debian/pool/main/l/logrotate/logrotate_${PV}.orig.tar.gz \
	   file://logrotate-3.7.1.patch;patch=1 \
           file://logrotate.conf"

CFLAGS_prepend  += "-I${STAGING_INCDIR} "
LDFLAGS_prepend += "-L${STAGING_LIBDIR} "
EXTRA_OEMAKE    =  "-p"

do_compile() {
    oe_runmake
}

do_install () {
    # Install the binary and conf file
    install -D -s -m 0755 ${WORKDIR}/logrotate-${PV}/logrotate ${D}${base_sbindir}/logrotate
    install -D -m 0644 ${WORKDIR}/logrotate.conf ${D}${sysconfdir}/logrotate.conf
    install -m 0755 -d ${D}${sysconfdir}/logrotate.d
}

pkg_postinst () {
    # Add the logrotate line to /etc/crontab
    grep -q "/sbin/logrotate" ${sysconfdir}/crontab || echo "*/5 * * * *   /sbin/logrotate /etc/logrotate.conf" >> ${sysconfdir}/crontab
}

pkg_postrm() {
    # Remove the logrotate line from /etc/crontab
    grep -v /sbin/logrotate ${sysconfdir}/crontab > ${sysconfdir}/crontab.no-${PF}
    mv ${sysconfdir}/crontab.no-${PF} ${sysconfdir}/crontab
}
