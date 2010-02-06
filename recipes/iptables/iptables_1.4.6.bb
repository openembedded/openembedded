require iptables.inc
inherit autotools
EXTRA_OECONF = "--with-kernel=${STAGING_INCDIR} \
                ${@base_contains('DISTRO_FEATURES', 'ipv6', '', '--disable-ipv6', d)}"

PR = "${INC_PR}.0"

SRC_URI += "\
	file://netfilter_remove_ipt_DSCP.patch;patch=1 \
	"
