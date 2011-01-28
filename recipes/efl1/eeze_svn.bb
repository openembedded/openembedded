DESCRIPTION = "Eeze is a library to simplify the use of devices"
LICENSE = "MIT BSD"
DEPENDS = "ecore udev"
PV = "0.2.0.+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"

inherit efl

SRC_URI = "${E_SVN}/trunk;module=${SRCNAME};proto=http;scmdata=keep"
S = "${WORKDIR}/${SRCNAME}"

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""
