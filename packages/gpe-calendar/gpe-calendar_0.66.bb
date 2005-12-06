LICENSE = "GPL"
PR = "r0"
GPE_TARBALL_SUFFIX = "bz2"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

inherit autotools gpe

DEPENDS = "libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

