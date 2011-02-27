require avahi.inc

PR = "${INC_PR}.0"

DEPENDS += "intltool-native"

PACKAGES =+ "libavahi-gobject"

SRC_URI += "file://disable-ipv6.patch \
            file://fix-CVE-2011-1002.patch"

noipv6 = "${@base_contains('DISTRO_FEATURES', 'ipv6', '', '-DDISABLE_IPV6', d)}"
EXTRA_OEMAKE_append = " 'CFLAGS=${CFLAGS} ${noipv6}'"


SRC_URI[md5sum] = "a83155a6e29e3988f07e5eea3287b21e"
SRC_URI[sha256sum] = "9220d974f5515b8ccfa3900cd72cedcac0fa4cc87ca3c64405f7c55346cbba59"
