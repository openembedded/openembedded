require e2fsprogs.inc

PR = "${INC_PR}"

SRC_URI += "file://no-hardlinks.patch;patch=1 \
	    file://mkinstalldirs.patch;patch=1 \
            file://file-open-mode.patch;patch=1 \
           "

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI[md5sum] = "d774d4412bfb80d12cf3a4fdfd59de5a"
SRC_URI[sha256sum] = "c4e482687d0cff240d02a70fcf423cc14296b6a7869cd8dd42d5404d098e0bb7"
