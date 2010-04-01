DESCRIPTION = "The Enlightenment C-like scripting language for Edje"
LICENSE = "MIT BSD"
PV = "0.9.9.060+svnr${SRCPV}"
PR = "r2"
SRCREV = "${EFL_SRCREV}"

inherit efl

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

RREPLACES_${PN} = "libembryo-ver-pre-svn-00-0 libembryo-ver-pre-svn-01-0"

RREPLACES_${PN}-tests = "libembryo-ver-pre-svn-00-tests libembryo-ver-pre-svn-01-tests"

