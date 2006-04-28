include quilt.inc

include quilt_${PV}.bb

INHIBIT_AUTOTOOLS_DEPS = "1"

#SRC_URI += "file://autoreconf.patch;patch=1"

S = "${WORKDIR}/quilt-${PV}"

inherit autotools native

PATCHCLEANCMD = ""
PATCHCMD = "num='%s'; name='%s'; file='%s'; patch -p "$num" -i "$file""
EXTRA_OECONF = "--disable-nls"

do_configure () {
	chmod 755 configure
	oe_runconf
}
