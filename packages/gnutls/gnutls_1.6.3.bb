require gnutls.inc

SRC_URI += "\
	file://gnutls-openssl.patch;patch=1 \
	file://gnutls-texinfo-euro.patch;patch=1 \
	file://configure_madness.patch;patch=1 \
	"

# fix wrong dependency
do_configure_prepend() {
    sed -i s,gcrypt,libgcrypt, lib/gnutls.pc.in
}

PR = "r6"
