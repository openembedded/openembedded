DESCRIPTION = "EFLpp are C++ bindings to the EFL"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.vanille-media.de/site/index.php/projects/efl/"
LICENSE = "LGPL"
DEPENDS = "evas ecore edje emotion esmart libsigc++-2.0"
SRCREV = "${EFL_SRCREV}"
PV = "0.1.0+svnr${SRCPV}"
PR = "r1" 

inherit efl
SRCNAME = "cxx"
SRC_URI = "${E_SVN}/trunk/BINDINGS;module=${SRCNAME};proto=http;scmdata=keep"
S = "${WORKDIR}/${SRCNAME}"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
