require orbit2.inc

LICENSE = "GPLv2+"

PR = "r1"

SRC_URI += "file://disable-ipv6.patch"
noipv6 = "${@base_contains('DISTRO_FEATURES', 'ipv6', '', '-DDISABLE_IPV6', d)}"
EXTRA_OEMAKE_append = " 'CFLAGS=${CFLAGS} ${noipv6}'"

SRC_URI[md5sum] = "10bfb957fa4a8935a0b4afaee7d71df7"
SRC_URI[sha256sum] = "62bfce3f678f9347a19c766944e8aef7b89bc32b25ac23eb3e4c25929ce8974c"
