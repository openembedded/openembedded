DESCRIPTION = "libdvdcss is a simple library designed for accessing DVDs like a block device without having to bother about the decryption."
LICENSE = "GPLv2"

SRC_URI = "http://download.videolan.org/pub/libdvdcss/${PV}/libdvdcss-${PV}.tar.bz2"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
	autotools_stage_all
}





