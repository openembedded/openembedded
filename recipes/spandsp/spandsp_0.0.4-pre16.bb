PR = "r2"

SRC_URI = "http://www.soft-switch.org/downloads/spandsp/${PN}-0.0.4pre16.tgz"

S = "${WORKDIR}/spandsp-0.0.4"

# *cough*
do_configure_append() {
      rm config.log
}

require spandsp.inc

DEFAULT_PREFERENCE = "-16"

SRC_URI[md5sum] = "9e4de1934d4d49bfee9640e39d19894e"
SRC_URI[sha256sum] = "3ab8a8ccaa5c9f3ca918209240d38f30e6d43fc9592ae0a791d0e235b15e28aa"
