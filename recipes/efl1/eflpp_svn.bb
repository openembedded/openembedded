DESCRIPTION = "EFLpp are C++ bindings to the EFL"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.vanille-media.de/site/index.php/projects/efl/"
LICENSE = "LGPL"
DEPENDS = "evas ecore edje emotion esmart etk ewl libsigc++-2.0"
SRCREV = "${EFL_SRCREV}"
PV = "0.1.0+svnr${SRCPV}"
PR = "r1" 

inherit efl

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/BINDINGS;module=cxx;proto=http"
S = "${WORKDIR}/cxx"
