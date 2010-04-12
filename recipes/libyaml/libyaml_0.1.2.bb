DESCRIPTION = "LibYAML is a YAML parser and emitter written in C."
HOMEPAGE = "http://pyyaml.org/wiki/LibYAML"
SECTION = "libs/devel"
LICENSE = "MIT"
PR = "r1"

SRC_URI = "http://pyyaml.org/download/libyaml/yaml-${PV}.tar.gz"
S = "${WORKDIR}/yaml-${PV}"

inherit autotools

SRC_URI[md5sum] = "f6c9b5c2b0f6919abd79f5fd059b01dc"
SRC_URI[sha256sum] = "5beb94529cc7ac79b17e354f9b03aea311f5af17be5d48bc39e6f1db5059f70f"
