# This is a dummy package so OE can use the poky mesa files
require mesa-dri_${PV}.bb

PR = "${INC_PR}.1"

EXTRA_OECONF += "--disable-egl"

