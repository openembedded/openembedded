PR = "r2"

SRC_URI = "http://www.soft-switch.org/downloads/spandsp/spandsp-${PV}.tgz"

# *cough*
do_configure_append() {
        rm config.log
}

require spandsp.inc
