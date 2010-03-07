require gnutls.inc

# fix wrong dependency
do_configure_prepend() {
    sed -i s,gcrypt,libgcrypt, lib/gnutls.pc.in
}

PR = "${INC_PR}.0"

do_install_append() {

    install -d ${D}${datadir}/aclocal
    install -m 0644 ${S}/lib/libgnutls.m4 ${D}${datadir}/aclocal/
    install -m 0644 ${S}/libextra/libgnutls-extra.m4 ${D}${datadir}/aclocal/
}
