DESCRIPTION = "A library of many DSP functions for telephony."
HOMEPAGE = "http://www.soft-switch.org"
DEPENDS = "tiff libxml2"
SECTION = "voip"
LICENSE = "GPL"

PR = "r0"

SRC_URI = "http://www.soft-switch.org/downloads/spandsp/spandsp-0.0.4pre3.tgz"

S = "${WORKDIR}/spandsp-0.0.4"

inherit autotools pkgconfig

PARALLEL_MAKE = ""

# *cough*
do_configure_append() {
	rm config.log
}

do_stage () { 
    autotools_stage_all 
}
