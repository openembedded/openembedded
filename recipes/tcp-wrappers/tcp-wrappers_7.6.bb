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
           file://00_man_quoting.diff \
           file://01_man_portability;apply=yes \
           file://05_wildcard_matching;apply=yes \
           file://06_fix_gethostbyname;apply=yes \
           file://10_usagi-ipv6;apply=yes \
           file://11_tcpd_blacklist;apply=yes \
           file://11_usagi_fix;apply=yes \
           file://12_makefile_config;apply=yes \
           file://13_shlib_weaksym;apply=yes \
           file://14_cidr_support;apply=yes \
           file://15_match_clarify;apply=yes \
           file://expand_remote_port;apply=yes \
           file://have_strerror;apply=yes \
           file://man_fromhost;apply=yes \
           file://restore_sigalarm;apply=yes \
           file://rfc931.diff \
           file://safe_finger;apply=yes \
           file://sig_fix;apply=yes \
           file://siglongjmp;apply=yes \
           file://size_t;apply=yes \
           file://tcpdchk_libwrapped;apply=yes \
           file://ldflags;apply=yes \
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


SRC_URI[md5sum] = "e6fa25f71226d090f34de3f6b122fb5a"
SRC_URI[sha256sum] = "9543d7adedf78a6de0b221ccbbd1952e08b5138717f4ade814039bb489a4315d"
