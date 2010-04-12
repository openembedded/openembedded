PR = "r3"

SRC_URI = "http://www.soft-switch.org/downloads/spandsp/spandsp-${PV}.tgz"

# *cough*
do_configure_append() {
        rm config.log
}

require spandsp.inc

SRC_URI[md5sum] = "6ea33941985fbf94b5f79dc3255ad925"
SRC_URI[sha256sum] = "368467b757736aef99e19f68e4ed50012b555ef18445b4ad7e47da8c1c353118"
