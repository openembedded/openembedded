DESCRIPTION = "GPE calendar is the calendar application of the GPE PIM suite."
SECTION = "gpe"
LICENSE = "GPL"

DEPENDS = "dbus-glib libeventdb libschedule libxsettings-client libgpepimc libgpevtype"
RDEPENDS = "gpe-icons"

PR = "r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe

do_configure () {
        autotools_do_configure
}



SRC_URI[md5sum] = "b10a91ce3fb39b87656fc5c5510b68d6"
SRC_URI[sha256sum] = "780ddb4f2bb72e3e8d970ebc647c8040cfef0fccd405773cf7776074c26175b6"
