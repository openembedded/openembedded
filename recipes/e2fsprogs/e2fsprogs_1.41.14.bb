require e2fsprogs.inc

PR = "${INC_PR}"

SRC_URI += "file://llseek-uclibc.patch"

do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "05f70470aea2ef7efbb0845b2b116720"
SRC_URI[sha256sum] = "3f8ac1fedd7c4bec480afcbe4acabdd4ac59ec0446a0fd50c8975cd0aad7b176"
