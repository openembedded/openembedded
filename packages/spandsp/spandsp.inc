DESCRIPTION = "A library of many DSP functions for telephony."
HOMEPAGE = "http://www.soft-switch.org"
SECTION = "voip"
LICENSE = "GPL"
DEPENDS = "tiff libxml2"

inherit autotools

do_stage () {
    autotools_stage_all
}

PARALLEL_MAKE = ""
