require iptables.inc
inherit autotools
EXTRA_OECONF = "--with-kernel=${STAGING_INCDIR} \
                ${@base_contains('DISTRO_FEATURES', 'ipv6', '', '--disable-ipv6', d)}"

PR = "${INC_PR}.0"

SRC_URI += "\
	file://netfilter_remove_ipt_DSCP.patch;patch=1 \
	"

SRC_URI[iptables-1.4.6.md5sum] = "c67cf30e281a924def6426be0973df56"
SRC_URI[iptables-1.4.6.sha256sum] = "6e732798cad62163d6e033aa52e22b771246556a230c0f66cd33fe69e96d72a4"
