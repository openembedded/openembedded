DESCRIPTION = "json C library"
AUTHOR = "Michael Clark and C. Watford"
HOMEPAGE = "http://oss.metaparadigm.com/json-c/"
SECTION = "libs"
LICENSE = "MIT/X11"
PV = "0.9+svnr${SRCPV}"

SRC_URI = "svn://svn.metaparadigm.com/svn/json-c/;module=trunk;proto=http"

SRCREV = "55"
S = "${WORKDIR}/trunk"

inherit autotools

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"
