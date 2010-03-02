DESCRIPTION = "LibYAML is a YAML parser and emitter written in C."
HOMEPAGE = "http://pyyaml.org/wiki/LibYAML"
SECTION = "libs/devel"
LICENSE = "MIT"
PR = "r1"

SRC_URI = "http://pyyaml.org/download/libyaml/yaml-${PV}.tar.gz"
S = "${WORKDIR}/yaml-${PV}"

inherit autotools
