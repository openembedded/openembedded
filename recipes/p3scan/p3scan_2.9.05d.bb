DESCRIPTION = "A transparent proxy-server for email clients. It is designed \
to enable scanning of incoming/outgoing email messages (POP3, POPSS and \
SMTP) for Virus's, Worms, Trojans, Spam and harmfull attachments."
HOMEPAGE = "http://p3scan.sourceforge.net/"
SECTION = "network"
LICENSE = "GPLv2"
DEPENDS = "gmp bzip2 zlib clamav openssl"
RDEPENDS_${PN} = "${PN}-templates-en"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/p3scan/p3scan-2.9.05d.tar.gz \
           file://libtool-fix.patch;patch=1 \
           file://dont-search-use-include.patch;patch=1 \
           file://configure.in-add-newline.patch;patch=1 \
           file://p3scan.init \
           file://p3scan.conf \
           file://doc.configure.txt \
           file://volatiles.05_p3scan"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-clamav=${STAGING_LIBDIR}/.. \
                --with-openssl=${STAGING_LIBDIR}/.. \
                --disable-ripmime"

# Full manual install because the autoconf installer puts in lots of
# stuff we don't want and in lots of odd directories.
do_install () {
        install -m 0755 -d ${D}${sysconfdir}/init.d \
                           ${D}${docdir}/p3scan \
                           ${D}${mandir}/man8 \
                           ${D}${sysconfdir}/p3scan \
                           ${D}${sysconfdir}/default/volatiles \
                           ${D}${sbindir}
        install -m 755 ${WORKDIR}/p3scan.init ${D}${sysconfdir}/init.d/p3scan
        install -m 755 ${WORKDIR}/p3scan.conf ${D}${sysconfdir}/p3scan/p3scan.conf
        install -m 644 ${WORKDIR}/doc.configure.txt ${D}${docdir}/p3scan/configure.txt
        install -m 755 src/.libs/p3scan ${D}${sbindir}
        for i in etc/p3scan-*.mail \
                 etc/p3scan.whitelist \
                 etc/p3scan.blacklist; do
          install -m 644 $i ${D}${sysconfdir}/p3scan/`basename $i`
        done
        for i in README ChangeLog README-ripmime README-emergency \
                 spamfaq.html etc/p3scan.conf.sample p3scan.sh \
                 AUTHORS CONTRIBUTERS; do
          install -m 644 $i ${D}${docdir}/p3scan/`basename $i`
        done
        install -m 644 man/p3scan.man ${D}${mandir}/man8/p3scan.8
        # We need some /var directories
        for i in 05_p3scan; do
          install -m 0644 ${WORKDIR}/volatiles.$i ${D}${sysconfdir}/default/volatiles/$i
        done
}

PACKAGES = "${PN}-dbg ${PN}-doc \
            ${PN}-templates-ru ${PN}-templates-en ${PN}-templates-pt-br \
            ${PN}-templates-sp ${PN}-templates-ge ${PN}-templates-fr \
            ${PN}-templates-nl ${PN}-templates-pl ${PN}-templates-it \
            ${PN}"

FILES_${PN} = "${sysconfdir}/p3scan/* \
               ${sysconfdir}/init.d ${sysconfdir}/default ${sbindir}/*"
FILES_${PN}-templates-ru = "${sysconfdir}/p3scan/p3scan-ru.mail"
FILES_${PN}-templates-en = "${sysconfdir}/p3scan/p3scan-en.mail"
FILES_${PN}-templates-pt-br = "${sysconfdir}/p3scan/p3scan-pt-br.mail"
FILES_${PN}-templates-sp = "${sysconfdir}/p3scan/p3scan-sp.mail"
FILES_${PN}-templates-ge = "${sysconfdir}/p3scan/p3scan-ge.mail"
FILES_${PN}-templates-fr = "${sysconfdir}/p3scan/p3scan-fr.mail"
FILES_${PN}-templates-nl = "${sysconfdir}/p3scan/p3scan-nl.mail"
FILES_${PN}-templates-pl = "${sysconfdir}/p3scan/p3scan-pl.mail"
FILES_${PN}-templates-it = "${sysconfdir}/p3scan/p3scan-it.mail"

# Add havp's user and groups
pkg_postinst_${PN} () {
        grep -q mail: /etc/group || addgroup --system havp
        grep -q mail: /etc/passwd || \
            adduser --disabled-password --home=${localstatedir}/mail --system \
                    --ingroup mail --no-create-home -g "Mail" mail
        /etc/init.d/populate-volatile.sh update
}

CONFFILES_${PN} = "${sysconfdir}/p3scan/p3scan.conf"

INITSCRIPT_NAME = "p3scan"
INITSCRIPT_PARAMS = "defaults 65 35"
