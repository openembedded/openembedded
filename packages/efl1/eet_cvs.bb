DESCRIPTION = "EET is a tiny library designed to write an \
arbitary set of chunks of data to a file and optionally compress \
each chunk (very much like a zip file) and allow fast \
random-access reading of the file later on."
DEPENDS = "zlib jpeg"
LICENSE = "BSD"
PV = "0.9.10.041+cvs${SRCDATE}"
PR = "r0"

inherit efl_library
