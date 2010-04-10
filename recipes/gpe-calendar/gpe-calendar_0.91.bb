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

SRC_URI[md5sum] = "478ed24de48860712f45563640041301"
SRC_URI[sha256sum] = "75581218e2871c8bd1ab645977318050d9ba60c5cf632a51c05c4339fa9365ae"
