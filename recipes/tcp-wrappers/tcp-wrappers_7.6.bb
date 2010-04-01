DESCRIPTION = "Tools for monitoring and filtering incoming requests for tcp \
	      services."
LICENSE = "tcp-wrappers"
PRIORITY = "optional"
SECTION = "console/network"
PR ="r5"


PACKAGES = "${PN}-dbg libwrap libwrap-doc libwrap-dev tcp-wrappers tcp-wrappers-doc"
FILES_libwrap = "${libdir}/lib*.so.*"
FILES_libwrap-doc = "${mandir}/man3 ${mandir}/man5"
FILES_libwrap-dev = "${libdir}/lib*.so ${includedir}"
FILES_tcp-wrappers = "${bindir}"
FILES_tcp-wrappers-doc = "${mandir}/man8"

SRC_URI = "ftp://ftp.porcupine.org/pub/security/tcp_wrappers_${PV}.tar.gz \
           file://00_man_quoting.diff;patch=1 \
           file://01_man_portability;patch=1 \
           file://05_wildcard_matching;patch=1 \
           file://06_fix_gethostbyname;patch=1 \
           file://10_usagi-ipv6;patch=1 \
           file://11_tcpd_blacklist;patch=1 \
           file://11_usagi_fix;patch=1 \
           file://12_makefile_config;patch=1 \
           file://13_shlib_weaksym;patch=1 \
           file://14_cidr_support;patch=1 \
           file://15_match_clarify;patch=1 \
           file://expand_remote_port;patch=1 \
           file://have_strerror;patch=1 \
           file://man_fromhost;patch=1 \
           file://restore_sigalarm;patch=1 \
           file://rfc931.diff;patch=1 \
           file://safe_finger;patch=1 \
           file://sig_fix;patch=1 \
           file://siglongjmp;patch=1 \
           file://size_t;patch=1 \
           file://tcpdchk_libwrapped;patch=1 \
           file://ldflags;patch=1 \
           \
           file://try-from.8 \
           file://safe_finger.8"

S = "${WORKDIR}/tcp_wrappers_${PV}"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "'CC=${CC}' \
		'AR=${AR}' \
		'RANLIB=${RANLIB}' \
		'REAL_DAEMON_DIR=${sbindir}' \
		'STYLE=-DPROCESS_OPTIONS' \
		'FACILITY=LOG_DAEMON' \
		'SEVERITY=LOG_INFO' \
		'BUGS=' \
		'VSYSLOG=' \
		'RFC931_TIMEOUT=10' \
		'ACCESS=-DHOSTS_ACCESS' \
		'KILL_OPT=-DKILL_IP_OPTIONS' \
		'UMASK=-DDAEMON_UMASK=022' \
		'NETGROUP=${EXTRA_OEMAKE_NETGROUP}' \
		'LIBS=-lnsl' \
		'ARFLAGS=rv' \
		'AUX_OBJ=weak_symbols.o' \
		'TLI=' \
		'COPTS=' \
		'EXTRA_CFLAGS=${CFLAGS} -DSYS_ERRLIST_DEFINED -DHAVE_STRERROR -DHAVE_WEAKSYMS -D_REENTRANT -DINET6=1 -Dss_family=__ss_family -Dss_len=__ss_len'"

EXTRA_OEMAKE_NETGROUP = "-DNETGROUP"
EXTRA_OEMAKE_NETGROUP_linux-uclibc = ""
EXTRA_OEMAKE_NETGROUP_linux-uclibceabi = ""

do_compile () {
	oe_runmake 'TABLES=-DHOSTS_DENY=\"${sysconfdir}/hosts.deny\" -DHOSTS_ALLOW=\"${sysconfdir}/hosts.allow\"' \
		   all
}

BINS = "safe_finger tcpd tcpdchk try-from tcpdmatch"
MANS3 = "hosts_access"
MANS5 = "hosts_options"
MANS8 = "tcpd tcpdchk tcpdmatch"
do_install () {
	oe_libinstall -C shared -so libwrap ${D}${libdir}/

	install -d ${D}${sbindir}
	for b in ${BINS}; do
		install -m 0755 $b ${D}${sbindir}/ || exit 1
	done

	install -d ${D}${mandir}/man3
	for m in ${MANS3}; do
		install -m 0644 $m.3 ${D}${mandir}/man3/ || exit 1
	done

	install -d ${D}${mandir}/man5
	for m in ${MANS5}; do
		install -m 0644 $m.5 ${D}${mandir}/man5/ || exit 1
	done

	install -d ${D}${mandir}/man8
	for m in ${MANS8}; do
		install -m 0644 $m.8 ${D}${mandir}/man8/ || exit 1
	done

	install -m 0644 ${WORKDIR}/try-from.8 ${D}${mandir}/man8/
	install -m 0644 ${WORKDIR}/safe_finger.8 ${D}${mandir}/man8/

	install -d ${D}${includedir}
	install -m 0644 tcpd.h ${D}${includedir}/
}

