require gpe-su.inc

PR = "r1"

SRC_URI = "${GPE_SVN} \
           file://svn-build.patch"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"

