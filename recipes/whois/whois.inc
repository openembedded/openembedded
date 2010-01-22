DEPENDS += "gettext-native virtual/libintl"
DESCRIPTION = "whois is an improved whois client"
LICENSE = "GPL"
HOMEPAGE = "http://www.linux.it/~md/software/"
SECTION = "network"

INC_PR  = "r1"

SRC_URI = "${DEBIAN_MIRROR}/main/w/whois/whois_${PV}.tar.gz;name=whois"

S = "${WORKDIR}/whois-${PV}"

inherit gettext

def whois_intl(bb, d):
	# FIXME: This is ugly.. we already have the virtual for this,
	# but there's no way to ask bb who the current selected provider of
	# a given virtual/ is.
	if (bb.data.getVar('TARGET_OS', d, 1) or '').endswith('-uclibc'):
		return ' -lintl'
	return ''

EXTRA_OEMAKE = '"OPTS=${CFLAGS} -DCONFIG_FILE=\\\"/etc/whois.conf\\\"" \
		"CC=${CC}" "LDFLAGS=${LDFLAGS}${@whois_intl(bb, d)}"'

do_install () {
	install -D -m 0755 whois ${D}${bindir}/whois
	install -D -m 0644 whois.1 ${D}${mandir}/man1/whois.1
}
