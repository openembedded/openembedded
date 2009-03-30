DESCRIPTION = "GPE calendar is the calendar application of the GPE PIM suite."
SECTION = "gpe"
LICENSE = "GPL"

DEPENDS = "libhandoff libsoup libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype libsoundgen"
RDEPENDS = "gpe-icons"

PR = "r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe

do_configure () {
        autotools_do_configure
}
