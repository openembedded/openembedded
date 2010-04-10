DESCRIPTION = "GPE calendar is the calendar application of the GPE PIM suite."
SECTION = "gpe"
LICENSE = "GPL"

DEPENDS = "libhandoff libsoup libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
RDEPENDS = "gpe-icons"

PR = "r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe

do_configure () {
        autotools_do_configure
}



SRC_URI[md5sum] = "e2834f77e3e9a476fd9a114411cdfa22"
SRC_URI[sha256sum] = "b70e8a2d20c206cfc978d918d73356a4a46f948ce109714d07b82c5327308498"
