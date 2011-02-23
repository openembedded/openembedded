DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."
HOMEPAGE = "http://www.loudmouth-project.org/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls check"
PR = "r1"

inherit gnomebase

SRC_URI[archive.md5sum] = "0bdd62dcbca0dfc8b46de6806c0cc3ca"
SRC_URI[archive.sha256sum] = "d7efb5a6c777ed0f375444a57e4de75e8406adb61d1f52829f84bc5404cfb03b"
