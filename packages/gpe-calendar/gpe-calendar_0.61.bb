LICENSE = "GPL"
PR = "r1"

inherit gpe

DEPENDS = "libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

SRC_URI += "file://remove-render.patch;patch=1"
