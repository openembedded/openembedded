require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_opiealarm.tar.bz2;name=split_core_opiealarm \
           file://01opiealarm \
	   file://dirdefines-2.patch "
SRC_URI[split_core_opiealarm.md5sum] = "b7f026785ccfadfe292317a1e064cbc8"
SRC_URI[split_core_opiealarm.sha256sum] = "1dfd224ab072445a84c2530f643a3496512a9dd3a1255ce1d6da9f9cd38d4595"
