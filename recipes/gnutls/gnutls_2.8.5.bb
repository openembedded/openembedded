require gnutls.inc

PR = "${INC_PR}.0"

LICENSE_${PN}-extra = "GPLv3"

SRC_URI += "\
	file://gnutls-openssl.patch \
	file://gnutls-replace-siginterrupt.patch \
	"

EXTRA_OECONF += " --without-libgcrypt-prefix "

do_configure_prepend() {

    cd ${S} && rm -rf m4/ aclocal.m4 lib/m4/libtool.m4 lib/m4/lt*m4
}

SRC_URI[gnutls.md5sum] = "e3b2788b79bfc82acbe717e3c54d4e92"
SRC_URI[gnutls.sha256sum] = "9249c29df71551e302e0186f4e1876dd6cc4c6cf2974b432c22525dde815cae8"
