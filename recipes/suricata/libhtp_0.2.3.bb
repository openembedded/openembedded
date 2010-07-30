DESCRIPTION = "The HTP Library is an HTTP normalizer and parser written by Ivan Ristic"
LICENSE = "GPLv2"

SRC_URI = "http://www.openinfosecfoundation.org/download/libhtp-${PV}.tar.gz"
SRC_URI[md5sum] = "1ce445b99b01eb6cc84828f0f2adf9c7"
SRC_URI[sha256sum] = "a4f3a4130bcf7bcf590d93d46492f59dc211c49e8486c727cdc3b35aafa78358"

inherit autotools pkgconfig
