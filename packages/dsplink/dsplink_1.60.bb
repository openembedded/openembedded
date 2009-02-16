require dsplink.inc

# The tconf tool breaks if there is a '.' in your pwd
PR = "r8"
PE = "1"
PV = "160"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/link/link_1_60/index.html

SRC_URI = "http://install.tarball.in.source.dir/dsplink_1_60.tar.gz \
        file://dsplink-semaphore-27.patch;patch=1;pnum=4 \
		file://Makefile-dsplink-gpp \
		file://Makefile-dsplink-dsp \
"

S = "${WORKDIR}/dsplink_1_60/dsplink"

