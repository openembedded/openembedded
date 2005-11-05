LICENSE = "GPL"
inherit gpe

DEPENDS = "libeventdb libschedule libxsettings libxsettings-client libgpepimc libdisplaymigration libgpevtype"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE calendar"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"
