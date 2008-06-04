require gdb-cross.inc

inherit sdk

PR = "r1"

SRC_URI += "file://sim-install-6.6.patch;patch=1 \
            file://early_debug_in_nptl.patch;patch=1;pnum=0"

do_stage() {
	:
}
