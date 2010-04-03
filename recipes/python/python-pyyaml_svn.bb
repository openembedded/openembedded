DESCRIPTION = "Python support for YAML"
HOMEPAGE = "http://www.pyyaml.org"
SECTION = "devel/python"
LICENSE = "MIT"
DEPENDS = "libyaml python-cython-native"
SRCREV = "344"
PV = "3.08+svnr${SRCPV}"
PR = "ml0"

SRC_URI = "\
  svn://svn.pyyaml.org/pyyaml;module=trunk;proto=http \
  file://setup.py \
"
S = "${WORKDIR}/trunk"

inherit distutils

do_configure_prepend() {
	# upstream setup.py overcomplicated, use ours
	install -m 0644 ${WORKDIR}/setup.py ${S}
}
