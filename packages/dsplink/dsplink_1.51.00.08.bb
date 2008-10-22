require dsplink.inc


DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_armv7a = "1"

FILE_PR = "r10"
PE = "1"
PV = "1.51"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/link/index.html

SRC_URI = "http://install.tarball.in.source.dir/dsplink_1_51_00_08.tar.gz \
           file://CURRENTCFG.MK \
           file://c64xx_5.xx_linux.mk \
           file://openembedded.mk \
	   file://prcs-fix-include.patch;patch=1;pnum=2 \
		file://Makefile.dsplink \
"

SRC_URI_append_beagleboard = " \
#           file://dsplink-128M.patch;patch=1;pnum=2 \
"

S = "${WORKDIR}/dsplink_1_51_00_08/dsplink"

