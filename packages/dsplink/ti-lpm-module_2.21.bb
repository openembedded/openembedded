# tconf from xdctools dislikes '.' in pwd :/
PR = "r2"
PV = "221"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_21.tar.gz \
           file://Makefile.dsplink \
          "
inherit module

S = "${WORKDIR}/codec_engine_2_21"

do_compile() {
	:
}

require lpm.inc
