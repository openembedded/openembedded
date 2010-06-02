require gnutls.inc

PR = "${INC_PR}.0"

LICENSE_${PN}-extra = "GPLv3"

EXTRA_OECONF += " --without-libgcrypt-prefix "

SRC_URI += "file://gettextize-with-gettext-0.18.patch \
            file://gnutls-openssl.patch \
            file://gnutls-replace-siginterrupt.patch \
           "

SRC_URI[gnutls.md5sum] = "eb0a6d7d3cb9ac684d971c14f9f6d3ba"
SRC_URI[gnutls.sha256sum] = "d6f846a7064af3ee2c9aebd65dcee76953b767170cbcd719e990ed6b9688a356"

