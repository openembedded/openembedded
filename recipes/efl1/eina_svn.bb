DESCRIPTION = "Eina is the Enlightenment data library"
LICENSE = "LGPL"
PV = "0.0.2.060+svnr${SRCPV}"
PR = "r1"

inherit efl

SRC_URI += "file://gnu_source.patch;patch=1"

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

RREPLACES_${PN} = "libeina-ver-pre-svn-00-0 libeina-ver-pre-svn-01-0"

FILES_${PN} += "${libdir}/eina"
