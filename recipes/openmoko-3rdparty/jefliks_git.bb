DESCRIPTION = "This project is a try to write real tiny and fast XMPP/Jabber \
    client for handheld devices, supported by Enlightment Foundation Library.\
    It use Elementary widget toolkit and Iksemel library to make it possible."
LICENSE = "GPL"
DEPENDS = "edje-native elementary iksemel gnutls eet evas ecore eina"
HOMEPAGE = "http://jefliks.sourceforge.net/"
AUTHOR = "Phoenix Kayo <kayo.k11.4@gmail.com>"
PV = "0.0.2b+gitr${SRCREV}"
PR = "r0"

inherit autotools pkgconfig

SRCREV = "c4d035f4696bf8a233a54c74dd148173fdef43c2"

SRC_URI = "git://jefliks.git.sourceforge.net/gitroot/jefliks/jefliks;protocol=git;branch=master"
S = "${WORKDIR}/git"
