# Copyright (C) 2007-2008, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "The Asterisk open source software PBX"
HOMEPAGE = "http://www.asterisk.org"
LICENSE = "GPLv2"
PRIORITY = "optional"
SECTION = "console/telephony"
DEPENDS = "speex readline zlib openssl curl popt gnutls sqlite libogg libvorbis"
#RRECOMMENDS_${PN} = "logrotate"

SRC_URI="http://downloads.asterisk.org/pub/telephony/asterisk/old-releases/asterisk-${PV}.tar.gz \
#	file://sounds.xml.patch \
	file://Makefile.patch \
	file://asterisk-1.4-bugid18301.patch \
	file://logrotate \
	file://volatiles \
	file://init"

ARCH_efika="powerpc"
ARCH_dht-walnut="powerpc"
ARCH_magicbox="powerpc"
ARCH_sequoia="powerpc"

INITSCRIPT_NAME = "asterisk"
INITSCRIPT_PARAMS = "defaults 60"

inherit autotools update-rc.d

EXTRA_OECONF =  "--with-ssl=${STAGING_EXECPREFIXDIR} \
			--with-z=${STAGING_EXECPREFIXDIR} \
			--with-curl=${STAGING_EXECPREFIXDIR} \
			--with-termcap=${STAGING_EXECPREFIXDIR} \
			--with-ogg=${STAGING_EXECPREFIXDIR} \
			--with-vorbis=${STAGING_EXECPREFIXDIR} \
			--with-sqlite=${STAGING_EXECPREFIXDIR} \
			--with-popt=${STAGING_EXECPREFIXDIR} \
			--with-gnutls=${STAGING_EXECPREFIXDIR} \
			--without-curses\
			--with-ncurses=${STAGING_EXECPREFIXDIR} \
			--without-imap\
			--without-netsnmp\
			--without-odbc\
			--without-osptk\
			--without-nbs\
			--without-pwlib\
			--without-radius\
			--without-tds\
			--without-postgres\
			--without-zaptel\
			"

#export NOISY_BUILD=yes

export ASTCFLAGS = "-fsigned-char -I${STAGING_INCDIR} -DPATH_MAX=4096"
export ASTLDFLAGS="${LDFLAGS} -lpthread -ldl -lresolv "
export PROC="${ARCH}"

do_configure_prepend() {
	sed -i 's:/var:${localstatedir}:' ${WORKDIR}/logrotate
	sed -i 's:/etc/init.d:${sysconfdir}/init.d:' ${WORKDIR}/logrotate
	sed -i 's:/var:${localstatedir}:' ${WORKDIR}/volatiles

	# Due to menuselect below we want to save off these configures
	mv ${S}/menuselect/configure ${S}/menuselect/configure.SAVE
	mv ${S}/menuselect/mxml/configure ${S}/menuselect/mxml/configure.SAVE
	mv ${S}/main/editline/configure ${S}/main/editline/configure.SAVE
}

do_configure_append() {
	# Put this back
	mv ${S}/menuselect/configure.SAVE ${S}/menuselect/configure
	mv ${S}/menuselect/mxml/configure.SAVE ${S}/menuselect/mxml/configure
	mv ${S}/main/editline/configure.SAVE ${S}/main/editline/configure
}

do_compile() {
        (
         # Make sure that menuselect gets build using host toolchain
         unset CC CPP LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS RANLIB
         unset CONFIG_SITE
         export ac_cv_prog_PKGCONFIG=No
         cd menuselect 
         ./configure
         oe_runmake
        ) || exit 1
        oe_runmake
}

do_install_append() {
        install -d ${D}${sysconfdir}/init.d/
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/asterisk
	install -c -D -m 644 ${WORKDIR}/logrotate ${D}${sysconfdir}/logrotate.d/asterisk
	install -c -D -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/asterisk
}

pkg_postinst_prepend() {
	grep -q asterisk  ${sysconfdir}/group || addgroup --system asterisk
	grep -q asterisk ${sysconfdir}/passwd || adduser --system --home ${localstatedir}/run/asterisk --no-create-home --disabled-password --ingroup asterisk -s ${base_bindir}/false asterisk
	chown -R asterisk:asterisk ${libdir}/asterisk ${localstatedir}/lib/asterisk ${localstatedir}/spool/asterisk ${localstatedir}/log/asterisk ${localstatedir}/run/asterisk ${sysconfdir}/asterisk
}

FILES_${PN} += "${libdir}/asterisk/modules/*"
FILES_${PN}-dbg += "${libdir}/asterisk/modules/.debug \
                    ${localstatedir}/lib/asterisk/*/.debug"

CONFFILES_${PN} += "${sysconfdir}/asterisk/adsi.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/adtranvofr.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/agents.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/alarmreceiver.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/alsa.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/amd.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/asterisk.adsi"
CONFFILES_${PN} += "${sysconfdir}/asterisk/asterisk.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr_custom.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr_manager.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr_odbc.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr_pgsql.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr_tds.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/codecs.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/dnsmgr.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/dundi.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/enum.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/extconfig.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/extensions.ael"
CONFFILES_${PN} += "${sysconfdir}/asterisk/extensions.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/features.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/festival.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/followme.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/func_odbc.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/gtalk.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/h323.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/http.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/iax.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/iaxprov.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/indications.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/jabber.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/logger.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/manager.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/meetme.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/mgcp.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/misdn.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/modules.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/musiconhold.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/muted.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/osp.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/oss.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/phone.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/privacy.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/queues.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/res_odbc.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/res_snmp.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/rpt.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/rtp.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/say.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/sip.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/sip_notify.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/skinny.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/sla.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/smdi.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/telcordia-1.adsi"
CONFFILES_${PN} += "${sysconfdir}/asterisk/udptl.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/users.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/voicemail.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/vpb.conf"
CONFFILES_${PN} += "${sysconfdir}/logrotate.d/asterisk"

SRC_URI[md5sum] = "b3c0102860cf8b5ca44660636d6eac87"
SRC_URI[sha256sum] = "b2eb49e2198a4f05e4254cf224e0f13755889ba421a70c772ffafb3a6775271e"
