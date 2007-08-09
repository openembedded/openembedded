DESCRIPTION = "A library of many DSP functions for telephony."
HOMEPAGE = "http://www.soft-switch.org"
DEPENDS = "tiff libxml2"
SECTION = "voip"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.soft-switch.org/downloads/snapshots/spandsp/spandsp-20070123.tar.gz"
S = "${WORKDIR}/${PN}-0.0.3"

inherit autotools

PARALLEL_MAKE = ""

do_stage () { 
    autotools_stage_all 
}