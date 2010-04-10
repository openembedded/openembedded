# This is a dummy package so OE can use the poky mesa files
require mesa-dri_${PV}.bb

PR = "${INC_PR}.1"

EXTRA_OECONF += "--disable-egl"


SRC_URI[md5sum] = "8c75f90cd0303cfac9e4b6d54f6759ca"
SRC_URI[sha256sum] = "782a7b2810b1c466b3a994eba96485b59b47cc1120c0caa24de1aecf1e013830"
SRC_URI[md5sum] = "0ede7adf217951acd90dbe4551210c07"
SRC_URI[sha256sum] = "2fdf09fd7967fb1946e7f6af07d39c9fb695c373e1bad3855d3c3fbece5badd0"
