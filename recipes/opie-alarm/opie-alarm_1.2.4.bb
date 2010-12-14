require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_opiealarm.tar.bz2;name=split_core_opiealarm \
           file://01opiealarm \
	   file://dirdefines.patch "
SRC_URI[split_core_opiealarm.md5sum] = "7813759ab6f98e1e09e9090d2c83225b"
SRC_URI[split_core_opiealarm.sha256sum] = "faf2d8cbf4e20541b1269f7075dd9b955b601dc4472420bc01f115c84dd86aed"
