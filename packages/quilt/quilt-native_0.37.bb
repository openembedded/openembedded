include quilt.inc

INHIBIT_AUTOTOOLS_DEPS = "1"

SRC_URI = "cvs://anoncvs:@savannah.nongnu.org/cvsroot/quilt;method=ext;module=quilt;tag=VER_0_37 \
	   file://install.patch;patch=1 \
	   file://nostrip.patch;patch=1 \
	   file://wiggle.patch;patch=1 \
	   file://autoreconf.patch;patch=1"
S = "${WORKDIR}/quilt"

inherit autotools native

PATCHCLEANCMD = ""
PATCHCMD = "num='%s'; name='%s'; file='%s'; patch -p "$num" -i "$file""
EXTRA_OECONF = "--disable-nls"

do_configure () {
	chmod 755 configure
	oe_runconf
}
