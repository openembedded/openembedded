DESCRIPTION = "LibYAML is a YAML parser and emitter written in C."
HOMEPAGE = "http://pyyaml.org/wiki/LibYAML"
SECTION = "libs/devel"
LICENSE = "MIT"
PR="r0"

SRC_URI = "http://pyyaml.org/download/libyaml/yaml-${PV}.tar.gz;name=libyaml"
SRC_URI[libyaml.md5sum] = "b8ab9064e8e0330423fe640de76608cd"
SRC_URI[libyaml.sha256sum] = "a8bbad7e5250b3735126b7e3bd9f6fce9db19d6be7cc13abad17a24b59ec144a"

S = "${WORKDIR}/yaml-${PV}"

inherit autotools
