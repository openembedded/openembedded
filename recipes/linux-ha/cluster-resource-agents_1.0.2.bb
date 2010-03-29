DESCRIPTION = "OCF resource agents for use by compatible cluster managers"
LICENSE = "GPL"
DEPENDS = "cluster-glue"

SRC_URI = "http://hg.linux-ha.org/agents/archive/agents-${PV}.tar.bz2;name=tar"
SRC_URI[tar.md5sum] = "b536dea1b1f642bdc3607cb85ea0b89d"
SRC_URI[tar.sha256sum] = "c5a1ea9a83c578672cd475ab4af5c2e40736669bae0eb70bb9bb6124074e5e5e"

inherit autotools_stage

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

PACKAGES =+ "ldirectord ldirectord-doc"

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
	/usr/lib/heartbeat/findif \
	/usr/lib/heartbeat/ocf-returncodes \
	/usr/lib/heartbeat/ocf-shellfuncs \
	/usr/lib/heartbeat/send_arp \
	/usr/lib/heartbeat/sfex_daemon \
	/usr/lib/heartbeat/tickle_tcp \
	/usr/lib/ocf/resource.d/heartbeat/ \
	/usr/share/resource-agents/ra-api-1.dtd \
	"

FILES_${PN}-dbg += "/usr/lib/heartbeat/.debug/"
