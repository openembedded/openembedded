DESCRIPTION = "microcom is a small minicom-like serial terminal emulator with \
scripting support."
LICENSE = "GPL"

# http://microcom.port5.com/m102.tar.gz is no longer available
#NOTE: this should probably be converted to pull from sourceforge
# CVS, because openwrt is just another mirror of a file which no
# longer seems to exist outside mirrors.  mirror magic.
SRC_URI = "http://downloads.openwrt.org/sources/m102.tar.gz \
	   file://make.patch;patch=1"
S = "${WORKDIR}"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 microcom ${D}${bindir}/
}

SRC_URI[md5sum] = "c7817035dc41cb02e7cfb565cf9b7401"
SRC_URI[sha256sum] = "d7ee2e668455f9a092418e5475f32676eb0b37c54ae38a7fcdf2d14e0fb80c91"
