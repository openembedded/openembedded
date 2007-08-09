DESCRIPTION = "EFLpp are C++ bindings to the EFL"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.vanille-media.de/site/index.php/projects/efl/"
LICENSE = "LGPL"
DEPENDS = "evas ecore edje emotion esmart etk ewl libsigc++-2.0"
PV = "0.1.0+cvs${SRCDATE}"

inherit efl_library

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

SRC_URI = "${E_CVS};module=e17/proto/${SRCNAME}"
