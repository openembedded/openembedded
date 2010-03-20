DESCRIPTION = "Squid is a caching proxy for the Web supporting HTTP, HTTPS, FTP, and more"
LICENSE = "GPLv2"
INC_PR = "r7"
DEPENDS = "squid-native-${PV} openssl openldap"

SRC_URI = "http://www.squid-cache.org/Versions/v2/${SQUID_MAJOR}/squid-${PV}.tar.bz2;name=squid-${PV} \
           file://fix_epoll_check.patch;patch=1 \
           file://squid.init \
	   file://squid-volatiles \
	   "

inherit autotools update-rc.d

EXTRA_OECONF = "--disable-epoll --disable-nls --enable-ssl --enable-storeio=null,ufs --enable-digest-auth-helpers=ldap --enable-basic-auth-helpers=LDAP"

logdir = ${localstatedir}/log/squid
EXTRA_OEMAKE = "\
  DEFAULT_CACHE_LOG=${logdir}/cache.log \
  DEFAULT_ACCESS_LOG=${logdir}/access.log \
  DEFAULT_STORE_LOG=${logdir}/store.log \
  DEFAULT_PID_FILE=${localstatedir}/run/squid.pid \
  DEFAULT_SWAP_DIR=${localstatedir}/spool/squid \
  DEFAULT_CONFIG_FILE=${sysconfdir}/squid/squid.conf \
  DEFAULT_MIME_TABLE=${sysconfdir}/squid/mime.conf \
  DEFAULT_CACHEMGR_CONFIG=${sysconfdir}/squid/cachemgr.conf \
  "

INITSCRIPT_NAME = "squid"

do_configure_append() {
   sed -i -e 's|./cf_gen |${STAGING_BINDIR_NATIVE}/cf_gen |g' src/Makefile
}

do_install_prepend() {
	install -d ${D}${sysconfdir}/squid
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/default/volatiles
	install -m 755 ${WORKDIR}/squid.init ${D}${sysconfdir}/init.d/squid
	mv ${D}${sysconfdir}/mime.conf.default ${D}${sysconfdir}/squid/
	mv ${D}${sysconfdir}/squid.conf.default ${D}${sysconfdir}/squid/
	install -m 0644 ${WORKDIR}/squid-volatiles ${D}${sysconfdir}/default/volatiles/squid
	sed -ri "s,^\#?\ *(pid_filename.+)$,\1," ${D}${sysconfdir}/squid/squid.conf
}

# this packages the languages better and saves some space, installs
# English as errors default and the others in locale package

PACKAGES =+ "${PN}-auth-ldap"
RDEPENDS_${PN}-auth-ldap += "${PN}"

FILES_${PN} += " ${datadir}/errors/English/* \
                 ${datadir}/icons/* \
                 ${datadir}/mib.txt"

FILES_${PN}-locale += " ${datadir}/errors/* " 
FILES_${PN}-auth-ldap = "${libexecdir}/digest_ldap_auth ${libexecdir}/squid_ldap_auth"