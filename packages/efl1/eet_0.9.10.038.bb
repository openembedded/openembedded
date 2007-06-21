DESCRIPTION = "EET is a tiny library designed to write an \
arbitary set of chunks of data to a file and optionally compress \
each chunk (very much like a zip file) and allow fast \
random-access reading of the file later on."
DEPENDS = "zlib jpeg"
LICENSE = "BSD"
PR = "r0"

inherit efl1

SRC_URI = "http://download.enlightenment.org/snapshots/2007-05-06/eet-${PV}.tar.gz"
