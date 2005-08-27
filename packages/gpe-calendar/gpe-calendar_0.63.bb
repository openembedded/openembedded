LICENSE = "GPL"
PR = "r1"

inherit autotools gpe

DEPENDS = "libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

