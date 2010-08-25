require iptables.inc

DEPENDS += "libnfnetlink"

inherit autotools
EXTRA_OECONF = "--with-kernel=${STAGING_INCDIR} \
                ${@base_contains('DISTRO_FEATURES', 'ipv6', '', '--disable-ipv6', d)}"

PR = "${INC_PR}.1"

SRC_URI[iptables-1.4.9.1.md5sum] = "fbadfb0b5f2dbda49e0ad06a798898e3"
SRC_URI[iptables-1.4.9.1.sha256sum] = "0550f7ba7a170811dcf9b2df65036999786d84040b767238effc40232f617839"

PACKAGES =+ "${PN}-osf"

FILES_${PN}-osf = "${sbindir}/nfnl_osf ${datadir}/xtables"
