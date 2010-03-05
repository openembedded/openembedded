require gnutls.inc
LICENSE_${PN}-extra = "GPLv3"

SRC_URI += "\
	file://gnutls-openssl.patch;patch=1 \
	file://gnutls-texinfo-euro.patch;patch=1 \
	file://configure_madness.patch;patch=1 \
	file://gnutls-replace-siginterrupt.patch;patch=1 \
	"

PR = "${INC_PR}.0"

do_install_append() {

    install -d ${D}${datadir}/aclocal
    install -m 0644 ${S}/lib/libgnutls.m4 ${D}${datadir}/aclocal/
    install -m 0644 ${S}/libextra/libgnutls-extra.m4 ${D}${datadir}/aclocal/
}
