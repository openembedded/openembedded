DESCRIPTION = "OCF resource agents for use by compatible cluster managers"
LICENSE = "GPL"
DEPENDS = "cluster-glue"

PR = "r1"

SRC_URI = " \
	http://hg.linux-ha.org/agents/archive/agents-${PV}.tar.bz2;name=tar \
	file://fix-header-defs-lookup.patch \
	file://disable-doc-build.patch \
	"
SRC_URI_append_libc-uclibc = " file://kill-stack-protector.patch"
SRC_URI[tar.md5sum] = "fcaa2cfd83a28d1965200e11db2ddd41"
SRC_URI[tar.sha256sum] = "09b58332e34cf128c8d53d5bb4b3f61e402c2e0c0c809f5abae53ca144ad101e"

inherit autotools

S = "${WORKDIR}/Cluster-Resource-Agents-agents-${PV}"

# ARM build fails on send_arp.linux.c with
#
# cc1: warnings being treated as errors
# send_arp.linux.c: In function 'send_pack':
# send_arp.linux.c:106: error: cast increases required alignment of target type
# send_arp.linux.c: In function 'recv_pack':
# send_arp.linux.c:207: error: cast increases required alignment of target type
#
# The code itself doesn't look that bad, so just disable -Werror
EXTRA_OECONF_arm += "--disable-fatal-warnings"

PACKAGES =+ "ldirectord ldirectord-doc ocft"

FILES_ldirectord = " \
	${sbindir}/ldirectord \
	${sysconfdir}/ha.d/resource.d/ldirectord \
	${sysconfdir}/init.d/ldirectord \
	${sysconfdir}/logrotate.d/ldirectord \
	${libdir}/ocf/resource.d/heartbeat/ldirectord \
	"
FILES_ldirectord-doc = "${mandir}/man8/ldirectord.8*"

# Missing:
# Authen::Radius
# Net::LDAP
# Net::IMAP::Simple::SSL
# Net::IMAP::Simple
RDEPENDS_ldirectord += " \
	libdbi-perl \
	libmailtools-perl \
	libnet-dns-perl \
	libsocket6-perl \
	libwww-perl \
	perl \
	perl-module-getopt-long \
	perl-module-net-ftp \
	perl-module-net-smtp \
	perl-module-pod-usage \
	perl-module-posix \
	perl-module-socket \
	perl-module-strict \
	perl-module-sys-hostname \
	perl-module-sys-syslog \
	perl-module-vars \
	"

FILES_${PN} += " \
	${libdir}/heartbeat/findif \
	${libdir}/heartbeat/ocf-returncodes \
	${libdir}/heartbeat/ocf-shellfuncs \
	${libdir}/heartbeat/send_arp \
	${libdir}/heartbeat/sfex_daemon \
	${libdir}/heartbeat/tickle_tcp \
	${libdir}/ocf/resource.d/heartbeat/ \
	${datadir}/resource-agents/ra-api-1.dtd \
	"

FILES_ocft += " \
	${datadir}/resource-agents/ocft \
	${sbindir}/ocft \
	"

FILES_${PN}-dbg += "${libdir}/heartbeat/.debug/ ${libdir}/ocf/resource.d/heartbeat/.debug/"
