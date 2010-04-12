include libnfnetlink.inc

PR = "${INC_PR}.1"

do_configure() {
	oe_runconf
}

SRC_URI[libnfnetlink-0.0.30.md5sum] = "7fd3c8ddc03d42fa9f0177a17a38f163"
SRC_URI[libnfnetlink-0.0.30.sha256sum] = "a6a336a5b3e063748d93ae910bbf6b2d36ead9f9ecd6011b14325b8814b54bc2"
