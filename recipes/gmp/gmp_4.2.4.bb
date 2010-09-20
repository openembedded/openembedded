require gmp.inc

SRC_URI += "file://sh4-asmfix.patch \
            file://use-includedir.patch \
            file://dont_use_mips_h_constraint.patch \
           "

PR = "${INC_PR}.5"

LICENSE = "GPLv3 LGPLv3"

SRC_URI[gmp.md5sum] = "fc1e3b3a2a5038d4d74138d0b9cf8dbe"
SRC_URI[gmp.sha256sum] = "5420b0e558a69a53b36f2b2c70a69f547e075d98366a585fc80cbbcce1efe368"
