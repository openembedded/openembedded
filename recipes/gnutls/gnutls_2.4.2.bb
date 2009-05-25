require gnutls.inc
LICENSE_${PN}-extra = "GPLv3"

SRC_URI += "\
	file://gnutls-openssl.patch;patch=1 \
	file://gnutls-texinfo-euro.patch;patch=1 \
	file://configure_madness.patch;patch=1 \
	file://gnutls-replace-siginterrupt.patch;patch=1 \
	"

PR = "r4"
