DESCRIPTION = "LibYAML is a YAML 1.1 parser and emitter written in C."
HOMEPAGE = "http://pyyaml.org/wiki/LibYAML"
SECTION = "libs/devel"
LICENSE = "MIT"

SRC_URI = "http://pyyaml.org/download/libyaml/yaml-${PV}.tar.gz"
S = "${WORKDIR}/yaml-${PV}"

inherit autotools

do_stage() {
	autotools_stage_all
}
