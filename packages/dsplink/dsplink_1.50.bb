DESCRIPTION = "DSP Link for TI ARM/DSP processors"

PR = "r0"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
SRC_URI ="http://install.tarball.in.source.dir/dsplink_1_50.tar.gz \
"

S = "${WORKDIR}/dsplink_1_50"

do_configure () {
}

do_compile () {
}

