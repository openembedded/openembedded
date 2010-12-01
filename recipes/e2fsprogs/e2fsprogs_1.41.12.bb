require e2fsprogs.inc

PR = "${INC_PR}"

SRC_URI += "file://llseek-uclibc.patch"

do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "1b24a21fc0c2381ef420961cbfec733f"
SRC_URI[sha256sum] = "9c26d0dc20bfdafd0f27f3564791d6121d1c1876549d4f2ff1e41955c9bb9f20"
