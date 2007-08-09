DESCRIPTION = "The Asterisk open source software PBX"
HOMEPAGE = "http://www.asterisk.org"
SECTION = "voip"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "ncurses readline zlib openssl curl popt gnutls sqlite libogg libvorbis"
RRECOMMENDS_${PN} = "logrotate"

DEFAULT_PREFERENCE = "-1"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-${PV}.tar.gz\
	file://sounds.xml.patch;patch=1\
	file://Makefile.patch;patch=1\
	file://logrotate \
	file://volatiles \
	file://init"


INITSCRIPT_NAME = "asterisk"
INITSCRIPT_PARAMS = "defaults 60"

inherit autotools update-rc.d

EXTRA_OECONF =  "--with-ssl=${STAGING_DIR}/${HOST_SYS}\
			--with-z=${STAGING_DIR}/${HOST_SYS}\
			--with-curl=${STAGING_DIR}/${HOST_SYS}\
			--with-termcap=${STAGING_DIR}/${HOST_SYS}\
			--with-ogg=${STAGING_DIR}/${HOST_SYS}\
			--with-vorbis=${STAGING_DIR}/${HOST_SYS}\
			--with-sqlite=${STAGING_DIR}/${HOST_SYS}\
			--with-popt=${STAGING_DIR}/${HOST_SYS}\
			--with-gnutls=${STAGING_DIR}/${HOST_SYS}\
			--without-curses\
			--with-ncurses=${STAGING_DIR}/${HOST_SYS}\
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
export ASTLDFLAGS="${LDFLAGS}"

do_configure_prepend () {
	sed -i 's:/var:${localstatedir}:' ${WORKDIR}/logrotate
	sed -i 's:/etc/init.d:${sysconfdir}/init.d:' ${WORKDIR}/logrotate
	sed -i 's:/var:${localstatedir}:' ${WORKDIR}/volatiles
}

do_configure () {
	# Looks like rebuilding configure doesn't work, so we are skipping
	# that and are just using the shipped one
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_install_append() {
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
CONFFILES_${PN} += "${sysconfdir}/asterisk/modem.conf"
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
CONFFILES_${PN} += "${sysconfdir}/asterisk/zapata.conf"

