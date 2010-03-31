DESCRIPTION = "The Powerful #1 Open-Source Spam Filter"
HOMEPAGE = "http://spamassassin.apache.org/"
SECTION = "network"
LICENSE = "GPL"
PR = "r0"

inherit cpan

DEPENDS += " \
	libarchive-tar-perl-native \
	libdb-file-perl-native \
	libdbi-perl-native \
	libdigest-sha1-perl-native \
	libencode-detect-perl-native \
	libhtml-parser-perl-native \
	libio-socket-inet6-perl-native \
	libio-socket-ssl-perl-native \
	libio-zlib-perl-native \
	libip-country-perl-native \
	libmail-dkim-perl-native \
	libmail-spf-perl-native \
	libnetaddr-ip-perl-native \
	libnet-dns-perl-native \
	libnet-ident-perl-native \
	libwww-perl-native \
	openssl \
	zlib \
	"
RDEPENDS += " \
	libarchive-tar-perl \
	libdb-file-perl \
	libdbi-perl \
	libdigest-sha1-perl \
	libencode-detect-perl \
	libhtml-parser-perl \
	libio-socket-inet6-perl \
	libio-socket-ssl-perl \
	libio-zlib-perl \
	libip-country-perl \
	libmail-dkim-perl \
	libmail-spf-perl \
	libnetaddr-ip-perl \
	libnet-dns-perl \
	libnet-ident-perl \
	liburi-perl \
	libwww-perl \
	perl-module-base \
	perl-module-bytes \
	perl-module-carp \
	perl-module-config \
	perl-module-config-heavy \
	perl-module-constant \
	perl-module-cwd \
	perl-module-data-dumper \
	perl-module-errno \
	perl-module-exporter \
	perl-module-fcntl \
	perl-module-file-basename \
	perl-module-file-copy \
	perl-module-file-find \
	perl-module-file-glob \
	perl-module-file-path \
	perl-module-file-spec \
	perl-module-file-spec-unix \
	perl-module-io-file \
	perl-module-io-select \
	perl-module-io-socket \
	perl-module-io-socket-inet \
	perl-module-lib \
	perl-module-pod-text \
	perl-module-pod-usage \
	perl-module-posix \
	perl-module-socket \
	perl-module-strict \
	perl-module-sys-hostname \
	perl-module-sys-syslog \
	perl-module-time-hires \
	perl-module-time-local \
	perl-module-vars \
	perl-module-warnings \
	"

# Most of the patches are from Debian
SRC_URI = " \
	${APACHE_MIRROR}/spamassassin/source/Mail-SpamAssassin-${PV}.tar.bz2;name=spamassassin-${PV} \
	file://spamassassin.default \
	file://spamassassin.init \
	file://10_change_config_paths;patch=1 \
	file://20_edit_spamc_pod;patch=1 \
	file://30_edit_README;patch=1 \
	file://50_sa-learn_fix_empty_list_handling;patch=1 \
	file://60_fix-pod;patch=1 \
	file://70_fix-whatis;patch=1 \
	file://80_fix_man_warnings;patch=1 \
	file://spamassassin-spamc-configure.patch;patch=1 \
	"
SRC_URI[spamassassin-3.3.1.md5sum] = "bb977900c3b2627db13e9f44f9b5bfc8"
SRC_URI[spamassassin-3.3.1.sha256sum] = "4c348cd951fc2c5688e9713fcbc6ba453df51d32a1ab332a63800d20ff18bdb4"

S = "${WORKDIR}/Mail-SpamAssassin-${PV}"

do_compile_prepend() {
	export BUILD_SYS=${BUILD_SYS}
	export HOST_SYS=${HOST_SYS}
	export TARGET_SYS=${TARGET_SYS}
}

EXTRA_CPANFLAGS = " \
	DESTDIR="${D}" \
	PREFIX="${prefix}" \
	INSTALLDIRS=vendor \
	INSTALLVENDORMAN1DIR="${mandir}/man1" \
	INSTALLVENDORMAN3DIR="${mandir}/man3" \
	CONFDIR=${sysconfdir}/spamassassin \
	ENABLE_SSL=yes \
	"

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}/${sysconfdir}/default
	install -d ${D}/${sbindir}
	install -m 0755 ${WORKDIR}/spamassassin.init ${D}/${sysconfdir}/init.d/spamassassin
	install -m 0644 ${WORKDIR}/spamassassin.default ${D}/${sysconfdir}/default/spamassassin
	mv ${D}/${bindir}/spamd ${D}/${sbindir}/spamd
	sed -ri "s,${D},," ${D}/${bindir}/sa-learn \
		${D}/${bindir}/sa-awl \
		${D}/${bindir}/sa-update \
		${D}/${bindir}/sa-check_spamd \
		${D}/${bindir}/sa-compile \
		${D}/${bindir}/spamassassin \
		${D}/${sbindir}/spamd
}
