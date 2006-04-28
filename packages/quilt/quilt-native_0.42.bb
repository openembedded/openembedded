include quilt.inc

include quilt_${PV}.bb

INHIBIT_AUTOTOOLS_DEPS = "1"

inherit autotools native

PATCHCLEANCMD = ""
PATCHCMD = "num='%s'; name='%s'; file='%s'; patch -p "$num" -i "$file""
EXTRA_OECONF = "--disable-nls"

do_configure () {
	oe_runconf
}
