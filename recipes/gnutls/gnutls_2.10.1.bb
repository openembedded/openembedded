require gnutls.inc

PR = "${INC_PR}.0"

LICENSE_${PN}-extra = "GPLv3"

EXTRA_OECONF += " --without-libgcrypt-prefix "

SRC_URI += "file://gettextize-with-gettext-0.18.patch \
            file://gnutls-openssl.patch \
            file://gnutls-replace-siginterrupt.patch \
           "

SRC_URI[gnutls.md5sum] = "b614448d7fb43ea0d4f727e6302bbf0f"
SRC_URI[gnutls.sha256sum] = "731078bc11661411ba47b20a65024abeca40d43a1b3c4526a6599b7905c302ee"
