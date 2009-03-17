require gnutls.inc

# fix wrong dependency
do_configure_prepend() {
    sed -i s,gcrypt,libgcrypt, lib/gnutls.pc.in
}

PR = "r3"
