DESCRIPTION = "An implementation of freedesktop.org specs for the \
Enlightenment Foundation Libraries"
DEPENDS = "ecore"
LICENSE = "BSD"
PR = "r0"

inherit efl1

PACKAGES =+ "efreet-tests"
FILES_efreet-tests = "${bindir}/*_* ${datadir}"
