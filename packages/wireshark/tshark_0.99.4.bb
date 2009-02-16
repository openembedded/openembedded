DESCRIPTION = "tshark is the text based verion of wireshark - a popular network protocol analyzer"
require wireshark.inc

EXTRA_OECONF = "--disable-wireshark --with-net-snmp=${STAGING_DIR_HOST}${layout_bindir}/net-snmp-config"

