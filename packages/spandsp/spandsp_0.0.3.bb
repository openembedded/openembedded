DESCRIPTION = "A library of many DSP functions for telephony."
HOMEPAGE = "http://www.soft-switch.org"
DEPENDS = "tiff libxml2"
SECTION = "voip"
LICENSE = "GPL"
PV = "0.0.3"
PSUBV = "pre27"
PR = "r0"

SRC_URI = "http://www.soft-switch.org/downloads/snapshots/spandsp/spandsp-20070123.tar.gz"

inherit autotools

PARALLEL_MAKE = ""

do_stage () { 
    autotools_stage_all 
}
