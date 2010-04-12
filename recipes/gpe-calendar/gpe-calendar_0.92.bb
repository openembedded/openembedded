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

SRC_URI[md5sum] = "7fbe3cf31139b52f755f613c2006ad7e"
SRC_URI[sha256sum] = "13cd337f72215fc51eca9ab24bd7c7c7fc70b2ff27e23709ffae811d489e078b"
