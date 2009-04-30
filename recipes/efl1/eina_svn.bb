DESCRIPTION = "Eina is the Enlightenment data library"
LICENSE = "LGPL"
PV = "0.0.2.060+svnr${SRCPV}"
PR = "r0"

inherit efl

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

RREPLACES_${PN} = "libeina-ver-pre-svn-00-0 libeina-ver-pre-svn-01-0"

FILES_${PN} += "${libdir}/eina"
