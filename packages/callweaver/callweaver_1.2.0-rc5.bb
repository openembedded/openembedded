DESCRIPTION = "A flexible VOIP soft switch/PBX."
DESCRIPTION_${PN}-ogi = "Callweaver Gateway Interface for scripted PBX call processing"
DESCRIPTION_${PN}-fax = "Fax send/receive file and T.38 support for Callweaver"
DESCRIPTION_${PN}-ldap = "LDAP Directory services interface for Callweaver"
DESCRIPTION_${PN}-sounds = "Standard set of audio prompts for Callweaver"
HOMEPAGE = "http://www.callweaver.org"
RDEPENDS = "ssmtp"
SECTION = "voip"
LICENSE = "GPL"
DEPENDS = "openssl zlib tiff libcap spandsp (>= 0.0.3+0.0.4pre10) speex readline js \
           sox-native findutils-native"
RRECOMMENDS = "logrotate"
RRECOMMENDS_${PN}-ogi = "perl perl-module-strict callweaver-perl"
PR = "r1"
S = "${WORKDIR}/callweaver-1.2-rc5"

CWRCV = "rc5"

SRC_URI = "http://devs.callweaver.org/release/callweaver-1.2.0-${CWRCV}.tar.bz2 \
           svn://svn.callweaver.org/callweaver-sounds/trunk/sounds/en_US;module=MelanieTaylor;proto=https;rev=4466 \
           file://bootstrap.patch;patch=1 \
           file://logrotate \
           file://volatiles \
           file://init"

PARALLEL_MAKE = ""
INITSCRIPT_NAME = "callweaver"
INITSCRIPT_PARAMS = "defaults 60"

inherit autotools update-rc.d

EXTRA_OECONF = " --with-ssl=${STAGING_DIR_HOST}${layout_exec_prefix} --enable-low_memory \
        --disable-zaptel --with-directory-layout=lsb --enable-t38 \
        --with-codec-speex=${STAGING_DIR_HOST}${layout_exec_prefix} \
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
    install -c -D -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/callweaver
    install -c -D -m 644 ${WORKDIR}/logrotate ${D}${sysconfdir}/logrotate.d/callweaver
    install -c -D -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/callweaver
    # And now for sounds...
    for file in `find ${WORKDIR}/MelanieTaylor -name \*.wav`; do
        echo $file
        sox -V $file -t raw -s -r 8000 -c 1 -w `echo $file|sed -e s/\.wav$/.sln/` resample -ql;
        sox -V $file -t raw -U -r 8000 -c 1 -b `echo $file|sed -e s/\.wav$/.ulaw/` resample -ql;
        sox -V $file -t raw -A -r 8000 -c 1 -b `echo $file|sed -e s/\.wav$/.alaw/` resample -ql;
        sox -V $file -t gsm -r 8000 -c 1 -b `echo $file|sed -e s/\.wav$/.gsm/` resample -ql;
        relfile=`echo $file|sed -e s:^${WORKDIR}/MelanieTaylor/::`
        relfile2=`echo $relfile|sed -e s:\.wav$::`
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.sln ${D}${datadir}/callweaver/sounds/$relfile2.sln
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.ulaw ${D}${datadir}/callweaver/sounds/$relfile2.ulaw
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.alaw ${D}${datadir}/callweaver/sounds/$relfile2.alaw
        install -c -D -m 644 ${WORKDIR}/MelanieTaylor/$relfile2.gsm ${D}${datadir}/callweaver/sounds/$relfile2.gsm
    done
}

pkg_postinst_prepend() {
    grep -q callweaver ${sysconfdir}/group || addgroup --system callweaver
    grep -q callweaver ${sysconfdir}/passwd || adduser --system --home ${localstatedir}/run/callweaver --no-create-home --disabled-password --ingroup callweaver -s ${base_bindir}/false callweaver
    chown -R callweaver:callweaver ${libdir}/callweaver ${localstatedir}/lib/callweaver  ${localstatedir}/spool/callweaver ${localstatedir}/log/callweaver ${localstatedir}/run/callweaver ${sysconfdir}/callweaver ${datadir}/callweaver
    /etc/init.d/populate-volatile.sh update
}

pkg_postinst_${PN}-fax () {
    chown -R callweaver:callweaver ${libdir}/callweaver
}

pkg_postinst_${PN}-ldap () {
    chown -R callweaver:callweaver ${libdir}/callweaver
}

pkg_postinst_${PN}-sounds () {
    chown -R callweaver:callweaver ${datadir}/callweaver
}

CONFFILES_${PN} += "${sysconfdir}/callweaver/musiconhold.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/adsi.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/adtranvofr.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/agents.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/cdr.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/callweaver.adsi"
CONFFILES_${PN} += "${sysconfdir}/callweaver/callweaver.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/cdr_custom.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/cdr_manager.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/cdr_tds.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/codecs.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/dnsmgr.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/dundi.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/enum.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/extconfig.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/extensions.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/extensions.ael"
CONFFILES_${PN} += "${sysconfdir}/callweaver/features.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/iax.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/indications.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/logger.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/manager.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/meetme.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/mgcp.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/modem.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/modules.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/muted.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/osp.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/privacy.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/queues.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/rpt.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/rtp.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/sip.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/sip_notify.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/udptl.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/voicemail.conf"
CONFFILES_${PN} += "${sysconfdir}/callweaver/woomera.conf"

PACKAGES = "${PN}-dbg ${PN}-sounds ${PN}-fax ${PN}-ogi ${PN}-ldap ${PN}-doc ${PN}-dev ${PN}"

FILES_${PN}-dbg += "${datadir}/callweaver/ogi/.debug ${libdir}/callweaver/modules/.debug"
FILES_${PN}-sounds += "${datadir}/callweaver/sounds/*"
FILES_${PN}-dev += "${libdir}/callweaver/modules/*.la \
                    ${libdir}/callweaver/*.la \
                    ${libdir}/callweaver/*.so \
                    ${includedir}/callweaver/*"
FILES_${PN}-fax += "${libdir}/callweaver/modules/app_backgrounddetect.so \
                    ${libdir}/callweaver/modules/app_faxdetect.so \
                    ${libdir}/callweaver/modules/app_rxfax.so \
                    ${libdir}/callweaver/modules/app_txfax.so"
FILES_${PN}-ogi += "${libdir}/callweaver/modules/res_ogi.so \
                    ${datadir}/callweaver/ogi/*"
FILES_${PN}-ldap += "${libdir}/callweaver/modules/app_ldap.*"
