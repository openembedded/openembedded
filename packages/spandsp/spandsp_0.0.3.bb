DESCRIPTION = "A library of many DSP functions for telephony."
HOMEPAGE = "http://www.soft-switch.org"
SECTION = "voip"
LICENSE = "GPL"
DEPENDS = "tiff libxml2"
PR = "r1"

SRC_URI = "http://www.soft-switch.org/downloads/spandsp/spandsp-${PV}.tgz"

inherit autotools

PARALLEL_MAKE = ""

# *cough*
do_configure_append() {
        rm config.log
}

do_stage () { 
    autotools_stage_all 
}
