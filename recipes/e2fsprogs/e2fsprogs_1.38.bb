require e2fsprogs.inc

PR = "${INC_PR}"

SRC_URI += "file://no-hardlinks.patch;patch=1 \
	    file://mkinstalldirs.patch;patch=1 \
            file://file-open-mode.patch;patch=1 \
           "

TARGET_CC_ARCH += "${LDFLAGS}"
