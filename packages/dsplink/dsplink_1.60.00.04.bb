require dsplink.inc

# The tconf tool breaks if there is a '.' in your pwd
PR = "r2"
PE = "1"
PV = "160"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/link/index.html

SRC_URI = "http://install.tarball.in.source.dir/dsplink_1_60_00_04.tar.gz \
		file://Makefile.dsplink \
"

S = "${WORKDIR}/dsplink_1_60_00_04/dsplink"

