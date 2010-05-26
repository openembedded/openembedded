require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://fix-make-c.patch \
            file://optional-uuid.patch \
            file://uclibc-compile.patch \
"

do_compile_prepend() {
	sed -i /am__append_1/d ${S}/libs/blkid/src/Makefile
}

SRC_URI[archive.md5sum] = "71919b69eeecbba05612224d8f2c450f"
SRC_URI[archive.sha256sum] = "db4dcbf99d989a8f539d7521e9e64047367fa2ccdcbb91517cdec19693a41ffd"
