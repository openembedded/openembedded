DESCRIPTION = "A flexible VOIP soft switch/PBX."
DESCRIPTION_${PN}-ogi = "OpenPBX Gateway Inerface for scripted PBX call processing"
DESCRIPTION_${PN}-fax = "Fax send/receive file and T.38 support for OpenPBX"
DESCRIPTION_${PN}-ldap = "LDAP Directory services interface for OpenPBX"
DESCRIPTION_${PN}-sounds = "Standard set of audio prompts for OpenPBX"
HOMEPAGE = "http://www.openpbx.org"
RDEPENDS = "ssmtp"
SECTION = "voip"
LICENSE = "GPL"
DEPENDS = "openssl zlib tiff libcap spandsp speex readline js \
           sox-native findutils-native"
DEPENDS_${PN}-ldap = "openldap"
RRECOMMENDS = "logrotate"
RRECOMMENDS_${PN}-ogi = "perl perl-module-strict openpbx.org-perl"
PV = "1.2_rc3"
PR = "r2"

SRC_URI = "http://www.openpbx.org/releases/${P}.tar.gz \
           svn://svn.openpbx.org/openpbx-sounds/trunk/sounds/en_US;module=MelanieTaylor;proto=svn \
           file://bootstrap.patch;patch=1 \
           file://openssl.m4.patch;patch=1 \
           file://logrotate \
           file://volatiles \
           file://init"

PARALLEL_MAKE = ""
INITSCRIPT_NAME = "openpbx"
INITSCRIPT_PARAMS = "defaults 60"

inherit autotools update-rc.d

EXTRA_OECONF = " --with-ssl=${STAGING_DIR}/${HOST_SYS} --enable-low_memory \
        --disable-zaptel --with-directory-layout=lsb --enable-t38 \
        --with-codec-speex=${STAGING_DIR}/${HOST_SYS} --with-app_ldap \
        --with-perl-shebang='#!${bindir}/perl' --with-jabber --with-res_jabber \
        --with-javascript --with-res_js \
        --bindir=${bindir} --datadir=${datadir} --sysconfdir=${sysconfdir} \
        --includedir=${includedir} --infodir=${infodir} --mandir=${mandir} \
        --localstatedir=${localstatedir} --libdir=${libdir}"

do_configure_prepend () {
    ${S}/bootstrap.sh
    # Fix some stupidness with the VoiceMail app naming. Case Matters!
    sed -i 's:Voicemail:VoiceMail:' ${S}/configs/extensions.conf.sample
    sed -i 's:/var:${localstatedir}:' ${WORKDIR}/volatiles
    sed -i 's:/var:${localstatedir}:' ${WORKDIR}/logrotate
    sed -i 's:/etc/init.d:${sysconfdir}/init.d:' ${WORKDIR}/logrotate
}

do_install_append() {
    install -c -D -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/openpbx
    install -c -D -m 644 ${WORKDIR}/logrotate ${D}${sysconfdir}/logrotate.d/openpbx
    install -c -D -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/openpbx
    # And now for sounds...
    for file in `find ${WORKDIR}/MelanieTaylor -name \*.wav`; do
        echo $file
        sox -V $file -t raw -s -r 8000 -c 1 -w `echo $file|sed -e s/\.wav$/.sln/` resample -ql;
        sox -V $file -t raw -U -r 8000 -c 1 -b `echo $file|sed -e s/\.wav$/.ulaw/` resample -ql;
        sox -V $file -t raw -A -r 8000 -c 1 -b `echo $file|sed -e s/\.wav$/.alaw/` resample -ql;
        sox -V $file -t gsm -r 8000 -c 1 -b `echo $file|sed -e s/\.wav$/.gsm/` resample -ql;
        relfile=`echo $file|sed -e s:^${WORKDIR}/MelanieTaylor/::`
        relfile2=`echo $relfile|sed -e s:\.wav$::`
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.sln ${D}${datadir}/openpbx.org/sounds/$relfile2.sln
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.ulaw ${D}${datadir}/openpbx.org/sounds/$relfile2.ulaw
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.alaw ${D}${datadir}/openpbx.org/sounds/$relfile2.alaw
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.gsm ${D}${datadir}/openpbx.org/sounds/$relfile2.gsm
    done
}

PACKAGES = "${PN}-sounds ${PN}-fax ${PN}-ogi ${PN}-ldap ${PN}-doc ${PN}-dev ${PN}"

FILES_${PN}-sounds = "${datadir}/openpbx.org/sounds/*"
FILES_${PN}-dev = "${libdir}/openpbx.org/modules/*.la \
                   ${libdir}/openpbx.org/*.la \
                   ${includedir}/openpbx/*"
FILES_${PN}-fax = "${libdir}/openpbx.org/modules/app_backgrounddetect.so \
                   ${libdir}/openpbx.org/modules/app_faxdetect.so \
                   ${libdir}/openpbx.org/modules/app_rxfax.so \
                   ${libdir}/openpbx.org/modules/app_txfax.so"
FILES_${PN}-ogi = "${libdir}/openpbx.org/modules/res_ogi.so \
                   ${datadir}/openpbx.org/ogi/*"
FILES_${PN}-ldap = "${libdir}/openpbx.org/modules/app_ldap.*"

pkg_postinst_prepend() {
    grep -q openpbx ${sysconfdir}/group || addgroup --system openpbx
    grep -q openpbx ${sysconfdir}/passwd || adduser --system --home ${localstatedir}/run/openpbx.org --no-create-home --disabled-password --ingroup openpbx -s ${base_bindir}/false openpbx
    chown -R openpbx:openpbx ${libdir}/openpbx.org ${localstatedir}/lib/openpbx.org  ${localstatedir}/spool/openpbx.org ${localstatedir}/log/openpbx.org ${localstatedir}/run/openpbx.org ${sysconfdir}/openpbx.org ${datadir}/openpbx.org
    /etc/init.d/populate-volatile.sh update
}

pkg_postinst_${PN}-fax () {
    chown -R openpbx:openpbx ${libdir}/openpbx.org
}

pkg_postinst_${PN}-ldap () {
    chown -R openpbx:openpbx ${libdir}/openpbx.org
}

pkg_postinst_${PN}-sounds () {
    chown -R openpbx:openpbx ${datadir}/openpbx.org
}

CONFFILES_${PN} += "${sysconfdir}/openpbx.org/musiconhold.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/adsi.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/adtranvofr.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/agents.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/cdr.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/cdr_custom.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/cdr_manager.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/cdr_tds.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/codecs.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/dnsmgr.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/dundi.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/enum.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/extconfig.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/extensions.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/extensions.ael"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/features.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/iax.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/indications.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/logger.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/manager.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/meetme.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/mgcp.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/modem.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/modules.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/muted.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/openpbx.adsi"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/openpbx.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/osp.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/privacy.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/queues.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/rpt.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/rtp.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/sip.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/sip_notify.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/udptl.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/voicemail.conf"
CONFFILES_${PN} += "${sysconfdir}/openpbx.org/woomera.conf"
