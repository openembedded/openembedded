DESCRIPTION = "GPE modal help"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 gtk+"
PV = "0.41+svn${SRCDATE}"

inherit autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
