PR = "r2"

SRC_URI = "http://www.soft-switch.org/downloads/spandsp/${PN}-0.0.4pre16.tgz"

S = "${WORKDIR}/spandsp-0.0.4"

# *cough*
do_configure_append() {
      rm config.log
}

require spandsp.inc

DEFAULT_PREFERENCE = "-16"
