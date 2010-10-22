DESCRIPTION = "Eeze is a library to simplify the use of devices"
LICENSE = "MIT BSD"
DEPENDS = "ecore udev"
PV = "0.2.0.+svnr${SRCPV}"
PR = "r0"
SRCREV = "${EFL_SRCREV}"

inherit efl

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""
