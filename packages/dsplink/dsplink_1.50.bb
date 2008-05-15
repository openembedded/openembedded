DESCRIPTION = "DSP Link for TI ARM/DSP processors"

PR = "r0"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# https://www-a.ti.com/downloads/sds_support/targetcontent/link/index.html
SRC_URI ="http://install.tarball.in.source.dir/dsplink_1_50.tar.gz \
"

S = "${WORKDIR}/dsplink_1_50"

do_configure () {
}

do_compile () {
}

