require qt4-x11-free.inc
LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.3"

SRC_URI += "file://hack-out-pg_config.patch;patch=1"
